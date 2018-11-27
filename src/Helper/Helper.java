package Helper;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;
import Model.user.Client;

public class Helper {
    public Helper() {};

    public static boolean isNumber(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public static boolean isDouble(String str)
    {
        try
        {
            
            Double.parseDouble(str);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public static Client dummyUser() {
    	ArrayList<ServicePlan> spal = new ArrayList<>();       
        try {
            JSONParser p = new JSONParser();
        	Object obj = p.parse(new FileReader("./src/dummyUserPlan.json"));
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
        	    spal.add(sp);
        	}
        	
        	Client c = new Client("999","jogn", "test");
        	c.setPlans(spal);
        	
        	return c;
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        	return null;
        }
    }


    public static String seperateStyleString(String str)
    {
        return "\n---------------------------------- "+str+"  --------------------------------------------------------------\n";
    }
}
