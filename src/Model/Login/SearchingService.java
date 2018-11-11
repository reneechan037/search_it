package Model.Login;

import Model.Manager.Response;
import Model.Manager.ServicePlanManager;
import Model.service_plan.ServicePlan;

import java.util.ArrayList;

public class SearchingService {
    ServicePlanManager servicePlanManager = ServicePlanManager.getInstance();

    public SearchingService() {

    }

    public Response getPlanById(String id) {
        return servicePlanManager.getPlanById(id);
    }

    public Response filterServicePlanByPlanName(ArrayList<ServicePlan> plans, String name) {
        return servicePlanManager.filterServicePlanByPlanName(plans, name);
    }

    public Response filterServicePlanByPriceRange(ArrayList<ServicePlan> plans, double minPrice, double maxPrice) {
        return servicePlanManager.filterServicePlanByPriceRange(plans, minPrice, maxPrice);
    }

    public Response filterServicePlanByDataUsage(ArrayList<ServicePlan> plans, double min, double max) {
        return servicePlanManager.filterServicePlanByDataUsage(plans, min, max);
    }

    public Response filterServicePlanByExtraOffer(ArrayList<ServicePlan> plans) {
        return servicePlanManager.filterServicePlanByExtraOffer(plans);
    }

    public Response clearFilter() {
        return servicePlanManager.clearFilter();
    }
}
