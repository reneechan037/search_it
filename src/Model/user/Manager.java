package Model.user;

import java.util.ArrayList;

import Model.Login.SearchingService;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

public class Manager extends User implements Role{
	private static final Manager instance = new Manager();

	private Manager m;
	private SearchingService searchService;

	public Manager(String u_id, String u_name, String u_pwd)
	{
		super(u_id, u_name, u_pwd);
		this.searchService = new SearchingService();
	}

	public Manager()
	{
		this.searchService = new SearchingService();
	}


	public static Manager getInstance()
	{
		return instance;
	}

	@Override
	public Manager getRole() {
		return m;
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
