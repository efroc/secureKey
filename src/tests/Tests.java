package tests;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import classes.Traitement;

public class Tests {
    
    @Test
    public void testStringToSubstring() {
        String s = "";
        char c = ';';
        ArrayList<String> result = Traitement.stringToSubstring(s, c);
        ArrayList<String> expected = new ArrayList<>();
        assertTrue(result.equals(expected));
    }

    @Test
    public void testStringToSubstring2() {
        String s = "dgdg;pgm";
        char c = ';';
        ArrayList<String> result = Traitement.stringToSubstring(s, c);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("dgdg");
        expected.add("pgm");
        assertTrue(result.equals(expected));
    }

    @Test
    public void testStringToSubstring3() {
        String s = "dgdg;pgm;";
        char c = ';';
        ArrayList<String> result = Traitement.stringToSubstring(s, c);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("dgdg");
        expected.add("pgm");
        expected.add("");
        assertTrue(result.equals(expected));
    }

}
