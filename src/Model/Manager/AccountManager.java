package Model.Manager;

import Model.user.User;

import java.util.ArrayList;

public class AccountManager {
    private static final AccountManager instance = new AccountManager();
    private ArrayList<User> userList;
    private ArrayList<User> loggedOnUserList;

    public static AccountManager getInstance() {
        return instance;
    }

    private AccountManager() {
        userList = new ArrayList<User>();
        loggedOnUserList = new ArrayList<User>();
    }

    public Response registerAccount(User user) {
        for(User curUser : userList) {
            if (curUser.userDuplicated(user))
                return new Response(false, "User is existed");
        }
        String userId = "AL" + userList.size();
        user.setU_id(userId);
        userList.add(user);
        return new Response(true, "Registration successful");
    }

    public Response loginAccount(String u_name, String u_pwd) {
        for(User curUser : userList) {
            if (curUser.compare(u_name, u_pwd)) {
                return new Response(true, "Login successful", curUser.getU_id());
            }
        }
        return new Response(false, "Invalid username or password");
    }

    public boolean userIsExisted(User user) {
        return userList.contains(user)?true:false;
    }
}
