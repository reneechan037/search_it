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
		boolean wantToBack = false;
		do {
		wantToBack = ManageOrder.getOrderinstance().displayOrder(Cache.getInstance().getUser());
            
        } while (!wantToBack);
	}

}
