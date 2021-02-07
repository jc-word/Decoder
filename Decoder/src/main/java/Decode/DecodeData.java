package Decode;

public class DecodeData {

    private Integer DeviceId;
    private String AttrNameNew;
    private String RedisKey;

    public Integer getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(Integer deviceId) {
        DeviceId = deviceId;
    }

    public String getAttrNameNew() {
        return AttrNameNew;
    }

    public void setAttrNameNew(String attrNameNew) {
        AttrNameNew = attrNameNew;
    }

    public String getRedisKey() {
        return RedisKey;
    }

    public void setRedisKey(String redisKey) {
        RedisKey = redisKey;
    }

    @Override
    public String toString() {
        return "DecodeData{" +
                "DeviceId=" + DeviceId +
                ", AttrNameNew='" + AttrNameNew + '\'' +
                ", RedisKey='" + RedisKey + '\'' +
                '}';
    }
}
