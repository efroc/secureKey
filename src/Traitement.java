import java.util.ArrayList;

public class Traitement {

    /** Affiche le message souhaité en console
     * @param msg le message d'erreur souhaité
     */
    public static void messErr(String msg) {
        System.out.println("Erreur : " + msg);
        System.exit(0);
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

    /** Selon une chaine de caractères contenant une ou plusieurs fois un séparateur donné, 
     *  donne la liste des sous-chaines
     * 
     * @param s la chaine d'entrée
     * @param sep le séparateur
     * @return la liste des mots séparés par sep
     */
    public static ArrayList<String> stringToSubstring(String s, char sep) {
        ArrayList<String> substring = new ArrayList<>();
        String subWord = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == sep) {
                substring.add(subWord);
                subWord = "";
            } else {
                subWord += s.charAt(i);
            }
        }
        substring.add(subWord);
        return substring;
    }
}