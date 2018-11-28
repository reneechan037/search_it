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
            ServicePlan plan = response.getServicePlan();
            System.out.println("Plan ID: " + plan.getPlanId());
            System.out.println("Plan Name: " + plan.getName());
            if (plan.getSpecialMonthlyFee() != 0)
            	System.out.println("Special Monthly Fee: " + plan.getSpecialMonthlyFee());
            else
            	System.out.println("Monthly Fee: " + plan.getMonthlyFee());
            System.out.println("Duration: " + plan.getDuration() + " " + plan.getDurationUnit());
            System.out.println("Local Data Usage: " + plan.getLocalDataUsage());
            System.out.println("Extra Offer: " + plan.getExtraOffer());
            System.out.println("Back: 0 | Add to cart: 1");
            input = in.nextLine();
            if (input.equals("1")) {
                ManageShoppingCart.getinstance().addToShoppingCart(Cache.getInstance().getUser(), plan);
            }
        } else {
            System.out.println(response.getDescription());
        }
    }
}
