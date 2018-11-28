package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Helper.Helper;
import Model.Cache.Cache;
import Model.Login.SearchingService;
import Model.Manager.Response;
import Model.service_plan.ServicePlan;
import Model.user.Manager;
import Model.user.Officer;

public class CmdManagerAction implements Command {
   private Officer manager;

    public CmdManagerAction() {
        manager = new Officer();
    }

    @Override
    public void execute(String[] cmdParts, Scanner in) {
        String cmd = "";
        boolean isExit = false;


        /**
         * 
         * full speed share service: 1 air time service: 2 message service: 3
         */

        println(Helper.seperateStyleString("Manager Action"));
        while(!isExit) {
            println("\n0: Exit | 1: Add service plan | 2: Update service plan | 3: Delete service plan | 4: Check user plan");
            cmd = in.nextLine();
            if (cmd.equals("0")) {
                isExit = true;
            } else if (cmd.equals("1")) {
                addPlan(in);
                // isExit = true;
                // break;
            } else if (cmd.equals("2")) {
                updatePlan(in);
                // isExit = true;
                // break;
            } else if (cmd.equals("3")) {
                deletePlan(in);
                // isExit = true;
                // break;
            } else if (cmd.equals("4")) {
                checkUserPlan(in);
                // isExit = true;
                // break;
            } else {
                System.out.println("\nPlease choose follow action command !!");

            }
        };
    }


    public void addPlan(Scanner in) {
        println(Helper.seperateStyleString("Add Service Plan Mode"));

        String title, unit, localDataDetail, localDataUnit, extraOffer;
        double monthlyFee = 0.0;
        double specialFee = 0.0;
        int duration = -1, dataAmount = -1;
        int[] specialMonth = null;

        int planType = -1;
        String cmd = "";

        String planId = generatePlanId();

        println("Select plan type - 1: Full speed share service | 2: Air time service | 3: Message service | 0: Exit");
        cmd = in.nextLine();

        if (cmd.equals("0")) return;

        if (cmd.equals("1") || cmd.equals("2") || cmd.equals("3"))
        {
            planType = Integer.parseInt(cmd);
        }
        else
        {
            println("Invalid plan type");
            return;
        }

        print("Set plan title:");
        title = in.nextLine();
        if (title.isEmpty())
        {
            println("Invalid title name");
        }

        print("Set monthly fee:");
        cmd = in.nextLine();
        if (Helper.isDouble(cmd))
        {
            monthlyFee = Double.parseDouble(cmd);
        }
        else
        {
            println("Invalid month fee");
            return;
        }

        print("Set special monthly fee?(Yes/No)");
        cmd = in.nextLine();
        if (cmd.equals("y") || cmd.equals("yes")) 
        {
            print("Set special monthly fee:");
            cmd = in.nextLine();
            if (Helper.isDouble(cmd))
            {
                specialFee = Double.parseDouble(cmd);

                print("Set special month for special fee (from 1-12 seperate by ','):");
                String monthStr = in.nextLine();
                if (!monthStr.isEmpty()) 
                {
                    String[] months = monthStr.split(",");
                    specialMonth = new int[months.length];
                    for (int i = 0; i < months.length; i++) {
                        if (Helper.isNumber(months[i]))
                        {
                            specialMonth[i] = Integer.parseInt(months[i]);

                            if(specialMonth[i] > 12 || specialMonth[i] < 1)
                            {
                                println("The month range should between 1 - 12");
                                return;
                            }
                        }
                        else
                        {
                            println("Invalid special months");
                            return;
                        }
                    }
                }
            }
            else
            {
                println("Invalid special monthly fee");
                return;
            }
        }

        print("Set duration unit (Year/Month):");
        cmd = in.nextLine().toLowerCase();
        if (cmd.equals("year") || cmd.equals("month"))
        {
            unit = cmd;
        }
        else
        {
            println("Invalid duration unit");
            return;
        }

        print("Set plan duration (a digital number is requried):");
        cmd = in.nextLine();
        if (Helper.isNumber(cmd))
        {
            duration = Integer.parseInt(cmd);
            if (duration <= 0)
            {
                println("Invalid duration number");
                return;
            }
        }
        
        print("Set plan local data amount (a digital number is requried):");
        cmd = in.nextLine();
        if (Helper.isNumber(cmd))
        {
            dataAmount = Integer.parseInt(cmd);
            if (dataAmount <= 0)
            {
                println("Invalid local data amount number");
                return;
            }
        }
        
        print("Set plan local data unit (MB/GB):");
        cmd = in.nextLine().toLowerCase();
        if (cmd.equals("gb") || cmd.equals("mb"))
        {
        	localDataUnit = cmd;
        }
        else
        {
        	 println("Invalid data unit");
             return;
        }
        
        print("Set plan extra offer:");
        cmd = in.nextLine();
        if (cmd.length() > 0) {
        	extraOffer = cmd;
        } else {
        	println("Invalid extra offer");
            return;
        }
        
        localDataDetail = dataAmount + " " + localDataUnit;

        ServicePlan newPlan = new ServicePlan(planId, title, monthlyFee, specialFee, specialMonth, duration, unit, localDataDetail, dataAmount, localDataUnit, extraOffer, planType);
        boolean isSuccess = manager.addPlan(newPlan);

        if (isSuccess)
        {
            println("\nService Plan Info:");
            println(newPlan.toString());
            println(Helper.seperateStyleString("Service Plan Added"));
        }
        else
        {
            println("Add Service Plan Fail");
        }
    };

