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
	
	public boolean checkUserPlan(Client client)
	{
		for (ServicePlan plan : client.getPlans())
		{
			System.out.println(plan);
			System.out.print("");
		}
		if (client.getPlans().size() > 0)
			return true;
		else
			return false;
	}

	public boolean addPlan(ServicePlan plan)
	{
		ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
		for (ServicePlan cPlan : plans) {
			if (cPlan.getPlanId().equals(plan.getPlanId()))
				return false;
		}
		return plans.add(plan);
	}

	public boolean updatePlan(ServicePlan oldPlan, ServicePlan newPlan)
	{
		if (!oldPlan.getPlanId().equals(newPlan.getPlanId()))
			return false;
		try {
			ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
			int index = -1;
			for (int i = 0; i < plans.size(); i ++) {
				if (plans.get(i).getPlanId().equals(oldPlan.getPlanId()))
					index = i;
			}
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
