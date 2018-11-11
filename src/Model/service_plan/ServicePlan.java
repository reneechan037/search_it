package Model.service_plan;


import java.util.ArrayList;

public class ServicePlan {
    private String planId;
    private String name;
    private int duration;
    private String durationUnit;

    private double monthlyFee;
    private double specialMonthlyFee;

    private FullSpeedShareService fullSpeedShareService;
    private AirtimeService airtimeService;
    private MessageService messageService;
    private ArrayList<ExtraOffer> extraOffers;

    private int planType;
    private int [] specialFeeMonth;

    public ServicePlan() {
    //    fullSpeedShareService = new FullSpeedShareService();
    //    airtimeService = new AirtimeService();
    //    messageService = new MessageService();
//        extraOffers = new ArrayList<>();
    }

    public ServicePlan(String pId, String name, double monthFee, double specialMonthFee, int[] specialMonth, int duration, String unit, int type)
    {
        this.planId = pId;
        this.name = name;
        this.monthlyFee = monthFee;
        this.specialMonthlyFee = specialMonthFee;
        this.specialFeeMonth = specialMonth;
        this.duration = duration;
        this.durationUnit = unit;

        setPlanType(type);

    }

    public void setPlanType(int type)
    {
        switch(type)
        {
            case 1:
                fullSpeedShareService = new FullSpeedShareService();
                break;
            case 2:
                airtimeService = new AirtimeService();
                break;
            case 3: 
                messageService = new MessageService();
                break;
            default:
                fullSpeedShareService = new FullSpeedShareService();
        }
    }

    public int getPlanType()
    {
        return planType;
    }

    public int [] getSpecialMonth()
    {
        return specialFeeMonth;
    }

    public String getPlanId() {
        return planId;
    }

    public void setSpecialMonth(int [] months)
    {
        this.specialFeeMonth = months;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setFullSpeedShareService(FullSpeedShareService fullSpeedShareService) {
        this.fullSpeedShareService = fullSpeedShareService;
    }

    public void setAirtimeService(AirtimeService airtimeService) {
        this.airtimeService = airtimeService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setExtraOffers(ArrayList<ExtraOffer> extraOffers) {
        this.extraOffers = extraOffers;
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
