package Model.Register;

import Model.Manager.*;
import Model.user.User;

public class RegisterService {
    AccountManager accountManager = AccountManager.getInstance();

    public RegisterService() {

    }

    public Response register(String u_name, String u_pwd) {
        return accountManager.registerAccount(new User(u_name, u_pwd));
    }
}
