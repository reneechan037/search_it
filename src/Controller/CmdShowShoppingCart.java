
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
            System.out.println("Back: 0 | Checkout: c | Shopping Cart id to delete plan: ");
            input = in.nextLine();
            if (input.equals("0")){
                wantToBack = true;
            } else if(input.equals("c")){
            	ManageShoppingCart.getinstance().checkOut(Cache.getInstance().getUser());
            } else {
                try{
                 ManageShoppingCart.getinstance().deleteToShoppingCart(Cache.getInstance().getUser(),Integer.parseInt(input));
                }
                catch(Exception e){
                    System.out.println("Please Input Shopping Cart id");
                }
            }
        } while (!wantToBack);
    }
}
