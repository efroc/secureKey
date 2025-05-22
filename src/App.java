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
    // visible passwords
    private static boolean lock = false;
    // save file
    private static Lecture file = new Lecture();

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
                table.setConnexion();
                break;
   
            case 3:
                lock = !lock;
                break;

            case 4:
                file.affiche();
                break;

            case 6:
                System.out.println("Nombre d'éléments : "+table.getTable().size());
                break;

            default:
                Traitement.messErr("Numéro d'action invalide !");
                break;
        }
    }

    /** Affiche le menu des actions
     */
    public static void afficheMenu() {
        String lockOrNot;
        String symb;
        if(lock == false) {
            lockOrNot = "    3- Masquer les mots de passe \n";
            symb = "not lock";
        } else {
            lockOrNot = "    3- Visualiser les mots de passe \n";
            symb = "lock";
        }
        String s = "############################### Menu ################################## \n"
                 + "    1- Ajouter une connexion                            " + symb +"\n"
                 + "    2- Modifier une connexion \n"
                 + lockOrNot
                 + "    4- Afficher le contenu du fichier de sauvegarde \n"
                 + "    0- Arrêter";
        System.out.println(s);
    }

    
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("==================== GESTIONNAIRE DE MOTS DE PASSE ====================");
        
        sc = new Scanner(System.in);
        stop = false;
        table = new Table(file.dataToTriple());

        while(!stop) {
            table.showTable(lock);
            afficheMenu();
            System.out.print("=> ");
            String getScan = sc.nextLine();
            action(Traitement.validNumber(getScan, -1, nbAction));
            System.out.println("=======================================================================");     
        }
        sc.close();
    }
}
