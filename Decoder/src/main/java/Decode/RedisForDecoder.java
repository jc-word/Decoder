package Decode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RedisForDecoder {
    private String ipAddress;
    public RedisForDecoder(){
        TypeUtils.compatibleWithFieldName=true;
    }
    //初始化redis地址
    public RedisForDecoder(String ipAddress) {
        TypeUtils.compatibleWithFieldName=true;
        this.ipAddress=ipAddress;
    }
    //存储到redis
    public  void saveToRedis(String listName, Object obj) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.9.150", 6379);
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
//         jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        System.out.println("-----------------------");
        //jedis.del(listName);
        jedis.lpush(listName, JSON.toJSONString(obj));
        // 获取存储的数据并输出
        List<String> list = jedis.lrange(listName, 0, 99);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(listName + " = " + list.get(i));
        }
    }
    //获取redis连接
    public  Jedis linkToRedis() {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis(this.ipAddress);
        // 如果 Redis 服务设置来密码，需要下面这行，没有就不需要
        //jedis.auth("123456");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
        System.out.println("-----------------------");
        return jedis;
    }
    //保存到redis
    public  void saveToRedis(Jedis jedis, String listName, Object obj) {
        //jedis.del(listName);
        jedis.lpush(listName, JSON.toJSONString(obj));
    }
    //显示redis中列表数据
    public  void showRedisList(Jedis jedis, String listName, Integer start, Integer end) {
        List<String> list = jedis.lrange(listName, start, end);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(listName + " = " + list.get(i));
        }
    }
    //保存解码数据
    public void saveData(HashMap<String, Map> stationMap, HashMap<String, List<String>> saveType, Jedis jedis) {
        List<String> inv = saveType.get("inv");
        iterateList(inv, stationMap, "inv", jedis);
        List<String> conv = saveType.get("conv");
        iterateList(conv, stationMap, "conv", jedis);
        List<String> meter = saveType.get("meter");
        iterateList(meter, stationMap, "meter", jedis);
        List<String> env = saveType.get("env");
        iterateList(env, stationMap, "env", jedis);
        List<String> box = saveType.get("box");
        iterateList(box, stationMap, "box", jedis);
        List<String> dcbus = saveType.get("dcbus");
        iterateList(dcbus, stationMap, "dcbus", jedis);
    }
    //遍历List集合将数据存储进Redis
    public void iterateList(List<String> equipmentTypeList, HashMap<String, Map> stationMap, String type, Jedis jedis) {
        Iterator<String> iterator = equipmentTypeList.iterator();
        while (iterator.hasNext()) {
            String[] split = iterator.next().split("-");
            Object obj = stationMap.get(split[0]).get(split[1]);
            saveToRedis(jedis, type, obj);
        }
    }
}
