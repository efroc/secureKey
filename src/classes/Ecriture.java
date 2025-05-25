package classes;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Ecriture {
    
    private String nomFichier = "data.txt";

    public void tripleToData(ArrayList<Triple<String,String,String>> table) {
        String fstWord = ""; 
        String sndWord = ""; 
        String thdWord = "";
        try {
            OutputStream f = new FileOutputStream(System.getProperty("user.dir")+"\\save\\"+nomFichier);
            // parcours de la table
            try {
                for(int i = 0; i < table.size(); i++) {
                    fstWord = table.get(i).getFirst();
                    sndWord = table.get(i).getSecond();
                    thdWord = table.get(i).getThird();
                    String data = fstWord + ';' + sndWord + ';' + thdWord;
                    if(i != 0) {
                        data = '#' + data;
                    }
                    byte[] bytes = data.getBytes();
                    f.write(bytes);
                    f.flush();
                }
                f.close();
            } catch(IOException e) {
                Traitement.messErr("Impossible d'écrire dans le fichier de sauvegarde !");
            }     
        } catch(FileNotFoundException e) {
            Traitement.messErr("Impossible de trouver le fichier de sauvegarde !");
        }
    }
}
