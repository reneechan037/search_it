package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Cache.Cache;
import Model.Order.*;
import Model.ShoppingCart.ManageShoppingCart;
import Model.service_plan.ServicePlan;

public class CmdCheckout implements Command{
	public CmdCheckout() {
		
	}
	
	public void execute(String[] cmdParts, Scanner in) {
		String input;
		ManageShoppingCart.getinstance().checkOut(Cache.getInstance().getUser());
		
		boolean wantToBack = false;
        do {
            System.out.println("Back: 0");
            input = in.nextLine();
            if (input.equals("0")){
                wantToBack = true;
            } 
        } while (!wantToBack);
	}

}
