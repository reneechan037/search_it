package Model.Manager;

import Model.service_plan.ServicePlan;

import java.util.ArrayList;

public class Response {
    private boolean result;
    private String description;
    private String u_id;
    private ArrayList<ServicePlan> servicePlans;
    private ServicePlan servicePlan;

    public Response(boolean result, String description) {
        this.result = result;
        this.description = description;
    }

    public Response(boolean result, String description, String u_id) {
        this.result = result;
        this.description = description;
        this.u_id = u_id;
    }

    public Response(boolean result, String description, ArrayList<ServicePlan> servicePlans) {
        this.result = result;
        this.description = description;
        this.servicePlans = servicePlans;
    }

    public Response(boolean result, String description, ServicePlan servicePlan) {
        this.result = result;
        this.description = description;
        this.servicePlan = servicePlan;
    }

    public boolean getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }

    public String getU_id() {
        return u_id;
    }

    public ArrayList<ServicePlan> getServicePlans() { return servicePlans; }

    public ServicePlan getServicePlan() { return servicePlan; }
}
