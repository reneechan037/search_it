package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Cache.Cache;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.Order.ManageOrder;
import Model.Order.Order;
import Model.ShoppingCart.ManageShoppingCart;
import Model.service_plan.ServicePlan;
import Model.service_plan.ServicePlanStorage;
import Model.user.User;

class ManageOrderTest {
	private ArrayList<Order> orderlist = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	public void displayOrdertest() {
		User user = new User("Terry","Terry","Terry");
		int[] sma;
		sma = new int[] {};
		ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P002","4G Anytime+ Service plan",108.00,0.00,sma,12,"months","5 GB",5.0,"GB","",1));
		sma = new int[] {10,12};
		ManageShoppingCart.getinstance().addToShoppingCart(user, new ServicePlan("P003","4G Anytime Service plan",100.00,75.00,sma,24,"months","2 GB",2.0,"GB","",2));
		ManageShoppingCart.getinstance().checkOut(user);
	
		
		assertEquals(true,ManageOrder.getOrderinstance().displayOrder(user));
	}
	@Test
	public void displayOrderNoPlantest() {
		User user = new User("Terry","Terry");
		ManageShoppingCart.getinstance().checkOut(user);
		assertEquals(true,ManageOrder.getOrderinstance().displayOrder(user));
	}

}
