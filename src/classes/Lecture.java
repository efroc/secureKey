package classes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Lecture {
    
    private String nomFichier = "data.txt";

    public void affiche() {
        try {
            InputStream f = new FileInputStream(System.getProperty("user.dir")+"\\save\\"+nomFichier);
            try {
                int data = f.read();
                while(data != -1) {
                    System.out.print((char) data);
                    data = f.read();
                }
                System.out.println();
                f.close();
            } catch(IOException e) {
                Traitement.messErr("Impossible d'afficher le contenu du fichier !");
            }
        } catch(FileNotFoundException e) {     
            Traitement.messErr("Impossible de trouver le fichier de sauvegarde !");
        }    
    }

    public ArrayList<Triple<String,String,String>> dataToTriple() {
        ArrayList<Triple<String,String,String>> table = new ArrayList<>();
        String allData = "";
        try {
            InputStream f = new FileInputStream(System.getProperty("user.dir")+"\\save\\"+nomFichier);
            try {
                int carac = f.read();
                // lecture du fichier
                while(carac != -1) {
                    allData += (char)carac;
                    carac = f.read();
                }
                f.close();
            } catch(IOException e) {
                Traitement.messErr("Impossible de lire le fichier de sauvegarde !");
            }
        } catch(FileNotFoundException e) {     
            Traitement.messErr("Impossible de trouver le fichier de sauvegarde !");
        } 
        // obtention des triplets
        ArrayList<String> triplets = Traitement.stringToSubstring(allData, '#');
        for(int i = 0; i < triplets.size(); i++) {   
            Triple<String,String,String> newTriple = new Triple<>();
            ArrayList<String> triple = Traitement.stringToSubstring(triplets.get(i), ';');
            // erreur si trop d'elements (triplet)
            if(triple.size() > 3) {
                Traitement.messErr("Fichier corrompu, la donnée est trop longue !");
            }
            // ajout dans la table
            newTriple.setFirst(triple.get(0));
            newTriple.setSecond(triple.get(1));
            newTriple.setThird(triple.get(2));
            table.add(newTriple);
        }
        return table;
    }
}
