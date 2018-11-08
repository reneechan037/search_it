package Model.service_plan;

public class MessageService {
    private String localSMS;

    private int freeIntraNetworkSMS;
    private double intraNetworkSMSfee;

    private int freeInterNetworkSMS;
    private double interNetworkSMSfee;
    private double localSMSCharge;

    public MessageService() {

    }

    public String getLocalSMS() {
        return localSMS;
    }

    public void setLocalSMS(String localSMS) {
        this.localSMS = localSMS;
    }

    public int getFreeIntraNetworkSMS() {
        return freeIntraNetworkSMS;
    }

    public void setFreeIntraNetworkSMS(int freeIntraNetworkSMS) {
        this.freeIntraNetworkSMS = freeIntraNetworkSMS;
    }

    public double getIntraNetworkSMSfee() {
        return intraNetworkSMSfee;
    }

    public void setIntraNetworkSMSfee(double intraNetworkSMSfee) {
        this.intraNetworkSMSfee = intraNetworkSMSfee;
    }

    public int getFreeInterNetworkSMS() {
        return freeInterNetworkSMS;
    }

    public void setFreeInterNetworkSMS(int freeInterNetworkSMS) {
        this.freeInterNetworkSMS = freeInterNetworkSMS;
    }

    public double getInterNetworkSMSfee() {
        return interNetworkSMSfee;
    }

    public void setInterNetworkSMSfee(double interNetworkSMSfee) {
        this.interNetworkSMSfee = interNetworkSMSfee;
    }

    public double getLocalSMSCharge() {
        return localSMSCharge;
    }

    public void setLocalSMSCharge(double localSMSCharge) {
        this.localSMSCharge = localSMSCharge;
    }
}
