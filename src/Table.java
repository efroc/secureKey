import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    
    private ArrayList<Triple<String,String,String>> myTable;

    // constructeur
    public Table() {
        myTable = new ArrayList<>();
    }

    // getters setters
    public ArrayList<Triple<String,String,String>> getTable() {
        return this.myTable;
    }

    /** Ajoute une connexion, c'est-à-dire un triplet (entité, username, password)
     * dans myTable, en fonction de ce que l'on donne en console.
     */
    public void addConnection() {
        Scanner sc = new Scanner(System.in);
        String entity, username, password;
        try {
            // entity
            do {
                System.out.println("Entrez le nom de l'entité : ");
                System.out.print("=> : ");
                entity = sc.nextLine();
            } while(entity.length() == 0);
            // username 
            do {
                System.out.println("Entrez votre username : ");
                System.out.print("=> : ");
                username = sc.nextLine();
            } while(username.length() == 0);
            // password
            do {
                System.out.println("Entrez votre password : ");
                System.out.print("=> : ");
                password = sc.nextLine();
            } while(password.length() == 0);
            // ajout
            Triple<String, String, String> newTriple = new Triple<String,String,String>(entity, username, password);
            getTable().add(newTriple);
        } catch(Exception e) {
            Traitement.messErr("Impossible d'ajouter une connexion");
        }
    }


    public void setConnexion() {
        Scanner sc = new Scanner(System.in);
        int cLine, cTriple;
        if(!myTable.isEmpty()) {
            do {
                System.out.println("Choisir la connexion à modifier :");
                System.out.print("=> ");
                cLine = Traitement.validNumber(sc.nextLine(), 0, myTable.size()-1);
            } while(cLine == -1);
            do {
                System.out.println("Modifier : 1- l'entité ?    2- username ?   3- password ?");
                System.out.print("=> ");
                cTriple = Traitement.validNumber(sc.nextLine(), 1, 3);
            } while(cTriple == -1);  
            setChoice(cTriple, cLine);
        } else {
            Traitement.messErr("Impossible de modifier une connexion, la table est vide !");
        }
    }


    public void setChoice(int cTriple, int Cline) {
        Scanner sc = new Scanner(System.in);
        String getScan;
        switch(cTriple) {
            case 1:
                System.out.println("Entrez le nouveau nom :");
                System.out.print("=> ");
                myTable.get(Cline).setFirst(sc.nextLine());
                break;
            case 2:
                System.out.println("Entrez le nouveau username :");
                System.out.print("=> ");
                myTable.get(Cline).setSecond(sc.nextLine());
                break;
            case 3:
                System.out.println("Entrez le nouveau password :");
                System.out.print("=> ");
                myTable.get(Cline).setThird(sc.nextLine());
                break;
            default:
                Traitement.messErr("L'entier doit être entre 1 et 3 !");
                break;
        }
    }


    /** Affichage de myTable
     */
    public void showTable(boolean lock) {
        String password;
        if(getTable().isEmpty()) {
            System.out.println("La table ne contient pas d'éléments !");
        } else {
            for(int i = 0; i < getTable().size(); i++) {
                Triple<String, String, String> myTriple = getTable().get(i);
                if(lock == true) {
                    password = "********";
                } else {
                    password = myTriple.getThird();
                }
                System.out.println(i + " | " + myTriple.getFirst() + " | " + myTriple.getSecond()
                                     + " | " + password); 
            }
        }
        System.out.println();
    }   
}
