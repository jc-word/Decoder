package Bean;



import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;


public class InvDTO {
    private Double InverterState;
    private Double DayTakeTime;
    private Double TakeAllTime;
    private Double DCV;
    private Double DCCurrent;
    private Double DCPower;
    private Double TotalPower;
    private Double TotalPowerL;
    private Double TotalPowerH;
    private Double TActivePower;
    private Double Qtotal;
    private Double DayPower;
    private Double AVoltage;
    private Double BVoltage;
    private Double CVoltage;
    private Double Vab;
    private Double Vbc;
    private Double Vca;
    private Double ACurrent;
    private Double BCurrent;
    private Double CCurrent;
    private Double Afault;
    private Double Bfault;
    private Double Cfault;
    private Double Stotal;
    private Double GridFrequency;
    private Double PowerFactor;
    private Double AirTemperature;
    private Double RadiatorTemperature;
    private Double TransformerTemperature;
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
    private Double VoltageNo1;
    private Double VoltageNo2;
    private Double VoltageNo3;
    private Double VoltageNo4;
    private Double VoltageNo5;
    private Double VoltageNo6;
    private Double VoltageNo7;
    private Double VoltageNo8;
    private Double VoltageNo9;
    private Double VoltageNo10;
    private Double VoltageNo11;
    private Double VoltageNo12;
    private Double VoltageNo13;
    private Double VoltageNo14;
    private Double VoltageNo15;
    private Double VoltageNo16;
    private Double Pa;
    private Double Pb;
    private Double Pc;
    private Double Qa;
    private Double Qb;
    private Double Qc;
    private Double Sa;
    private Double Sb;
    private Double Sc;
    private Integer PStationId;
    private Integer DeviceId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date DataTime;

    public Double getInverterState() {
        return InverterState;
    }

    public void setInverterState(Double inverterState) {
        InverterState = inverterState;
    }

    public Double getDayTakeTime() {
        return DayTakeTime;
    }

    public void setDayTakeTime(Double dayTakeTime) {
        DayTakeTime = dayTakeTime;
    }

    public Double getTakeAllTime() {
        return TakeAllTime;
    }

    public void setTakeAllTime(Double takeAllTime) {
        TakeAllTime = takeAllTime;
    }

    public Double getDCV() {
        return DCV;
    }

    public void setDCV(Double DCV) {
        this.DCV = DCV;
    }

    public Double getDCCurrent() {
        return DCCurrent;
    }

    public void setDCCurrent(Double DCCurrent) {
        this.DCCurrent = DCCurrent;
    }

    public Double getDCPower() {
        return DCPower;
    }

    public void setDCPower(Double DCPower) {
        this.DCPower = DCPower;
    }

    public Double getTotalPower() {
        return TotalPower;
    }

    public void setTotalPower(Double totalPower) {
        TotalPower = totalPower;
    }

    public Double getTotalPowerL() {
        return TotalPowerL;
    }

    public void setTotalPowerL(Double totalPowerL) {
        TotalPowerL = totalPowerL;
    }

    public Double getTotalPowerH() {
        return TotalPowerH;
    }

    public void setTotalPowerH(Double totalPowerH) {
        TotalPowerH = totalPowerH;
    }

    public Double getTActivePower() {
        return TActivePower;
    }

    public void setTActivePower(Double TActivePower) {
        this.TActivePower = TActivePower;
    }

    public Double getQtotal() {
        return Qtotal;
    }

    public void setQtotal(Double qtotal) {
        Qtotal = qtotal;
    }

    public Double getDayPower() {
        return DayPower;
    }

