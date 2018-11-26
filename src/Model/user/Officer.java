package Model.user;

import java.util.ArrayList;

import Model.Login.SearchingService;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

public class Officer extends User{
	private SearchingService searchService;
	private Role r;
	
	public Officer(String u_id, String u_name, String u_pwd,Role r) {
		super(u_id, u_name, u_pwd);
		this.r = r;
		this.searchService = new SearchingService();
	}

	public Officer(){
		this.searchService = new SearchingService();
	}
	
	public Role getRole() {
		return r;
	}
	
	public void checkUserPlan(Client clinet)
	{
		for (ServicePlan plan : clinet.getPlans())
		{
			System.out.print(plan);
		}
	}

	public boolean addPlan(ServicePlan plan)
	{
		ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
		return plans.add(plan);
	}

	public boolean updatePlan(ServicePlan oldPlan, ServicePlan newPlan)
	{

		try {
			ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
			int index = plans.indexOf(oldPlan);
			plans.set(index, newPlan);
			return true;
		} catch (Exception e) {
			//TODO: handle exception
			return false;
		}
		

	}

	public boolean deletePlan(String planId)
	{
		ServicePlan plan = searchService.getPlanById(planId).getServicePlan();
		ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();

		return plans.remove(plan);
	}
}
