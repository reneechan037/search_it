package Controller;

import Model.Cache.Cache;
import Model.Login.LoginService;
import Model.Manager.AccountManager;
import Model.Manager.Response;
import Model.user.User;

import java.util.Scanner;

public class CmdLogout implements Command {

    public CmdLogout(){

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        LoginService loginService = new LoginService();
        Response response = loginService.logout();

        System.out.println(response.getDescription());
        if (response.getResult()) {
            Cache.getInstance().setUser(null);
        }
    }
}
