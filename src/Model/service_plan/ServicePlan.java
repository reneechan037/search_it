package Model.service_plan;


import java.util.ArrayList;
import java.util.Arrays;

public class ServicePlan {
    private String planId;
    private String name;
    private int duration;
    private String durationUnit;

    private double monthlyFee;
    private double specialMonthlyFee;
    private String localDataUsage;
    private double localDataUsageAmount;
    private String localDataUsageUnit;

    private FullSpeedShareService fullSpeedShareService;
    private AirtimeService airtimeService;
    private MessageService messageService;
    private String extraOffer;

    private int planType;
    private int [] specialFeeMonth;

    public ServicePlan() {
    //    fullSpeedShareService = new FullSpeedShareService();
    //    airtimeService = new AirtimeService();
    //    messageService = new MessageService();
//        extraOffers = new ArrayList<>();
    }

    public ServicePlan(String pId, String name, double monthFee, double specialMonthFee, int[] specialMonth, int duration, String unit, String localDataUsage, double localDataUsageAmount, String localDataUsageUnit, String extraOffer, int type)
    {
        this.planId = pId;
        this.name = name;
        this.monthlyFee = monthFee;
        this.specialMonthlyFee = specialMonthFee;
        this.specialFeeMonth = specialMonth;
        this.duration = duration;
        this.durationUnit = unit;
        this.localDataUsage = localDataUsage;
        this.localDataUsageAmount = localDataUsageAmount;
        this.localDataUsageUnit = localDataUsageUnit;
        this.planType = type;
        this.extraOffer = extraOffer;
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

    @Override
    public String toString()
    {
        return String.format("Plan Id:%s\nPlan Type:%d\nPlan name:%s\nMonthly fee:%f\nSpecial monthly fee:%f\nMonths for special fee:%s\nPlan duration:%d %s\n", 
                            planId,planType,name,monthlyFee,specialMonthlyFee,Arrays.toString(specialFeeMonth),duration,durationUnit);
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

    public void setExtraOffer(String extraOffer) {
        this.extraOffer = extraOffer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocalDataUsage() {
        return localDataUsage;
    }

    public void setLocalDataUsage(String localDataUsage) {
        this.localDataUsage = localDataUsage;
    }

    public double getLocalDataUsageAmount() {
        return localDataUsageAmount;
    }

    public void setLocalDataUsageAmount(double localDataUsageAmount) {
        this.localDataUsageAmount = localDataUsageAmount;
    }

    public String getLocalDataUsageUnit() {
        return localDataUsageUnit;
    }

    public void setLocalDataUsageUnit(String localDataUsageUnit) {
        this.localDataUsageUnit = localDataUsageUnit;
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

    public String getExtraOffer() {
        return extraOffer;
    }
}
