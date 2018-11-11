
package Controller;
import Model.Cache.Cache;
import Model.ShoppingCart.ManageShoppingCart;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class CmdShowShoppingCart implements Command {
    public CmdShowShoppingCart(){

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        
        String input;
        boolean wantToBack = false;
        do {
             ManageShoppingCart.getinstance().displayShoppingCart(Cache.getInstance().getUser());
            System.out.println("Back: 0 | Enter Shopping Cart id to delete plan: ");
            input = in.nextLine();
            if (input.equals("0")){
                wantToBack = true;
            } else {
                 ManageShoppingCart.getinstance().deleteToShoppingCart(Cache.getInstance().getUser(),Integer.parseInt(input));
            }
        } while (!wantToBack);
    }
}
