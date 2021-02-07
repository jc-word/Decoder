package Decode;


import Bean.*;
import DataBaseUtil.PreparedStatementUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Decoder {
    private PreparedStatementUtil preparedStatementUtil = null;
    private String connectionUrl="";
    public Decoder(String connectionUrl){
        this.connectionUrl=connectionUrl;
    }
    public void init() {
        String sql = "SELECT\n" +
                "\tRaw.PStationId,Raw.ChannelId,Raw.Address,Raw.DeviceId,DeviceAttribute.AttrNameNew,DeviceType.RedisKey\n" +
                "FROM\n" +
                "\tT_Raw Raw\n" +
                "LEFT JOIN T_DeviceAttribute DeviceAttribute ON Raw.PropertyId = DeviceAttribute.Id\n" +
                "LEFT JOIN T_DeviceType DeviceType ON DeviceAttribute.DeviceTypeId = DeviceType.Id\n" +
                "where  Raw.Address<=? AND Raw.Address>? AND Raw.PStationId = ?\n" +
                "AND Raw.ChannelId = ?";
        this.preparedStatementUtil = new PreparedStatementUtil(sql);
        this.preparedStatementUtil.init(this.connectionUrl);
    }

    //关闭资源连接
    public void close() {
        if (preparedStatementUtil == null) {
            return;
        }
        preparedStatementUtil.close();
    }

    //获取数据库中的数据并缓存进缓存容器中
    public HashMap<String, HashMap<String, HashMap<String, DecodeData>>> cacheData(int max, int min, int PStation, int Channel) {
        HashMap<String, HashMap<String, HashMap<String, DecodeData>>> company = new HashMap<>();

        PreparedStatement preparedStatement = this.preparedStatementUtil.getPreparedStatement();
        try {
            preparedStatement.setInt(1, max);
            preparedStatement.setInt(2, min);
            preparedStatement.setInt(3, PStation);
            preparedStatement.setInt(4, Channel);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            int i = 1;
            while (resultSet.next()) {
                DecodeData decodeData = new DecodeData();
                String PStationId = resultSet.getString(1);
                String ChannelId = resultSet.getString(2);
                String Address = resultSet.getString(3);
                decodeData.setDeviceId(resultSet.getInt(4));
                decodeData.setAttrNameNew(resultSet.getString(5));
                decodeData.setRedisKey(resultSet.getString(6));
                buffereContainer(PStationId, ChannelId, Address, decodeData, company);
            }
            resultSet.close();
            //System.out.println("cache sucess");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    //创建数据库缓冲数据容器
    public void buffereContainer(String PStationId, String ChannelId, String Address, DecodeData decodeData, HashMap<String, HashMap<String, HashMap<String, DecodeData>>> hashMap) {

        //电站不存在
        if (hashMap.get(PStationId) == null) {
            //创建电站
            hashMap.put(PStationId, new HashMap<>());
            //创建通道
            //获取电站
            HashMap<String, HashMap<String, DecodeData>> station = hashMap.get(PStationId);
            //创建通道
            station.put(ChannelId, new HashMap<>());
            //创建设备
            //获取通道
            HashMap<String, DecodeData> channel = station.get(ChannelId);
            //创建地址添加数据
            channel.put(Address, decodeData);

        }
        //电站存在
        else {
            //获取电站
            HashMap<String, HashMap<String, DecodeData>> station = hashMap.get(PStationId);
            //通道存在
            if (station.get(ChannelId) != null) {
                //获取通道
                HashMap<String, DecodeData> channel = station.get(ChannelId);
                //创建设备添加数据
                channel.put(Address, decodeData);

            }
            //通道不存在
            else {
                //创建通道
                //创建通道
                station.put(ChannelId, new HashMap<>());
                //创建设备
                //获取通道
                HashMap<String, DecodeData> channel = station.get(ChannelId);
                //创建设备添加数据
                channel.put(Address, decodeData);
            }

        }
    }

    //解析文件
    public List<Map> readFile(File file) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int length = 0;
        int max = -1;
        int min = -1;
        HashMap<String, HashMap<String, HashMap<String, DecodeData>>> company = null;
        HashMap<String, HashMap<String, Object>> redisMap = new HashMap<>();
        //类型数组标记设备对象存储类型
        HashMap<String, List<String>> saveType = new HashMap<>();
        saveType.put("inv", new ArrayList<String>());
        saveType.put("conv", new ArrayList<String>());
        saveType.put("meter", new ArrayList<String>());
        saveType.put("env", new ArrayList<String>());
        saveType.put("box", new ArrayList<String>());
        saveType.put("dcbus", new ArrayList<String>());
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String dateStr = bufferedReader.readLine();
            Date date = getDate(dateStr, false);
            int a = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");

                for (int i = 1; i <= split.length; i++) {
                    if (i % 2 != 0) {
                        //  3位电站号+2位通道号+2位遥信/遥测/遥脉+5位点号
                        String code = split[i - 1];
                        String stationId = Integer.parseInt(code.substring(0, 3)) + "";
                        String channelId = Integer.parseInt(code.substring(3, 5)) + "";
                        String typeOfMeasuringPoint = code.substring(5, 7);
                        String address = Integer.parseInt(code.substring(7, 12)) + "";
                        Double value = Double.parseDouble(split[i]);
                        while (Integer.parseInt(address) > max) {
                            max = Integer.parseInt(address)+99;;
                            min = Integer.parseInt(address)-1;;
                            if (Integer.parseInt(address) < max) {
                                //System.out.println("添加缓存");
                                company = cacheData(max, min, Integer.parseInt(stationId), Integer.parseInt(channelId));
                                //System.out.println(address + "------" + max + "--------" + min);
                            }
                        }

                        try {

                            if (company.get(stationId).get(channelId).get(address).getRedisKey() != null) {
                                DecodeData decodeData = company.get(stationId).get(channelId).get(address);
                                length++;
                                //System.out.println(company.get(stationId).get(channelId).get(address).toString() + "----address:" + stationId + "----" + channelId + "----" + address);
                                buildStation(redisMap, stationId, decodeData.getDeviceId() + "", decodeData.getRedisKey(), decodeData.getAttrNameNew(), value, date, saveType);
                            }else {
                               // System.out.println("\nRedisKey为null" + stationId + "---" + channelId + "---" + address);
                            }

                        } catch (Exception e) {

                            //System.out.println("\n-----error:" + stationId + "---" + channelId + "---" + address);
                        }
                    }

                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------xx-finalnumber--" + length + "-------");
        List<Map> list=new ArrayList<>();
        list.add(redisMap);
        list.add(saveType);
        return list;
    }

    //解析数据进入stationMap
    public void buildStation(HashMap<String, HashMap<String, Object>> stationMap, String stationNum, String equipmentNum, String equipmentType, String attribute, Double vlaue, Date date, Map<String, List<String>> saveType) {

        //电站存在
        if (stationMap.containsKey(stationNum)) {
            HashMap<String, Object> equipment = stationMap.get(stationNum);
            //设备存在
            if (equipment.containsKey(equipmentNum)) {

                //为设备属性赋值
                setAttributeValue(equipment, equipmentType, equipmentNum, attribute, vlaue, stationNum, date);
                //设备不存在
            } else {
                //创建设备
                createEquipment(equipment, equipmentType,stationNum, equipmentNum, saveType);
                //为设备属性赋值
                setAttributeValue(equipment, equipmentType, equipmentNum, attribute, vlaue, stationNum, date);
            }
            //电站不存在
        } else {
            //创建设备Map
            HashMap<String, Object> equipment = new HashMap<>();
            //创建电站
            stationMap.put(stationNum, equipment);
            //创建设备
            createEquipment(equipment, equipmentType,stationNum, equipmentNum, saveType);
            //为设备属性赋值
            setAttributeValue(equipment, equipmentType, equipmentNum, attribute, vlaue, stationNum, date);
        }
    }

    //获取日期
    public Date getDate(String dateCode, boolean IsAccurateMillisecond) {
        SimpleDateFormat dateParse;
        Date date = null;
        if (IsAccurateMillisecond) {
            dateParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        } else {
            dateParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        String dateString = dateCode.replaceFirst(",", "");
        try {
            date = dateParse.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //通过反射为对象赋值
    public <T> void setValue(T obj, String arrtibute, Double value, String stationNum, String equipmentNum, Date date) {

        Class<?> aClass = obj.getClass();

        try {
            Method setAttribute = aClass.getMethod("set" + arrtibute, Double.class);
            setAttribute.invoke(obj, value);
            Method setAttributeStationNum = aClass.getMethod("set" + "PStationId", Integer.class);
            setAttributeStationNum.invoke(obj, Integer.parseInt(stationNum));
            Method setAttributeEquipmentNum = aClass.getMethod("set" + "DeviceId", Integer.class);
            setAttributeEquipmentNum.invoke(obj, Integer.parseInt(equipmentNum));
            Method setAttributeDate = aClass.getMethod("set" + "DataTime", Date.class);
            setAttributeDate.invoke(obj, date);

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
           // System.out.println("对象" + aClass.getName() + "中不存在" + arrtibute + "属性");
        }
    }

    //将解析数据赋值进设备对象
    public void setAttributeValue(Map<String, Object> equipment, String equipmentType, String equipmentNum, String attribute, Double value, String stationNum, Date date) {
        switch (equipmentType) {
            case "inv":
                InvDTO invDTO = (InvDTO) equipment.get(equipmentNum);
                setValue(invDTO, attribute, value, stationNum, equipmentNum, date);
                break;
            case "conv":
                ConvDTO convDTO = (ConvDTO) equipment.get(equipmentNum);
                setValue(convDTO, attribute, value, stationNum, equipmentNum, date);
                break;
            case "meter":
                MeterDTO meterDTO = (MeterDTO) equipment.get(equipmentNum);
                setValue(meterDTO, attribute, value, stationNum, equipmentNum, date);
                break;
            case "env":
                EnvDTO envDTO = (EnvDTO) equipment.get(equipmentNum);
                setValue(envDTO, attribute, value, stationNum, equipmentNum, date);
                break;
            case "box":
                BoxDTO boxDTO = (BoxDTO) equipment.get(equipmentNum);
                setValue(boxDTO, attribute, value, stationNum, equipmentNum, date);
                break;
            case "dcbus":
                DcbusDTO dcbusDTO = (DcbusDTO) equipment.get(equipmentNum);
                setValue(dcbusDTO, attribute, value, stationNum, equipmentNum, date);
                break;

        }
    }

    //创建设备对象
    public void createEquipment(Map<String, Object> equipment, String equipmentType, String stationNum,String equipmentNum, Map<String, List<String>> saveType) {
        List<String> inv = saveType.get("inv");
        List<String> conv = saveType.get("conv");
        List<String> meter = saveType.get("meter");
        List<String> env = saveType.get("env");
        List<String> box = saveType.get("box");
        List<String> dcbus = saveType.get("dcbus");

        switch (equipmentType) {
            case "inv":
                InvDTO invDTO = new InvDTO();
                inv.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, invDTO);
                break;
            case "conv":
                ConvDTO convDTO = new ConvDTO();
                conv.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, convDTO);
                break;
            case "meter":
                MeterDTO meterDTO = new MeterDTO();
                meter.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, meterDTO);
                break;
            case "env":
                EnvDTO envDTO = new EnvDTO();
                env.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, envDTO);
                break;
            case "box":
                BoxDTO padmountedDTO = new BoxDTO();
                box.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, padmountedDTO);
                break;
            case "dcbus":
                DcbusDTO dcbusDTO = new DcbusDTO();
                dcbus.add(stationNum+'-'+equipmentNum);
                equipment.put(equipmentNum, dcbusDTO);
                break;

        }
    }

}
