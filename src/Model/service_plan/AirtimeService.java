package Model.service_plan;

public class AirtimeService {
    private String localAirtime;
    private double localAirtimeAmount;
    private String localAirtimeUnit;

    private String localVideoCall;
    private double localVideoCallAmount;
    private String localVideoCallUnit;

    public AirtimeService() {

    }

    public String getLocalAirtime() {
        return localAirtime;
    }

    public void setLocalAirtime(String localAirtime) {
        this.localAirtime = localAirtime;
    }

    public double getLocalAirtimeAmount() {
        return localAirtimeAmount;
    }

    public void setLocalAirtimeAmount(double localAirtimeAmount) {
        this.localAirtimeAmount = localAirtimeAmount;
    }

    public String getLocalAirtimeUnit() {
        return localAirtimeUnit;
    }

    public void setLocalAirtimeUnit(String localAirtimeUnit) {
        this.localAirtimeUnit = localAirtimeUnit;
    }

    public String getLocalVideoCall() {
        return localVideoCall;
    }

    public void setLocalVideoCall(String localVideoCall) {
        this.localVideoCall = localVideoCall;
    }

    public double getLocalVideoCallAmount() {
        return localVideoCallAmount;
    }

    public void setLocalVideoCallAmount(double localVideoCallAmount) {
        this.localVideoCallAmount = localVideoCallAmount;
    }

    public String getLocalVideoCallUnit() {
        return localVideoCallUnit;
    }

    public void setLocalVideoCallUnit(String localVideoCallUnit) {
        this.localVideoCallUnit = localVideoCallUnit;
    }
}
