package Model.Manager;

import java.util.ArrayList;

import Model.service_plan.*;

public class SearchingManager {
	// plan name
	
	// price range
	
	// functional
	
	// data usage
	
	// extra offer
	
	public ArrayList<ServicePlan> getServicePlanByPlanName(String planName) {
		ArrayList<ServicePlan> list = new ArrayList<>();
		ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
		
		for(ServicePlan plan : plans) {
			if (plan.getName().toLowerCase().contains(planName.toLowerCase())) {
				list.add(plan);
			}
		}
		
		return list;
	}
	
	public ArrayList<ServicePlan> filterServicePlanByPriceRange(ArrayList<ServicePlan> plans, double minPrice, double maxPrice) {
		ArrayList<ServicePlan> list = new ArrayList<>();
		
		for (ServicePlan plan : plans) {
			if ((plan.getMonthlyFee() >= minPrice && plan.getMonthlyFee() <= maxPrice)
					|| (plan.getSpecialMonthlyFee() >= minPrice && plan.getSpecialMonthlyFee() <= maxPrice)) {
				list.add(plan);
			}
		}
		
		return list;
	}
}
