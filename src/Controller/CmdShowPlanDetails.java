package Controller;

import Model.Cache.Cache;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.Manager.ServicePlanManager;
import Model.ShoppingCart.ManageShoppingCart;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdShowPlanDetails implements Command {

    public CmdShowPlanDetails() {

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        // show plan code
        SearchingService service = new SearchingService();
        Response response = service.getPlanById(cmdParts[0]);

        if (response.getResult()) {
            String input;
            System.out.println("Back: 0 | Add to cart: 1");
            input = in.nextLine();
            if (input.equals("1")) {
                int result=0;
                for (ServicePlan plan : ServicePlanStorage.getInstance().getPlans()) {
                    if (plan.getPlanId().equals(cmdParts[0])) {
                        ManageShoppingCart.getinstance().addToShoppingCart(Cache.getInstance().getUser(), plan);
                        result=1;
                        break;
                    }
                }
                if(result!=1){
                    System.out.println("Plan not found");
                }
            }
        } else {
            System.out.println(response.getDescription());
        }
    }
}
