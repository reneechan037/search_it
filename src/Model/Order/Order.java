package Model.Order;

import Model.ShoppingCart.*;
import Model.user.*;

public class Order {
	private User user;
	private ManageShoppingCart shoppingCart;
	
	public Order(User user,ManageShoppingCart shoppingCart) {
		this.user = user;
		this.shoppingCart = shoppingCart;
	}
	
	public ManageShoppingCart getOrder() {
		return shoppingCart;
	}
	
	public User getUser() {
		return user;
	}
	
	public void displayOrder() {
		shoppingCart.displayShoppingCart(user);
	}
}
