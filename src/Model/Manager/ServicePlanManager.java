package Model.Manager;

import java.util.ArrayList;
import Model.service_plan.*;

public class ServicePlanManager {
    private static final ServicePlanManager instance = new ServicePlanManager();

    private ServicePlanManager() {
    }

    public static ServicePlanManager getInstance() {
        return instance;
    }

    public Response filterServicePlanByPlanName(ArrayList<ServicePlan> plans, String planName) {
        ArrayList<ServicePlan> list = new ArrayList<>();

        for (ServicePlan plan : plans) {
            if (plan.getName().toLowerCase().contains(planName.toLowerCase())) {
                list.add(plan);
            }
        }

        return new Response(true, "successful to filter", list);
    }

    public Response filterServicePlanByPriceRange(ArrayList<ServicePlan> plans, double minPrice, double maxPrice) {
        ArrayList<ServicePlan> list = new ArrayList<>();

        for (ServicePlan plan : plans) {
            if ((plan.getMonthlyFee() >= minPrice && plan.getMonthlyFee() <= maxPrice)
                    || (plan.getSpecialMonthlyFee() >= minPrice && plan.getSpecialMonthlyFee() <= maxPrice)) {
                list.add(plan);
            }
        }

        return new Response(true, "successful to filter", list);
    }

    public Response filterServicePlanByDataUsage(ArrayList<ServicePlan> plans, double min, double max) {
        ArrayList<ServicePlan> list = new ArrayList<>();

        for (ServicePlan plan : plans) {
            if (plan.getFullSpeedShareService().getLocalDataUsageAmount() >= min && plan.getFullSpeedShareService().getLocalDataUsageAmount() <= max) {
                list.add(plan);
            }
        }

        return new Response(true, "successful to filter", list);
    }

    public Response filterServicePlanByExtraOffer(ArrayList<ServicePlan> plans) {
        ArrayList<ServicePlan> list = new ArrayList<>();

        for (ServicePlan plan : plans) {
            if (plan.getExtraOffers().size() > 0) {
                list.add(plan);
            }
        }

        return new Response(true, "successful to filter", list);
    }

    public Response clearFilter() {
        return new Response(true, "successful to filter", ServicePlanStorage.getInstance().getPlans());
    }

    public Response getPlanById (String id) {
        ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
        for (ServicePlan plan : plans) {
            if (plan.getPlanId().equals(id)) {
                return new Response(true, "successful to get plan", plan);
            }
        }
        return new Response(false, "plan not found!");
    }
}
