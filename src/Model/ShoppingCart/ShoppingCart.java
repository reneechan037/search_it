package Model.ShoppingCart;

import Model.service_plan.ServicePlan;
import Model.user.User;

public class ShoppingCart {

    private User user;
    private ServicePlan plan;

    public ShoppingCart(User user, ServicePlan plan) {
        this.user = user;
        this.plan = plan;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServicePlan getPlan() {
        return plan;
    }

    public void setPlan(ServicePlan plan) {
        this.plan = plan;
    }

}
