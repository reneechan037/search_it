package Model.order;

import Model.user.*;

public class manageOrder {
	private Client client;
	private Order order;
	
	public void showOrder(){
		order.getOrder().displayShoppingCart(client);
	}

}
