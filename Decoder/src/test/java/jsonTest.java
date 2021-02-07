import Bean.BoxDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import java.util.Date;

public class jsonTest {

    public static void main(String[] args) {
        TypeUtils.compatibleWithFieldName=true;
        BoxDTO boxDTO = new BoxDTO();
        boxDTO.setActivePower(23.33);
        boxDTO.setACurrent(12.1);
        boxDTO.setDeviceId(1);
        Date date = new Date();
        boxDTO.setDataTime(date);
        System.out.println(JSON.toJSONString(boxDTO));
    }
}
