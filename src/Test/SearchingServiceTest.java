package Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.FileReader;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.Manager.ServicePlanManager;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

class SearchingServiceTest {

	 ServicePlanManager servicePlanManager = ServicePlanManager.getInstance();
	 private ArrayList<ServicePlan> result= ServicePlanStorage.getInstance().getPlans();
	@BeforeEach
	void setUp() throws Exception {
		importPLan(result);
	}

	@Test
	public void filterServicePlanByPlanNametest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test= service.filterServicePlanByPlanName(result,"4G Supreme Service plan");
		int[] sma = new int[] {1,3,4};
		ServicePlan sa = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,sma,24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		list.add(sa);
		Response response = new Response(true, "successful to filter",list);
		
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());

	}
	@Test
	public void filterServicePlanByPlanNameNoPlantest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByPlanName(result,"I am Terry");
		assertEquals(list,test.getServicePlans());

	}
	@Test
	public void filterServicePlanByPriceRangetest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByPriceRange(result,140,150);
		int[] sma = new int[] {2,3,4,5,6,7,10};
		ServicePlan sa = new ServicePlan("P004","4G Easy Connect Service plans",178.00,150.00,sma,12,"months","5 GB",5.0,"GB","",1);
		list.add(sa);
		Response response = new Response(true, "successful to filter",list);
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());


	}
	@Test
	public void filterServicePlanByPriceRangeNoPlantest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByPriceRange(result,10000,10000);
		assertEquals(list,test.getServicePlans());
	}
	@Test
	public void filterServicePlanByDataUsage1GBtest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByDataUsage(result,0,0.99);
		Response response = new Response(true, "successful to filter",list);
		assertEquals(list,test.getServicePlans());

	}
	@Test
	public void filterServicePlanByDataUsage1GBTo5GBtest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByDataUsage(result,1,5);
		int[] sma;
		ServicePlan sa;	
		sma = new int[] {};
		 sa = new ServicePlan("P002","4G Anytime+ Service plan",108.00,0.00,sma,12,"months","5 GB",5.0,"GB","",1);
		list.add(sa);		
		sma = new int[] {10,12};
		 sa = new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2);
		list.add(sa);		
		sma = new int[] {2,3,4,5,6,7,10};
		 sa = new ServicePlan("P004","4G Easy Connect Service plans",178.00,150.00,sma,12,"months","5 GB",5.0,"GB","",1);
		list.add(sa);		
		sma = new int[] {};
		 sa = new ServicePlan("P005","Local Voice Plan 300mins/Month",16.00,0.00,sma,24,"months","1 GB",1.0,"GB","",3);
		list.add(sa);		
		sma = new int[] {};
		 sa = new ServicePlan("P006","Local Voice Plan 1200mins/Month",23.00,0.00,sma,24,"months","1 GB",1.0,"GB","",3);
		list.add(sa);				
		 sma = new int[] {2,3,4,5,6,7,10};
		 sa = new ServicePlan("P007","Local Voice Plan 2300mins/Month",68.00,0.00,sma,12,"months","1 GB",1.0,"GB","",1);
		list.add(sa);	
		Response response = new Response(true, "successful to filter",list);
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());
		assertEquals(response.getServicePlans().get(1).getName(),test.getServicePlans().get(1).getName());
		assertEquals(response.getServicePlans().get(2).getName(),test.getServicePlans().get(2).getName());
		assertEquals(response.getServicePlans().get(3).getName(),test.getServicePlans().get(3).getName());
		assertEquals(response.getServicePlans().get(4).getName(),test.getServicePlans().get(4).getName());
		assertEquals(response.getServicePlans().get(5).getName(),test.getServicePlans().get(5).getName());
	


	}
	@Test
	public void filterServicePlanByDataUsageOver5GBtest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByDataUsage(result,5.01,10000);
		int[] sma = new int[] {1,3,4};
		ServicePlan sa = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,sma,24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		list.add(sa);	
		Response response = new Response(true, "successful to filter",list);
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());
	}
	@Test
	public void filterServicePlanByExtraOffertest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.filterServicePlanByExtraOffer(result);
		int[] sma = new int[] {1,3,4};
		ServicePlan sa = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,sma,24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		list.add(sa);	
		Response response = new Response(true, "successful to filter",list);
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());
	}
	@Test
	public void clearFiltertest() {
		SearchingService service = new SearchingService();
		ArrayList<ServicePlan> list= new ArrayList();
		Response test=(Response) service.clearFilter();
		int[] sma;
		ServicePlan sa;	
		 sma = new int[] {1,3,4};
		 sa = new ServicePlan("P001","4G Supreme Service plan",120.00,80.00,sma,24,"months","10 GB",10.0,"GB","supermarket $50 coupon",1);
		list.add(sa);	
		sma = new int[] {};
		 sa = new ServicePlan("P002","4G Anytime+ Service plan",108.00,0.00,sma,12,"months","5 GB",5.0,"GB","",1);
		list.add(sa);		
		sma = new int[] {10,12};
		 sa = new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2);
		list.add(sa);		
		sma = new int[] {2,3,4,5,6,7,10};
		 sa = new ServicePlan("P004","4G Easy Connect Service plans",178.00,150.00,sma,12,"months","5 GB",5.0,"GB","",1);
		list.add(sa);		
		sma = new int[] {};
		 sa = new ServicePlan("P005","Local Voice Plan 300mins/Month",16.00,0.00,sma,24,"months","1 GB",1.0,"GB","",3);
		list.add(sa);		
		sma = new int[] {};
		 sa = new ServicePlan("P006","Local Voice Plan 1200mins/Month",23.00,0.00,sma,24,"months","1 GB",1.0,"GB","",3);
		list.add(sa);				
		 sma = new int[] {2,3,4,5,6,7,10};
		 sa = new ServicePlan("P007","Local Voice Plan 2300mins/Month",68.00,0.00,sma,12,"months","1 GB",1.0,"GB","",1);
		list.add(sa);	
		Response response = new Response(true, "successful to filter",list);
		assertEquals(response.getServicePlans().get(0).getName(),test.getServicePlans().get(0).getName());
		assertEquals(response.getServicePlans().get(1).getName(),test.getServicePlans().get(1).getName());
		assertEquals(response.getServicePlans().get(2).getName(),test.getServicePlans().get(2).getName());
		assertEquals(response.getServicePlans().get(3).getName(),test.getServicePlans().get(3).getName());
		assertEquals(response.getServicePlans().get(4).getName(),test.getServicePlans().get(4).getName());
		assertEquals(response.getServicePlans().get(5).getName(),test.getServicePlans().get(5).getName());
		assertEquals(response.getServicePlans().get(6).getName(),test.getServicePlans().get(6).getName());
	}
	
	@Test
	public void getPlanByIdtest() {
		SearchingService service = new SearchingService();
		Response test=(Response) service.getPlanById("P002");
		int[] sma;
		sma = new int[] {};
		Response response = new Response(true, "successful to get plan",new ServicePlan("P002","4G Anytime+ Service plan",108.00,0.00,sma,12,"months","5 GB",5.0,"GB","",1));
		assertEquals(response.getServicePlan().getName(),test.getServicePlan().getName());		
	}
	
	@Test
	public void getPlanByIdNoPlantest() {
		SearchingService service = new SearchingService();
		Response test=(Response) service.getPlanById("P00");
		int[] sma;
		sma = new int[] {};
		ServicePlan sa=null;
		Response response = new Response(true, "successful to get plan",sa);
		assertEquals(response.getServicePlan(),test.getServicePlan());		
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
