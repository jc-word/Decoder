package Bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class BoxDTO {
    private  Double Vab;
    private  Double Vbc;
    private  Double Vca;
    private  Double AVoltage;
    private  Double BVoltage;
    private  Double CVoltage;
    private  Double ACurrent;
    private  Double BCurrent;
    private  Double CCurrent;
//    @JSONField(name = "ActivePower")
    private  Double ActivePower;
    private  Double ReActivitPower;
    private  Double  PowerFactor;
    private  Double  Frequency;
    private  Integer  PStationId;
    private  Integer DeviceId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date DataTime;

    public Double getVab() {
        return Vab;
    }

    public void setVab(Double vab) {
        Vab = vab;
    }

    public Double getVbc() {
        return Vbc;
    }

    public void setVbc(Double vbc) {
        Vbc = vbc;
    }

    public Double getVca() {
        return Vca;
    }

    public void setVca(Double vca) {
        Vca = vca;
    }

    public Double getAVoltage() {
        return AVoltage;
    }

    public void setAVoltage(Double AVoltage) {
        this.AVoltage = AVoltage;
    }

    public Double getBVoltage() {
        return BVoltage;
    }

    public void setBVoltage(Double BVoltage) {
        this.BVoltage = BVoltage;
    }

    public Double getCVoltage() {
        return CVoltage;
    }

    public void setCVoltage(Double CVoltage) {
        this.CVoltage = CVoltage;
    }

    public Double getACurrent() {
        return ACurrent;
    }

    public void setACurrent(Double ACurrent) {
        this.ACurrent = ACurrent;
    }

    public Double getBCurrent() {
        return BCurrent;
    }

    public void setBCurrent(Double BCurrent) {
        this.BCurrent = BCurrent;
    }

    public Double getCCurrent() {
        return CCurrent;
    }

    public void setCCurrent(Double CCurrent) {
        this.CCurrent = CCurrent;
    }

    public Double getActivePower() {
        return ActivePower;
    }

    public void setActivePower(Double activePower) {
        ActivePower = activePower;
    }

    public Double getReActivitPower() {
        return ReActivitPower;
    }

    public void setReActivitPower(Double reActivitPower) {
        ReActivitPower = reActivitPower;
    }

    public Double getPowerFactor() {
        return PowerFactor;
    }

    public void setPowerFactor(Double powerFactor) {
        PowerFactor = powerFactor;
    }

    public Double getFrequency() {
        return Frequency;
    }

    public void setFrequency(Double frequency) {
        Frequency = frequency;
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
        return "PadmountedDTO{" +
                "Vab=" + Vab +
                ", Vbc=" + Vbc +
                ", Vca=" + Vca +
                ", AVoltage=" + AVoltage +
                ", BVoltage=" + BVoltage +
                ", CVoltage=" + CVoltage +
                ", ACurrent=" + ACurrent +
                ", BCurrent=" + BCurrent +
                ", CCurrent=" + CCurrent +
                ", ActivePower=" + ActivePower +
                ", ReActivitPower=" + ReActivitPower +
                ", PowerFactor=" + PowerFactor +
                ", Frequency=" + Frequency +
                ", PStationId=" + PStationId +
                ", DeviceId=" + DeviceId +
                ", DataTime=" + DataTime +
                '}';
    }
}
