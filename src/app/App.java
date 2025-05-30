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

    // TODO à modifier avec fonction de Traitement
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

    // TODO à modifier avec fonction de Traitement
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

            case 4:
                ajouterConnexion();
                afficheTable(table.getTable());
                break;

            case 5:
                modifierConnexion();
                afficheTable(table.getTable());
                break;

            case 6:
                supprimerConnexion();
                afficheTable(table.getTable());
                break;

            case 7:
                afficheTable(table.getTable());
                break;

            default:
                System.out.println("Ce numéro d'action n'a pas été codé !");
                break;
        }
    }
    

    public static void ajouterConnexion() {
        String entity, username, password;
        do {
            entity = Traitement.getScan("Entrez le nom de l'entité");
        } while(!Traitement.goodFormat(entity));
        do {
            username = Traitement.getScan("Entrez votre username");
        } while(!Traitement.goodFormat(username));
        do {
            password = Traitement.getScan("Entrez votre password");
        } while(!Traitement.goodFormat(password));
        table.getTable().add(new Triple<String,String,String>(entity, username, password));
    }


    public static void modifierConnexion() {

    }


    public static void supprimerConnexion() {
        int iSup;
        do {
            iSup = Traitement.scanToNumber(Traitement.getScan("Entrez la connexion à supprimer"));
        } while(iSup < 0 || iSup > table.getTable().size()-1);
        table.getTable().remove(iSup);
    }


    

    /***************** Fonctions affichage ********************/
    public static void afficheProg() {
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");                                             
        System.out.println("║                         GESTIONNAIRE DE MOTS DE PASSE                      ║");                                         
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
    }


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
        // init
        afficheProg();
        // choix du fichier de sauvegarde (lecture et ecriture)
        listerFichiers();
        choixFichier();
        // init table et affichage de la table des mots de passe
        table = new Table(readFile.dataToTriple());
        afficheTable(table.getTable());
        // tant qu'on ne quitte pas
        while(!stop) {
            afficheMenu();
            choixMenu();
        }
    }
}
