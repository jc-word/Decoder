package Decode;

import Bean.FileDTO;
import FileMonitoring.FileUtil;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void readFile(String filepath, long fileSize,String ipadd,String connectionUrl) {

        if (FileUtil.getDirectorySize(filepath) != fileSize) {
            //创建RedisForDecoder对象获取redis连接
            RedisForDecoder redisForDecoder = new RedisForDecoder(ipadd);
            Jedis jedis = redisForDecoder.linkToRedis();
            List<FileDTO> fileList = new ArrayList<>();
            FileUtil.getFile(filepath, fileList);
            Decoder decoder = new Decoder(connectionUrl);
            decoder.init();
            List<Map> list = null;
            for (FileDTO fileDTO : fileList) {
                list = decoder.readFile(fileDTO.getFile());
                System.out.println("已读取：" + fileDTO.getFile());
                //将数据存储进redis
                redisForDecoder.saveData((HashMap<String, Map>) list.get(0), (HashMap<String, List<String>>) list.get(1), jedis);
            }
//        redisForDecoder.showRedisList(jedis,"meter",0,10000);
            decoder.close();

        }
        try {
            System.out.println("休眠中··············");
            Thread.sleep(5000);
            readFile(filepath, fileSize,ipadd,connectionUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String ipadd = "null";
        String filepath ="null";
        String connectionUrl="null";
        if (ipadd.equals("null")) {
            System.out.println("请初始化redis的Ip地址：");
            try {
                ipadd = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (filepath.equals("null")) {
            System.out.println("请初始化文件地址：");
            try {
                filepath = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (connectionUrl.equals("null")) {
            System.out.println("请初始化数据库连接地址：");
            System.out.println("数据库地址格式实例：jdbc:sqlserver://192.168.0.142:1433;databaseName=PowerStation;user=sa;password=sarnath123!@#");
            try {
                connectionUrl = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        readFile(filepath, -1,ipadd, connectionUrl);
    }
}

