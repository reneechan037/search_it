package Controller;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdShowAllPlans implements Command {
    public CmdShowAllPlans(){

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        // show plan code
        ArrayList<ServicePlan> plans = ServicePlanStorage.getInstance().getPlans();
        if (plans.size() == 0)
            System.out.println("No plan found");
        for (ServicePlan plan : plans) {
        	if (plan.getSpecialMonthlyFee() != 0)
                System.out.println(plan.getPlanId() + " : " + plan.getName() + " - " + plan.getSpecialMonthlyFee());
            else
                System.out.println(plan.getPlanId() + " : " + plan.getName() + " - " + plan.getMonthlyFee());
        }

        String input;
        boolean wantToBack = false;
        do {
            System.out.println("Back: 0 | Filter: 1 | Enter plan id get details: ");
            input = in.nextLine();
            if (input.equals("0"))
                wantToBack = true;
            else if (input.equals("1")) {
                (new CmdFilterByCondition()).execute(new String[0], in);
            } else {
                String[] subCmdParts = new String[1];
                subCmdParts[0] = input;
                (new CmdShowPlanDetails()).execute(subCmdParts, in);
            }
        } while (!wantToBack);
    }
}
