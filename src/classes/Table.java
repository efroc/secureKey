package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
    
    private ArrayList<Triple<String,String,String>> myTable;

    // constructeur
    public Table() {
        myTable = new ArrayList<>();
    }

    public Table(ArrayList<Triple<String,String,String>> newTable) {
        myTable = newTable;
    }

    // getters setters
    public ArrayList<Triple<String,String,String>> getTable() {
        return this.myTable;
    }  
}
