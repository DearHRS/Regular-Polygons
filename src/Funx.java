public class Funx {
    //Checks if given string is a number
    public static boolean IsNumeric(String dummy){
        try{
            Double.parseDouble(dummy);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("    >" + dummy + "< is not a number!");
            return false;
        }
    }

    //changes degrees to radians
    public static double DegreesToRadians(int degree){
        //return Math.round((((double) degree )/ 180.0 * Math.PI) * 1000000.0)  / 1000000.0;
        return (double) degree / 180.0 * Math.PI ;
    }
}
