package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class Traitement {

    public static void messErr(String msg) {
        System.out.println("Erreur : " + msg);
        System.exit(0);
    }


    public static int scanToNumber(String getScan) {
        int result;
        try {
            result = Integer.parseInt(getScan);
            return result;
        } catch(NumberFormatException e) {
            return -1;
        }
    }


    public static boolean correctNumberAction(int number, int maxAction) {
        return (number >= 0 && number <= maxAction);
    }


    public static String getScan(String message) {
        System.out.println("║ " + message + " :");
        Scanner sc = new Scanner(System.in);
        System.out.print("║ => ");
        String input = sc.nextLine();
        while(!Traitement.goodFormat(input)) {
            System.out.println("L'entrée ne doit pas contenir de ; ou de # !");
            System.out.print("║ => ");
            input = sc.nextLine();
        }
        return input;
    }


    public static boolean goodFormat(String getScan) {
        if(contains(getScan, ';') || contains(getScan, '#')) {
            return false;
        }
        return true;
    }


    public static ArrayList<String> stringToSubstring(String s, char sep) {
        ArrayList<String> substring = new ArrayList<>();
        if(s.length() == 0) {
            return substring;
        }
        String subWord = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == sep) {
                substring.add(subWord);
                subWord = "";
            } else {
                subWord += s.charAt(i);
            }
        }
        substring.add(subWord);
        return substring;
    }

   
    public static boolean contains(String word, char c) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}