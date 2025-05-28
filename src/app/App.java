package app;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import classes.Traitement;
import classes.Triple;
import classes.Ecriture;
import classes.Lecture;
import classes.Table;

public class App {

    /********************** VARGLOBALES **************************/

    // file list in save repository
    private static ArrayList<String> fileList;
    // file name
    private static String nomFichier;
    // read file
    private static Lecture readFile;
    // write file
    private static Ecriture writeFile;
    // table des connexions
    private static Table table;
    // scanner actions
    private static Scanner sc;
    // stop for end
    private static boolean stop = false;
    // number of actions
    private static final int NBACTIONS = 10;
    
    
    /*********************** Fonctions console *************************/
    public static void listerFichiers() {
        File dossier = new File(System.getProperty("user.dir")+"\\save");
        fileList = new ArrayList<>(); 
        if (dossier.exists() && dossier.isDirectory()) {
            File[] fichiers = dossier.listFiles();

            if (fichiers != null && fichiers.length > 0) {
                for (File fichier : fichiers) {
                    if (fichier.isFile()) {
                        fileList.add(fichier.getName());
                    }
                }
            } else {
                Traitement.messErr("Le dossier \"save\" est vide !");
            }
        } else {
            Traitement.messErr("Le chemin spécifié n'est pas un dossier valide.");
        }
    }   

    // TODO
    public static void creerFichier() {
        File dossier = new File(System.getProperty("user.dir")+"\\save");
        if (dossier.exists() && dossier.isDirectory()) {
            
        } else {
            Traitement.messErr("Le chemin spécifié n'est pas un dossier valide.");
        }
    }

    public static void choixFichier() {
        System.out.println("╔═════════════════════════════════════════════════════════════════════════════");
        afficheArrayString(fileList);
        System.out.println("║ Choix du fichier :");
        sc = new Scanner(System.in);
        System.out.print("║ => ");
        String getScan = sc.nextLine();
        int idFile = Traitement.scanToNumber(getScan);
        while(idFile < 0 || idFile > fileList.size()-1) {
            System.out.println("║ Entrez un nombre valide ! ");
            System.out.println("║ Choix du fichier :");
            System.out.print("║ => ");
            getScan = sc.nextLine();
            idFile = Traitement.scanToNumber(getScan);
        }
        nomFichier = fileList.get(idFile);
        readFile = new Lecture(nomFichier);
        writeFile = new Ecriture(nomFichier);
        table = new Table(readFile.dataToTriple());
    }


    public static void choixMenu() {
        // on recupere le choix de l'utilisateur
        sc = new Scanner(System.in);
        System.out.print("║ => ");
        String getScan = sc.nextLine();
        int idAction = Traitement.scanToNumber(getScan);
        while(idAction < 0 || idAction > NBACTIONS) {
            System.out.println("║ Entrez un nombre valide ! ");
            System.out.print("║ => ");
            getScan = sc.nextLine();
            idAction = Traitement.scanToNumber(getScan);
        }
        // on execute l'action desiree
        switch(idAction) {
            case 0:
                writeFile.tripleToData(table.getTable());
                stop = true;
                break;
            
            case 1:
                writeFile.tripleToData(table.getTable());
                break;
            
            case 2:
                listerFichiers();
                choixFichier();
                afficheTable(table.getTable());
                break;

            default:
                System.out.println("Ce numéro d'action n'a pas été codé !");
                break;
        }
    }
    


    /***************** Fonctions affichage ********************/
    public static void afficheTable(ArrayList<Triple<String,String,String>> myTable) {
        System.out.println("║═════════════════════════════════════════════════════════════════════════════");
        System.out.println("║ Table des connexions : ");
        afficheArrayTriple(myTable);
    }


    public static void afficheMenu() {
        System.out.println("║═════════════════════════════════════════════════════════════════════════════");
        System.out.println("║ MENU :");
        System.out.println("║ 0- Quitter                                4- Ajouter une connexion\n"
                          +"║ 1- Sauvegarder                            5- Modifier une connexion\n"
                          +"║ 2- Changer de fichier de sauvegarde       6- Supprimer une connexion\n"
                          +"║ 3- Créer une nouvelle sauvegarde");
    }


    public static void afficheArrayString(ArrayList<String> myArray) {
        for(int i = 0; i < myArray.size(); i++) {
            System.out.println("║ " + i + " | " + myArray.get(i));
        }
    }


    public static void afficheArrayTriple(ArrayList<Triple<String,String,String>> myTable) {
        for(int i = 0; i < myTable.size(); i++) {
            System.out.println("║ " + i + myTable.get(i));
        }
    }


    /************************* Main ***************************/
    public static void main(String[] args) throws Exception {
        /* 
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
        */
        
        // init
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");                                             
        System.out.println("║                         GESTIONNAIRE DE MOTS DE PASSE                      ║");                                         
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        // choix du fichier de sauvegarde (lecture et ecriture)
        listerFichiers();
        choixFichier();
        // init table et affichage de la table des mots de passe
        table = new Table(readFile.dataToTriple());
        afficheTable(table.getTable());
        while(!stop) {
            afficheMenu();
            choixMenu();
        }
    }
}
