package Decode;

import org.junit.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class DecoderInit {

    public static void setProperties() {

        String redisIp="";
        String filePath="";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("请输入redis的IP地址：");
            redisIp=bufferedReader.readLine();

            System.out.println("请输入文件的存储路径：");
             filePath=bufferedReader.readLine();


            WriteProperties("src/main/resources/init.properties","redisIp", redisIp);
            WriteProperties("src/main/resources/init.properties","filePath", filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void WriteProperties (String filePath, String pKey, String pValue) throws IOException {
               Properties pps = new Properties();

                 InputStream in = new FileInputStream(filePath);
                //从输入流中读取属性列表（键和元素对）
                pps.load(in);
                //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
                 //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
                 OutputStream out = new FileOutputStream(filePath);
                 pps.setProperty(pKey, pValue);
                //以适合使用 load 方法加载到 Properties 表中的格式，
                 //将此 Properties 表中的属性列表（键和元素对）写入输出流
                pps.store(out, "Update " + pKey + " name");
    }
    public static HashMap<String,String> getProperties(){
    HashMap<String, String> properties = new HashMap<>();

    String ip=GetValueByKey("src/main/resources/init.properties", "filePath");
    String path=GetValueByKey( "src/main/resources/init.properties", "redisIp");
    properties.put("path",path);
    properties.put("ip",ip);
    return properties;
}
    public static String GetValueByKey(String filePath, String key) {
                Properties pps = new Properties();
                try {
                        InputStream in = new BufferedInputStream (new FileInputStream(filePath));
                        pps.load(in);
                    return pps.getProperty(key);

                   }catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
            }

}
