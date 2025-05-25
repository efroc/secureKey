package graphic;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;

public class GUI extends JFrame{
    
    public GUI() {
        // nom de la fenetre
        super("SecureKey");
        // taille de la fenetre
        setSize(800, 600);
        // centrer la fenetre
        setLocationRelativeTo(null);
        
        // barre de menu
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemSauvegarder = new JMenuItem("Sauvegarder");
        JMenuItem itemOuvrir = new JMenuItem("Ouvrir un nouveau fichier");
        JMenuItem itemQuitter = new JMenuItem("Quitter");

        menuFichier.add(itemSauvegarder);
        menuFichier.add(itemOuvrir);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);

        itemQuitter.addActionListener(e -> System.exit(0));
        menuBar.add(menuFichier);

        setJMenuBar(menuBar);
        
        
        
        
        
        
        
        
        // croix pour quitter
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // rendre visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