    public void setDayPower(Double dayPower) {
        DayPower = dayPower;
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

    public Double getAfault() {
        return Afault;
    }

    public void setAfault(Double afault) {
        Afault = afault;
    }

    public Double getBfault() {
        return Bfault;
    }

    public void setBfault(Double bfault) {
        Bfault = bfault;
    }

    public Double getCfault() {
        return Cfault;
    }

    public void setCfault(Double cfault) {
        Cfault = cfault;
    }

    public Double getStotal() {
        return Stotal;
    }

    public void setStotal(Double stotal) {
        Stotal = stotal;
    }

    public Double getGridFrequency() {
        return GridFrequency;
    }

    public void setGridFrequency(Double gridFrequency) {
        GridFrequency = gridFrequency;
    }

    public Double getPowerFactor() {
        return PowerFactor;
    }

    public void setPowerFactor(Double powerFactor) {
        PowerFactor = powerFactor;
    }

    public Double getAirTemperature() {
        return AirTemperature;
    }

    public void setAirTemperature(Double airTemperature) {
        AirTemperature = airTemperature;
    }

    public Double getRadiatorTemperature() {
        return RadiatorTemperature;
    }

    public void setRadiatorTemperature(Double radiatorTemperature) {
        RadiatorTemperature = radiatorTemperature;
    }

    public Double getTransformerTemperature() {
        return TransformerTemperature;
    }

    public void setTransformerTemperature(Double transformerTemperature) {
        TransformerTemperature = transformerTemperature;
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

    public Double getVoltageNo1() {
        return VoltageNo1;
    }

    public void setVoltageNo1(Double voltageNo1) {
        VoltageNo1 = voltageNo1;
    }

    public Double getVoltageNo2() {
        return VoltageNo2;
    }

    public void setVoltageNo2(Double voltageNo2) {
        VoltageNo2 = voltageNo2;
    }

    public Double getVoltageNo3() {
        return VoltageNo3;
    }

    public void setVoltageNo3(Double voltageNo3) {
        VoltageNo3 = voltageNo3;
    }

    public Double getVoltageNo4() {
        return VoltageNo4;
    }

    public void setVoltageNo4(Double voltageNo4) {
        VoltageNo4 = voltageNo4;
    }

    public Double getVoltageNo5() {
        return VoltageNo5;
    }

    public void setVoltageNo5(Double voltageNo5) {
        VoltageNo5 = voltageNo5;
    }

    public Double getVoltageNo6() {
        return VoltageNo6;
    }

    public void setVoltageNo6(Double voltageNo6) {
        VoltageNo6 = voltageNo6;
    }

    public Double getVoltageNo7() {
        return VoltageNo7;
    }

    public void setVoltageNo7(Double voltageNo7) {
        VoltageNo7 = voltageNo7;
    }

    public Double getVoltageNo8() {
        return VoltageNo8;
    }

    public void setVoltageNo8(Double voltageNo8) {
        VoltageNo8 = voltageNo8;
    }

    public Double getVoltageNo9() {
        return VoltageNo9;
    }

    public void setVoltageNo9(Double voltageNo9) {
        VoltageNo9 = voltageNo9;
    }

    public Double getVoltageNo10() {
        return VoltageNo10;
    }

    public void setVoltageNo10(Double voltageNo10) {
        VoltageNo10 = voltageNo10;
    }

    public Double getVoltageNo11() {
        return VoltageNo11;
    }

    public void setVoltageNo11(Double voltageNo11) {
        VoltageNo11 = voltageNo11;
    }

    public Double getVoltageNo12() {
        return VoltageNo12;
    }

    public void setVoltageNo12(Double voltageNo12) {
        VoltageNo12 = voltageNo12;
    }

    public Double getVoltageNo13() {
        return VoltageNo13;
    }

    public void setVoltageNo13(Double voltageNo13) {
        VoltageNo13 = voltageNo13;
    }

    public Double getVoltageNo14() {
        return VoltageNo14;
    }

    public void setVoltageNo14(Double voltageNo14) {
        VoltageNo14 = voltageNo14;
    }

    public Double getVoltageNo15() {
        return VoltageNo15;
    }

    public void setVoltageNo15(Double voltageNo15) {
        VoltageNo15 = voltageNo15;
    }

    public Double getVoltageNo16() {
        return VoltageNo16;
    }

    public void setVoltageNo16(Double voltageNo16) {
        VoltageNo16 = voltageNo16;
    }

    public Double getPa() {
        return Pa;
    }

    public void setPa(Double pa) {
        Pa = pa;
    }

    public Double getPb() {
        return Pb;
    }

    public void setPb(Double pb) {
        Pb = pb;
    }

    public Double getPc() {
        return Pc;
    }

    public void setPc(Double pc) {
        Pc = pc;
    }

    public Double getQa() {
        return Qa;
    }

    public void setQa(Double qa) {
        Qa = qa;
    }

    public Double getQb() {
        return Qb;
    }

    public void setQb(Double qb) {
        Qb = qb;
    }

    public Double getQc() {
        return Qc;
    }

    public void setQc(Double qc) {
        Qc = qc;
    }

    public Double getSa() {
        return Sa;
    }

    public void setSa(Double sa) {
        Sa = sa;
    }

    public Double getSb() {
        return Sb;
    }

    public void setSb(Double sb) {
        Sb = sb;
    }

    public Double getSc() {
        return Sc;
    }

    public void setSc(Double sc) {
        Sc = sc;
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
        return "InvDTO{" +
                "InverterState=" + InverterState +
                ", DayTakeTime=" + DayTakeTime +
                ", TakeAllTime=" + TakeAllTime +
                ", DCV=" + DCV +
                ", DCCurrent=" + DCCurrent +
                ", DCPower=" + DCPower +
                ", TotalPower=" + TotalPower +
                ", TotalPowerL=" + TotalPowerL +
                ", TotalPowerH=" + TotalPowerH +
                ", TActivePower=" + TActivePower +
                ", Qtotal=" + Qtotal +
                ", DayPower=" + DayPower +
                ", AVoltage=" + AVoltage +
                ", BVoltage=" + BVoltage +
                ", CVoltage=" + CVoltage +
                ", Vab=" + Vab +
                ", Vbc=" + Vbc +
                ", Vca=" + Vca +
                ", ACurrent=" + ACurrent +
                ", BCurrent=" + BCurrent +
                ", CCurrent=" + CCurrent +
                ", Afault=" + Afault +
                ", Bfault=" + Bfault +
                ", Cfault=" + Cfault +
                ", Stotal=" + Stotal +
                ", GridFrequency=" + GridFrequency +
                ", PowerFactor=" + PowerFactor +
                ", AirTemperature=" + AirTemperature +
                ", RadiatorTemperature=" + RadiatorTemperature +
                ", TransformerTemperature=" + TransformerTemperature +
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
                ", VoltageNo1=" + VoltageNo1 +
                ", VoltageNo2=" + VoltageNo2 +
                ", VoltageNo3=" + VoltageNo3 +
                ", VoltageNo4=" + VoltageNo4 +
                ", VoltageNo5=" + VoltageNo5 +
                ", VoltageNo6=" + VoltageNo6 +
                ", VoltageNo7=" + VoltageNo7 +
                ", VoltageNo=" + VoltageNo8 +
                ", VoltageNo9=" + VoltageNo9 +
                ", VoltageNo10=" + VoltageNo10 +
                ", VoltageNo11=" + VoltageNo11 +
                ", VoltageNo12=" + VoltageNo12 +
                ", VoltageNo13=" + VoltageNo13 +
                ", VoltageNo14=" + VoltageNo14 +
                ", VoltageNo15=" + VoltageNo15 +
                ", VoltageNo16=" + VoltageNo16 +
                ", Pa=" + Pa +
                ", Pb=" + Pb +
                ", Pc=" + Pc +
                ", Qa=" + Qa +
                ", Qb=" + Qb +
                ", Qc=" + Qc +
                ", Sa=" + Sa +
                ", Sb=" + Sb +
                ", Sc=" + Sc +
                ", PStationId=" + PStationId +
                ", DeviceId=" + DeviceId +
                ", DataTime=" + DataTime +
                '}';
    }
}
