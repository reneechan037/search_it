package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.ShoppingCart.ManageShoppingCart;
import Model.service_plan.ServicePlan;
import Model.user.User;

class ManageShoppingCartTest {

	@Test
	public void addToShoppingCartTest() {
		User user = new User("Sam","Sam","Sam");
		int[] sma;
		sma = new int[] {10,12};
		
		assertEquals(true,ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2)));
		
	}
	@Test
	public void deleteToShoppingCart() {
		User user = new User("Sam","Sam","Sam");
		User user1 = new User("Sam","Sam","Sam");
		int[] sma;
		sma = new int[] {10,12};
		ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2));
		int[] sma1;
		sma1 = new int[] {10,12};
		ManageShoppingCart.getinstance().addToShoppingCart(user1, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma1,24,"months","2 GB",2.0,"GB","",2));
		
		assertEquals(true,ManageShoppingCart.getinstance().deleteToShoppingCart(user, 0));
	}
	
	@Test
	public void deleteToNothingShoppingCart() {
		User user = new User("Sam","Sam","Sam");
		User user1 = new User("Sam","Sam","Sam");
		int[] sma;
		sma = new int[] {10,12};
		ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2));
		
		assertEquals(true,ManageShoppingCart.getinstance().deleteToShoppingCart(user1, 0));
	}
	@Test
	public void displayShoppingCartTest() {
		User user = new User("Sam","Sam","Sam");
		int[] sma;
		sma = new int[] {10,12};
		ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2));
		
		assertEquals(true,ManageShoppingCart.getinstance().displayShoppingCart(user));
	}
	@Test
	public void displayNoShoppingCartTest() {
		User user = new User("Sam","Sam","Sam");
		assertEquals(true,ManageShoppingCart.getinstance().displayShoppingCart(user));
	}

	

}
