/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;

/**
 *
 * @author thevenet
 */
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author thevenet
 */
class Fenetre extends javax.swing.JFrame implements KeyListener {

    AffichageJeu P1;

    PartieIntro pIntro;

    boolean doneF6 = false;
    QuestionnaireFin Quest;
    private boolean done;
    Color colorBackground = new Color(128, 191, 255);
    Color colorBackgroundExample = new Color(128, 191, 255);
    Insets margeNormal = new Insets(15, 15, 15, 15);

    Font fontTitre = new Font("TimesRoman", Font.PLAIN, 18);
    Font font = new Font("TimesRoman", Font.PLAIN, 14);
    Font fontTable = new Font("TimesRoman", Font.PLAIN, 10);
    Font fontButton = new Font("TimesRoman", Font.PLAIN, 25);


    GridBagConstraints gbc;
    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    int partActive = 0;
    int periodActive = 0;
    int nbPeriodMax = 0;
    int nbPart = 5;

    public Fenetre() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        super();

        int hauteur = (int) tailleEcran.getHeight();
        int largeur = (int) tailleEcran.getWidth();

        setPreferredSize(new java.awt.Dimension(largeur, hauteur));

        setUndecorated(true);
        
        
       // this.setAlwaysOnTop(true); // A remettre, enlevé car problème pop-up
        
        
        
        done = false;

        getContentPane().setBackground(colorBackground);

        //setContentPane(new BackgroundContainer(background.getImage()));
        repaint();

        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran

        System.out.println(largeur + "taille de l'écran : " + hauteur);
        setSize(largeur, hauteur);

        /*     setTitle("Keo"); //On donne un titre à l'application
         setResizable(true); //On  permet le redimensionnement
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
         */
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// interdit l'utilisation de la croix pour ferme
        setExtendedState(MAXIMIZED_BOTH); //Si JFrame

        this.setLocation(0, 0);

        setVisible(true);
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            public void eventDispatched(AWTEvent event) {
                if (event.getID() == KeyEvent.KEY_PRESSED) {
                    KeyEvent kEvent = (KeyEvent) event;
                    System.out.println(kEvent.getKeyCode());
                    boolean F6 = (kEvent.getKeyCode() == KeyEvent.VK_F6);
                    if (F6) {
                        System.out.println("F6");
                        setDoneF6(F6);
                    }
                }
            }

        }, AWTEvent.KEY_EVENT_MASK);
        
           setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0; // la grille commence en (0, 0)

        gbc.gridwidth = 1; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 15, 0, 0); // Marge à gauche de 15 et marge au dessus de 10.

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;

    }

    public void creatPart() {
        P1 = new AffichageJeu();
        pIntro = new PartieIntro();
        Quest = new QuestionnaireFin();

    }

    @Override
    public void removeAll() {
        super.getContentPane().removeAll();
        //buidTop();

    }

    public void buidTop() {
  
        TimeLine t = new TimeLine();

        this.add(t, gbc);

    }

    boolean getDone() {
        return done;
    }

    void setDone(boolean b) {
        done = b;
    }

    public void end() {
        dispose();
        setVisible(false);
        setDone(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
       // System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_F6) {
            setDoneF6(true);
            System.out.println("setf6");
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
       // System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_F6) {
            setDoneF6(true);
            System.out.println("setf6");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_F6) {
            setDoneF6(true);
            System.out.println("setf6");
        }

    }

    public boolean getDoneF6() {
        return doneF6;
    }

    public void setDoneF6(boolean d) {
        doneF6 = d;
    }

}