    public void updatePlan(Scanner in) {
        println(Helper.seperateStyleString("Update Service Plan Mode"));
        SearchingService service = new SearchingService();

        print("\nEnter plan id:");
        String planId = in.nextLine();
        ServicePlan oldPlan = service.getPlanById(planId).getServicePlan();
        if (oldPlan == null) 
        {
            println("Plan not found");
            return;
        } 
        else 
        {

            planId = oldPlan.getPlanId();
            println("\nUpdate plan type - 1: Full speed share service | 2: Air time service | 3: Message service (Press S to Skip)");
            String cmd = in.nextLine();
            int newPlanType = -1;
            if (!isSkip(cmd)) 
            {
                if (cmd.equals("1") || cmd.equals("2") || cmd.equals("3"))
                {
                    newPlanType = Integer.parseInt(cmd);
                    // oldPlan.setPlanType(newPlanType);
                }
                else
                {
                    println("Invalid plan type");
                    return;
                }
            }

            print("Update plan title (Press S to Skip): ");
            cmd = in.nextLine();
            String newTitle = "";
            if (!isSkip(cmd)) 
            {
                if (cmd.isEmpty())
                {
                    println("Invalid title name");
                    return;
                }
                newTitle = cmd;
                // oldPlan.setName(newTitle);
            }

            double newMonthFee = -1;
            print("Update monthly fee (Press S to Skip): ");
            cmd = in.nextLine();
            if (!isSkip(cmd)) 
            {
                if (Helper.isDouble(cmd))
                {
                    newMonthFee = Double.parseDouble(cmd);
                    // oldPlan.setMonthlyFee(newMonthFee);
                }
                else
                {
                    println("Invalid monthly fee");
                    return;
                }
            }

            double newSpecialFee = -1;
            print("Update special monthly fee (Press S to Skip): ");
            cmd = in.nextLine();
            if (!isSkip(cmd)) 
            {
                if (Helper.isDouble(cmd))
                {
                    newSpecialFee = oldPlan.getSpecialMonthlyFee();
                    // oldPlan.setSpecialMonthlyFee(newSpecialFee);
                }
                else
                {
                    println("Invalid special monthly fee");
                    return;
                }
            }

            print("Update special months for special fee (from 1-12 seperate by ',', Press S to Skip):");
            cmd = in.nextLine();
            int[] newSpecialMonth = null;
            if (!isSkip(cmd)) 
            {
                if (!cmd.isEmpty()) 
                {
                    String[] months = cmd.split(",");
                    newSpecialMonth = new int[months.length];
                    for (int i = 0; i < months.length; i++) 
                    {
                        if (Helper.isNumber(months[i]))
                        {
                            newSpecialMonth[i] = Integer.parseInt(months[i]);

                            if(newSpecialMonth[i] > 12 || newSpecialMonth[i] < 1)
                            {
                                println("The month range should between 1 - 12");
                                return;
                            }
                        }
                        else
                        {
                            println("Invalid special months");
                            return;
                        }
                        
                    }

                    // oldPlan.setSpecialMonth(newSpecialMonth);
                }
                else
                {
                    println("Invalid special months");
                    return;
                }
            }

            print("Update duration unit (Year/Month, Press S to Skip):");
            cmd = in.nextLine();
            String newUnit = "";
            if (!isSkip(cmd)) 
            {
                if (cmd.equals("year") || cmd.equals("month"))
                {
                    newUnit = oldPlan.getDurationUnit();
                    // oldPlan.setDurationUnit(newUnit);
                }
                else
                {
                    println("Invalid duration unit");
                    return;
                }
            }

            print("Update plan duration (a digital number is requried, Press S to Skip):");
            cmd = in.nextLine();
            int newDuration = -1;
            if (!isSkip(cmd)) 
            {
                if (Helper.isNumber(cmd))
                {
                    newDuration = Integer.parseInt(cmd);
                    // oldPlan.setDuration(newDuration);
                }
                else
                {
                    println("Invalid duration number");
                    return;
                }
            }
            
            print("Update plan local data amount (a digital number is requried, Press S to Skip):");
            cmd = in.nextLine();
            int newDataAmount = -1;
            if (!isSkip(cmd)) 
            {
                if (Helper.isNumber(cmd))
                {
                	newDataAmount = Integer.parseInt(cmd);
                    // oldPlan.setDuration(newDuration);
                }
                else
                {
                    println("Invalid local data amount number");
                    return;
                }
            }
            
            print("Update plan local data unit (MB/GB, Press S to Skip):");
            cmd = in.nextLine();
            String newDataUnit = "";
            if (!isSkip(cmd)) 
            {
                if (cmd.equals("gb") || cmd.equals("mb"))
                {
                    newDataUnit = oldPlan.getLocalDataUsageUnit();
                    // oldPlan.setDurationUnit(newUnit);
                }
                else
                {
                    println("Invalid local data unit");
                    return;
                }
            }
            String newDataDetail = newDataAmount + " " + newDataUnit;
            
            print("Set plan extra offer (Press S to Skip):");
            cmd = in.nextLine();
            String newExtraOffer = "";
            if (!isSkip(cmd)) 
            {
                if (cmd.length() > 0)
                {
                	newExtraOffer = oldPlan.getLocalDataUsageUnit();
                    // oldPlan.setDurationUnit(newUnit);
                }
                else
                {
                	println("Invalid extra offer");
                    return;
                }
            }

            ServicePlan newPlan = new ServicePlan(planId, newTitle, newMonthFee, newSpecialFee, newSpecialMonth, newDuration, newUnit, newDataDetail, newDataAmount, newDataUnit, newExtraOffer, newPlanType);
            boolean isSuccess = manager.updatePlan(oldPlan, newPlan);

            if (isSuccess)
            {
                println("\nUpdated Plan Info:");
                println(newPlan.toString());
                println(Helper.seperateStyleString("Pland Updated"));
            }
            else
            {
                println("Plan Update Fail");
            }
        }
    };

    public void deletePlan(Scanner in) {
        print("\nEnter plan id:");
        String planId = in.nextLine();

        boolean isSuucess = manager.deletePlan(planId);

        if (isSuucess)
        {
            println(Helper.seperateStyleString("Plan Deleted"));
        }
        else
        {
            println("Plan Delete Fail");
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

    public boolean isSkip(String str) {
        return str.toLowerCase().equals("s");
    }
}