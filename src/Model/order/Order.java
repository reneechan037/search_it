package Model.order;

import Model.ShoppingCart.*;
import Model.user.*;

public class Order {
	private Client client;
	private ManageShoppingCart plans;
	
	public Order(Client client,ManageShoppingCart plans) {
		this.client = client;
		this.plans = plans;
	}
	
	public ManageShoppingCart getOrder() {
		return plans;
	}
}
