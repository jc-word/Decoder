package Bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class DcbusDTO {
    private Double InternalTemperature;
    private Double DCBusVoltage;
    private Double TotalCurrent;
    private Double CurrentNo1;
    private Double CurrentNo2;
    private Double CurrentNo3;
    private Double CurrentNo4;
    private Double CurrentNo5;
    private Double CurrentNo6;
    private Double CurrentNo7;
    private Double CurrentNo8;
    private Double CurrentNo9;
    private Double CurrentNo10;
    private Double CurrentNo11;
    private Double CurrentNo12;
    private Double CurrentNo13;
    private Double CurrentNo14;
    private Double CurrentNo15;
    private Double CurrentNo16;
    private Integer PStationId;
    private Integer DeviceId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date DataTime;

    public Double getInternalTemperature() {
        return InternalTemperature;
    }

    public void setInternalTemperature(Double internalTemperature) {
        InternalTemperature = internalTemperature;
    }

    public Double getDCBusVoltage() {
        return DCBusVoltage;
    }

    public void setDCBusVoltage(Double DCBusVoltage) {
        this.DCBusVoltage = DCBusVoltage;
    }

    public Double getTotalCurrent() {
        return TotalCurrent;
    }

    public void setTotalCurrent(Double totalCurrent) {
        TotalCurrent = totalCurrent;
    }

    public Double getCurrentNo1() {
        return CurrentNo1;
    }

    public void setCurrentNo1(Double currentNo1) {
        CurrentNo1 = currentNo1;
    }

    public Double getCurrentNo2() {
        return CurrentNo2;
    }

    public void setCurrentNo2(Double currentNo2) {
        CurrentNo2 = currentNo2;
    }

    public Double getCurrentNo3() {
        return CurrentNo3;
    }

    public void setCurrentNo3(Double currentNo3) {
        CurrentNo3 = currentNo3;
    }

    public Double getCurrentNo4() {
        return CurrentNo4;
    }

    public void setCurrentNo4(Double currentNo4) {
        CurrentNo4 = currentNo4;
    }

    public Double getCurrentNo5() {
        return CurrentNo5;
    }

    public void setCurrentNo5(Double currentNo5) {
        CurrentNo5 = currentNo5;
    }

    public Double getCurrentNo6() {
        return CurrentNo6;
    }

    public void setCurrentNo6(Double currentNo6) {
        CurrentNo6 = currentNo6;
    }

    public Double getCurrentNo7() {
        return CurrentNo7;
    }

    public void setCurrentNo7(Double currentNo7) {
        CurrentNo7 = currentNo7;
    }

    public Double getCurrentNo8() {
        return CurrentNo8;
    }

    public void setCurrentNo8(Double currentNo8) {
        CurrentNo8 = currentNo8;
    }

    public Double getCurrentNo9() {
        return CurrentNo9;
    }

    public void setCurrentNo9(Double currentNo9) {
        CurrentNo9 = currentNo9;
    }

    public Double getCurrentNo10() {
        return CurrentNo10;
    }

    public void setCurrentNo10(Double currentNo10) {
        CurrentNo10 = currentNo10;
    }

    public Double getCurrentNo11() {
        return CurrentNo11;
    }

    public void setCurrentNo11(Double currentNo11) {
        CurrentNo11 = currentNo11;
    }

    public Double getCurrentNo12() {
        return CurrentNo12;
    }

    public void setCurrentNo12(Double currentNo12) {
        CurrentNo12 = currentNo12;
    }

    public Double getCurrentNo13() {
        return CurrentNo13;
    }

    public void setCurrentNo13(Double currentNo13) {
        CurrentNo13 = currentNo13;
    }

    public Double getCurrentNo14() {
        return CurrentNo14;
    }

    public void setCurrentNo14(Double currentNo14) {
        CurrentNo14 = currentNo14;
    }

    public Double getCurrentNo15() {
        return CurrentNo15;
    }

    public void setCurrentNo15(Double currentNo15) {
        CurrentNo15 = currentNo15;
    }

    public Double getCurrentNo16() {
        return CurrentNo16;
    }

    public void setCurrentNo16(Double currentNo16) {
        CurrentNo16 = currentNo16;
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
        return "DcbusDTO{" +
                "InternalTemperature=" + InternalTemperature +
                ", DCBusVoltage=" + DCBusVoltage +
                ", TotalCurrent=" + TotalCurrent +
                ", CurrentNo1=" + CurrentNo1 +
                ", CurrentNo2=" + CurrentNo2 +
                ", CurrentNo3=" + CurrentNo3 +
                ", CurrentNo4=" + CurrentNo4 +
                ", CurrentNo5=" + CurrentNo5 +
                ", CurrentNo6=" + CurrentNo6 +
                ", CurrentNo7=" + CurrentNo7 +
                ", CurrentNo8=" + CurrentNo8 +
                ", CurrentNo9=" + CurrentNo9 +
                ", CurrentNo10=" + CurrentNo10 +
                ", CurrentNo11=" + CurrentNo11 +
                ", CurrentNo12=" + CurrentNo12 +
                ", CurrentNo13=" + CurrentNo13 +
                ", CurrentNo14=" + CurrentNo14 +
                ", CurrentNo15=" + CurrentNo15 +
                ", CurrentNo16=" + CurrentNo16 +
                ", PStationId=" + PStationId +
                ", DeviceId=" + DeviceId +
                ", DataTime=" + DataTime +
                '}';
    }
}
