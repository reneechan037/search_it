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
	
	public void addToOrderList(User user, ManageShoppingCart shoppingCart) {

		orderlist.add(new Order(user, shoppingCart));
    }
	
	public ArrayList<Order> getOrder(User user) {
		ArrayList<Order> orderlistByUser = new ArrayList<Order>();
		for(Order order : orderlist) {
			if(order.getUser().getU_id().equals(user.getU_id())) {
				orderlistByUser.add(order);
			}
		}
		return orderlistByUser;
	}
	

}
