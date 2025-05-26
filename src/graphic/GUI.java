package graphic;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
