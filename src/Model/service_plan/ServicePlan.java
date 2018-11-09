package Model.service_plan;


import java.util.ArrayList;

public class ServicePlan {
    private String name;
    private int duration;
    private String durationUnit;

    private double monthlyFee;
    private double specialMonthlyFee;

    private FullSpeedShareService fullSpeedShareService;
    private AirtimeService airtimeService;
    private MessageService messageService;
    private ArrayList<ExtraOffer> extraOffers;

    public ServicePlan() {
//        fullSpeedShareService = new FullSpeedShareService();
//        airtimeService = new AirtimeService();
//        messageService = new MessageService();
//        extraOffers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public double getSpecialMonthlyFee() {
        return specialMonthlyFee;
    }

    public void setSpecialMonthlyFee(double specialMonthlyFee) {
        this.specialMonthlyFee = specialMonthlyFee;
    }

    public FullSpeedShareService getFullSpeedShareService() {
        return fullSpeedShareService;
    }

    public AirtimeService getAirtimeService() {
        return airtimeService;
    }

    public MessageService getMessageService() {
        return messageService;
    }

    public ArrayList<ExtraOffer> getExtraOffers() {
        return extraOffers;
    }
}
