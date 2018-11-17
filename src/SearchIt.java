import Controller.*;
import Model.Register.RegisterService;
import Model.Cache.Cache;

import java.util.Scanner;

public class SearchIt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;

        opening();

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
                if (Cache.getInstance().getUser().getU_id().equals("admin"))
                {
                    //admin action
                    displayAdminActions(in);
                }
                else
                {
                    //staff action
                    displayStaffActions(in);
                }
            }

        }while(true);
    }

    public static void displayAdminActions(Scanner in)
    {
        System.out.println("\nLogout: 0 | Show all plans: 1 | Display Shopping Cart: 2 |  Show Order: 3 | Manager Action: 4");
        String input = in.nextLine();
        if (input.equals("0")) {
            //exit
            (new CmdLogout()).execute(new String[0], in);
        } else if (input.equals("1")) {
            (new CmdShowAllPlans()).execute(new String[0], in);
        }else if (input.equals("2")) {
            (new CmdShowShoppingCart()).execute(new String[0], in);
        }else if (input.equals("3")){
            (new CmdShowOrder()).execute(new String[0], in);
        }else if(input.equals("4")) {
            (new CmdManagerAction()).execute(new String[0], in);
        }
    }

    public static void displayStaffActions(Scanner in)
    {
        System.out.println("\nLogout: 0 | Show all plans: 1 | Display Shopping Cart: 2 |  Show Order: 3 ");
        String input = in.nextLine();
        if (input.equals("0")) {
            //exit
            (new CmdLogout()).execute(new String[0], in);
        } else if (input.equals("1")) {
            (new CmdShowAllPlans()).execute(new String[0], in);
        }else if (input.equals("2")) {
            (new CmdShowShoppingCart()).execute(new String[0], in);
        }else if(input.equals("3")) {
            (new CmdShowOrder()).execute(new String[0], in);
        }
    }


    public static void opening()
    {
        // _______   _            _                        _____  _                _____                 _          
        // |__   __| | |          | |                      |  __ \| |              / ____|               (_)         
        //    | | ___| | ___ _ __ | |__   ___  _ __   ___  | |__) | | __ _ _ __   | (___   ___ _ ____   ___  ___ ___ 
        //    | |/ _ \ |/ _ \ '_ \| '_ \ / _ \| '_ \ / _ \ |  ___/| |/ _` | '_ \   \___ \ / _ \ '__\ \ / / |/ __/ _ \
        //    | |  __/ |  __/ |_) | | | | (_) | | | |  __/ | |    | | (_| | | | |  ____) |  __/ |   \ V /| | (_|  __/
        //    |_|\___|_|\___| .__/|_| |_|\___/|_| |_|\___| |_|    |_|\__,_|_| |_| |_____/ \___|_|    \_/ |_|\___\___|
        //                  | |                                                                                      
        //                  |_|    
        System.out.println();
        System.out.println("  _______   _            _                        _____  _                _____                 _                      ");
        System.out.println("  |__   __| | |          | |                      |  __ \\| |              / ____|               (_)                     ");
        System.out.println("     | | ___| | ___ _ __ | |__   ___  _ __   ___  | |__) | | __ _ _ __   | (___   ___ _ ____   ___  ___ ___             ");
        System.out.println("     | |/ _ \\ |/ _ \\ '_ \\| '_ \\ / _ \\| '_ \\ / _ \\ |  ___/| |/ _` | '_ \\   \\___ \\ / _ \\ '__\\ \\ / / |/ __/ _ \\            ");
        System.out.println("     | |  __/ |  __/ |_) | | | | (_) | | | |  __/ | |    | | (_| | | | |  ____) |  __/ |   \\ V /| | (_|  __/            ");
        System.out.println("     |_|\\___|_|\\___| .__/|_| |_|\\___/|_| |_|\\___| |_|    |_|\\__,_|_| |_| |_____/ \\___|_|    \\_/ |_|\\___\\___|            ");
        System.out.println("                   | |                                                                                                  ");
        System.out.println("                   |_|                     ");
        System.out.println();     

    };
}
