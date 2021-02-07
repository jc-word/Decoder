package Bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class EnvDTO {
   private Double WindSpeed;
    private Double Humidity;
    private Double EnviTemperature;
    private Double PanelTemperature;
    private Double Irradiance;
    private Double HorizontalIrradiance;
    private Double WindDirection;
    private Integer PStationId;
    private Integer DeviceId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date DataTime;

    public Double getWindSpeed() {
        return WindSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        WindSpeed = windSpeed;
    }

    public Double getHumidity() {
        return Humidity;
    }

    public void setHumidity(Double humidity) {
        Humidity = humidity;
    }

    public Double getEnviTemperature() {
        return EnviTemperature;
    }

    public void setEnviTemperature(Double enviTemperature) {
        EnviTemperature = enviTemperature;
    }

    public Double getPanelTemperature() {
        return PanelTemperature;
    }

    public void setPanelTemperature(Double panelTemperature) {
        PanelTemperature = panelTemperature;
    }

    public Double getIrradiance() {
        return Irradiance;
    }

    public void setIrradiance(Double irradiance) {
        Irradiance = irradiance;
    }

    public Double getHorizontalIrradiance() {
        return HorizontalIrradiance;
    }

    public void setHorizontalIrradiance(Double horizontalIrradiance) {
        HorizontalIrradiance = horizontalIrradiance;
    }

    public Double getWindDirection() {
        return WindDirection;
    }

    public void setWindDirection(Double windDirection) {
        WindDirection = windDirection;
    }

    public Integer getPStationId() {
        return PStationId;
    }

    public void setPStationId(Integer PStationId) {
        this.PStationId = PStationId;
    }

    public Integer getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(Integer deviceId) {
        DeviceId = deviceId;
    }

    public Date getDataTime() {
        return DataTime;
    }

    public void setDataTime(Date dataTime) {
        DataTime = dataTime;
    }

    @Override
    public String toString() {
        return "EnvDTO{" +
                "WindSpeed=" + WindSpeed +
                ", Humidity=" + Humidity +
                ", EnviTemperature=" + EnviTemperature +
                ", PanelTemperature=" + PanelTemperature +
                ", Irradiance=" + Irradiance +
                ", HorizontalIrradiance=" + HorizontalIrradiance +
                ", WindDirection=" + WindDirection +
                ", PStationId=" + PStationId +
                ", DeviceId=" + DeviceId +
                ", DataTime=" + DataTime +
                '}';
    }
}
