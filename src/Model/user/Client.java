package Model.user;

import java.util.ArrayList;

import Model.service_plan.ServicePlan;

public class Client extends User{
	private ArrayList<ServicePlan> plans;

	public Client(String u_id, String u_name, String u_pwd) {
		super(u_id, u_name, u_pwd);
		// TODO Auto-generated constructor stub
		plans = new ArrayList<>();
	}
	
	public void setPlans(ArrayList<ServicePlan> plan)
	{
		this.plans = plan;
	}

	public ArrayList<ServicePlan> getPlans()
	{
		return this.plans;
	}

}
