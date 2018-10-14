package Controller;

import Model.Cache.Cache;
import Model.Login.LoginService;
import Model.Manager.AccountManager;
import Model.Manager.Response;
import Model.user.User;

import java.util.Scanner;

public class CmdLogin implements Command {

    public CmdLogin(){

    }

    @Override
    public void execute(String[] cmdParts) {
        LoginService loginService = new LoginService();
        Response response = loginService.login(cmdParts[0], cmdParts[1]);

        System.out.println(response.getDescription());
        if (response.getResult()) {
            Cache.getInstance().setUser(AccountManager.getInstance().getUserByUserId(response.getU_id()));
            if (response.getU_id().contains("admin")) {
                System.out.println("login successful for admin");
            } else if (response.getU_id().contains("staff")) {
                System.out.println("login successful for staff");
            } else {
                System.out.println("login successful for client");
            }
        }
    }
}
