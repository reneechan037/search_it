package Model.service_plan;

import java.util.ArrayList;

public class ServicePlanStorage {
	private static final ServicePlanStorage instance = new ServicePlanStorage();
	private ArrayList<ServicePlan> plans;
	
	public static ServicePlanStorage getInstance() {
        return instance;
    }
	
	private ServicePlanStorage() {
		plans = new ArrayList<>();
	}
	
	public void setPlans(ArrayList<ServicePlan> plans) {
		this.plans = plans;
	}
	
	public ArrayList<ServicePlan> getPlans() {
		return this.plans;
	}
}
