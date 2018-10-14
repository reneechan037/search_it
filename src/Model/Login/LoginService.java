package Model.Login;

import Model.Manager.AccountManager;
import Model.Manager.Response;
import Model.user.User;

public class LoginService {
    AccountManager accountManager = AccountManager.getInstance();

    public LoginService() {

    }

    public Response customerLogin(String u_name, String u_pwd) {
        return accountManager.loginAccount(u_name, u_pwd);
    }

    public Response staffLogin(String u_name, String u_pwd) {
        return accountManager.loginAccount(u_name, u_pwd);
    }
}
