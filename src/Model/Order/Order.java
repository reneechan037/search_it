package Model.Order;

import java.util.ArrayList;

import Model.ShoppingCart.*;
import Model.user.*;

public class Order {
	private User user;
	private ArrayList<ShoppingCart> shoppingCart;
	
	public Order(User user,ArrayList<ShoppingCart> shoppingCart) {
		this.user = user;
		this.shoppingCart = shoppingCart;
	}
	
	public ArrayList<ShoppingCart> getOrder() {
		return shoppingCart;
	}
	
	public User getUser() {
		return user;
	}
	
	
}
