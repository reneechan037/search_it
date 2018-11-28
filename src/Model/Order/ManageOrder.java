package Model.Order;

import java.util.ArrayList;

import Model.ShoppingCart.*;
import Model.service_plan.ServicePlan;
import Model.user.*;

public class ManageOrder {
	
	private static final ManageOrder instance = new ManageOrder();
	private ArrayList<Order> orderlist;
	
	public static ManageOrder getOrderinstance() {
		return instance;
	}
	
	private ManageOrder() {
		orderlist = new ArrayList<>();
    }
	
	public void addToOrderList(User user, ArrayList<ShoppingCart> shoppingCart) {

		orderlist.add(new Order(user, shoppingCart));
    }
	
	public boolean displayOrder(User user) {
		ArrayList<Order> orderlistByUser = new ArrayList<Order>();
		for(Order order : orderlist) {
			if(order.getUser().getU_id().equals(user.getU_id())) {
				orderlistByUser.add(order);
			}
		}
		if(orderlistByUser.size() == 0) {
			System.out.println("You didn't have any order record!");
			return true;
		}
		int num = 1;
		for(Order order: orderlistByUser) {
			 for (ShoppingCart shoppingCart : order.getOrder()) {
				 System.out.println(num + ". " + shoppingCart.getPlan().getName());
		         System.out.println("Duration: " + shoppingCart.getPlan().getDuration() + " " + shoppingCart.getPlan().getDurationUnit());
		         System.out.println("");
		         num++;
		            
		       }
			
		}

		return true;
	}
	

}
