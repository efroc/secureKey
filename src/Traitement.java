public class Traitement {

    public static void messErr(String msg) {
        System.out.println("Erreur : " + msg);
    }

    public static int validNumber(String getScan, int min, int max) {
        int choice;
        try {
            choice = Integer.parseInt(getScan);
            if(choice < min || choice > max) {
                return -1;
            }
            return choice;
        } catch(NumberFormatException e) {
            return -1;
        }
    }
}