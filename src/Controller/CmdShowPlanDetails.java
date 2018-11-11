package Controller;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.Manager.ServicePlanManager;
import Model.service_plan.ServicePlan;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdShowPlanDetails implements Command {
    public CmdShowPlanDetails(){

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
                // add to cart
            }
        } else {
            System.out.println(response.getDescription());
        }
    }
}
