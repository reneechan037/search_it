package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Cache.Cache;
import Model.Order.ManageOrder;
import Model.Order.Order;

public class CmdShowOrder implements Command{
	public CmdShowOrder() {
		
	}
	
	public void execute(String[] cmdParts, Scanner in) {
		String input;
		ArrayList<Order> orderlists = ManageOrder.getOrderinstance().getOrder(Cache.getInstance().getUser());
		if(orderlists.size()==0) {
			System.out.println("NO Order record!");
		}else {
			for(Order order:orderlists) {
				order.displayOrder();
			}
		}
		
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
