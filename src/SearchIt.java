import Controller.*;
import Model.Register.RegisterService;
import Model.Cache.Cache;

import java.util.Scanner;

public class SearchIt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;

        do {
            // user actions before login
            if (!Cache.getInstance().isLoggedIn()) {
                System.out.println("Exit: 0 | Login: 1 | Registration: 2");
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
                    (new CmdLogin()).execute(cmdParts, in);
                } else if (input.equals("2")) {
                    // Register
                    String[] cmdParts = new String[2];
                    System.out.print("Please enter username: ");
                    input = in.nextLine();
                    cmdParts[0] = input;
                    System.out.print("Please enter password: ");
                    input = in.nextLine();
                    cmdParts[1] = input;
                    (new CmdRegisterAccount()).execute(cmdParts, in);
                }
            } else { // user actions after login
                System.out.println("Logout: 0 | Show all plans: 1 | Display Shopping Cart: 2");
                input = in.nextLine();
                if (input.equals("0")) {
                    //exit
                    (new CmdLogout()).execute(new String[0], in);
                } else if (input.equals("1")) {
                    (new CmdShowAllPlans()).execute(new String[0], in);
                }else if (input.equals("2")) {
                    (new CmdShowShoppingCart()).execute(new String[0], in);
                }
            }

        }while(true);
    }
}
