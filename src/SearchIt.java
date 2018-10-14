import Controller.CmdLogin;
import Controller.CmdRegisterAccount;
import Model.Register.RegisterService;

import java.util.Scanner;

public class SearchIt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Exit: 0 | Login: 1 | Registration: 2");
            String input;
            input = in.nextLine();

            if (input.equals("0")) {
                //exit
                System.out.println("Good-bye");
                in.close();
                System.exit(0);
            } else if (input.equals("1")) {
                //Login
                String[] cmdParts = new String[2];
                System.out.print("Please enter username: ");
                input = in.nextLine();
                cmdParts[0] = input;
                System.out.print("Please enter password: ");
                input = in.nextLine();
                cmdParts[1] = input;
                (new CmdLogin()).execute(cmdParts);
            } else if (input.equals("2")) {
                // Register
                String[] cmdParts = new String[2];
                System.out.print("Please enter username: ");
                input = in.nextLine();
                cmdParts[0] = input;
                System.out.print("Please enter password: ");
                input = in.nextLine();
                cmdParts[1] = input;
                (new CmdRegisterAccount()).execute(cmdParts);
            }
        }while(true);
    }
}
