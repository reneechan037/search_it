package Model.ShoppingCart;
import Model.service_plan.ServicePlan;
import Model.user.User;
import Model.service_plan.ServicePlan;
import java.util.ArrayList;

public class ManageShoppingCart {

    private static final ManageShoppingCart instance = new ManageShoppingCart();
    private ArrayList<ShoppingCart> shoppingCartlist;

    public static ManageShoppingCart getinstance() {
        return instance;
    }

    private ManageShoppingCart() {
        shoppingCartlist = new ArrayList<>();
    }

    public void addToShoppingCart(User user, ServicePlan plan) {

        shoppingCartlist.add(new ShoppingCart(user, plan));
        System.out.println("Added success!!");

    }

    public void deleteToShoppingCart(User user, int number) {
        int num = 0;
        boolean success=false;
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
                num++;
            }
            if (num == number) {
                shoppingCartlist.remove(shoppingCart);
            }

        }
        if(success){
             System.out.println("Remove success!!");
        }else{
            System.out.println("No this plan");
        }
    }

    public void displayShoppingCart(User user) {
        int num = 1;
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
                System.out.println(num + ". " + shoppingCart.getPlan().getName());
                System.out.println("Duration: " + shoppingCart.getPlan().getDuration() + " " + shoppingCart.getPlan().getDurationUnit());
                System.out.println("");
                num++;
            }
        }
        if(num==1){
            System.out.println("No plan were added in the shopping cart");
        }
    }
    public void removeListByUser(User user){
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
               shoppingCartlist.remove(shoppingCart);
            }
        }
        
    }
    
    public void checkOut() {
    	shoppingCartlist.clear();
    }

}
