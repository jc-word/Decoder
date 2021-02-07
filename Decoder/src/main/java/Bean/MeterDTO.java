package Bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class MeterDTO {
    private Double ForwardEP;
    private Double   ForwardEQ;
    private Double   BackwardEP;
    private Double   BackwardEQ;
    private Double  Sharp;
    private Double   Peak;
    private Double   Flat;
    private Double   Valley;
    private Double   Psum;
    private Double   Qsum;
    private Double   SystemPF;
    private Double   SystemFrequency;
    private Double   I1;
    private Double   I2;
    private Double   I3;
    private Double   U1;
    private Double   U2;
    private Double   U3;
    private Double   Uab;
    private Double   Ubc;
    private Double   Uca;
    private Integer PStationId;
    private Integer DeviceId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date DataTime;

    public Double getForwardEP() {
        return ForwardEP;
    }

    public void setForwardEP(Double forwardEP) {
        ForwardEP = forwardEP;
    }

    public Double getForwardEQ() {
        return ForwardEQ;
    }

    public void setForwardEQ(Double forwardEQ) {
        ForwardEQ = forwardEQ;
    }

    public Double getBackwardEP() {
        return BackwardEP;
    }

    public void setBackwardEP(Double backwardEP) {
        BackwardEP = backwardEP;
    }

    public Double getBackwardEQ() {
        return BackwardEQ;
    }

    public void setBackwardEQ(Double backwardEQ) {
        BackwardEQ = backwardEQ;
    }

    public Double getSharp() {
        return Sharp;
    }

    public void setSharp(Double sharp) {
        Sharp = sharp;
    }

    public Double getPeak() {
        return Peak;
    }

    public void setPeak(Double peak) {
        Peak = peak;
    }

    public Double getFlat() {
        return Flat;
    }

    public void setFlat(Double flat) {
        Flat = flat;
    }

    public Double getValley() {
        return Valley;
    }

    public void setValley(Double valley) {
        Valley = valley;
    }

    public Double getPsum() {
        return Psum;
    }

    public void setPsum(Double psum) {
        Psum = psum;
    }

    public Double getQsum() {
        return Qsum;
    }

    public void setQsum(Double qsum) {
        Qsum = qsum;
    }

    public Double getSystemPF() {
        return SystemPF;
    }

    public void setSystemPF(Double systemPF) {
        SystemPF = systemPF;
    }

    public Double getSystemFrequency() {
        return SystemFrequency;
    }

    public void setSystemFrequency(Double systemFrequency) {
        SystemFrequency = systemFrequency;
    }

    public Double getI1() {
        return I1;
    }

    public void setI1(Double i1) {
        I1 = i1;
    }

    public Double getI2() {
        return I2;
    }

    public void setI2(Double i2) {
        I2 = i2;
    }

    public Double getI3() {
        return I3;
    }

    public void setI3(Double i3) {
        I3 = i3;
    }

    public Double getU1() {
        return U1;
    }

    public void setU1(Double u1) {
        U1 = u1;
    }

    public Double getU2() {
        return U2;
    }

    public void setU2(Double u2) {
        U2 = u2;
    }

    public Double getU3() {
        return U3;
    }

    public void setU3(Double u3) {
        U3 = u3;
    }

    public Double getUab() {
        return Uab;
    }

    public void setUab(Double uab) {
        Uab = uab;
    }

    public Double getUbc() {
        return Ubc;
    }

    public void setUbc(Double ubc) {
        Ubc = ubc;
    }

    public Double getUca() {
        return Uca;
    }

    public void setUca(Double uca) {
        Uca = uca;
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
        return "MeterDTO{" +
                "ForwardEP=" + ForwardEP +
                ", ForwardEQ=" + ForwardEQ +
                ", BackwardEP=" + BackwardEP +
                ", BackwardEQ=" + BackwardEQ +
                ", Sharp=" + Sharp +
                ", Peak=" + Peak +
                ", Flat=" + Flat +
                ", Valley=" + Valley +
                ", Psum=" + Psum +
                ", Qsum=" + Qsum +
                ", SystemPF=" + SystemPF +
                ", SystemFrequency=" + SystemFrequency +
                ", I1=" + I1 +
                ", I2=" + I2 +
                ", I3=" + I3 +
                ", U1=" + U1 +
                ", U2=" + U2 +
                ", U3=" + U3 +
                ", Uab=" + Uab +
                ", Ubc=" + Ubc +
                ", Uca=" + Uca +
                ", PStationId=" + PStationId +
                ", DeviceId=" + DeviceId +
                ", DataTime=" + DataTime +
                '}';
    }
}
