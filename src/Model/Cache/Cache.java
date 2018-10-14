package Model.Cache;

import Model.user.User;

public class Cache {
    private static final Cache instance = new Cache();
    private User user;

    public static Cache getInstance() {
        return instance;
    }

    private Cache() {

    }

    public void setUser(User user) {

    }

    public User getUser() {
        return user;
    }
}
