package Model.Manager;

import Model.Cache.Cache;
import Model.user.Manager;
import Model.user.Officer;
import Model.user.Staff;
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
        userList = new ArrayList<>();
        loggedOnUserList = new ArrayList<>();
        User manager = new Officer("admin", "admin", "admin", new Manager());
        User staff = new Officer("staff", "staff", "staff", new Staff());
        userList.add(manager);
        userList.add(staff);
    }

    public Response registerAccount(User user) {
        for(User curUser : userList) {
            if (curUser.userDuplicated(user))
                return new Response(false, "User is existed");
        }
        String userId = "USER" + (userList.size() + 1);
        user.setU_id(userId);
        userList.add(user);
        return new Response(true, "Registration successful");
    }

    public Response loginAccount(String u_name, String u_pwd) {
        for(User curUser : userList) {
            if (curUser.compare(u_name, u_pwd)) {
                loggedOnUserList.add(curUser);
                return new Response(true, "Login successful", curUser.getU_id());
            }
        }
        return new Response(false, "Invalid username or password");
    }

    public Response logoutAccount(User user) {
        loggedOnUserList.remove(user);
        return new Response(true, "Logout successful");
    }

    public User getUserByUserId(String u_id) {
        for(User curUser : loggedOnUserList) {
            if (curUser.compare(u_id)) {
                return curUser;
            }
        }
        return null;
    }
}
