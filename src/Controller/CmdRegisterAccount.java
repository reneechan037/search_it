package Controller;
import Model.Manager.Response;
import Model.Register.RegisterService;

import java.util.Scanner;

public class CmdRegisterAccount implements Command {
    public CmdRegisterAccount(){

    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        RegisterService registerService = new RegisterService();
        Response response = registerService.register(cmdParts[0], cmdParts[1]);

        System.out.println(response.getDescription());
    }
}
