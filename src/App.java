import java.util.Scanner;

public class App {


    /************* VARGLOBALES ***************/

    // read file
    private static Lecture readFile = new Lecture();
    // write file
    private static Ecriture writeFile = new Ecriture();
    // table des connexions
    private static Table table;
    // scanner actions
    private static Scanner sc;


    // visible passwords
    private static boolean lock = false;
    // stop loop
    private static boolean stop;
    // max actions
    final private static int nbAction = 10;
    // false pour affichage console, true pour interface graphique
    final private static boolean affichage = false;
    
    /******************************************/


    /** Execute l'action associée à l'entier en entrée
     * @param choice l'entier désignant une action du menu
     */
    public static void action(int choice) {
        switch(choice) {
            case -1:
                Traitement.messErr("Nombre invalide !");
                break;

            case 0:
                writeFile.tripleToData(table.getTable());
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
                writeFile.tripleToData(table.getTable());
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
                 + "    4- Sauvegarder les changements \n"
                 + "    0- Arrêter";
        System.out.println(s);
    }

    
    public static void main(String[] args) throws Exception {
        if(!affichage) {
            System.out.println();
            System.out.println("==================== GESTIONNAIRE DE MOTS DE PASSE ====================");
            
            sc = new Scanner(System.in);
            stop = false;
            table = new Table(readFile.dataToTriple());

            while(!stop) {
                table.showTable(lock);
                afficheMenu();
                System.out.print("=> ");
                String getScan = sc.nextLine();
                action(Traitement.validNumber(getScan, -1, nbAction));
                System.out.println("=======================================================================");     
            }
            sc.close();
        } else {
            // interface graphique
        }   
    }
}
