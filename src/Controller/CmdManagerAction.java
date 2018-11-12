package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.Cache.Cache;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.service_plan.ServicePlan;
import Model.user.Manager;

public class CmdManagerAction implements Command {
   private Manager manager;

    public CmdManagerAction() {
        manager = Manager.getInstance();
    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        String cmd = "";
        boolean isExit = false;


        /**
         * 
         * full speed share service: 1 air time service: 2 message service: 3
         */

        while(!isExit) {
            println("0: Exit | 1: add service plan | 2: update service plan | 3: delete service plan | 4: check user plan");
            cmd = in.nextLine();
            if (cmd.equals("0")) {
                isExit = true;
            } else if (cmd.equals("1")) {
                addPlan(in);
                isExit = true;
                break;
            } else if (cmd.equals("2")) {
                updatePlan(in);
                isExit = true;
                break;
            } else if (cmd.equals("3")) {
                deletePlan(in);
                isExit = true;
                break;
            } else if (cmd.equals("4")) {
                checkUserPlan(in);
                isExit = true;
                break;
            } else {
                System.out.println("Please choose follow action command !!");

            }
        };
    }

    public void addPlan(Scanner in) {
        String title, unit;
        int monthlyFee = -1;
        int specialFee = -1;
        int duration = -1;
        int[] specialMonth = null;

        int planType = -1;
        String cmd = "";

        String planId = generatePlanId();

        println("Select plan type - 1: Full speed share service | 2: Air time service | 3: Message service | 0: Exit");
        cmd = in.nextLine();

        switch (cmd) {
        case "1":
        case "2":
        case "3":
            planType = Integer.parseInt(cmd);
            break;
        default:
            break;

        }

        print("Set plan title:");
        title = in.nextLine();

        print("\nSet monthly fee:");
        monthlyFee = Integer.parseInt(in.nextLine());

        print("\nSet special monthly fee ?(y/n)");
        cmd = in.nextLine();
        if (cmd.equals("y")) {
            print("\nSet special monthly fee:");
            specialFee = Integer.parseInt(in.nextLine());

            print("\nSet special month for special fee (from 1-12, seperate by ,):");
            String monthStr = in.nextLine();
            if (!monthStr.isEmpty()) {
                String[] months = monthStr.split(",");
                specialMonth = new int[months.length];
                for (int i = 0; i < months.length; i++) {
                    specialMonth[i] = Integer.parseInt(months[i]);
                }
            }
        }

        print("\nSet duration unit (year/month):");
        unit = in.nextLine();

        print("\nSet plan duration (enter integer):");
        duration = in.nextInt();

        boolean isSuccess = manager.addPlan(
                new ServicePlan(planId, title, monthlyFee, specialFee, specialMonth, duration, unit, planType)
            );

        if (isSuccess)
            println("Plan added !\n\n\n\n");
        else
            println("Add plan fail !\n\n\n\\n");
    };

    public void updatePlan(Scanner in) {
        SearchingService service = new SearchingService();

        print("\nEnter plan id:");
        String planId = in.nextLine();
        ServicePlan oldPlan = service.getPlanById(planId).getServicePlan();
        if (oldPlan == null) {
            println("Plan not found");
        } else {

            planId = oldPlan.getPlanId();
            println("Update plan type - 1: Full speed share service | 2: Air time service | 3: Message service | s: skip ");
            String cmd = in.nextLine();
            int newPlanType = -1;
            if (!isSkipt(cmd)) {
                switch (cmd) {
                    case "1":
                    case "2":
                    case "3":
                        newPlanType = Integer.parseInt(cmd);
                        break;
                    default:
                        break;
    
                    }
                oldPlan.setPlanType(newPlanType);
            }

            print("Update plan title(enter s to skip):");
            cmd = in.nextLine();
            String newTitle = "";
            if (!isSkipt(cmd)) {
                newTitle = cmd;
                oldPlan.setName(newTitle);
            }

            double newMonthFee = -1;

            print("\nUpdate monthly fee(enter s to skip):");
            cmd = in.nextLine();
            if (!isSkipt(cmd)) {
                newMonthFee = Double.parseDouble(cmd);
                oldPlan.setMonthlyFee(newMonthFee);
            }

            double newSpecialFee = -1;
            print("\nUpdate special monthly fee(enter s to skip):");
            cmd = in.nextLine();
            if (!isSkipt(cmd)) {
                newSpecialFee = oldPlan.getSpecialMonthlyFee();
                oldPlan.setSpecialMonthlyFee(newSpecialFee);
            }

            print("\nUpdate special month for special fee (enter s to skip ,from 1-12, seperate by ','):");
            cmd = in.nextLine();
            int[] newSpecialMonth = null;
            if (!isSkipt(cmd)) {
                String monthStr = in.nextLine();
                if (!monthStr.isEmpty()) {
                    String[] months = monthStr.split(",");
                    newSpecialMonth = new int[months.length];
                    for (int i = 0; i < months.length; i++) {
                        newSpecialMonth[i] = Integer.parseInt(months[i]);
                    }
                }

                oldPlan.setSpecialMonth(newSpecialMonth);
            }

            print("\nUpdate duration unit (year/month, enter s to skip):");
            cmd = in.nextLine();
            String newUnit = "";
            if (!isSkipt(cmd)) {
                newUnit = oldPlan.getDurationUnit();
                oldPlan.setDurationUnit(newUnit);
            }

            print("\nUpdate plan duration (enter integer, enter s to skip):");
            cmd = in.nextLine();
            int newDuration = -1;
            if (!isSkipt(cmd)) {
                newDuration = Integer.parseInt(cmd);
                oldPlan.setDuration(newDuration);
            }

            ServicePlan newPlan = new ServicePlan(planId, newTitle, newMonthFee, newSpecialFee, newSpecialMonth, newDuration, newUnit, newPlanType);
            boolean isSuccess = manager.updatePlan(oldPlan, newPlan);

           if (isSuccess)
                println("Plan Updated!\n\n\n\n");
            else
            println("Plan Update fail!\n\n\n\n");
        }
    };

    public void deletePlan(Scanner in) {
        print("\nEnter plan id:");
        String planId = in.nextLine();

        boolean isSuucess = manager.deletePlan(planId);
        if (isSuucess) {
            println("Update success !!\n\n\n");
        } else {
            println("Update fail !!\n\n\n");
        }

    };

    public void checkUserPlan(Scanner in) {
    };

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(String msg) {
        System.out.print((msg));
    }

    public String generatePlanId() {
        int max = 999;
        int min = 1;
        return "P" + new Random().nextInt(max) + min;
    }

    public boolean isSkipt(String str) {
        return str.equals("s");
    }
}