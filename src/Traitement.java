public class Traitement {

    /** Affiche le message souhaité en console
     * @param msg le message d'erreur souhaité
     */
    public static void messErr(String msg) {
        System.out.println("Erreur : " + msg);
    }

    /** Selon un intervalle de numéros d'action, renvoie l'action
     * à exécuter selon la chaine de caractères en entrée
     * 
     * @param getScan la chaine de caractère sortie du Scanner
     * @param min le numéro d'action minimal compris
     * @param max le numéro d'action maximal compris
     * @return le numéro d'action à exécuter, -1 si invalide
     */
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