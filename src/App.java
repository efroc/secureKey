import java.util.Scanner;

public class App {

    // scanner actions
    private static Scanner sc;
    // stop loop
    private static boolean stop;
    // table
    private static Table table;
    // max actions
    final private static int nbAction = 10;

    /** Execute l'action associée à l'entier en entrée
     * @param choice l'entier désignant une action du menu
     */
    public static void action(int choice) {
        switch(choice) {
            case -1:
                Traitement.messErr("Nombre invalide !");
                break;

            case 0:
                stop = true;
                break;
            
            case 1:
                table.addConnection();
                break;

            case 2:
                System.out.println("En cours de développement");
                break;
   
            default:
                Traitement.messErr("Numéro d'action invalide !");
                break;
        }
    }

    /** Affiche le menu des actions
     */
    public static void afficheMenu() {
        String s = "############################### Menu ################################## \n"
                 + "    1- Ajouter une connexion \n"
                 + "    2- Modifier une connexion \n"
                 + "    0- Arrêter";
        System.out.println(s);
    }


    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("==================== GESTIONNAIRE DE MOTS DE PASSE ====================");
        
        sc = new Scanner(System.in);
        stop = false;
        table = new Table();
    
        while(!stop) {
            table.showTable();
            afficheMenu();
            String getScan = sc.nextLine();
            action(Traitement.validNumber(getScan, -1, nbAction));
            System.out.println("=======================================================================");     
        }
        sc.close();
    }
}
