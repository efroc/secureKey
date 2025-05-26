package app;
import java.util.Scanner;

import java.awt.*;
import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import classes.Traitement;
import classes.Ecriture;
import classes.Lecture;
import classes.Table;

public class App {


    /********************** VARGLOBALES **************************/

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
    final private static boolean affichage = true;
    
    
    /******************* FONCTIONS CONSOLE *************************/


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

    /***************** FONCTIONS INTERFACE *******************/

    public static JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        // menu Fichier
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem itemOuvrir = new JMenuItem("Ouvrir un nouveau fichier");
        JMenuItem itemQuitter = new JMenuItem("Quitter");

        menuFichier.add(itemSauvegarder);
        menuFichier.add(itemOuvrir);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);

        // menu Actions
        JMenu menuActions = new JMenu("Actions");
        JMenuItem itemAjouter = new JMenuItem("Ajouter une connexion");

        menuActions.add(itemAjouter);

        // actions cliquables
        itemQuitter.addActionListener(e -> System.exit(0));

        // Ajouter au menu
        menuBar.add(menuFichier);
        menuBar.add(menuActions);
        return menuBar;
    }

    /************************ MAIN ***************************/
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
            // creation fenetre
            JFrame myWindow = new JFrame("SecureKey");
            // taille de la fenetre
            myWindow.setSize(800, 600);
            //centrer la fenetre
            myWindow.setLocationRelativeTo(null);
            // barre de menu
            JMenuBar menu = createMenu();
            myWindow.setJMenuBar(menu);
            // jpanel general
            JPanel generalPanel = new JPanel();
            generalPanel.setBounds(0, 0, 800, 600);
            generalPanel.setBackground(Color.lightGray);
            generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.X_AXIS));

            myWindow.add(generalPanel);
            // croix pour quitter
            myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // rendre visible
            myWindow.setVisible(true);
        }   
    }
}
