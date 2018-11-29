package Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Helper.Helper;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Manager.*;
import Model.user.*;
import Model.Login.*;
import Model.Register.*;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;
import Model.Cache.*;

class TestManagerAction {
	ServicePlanManager servicePlanManager = ServicePlanManager.getInstance();
	 private ArrayList<ServicePlan> result= ServicePlanStorage.getInstance().getPlans();
	@BeforeEach
	void setUp() throws Exception {
		importPLan(result);
	}
	
	@Test
	public void test_ManagerAction_1_login() throws Exception {
		AccountManager am = AccountManager.getInstance();
		User u = new Officer("test1","test1","test1",new Staff());
		Response r;
		
		r = am.registerAccount(u);

		r = am.loginAccount("test1","test1");
		assertEquals(true, r.getResult());
	}
	
	@Test
	public void test_ManagerAction_2_addNewPlan() throws Exception {
		Officer manager = new Officer();
		ServicePlan newPlan = new ServicePlan("P010", "title", 90, 80, new int[] {1,2}, 12, "months", "5 GB", 5, "GB", "50 coupon", 1);
		boolean result = manager.addPlan(newPlan);
		assertEquals(true, result);
	}
	
	@Test
	public void test_ManagerAction_3_addNewPlanFail() throws Exception {
		Officer manager = new Officer();
		ServicePlan newPlan = new ServicePlan("P001", "title", 90, 80, new int[] {1,2}, 12, "months", "6 GB", 5, "GB", "50 coupon", 1);
		boolean result = manager.addPlan(newPlan);
		assertEquals(false, result);
	}
	
	@Test
	public void test_ManagerAction_4_updatePlan() throws Exception {
		Officer manager = new Officer();
		ServicePlan oldPlan = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,new int[] {1,3,4},24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		ServicePlan newPlan = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,new int[] {1,3,4},12,"months","5 GB",5.0,"GB","supermarket $50 coupon",1);
		boolean result = manager.updatePlan(oldPlan, newPlan);
		assertEquals(true, result);
	}
	
	@Test
	public void test_ManagerAction_5_updatePlanFail() throws Exception {
		Officer manager = new Officer();
		ServicePlan oldPlan = new ServicePlan("P010","4G Supreme Service plan",120.00,80.00,new int[] {1,3,4},24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		ServicePlan newPlan = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,new int[] {1,3,4},12,"months","5 GB",5.0,"GB","supermarket $50 coupon",1);
		boolean result = manager.updatePlan(oldPlan, newPlan);
		assertEquals(false, result);
	}
	
	@Test
	public void test_ManagerAction_6_deletePlan() throws Exception {
		Officer manager = new Officer();
		boolean result = manager.deletePlan("P001");
		assertEquals(true, result);
	}
	
	@Test
	public void test_ManagerAction_7_deletePlanFail() throws Exception {
		Officer manager = new Officer();
		boolean result = manager.deletePlan("P010");
		assertEquals(false, result);
	}
	
	@Test
	public void test_ManagerAction_8_checkUserPlan() throws Exception {
		ArrayList<String> dummyUser = new ArrayList<>();
		dummyUser.add("John");
		Officer manager = new Officer();
		boolean result = manager.checkUserPlan(Helper.dummyUser());
		assertEquals(true, result);
	}
	
	@Test
	public void test_ManagerAction_9_checkUserPlanWithNoPlanFound() throws Exception {
		Officer manager = new Officer();
		boolean result = manager.checkUserPlan(new Client("abc", "abc", "abc"));
		assertEquals(false, result);
	}
	
	public static void importPLan(ArrayList<ServicePlan> result) {
    	
        try {
            JSONParser p = new JSONParser();
        	Object obj = p.parse(new FileReader("./src/PlanData.json"));
        	JSONObject jo = (JSONObject) obj;
        	JSONArray jarray = (JSONArray)jo.get("servicePlan");
        	ServicePlan sp;
        	for(int i = 0 ; i < jarray.size() ; i++){
        		JSONObject innobj = (JSONObject)jarray.get(i);
        		JSONArray sm = (JSONArray)innobj.get("specialMonth");
        		int[] sma = new int[sm.size()];
        		for (int i2 = 0; i2 < sm.size(); ++i2) {
        			sma[i2] = (int)(((Long)sm.get(i2)).intValue());
        		}
        	    sp = new ServicePlan((String)innobj.get("planId"),(String)innobj.get("title"),(double)innobj.get("monthlyFee"),(double)innobj.get("specialMonthlyFee"),sma,(int)(((Long)innobj.get("duration")).intValue()),(String)innobj.get("unit"),(String)innobj.get("localDataUsage"),(double)innobj.get("localDataUsageAmount"),(String)innobj.get("localDataUsageUnit"),(String)innobj.get("extraOffer"),(int)(((Long)innobj.get("type")).intValue()));
        	    result.add(sp);
        	}
        	
        }catch(Exception e) {
        	//System.out.println(e.getMessage());
        }
    }
}
