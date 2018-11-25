package Helper;

public class Helper {
    public Helper() {};

    public static boolean isNumber(String str)
    {
        try
        {
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public static boolean isDouble(String str)
    {
        try
        {
            
            Double.parseDouble(str);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    // public static double convert2Dboule(String str)
    // {
    //     return (double)Integer
    // }

    public static String seperateStyleString(String str)
    {
        return "\n---------------------------------- "+str+"  --------------------------------------------------------------\n";
    }
}
