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
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
                num++;
            }
            if (num == number) {
                shoppingCartlist.remove(shoppingCart);
                System.out.println("Remove success!!");
            }

        }
    }

    public void displayShoppingCart(User user) {
        int num = 0;
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
                System.out.println(num + ". " + shoppingCart.getPlan().getName());
                System.out.println("Duration: " + shoppingCart.getPlan().getDuration() + " " + shoppingCart.getPlan().getDurationUnit());
                System.out.println("");
                num++;
            }
        }
    }
    public void removeListByUser(User user){
        for (ShoppingCart shoppingCart : shoppingCartlist) {
            if (shoppingCart.getUser().equals(user)) {
               shoppingCartlist.remove(shoppingCart);
            }
        }
        
    }

}
