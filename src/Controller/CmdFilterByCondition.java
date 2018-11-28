package Controller;

import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdFilterByCondition implements Command {
    private ArrayList<ServicePlan> result;
    public CmdFilterByCondition(){

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        String input;
        result = ServicePlanStorage.getInstance().getPlans();
        SearchingService service = new SearchingService();

        boolean wantToBack = false;
        do {
            System.out.println("Back: 0 | Filter by name: 1 | Filter by price: 2 | Filter by data usage: 3 | Filter by extra offers: 4 | Clear filter: 5 | Enter plan id get details: ");
            input = in.nextLine();
            if (input.equals("0"))
                wantToBack = true;
            else if (input.equals("1")) {
                System.out.print("Please enter keyword: ");
                input = in.nextLine();
                Response response = service.filterServicePlanByPlanName(result, input);
                if (response.getResult()) {
                    result = response.getServicePlans();
                    displayList();
                } else {
                    System.out.println(response.getDescription());
                }
            } else if (input.equals("2")) {
                System.out.print("Please enter minimum price: ");
                input = in.nextLine();
                double minPrice = Double.parseDouble(input);
                System.out.print("Please enter maximum price: ");
                input = in.nextLine();
                double maxPrice = Double.parseDouble(input);
                Response response = service.filterServicePlanByPriceRange(result, minPrice, maxPrice);
                if (response.getResult()) {
                    result = response.getServicePlans();
                    displayList();
                } else {
                    System.out.println(response.getDescription());
                }
            } else if (input.equals("3")) {
                System.out.println("1. < 1GB");
                System.out.println("2. 1GB - 5GB");
                System.out.println("3. > 5GB");
                do {
                    System.out.print("Please select (1-3): ");
                    input = in.nextLine();
                } while (!input.equals("1") && !input.equals("2") && !input.equals("3")); // to ensure user enter correct number
                double min, max;
                if (input.equals("1")) {
                    min = 0;
                    max = 0.99;
                } else if (input.equals("2")) {
                    min = 1;
                    max = 5;
                } else {
                    min = 5.01;
                    max = 10000;
                }
                Response response = service.filterServicePlanByDataUsage(result, min, max);
                if (response.getResult()) {
                    result = response.getServicePlans();
                    displayList();
                } else {
                    System.out.println(response.getDescription());
                }
            } else if (input.equals("4")) {
                Response response = service.filterServicePlanByExtraOffer(result);
                if (response.getResult()) {
                    result = response.getServicePlans();
                    displayList();
                } else {
                    System.out.println(response.getDescription());
                }
            }  else if (input.equals("5")) {
                Response response = service.clearFilter();
                result = response.getServicePlans();
                displayList();
            } else {
                String[] subCmdParts = new String[1];
                subCmdParts[0] = input;
                (new CmdShowPlanDetails()).execute(subCmdParts, in);
            }
        } while (!wantToBack);
    }

    public void displayList() {
        if (result.size() == 0)
            System.out.println("No plan found");
        for (ServicePlan plan : result) {
            if (plan.getSpecialMonthlyFee() != 0)
                System.out.println(plan.getPlanId() + " : " + plan.getName() + " - " + plan.getSpecialMonthlyFee());
            else
                System.out.println(plan.getPlanId() + " : " + plan.getName() + " - " + plan.getMonthlyFee());
        }
    }
}
