import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    
    private ArrayList<Triple<String,String,String>> myTable;

    public Table() {
        myTable = new ArrayList<>();
    }

    public ArrayList<Triple<String,String,String>> getTable() {
        return this.myTable;
    }

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
        
    }


    public void setChoice() {
       
    }


    public void showTable() {
        if(getTable().isEmpty()) {
            System.out.println("La table ne contient pas d'éléments !");
        } else {
            for(int i = 0; i < getTable().size(); i++) {
                Triple<String, String, String> myTriple = getTable().get(i);
                System.out.println(i + " | " + myTriple.getFirst() + " | " + myTriple.getSecond()
                                     + " | " + myTriple.getThird()); 
            }
        }
        System.out.println();
    }   
}
