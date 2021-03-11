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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author thevenet
 */
public class Screen implements ActionListener {

    boolean nextScreen = false;

   /* long debutDecision;
    long tempsDecision[];*/

    int screen = 0;

    boolean finPartie = false;
    Insets marge = new Insets(15, 15, 5, 5);
    Color colorBackgroundButtonNonAppuie = Color.WHITE;
    Color colorBackgroundButtonAppuie = new Color(0, 150, 255); //Color.BLUE ;
    JButton Next = creatHomogenSizeButton("");
    JButton relance = creatHomogenSizeButton("");
    JButton buttonPrecedent = creatHomogenSizeButton("");

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void ecran1Text1Titre(String titre, String texte, boolean precedent, Font fonTitre, Font fontText) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        JLabel textTitreEcran1 = new JLabel("<html> <center> " + titre + " </center>  </html>");
        textTitreEcran1.setFont(fonTitre);
        textTitreEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitreEcran1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textTitreEcran1, expecamille2.fenetre.gbc);

        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(fontText);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textEcran1.setVerticalAlignment(javax.swing.SwingConstants.TOP);


        /* réutilisons le même objet <code>expecamille2.fenetre.expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 2;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);

        Next.setText("OK");


        /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 2;
        expecamille2.fenetre.gbc.gridy = 3;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 0;
        expecamille2.fenetre.gbc.weighty = 0;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;
        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);

        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
                      Next.setVisible(true);
         buttonPrecedent.setVisible(true);

        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }
    public void ecran1Text1Titre(String titre, String texte, boolean precedent) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        JLabel textTitreEcran1 = new JLabel("<html> <center> " + titre + " </center>  </html>");
        textTitreEcran1.setFont(expecamille2.fenetre.fontTitre);
        textTitreEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitreEcran1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textTitreEcran1, expecamille2.fenetre.gbc);

        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(expecamille2.fenetre.font);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textEcran1.setVerticalAlignment(javax.swing.SwingConstants.TOP);


        /* réutilisons le même objet <code>expecamille2.fenetre.expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 2;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);

        Next.setText("OK");


        /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 2;
        expecamille2.fenetre.gbc.gridy = 3;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 0;
        expecamille2.fenetre.gbc.weighty = 0;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;
        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);

        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
                      Next.setVisible(true);
         buttonPrecedent.setVisible(true);

        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    public void ecran1Text1Titre(String titre, String texte, boolean precedent, boolean suivant) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        JLabel textTitreEcran1 = new JLabel("<html> <center> " + titre + " </center>  </html>");
        textTitreEcran1.setFont(expecamille2.fenetre.fontTitre);
        textTitreEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitreEcran1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textTitreEcran1, expecamille2.fenetre.gbc);

        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(expecamille2.fenetre.font);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textEcran1.setVerticalAlignment(javax.swing.SwingConstants.TOP);


        /* réutilisons le même objet <code>expecamille2.fenetre.expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 2;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);

        if (suivant) {
            Next.setText("OK");


            /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
            /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
            expecamille2.fenetre.gbc.gridx = 2;
            expecamille2.fenetre.gbc.gridy = 3;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            expecamille2.fenetre.gbc.gridwidth = 1;
            expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            expecamille2.fenetre.gbc.weightx = 0;
            expecamille2.fenetre.gbc.weighty = 0;

            expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            expecamille2.fenetre.gbc.insets = marge;
            expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
        }

        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
              Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    public void ecran1Texte(String texte, boolean precedent,boolean suivant) {

        expecamille2.fenetre.removeAll();

        nextScreen = false;
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(expecamille2.fenetre.font);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);

        
        if(suivant)
        {
        Next.setText("OK");


        /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 2;
        expecamille2.fenetre.gbc.gridy = 2;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 0;
        expecamille2.fenetre.gbc.weighty = 0;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;
        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
        }
        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
         Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }
  //  ecran1Texte1Jpanel(String texte, JPanel panel, String nomBoutonSuivant, boolean precedent)
    public void ecran2Jpanel(JPanel buildQuest, JPanel buildGraph, String nomBoutonSuivant, boolean precedent) {
    
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(buildGraph, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.gridx = 1;
        expecamille2.fenetre.gbc.gridy = 1;
    
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.add(buildQuest, expecamille2.fenetre.gbc);
        if (nomBoutonSuivant == null) {

            expecamille2.fenetre.gbc.weighty = 4;
            expecamille2.fenetre.gbc.gridheight = GridBagConstraints.REMAINDER;;
        }

        if (nomBoutonSuivant != null) {
            Next = creatHomogenSizeButton(nomBoutonSuivant);
            /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
            /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
            expecamille2.fenetre.gbc.gridx = 2;
            expecamille2.fenetre.gbc.gridy = 3;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            expecamille2.fenetre.gbc.gridwidth = 1;
            expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            expecamille2.fenetre.gbc.weightx = 0;
            expecamille2.fenetre.gbc.weighty = 0;

            expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            expecamille2.fenetre.gbc.insets = marge;
            expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
        }

        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
              Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }
    public void ecran1Text1Titre1Jpanel(String titre, String texte, JPanel panel, String nomBoutonSuivant) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        JLabel textTitreEcran1 = new JLabel("<html> <center> " + titre + " </center>  </html>");
        textTitreEcran1.setFont(expecamille2.fenetre.fontTitre);
        textTitreEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textTitreEcran1, expecamille2.fenetre.gbc);

        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(expecamille2.fenetre.font);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        /* réutilisons le même objet <code>expecamille2.fenetre.expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 2;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 3;
        expecamille2.fenetre.add(panel, expecamille2.fenetre.gbc);

        Next = creatHomogenSizeButton(nomBoutonSuivant);


        /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 3;
        expecamille2.fenetre.gbc.gridy = 4;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 0;
        expecamille2.fenetre.gbc.weighty = 0;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;
        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
              Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    public void ecran1Texte1Jpanel(String texte, JPanel panel, String nomBoutonSuivant, boolean precedent) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        expecamille2.fenetre.add(panel, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.gridx = 1;
        expecamille2.fenetre.gbc.gridy = 1;
        JLabel textEcran1 = new JLabel(texte);
        textEcran1.setFont(expecamille2.fenetre.font);
        textEcran1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.add(textEcran1, expecamille2.fenetre.gbc);
        if (nomBoutonSuivant == null) {

            expecamille2.fenetre.gbc.weighty = 4;
            expecamille2.fenetre.gbc.gridheight = GridBagConstraints.REMAINDER;;
        }

        if (nomBoutonSuivant != null) {
            Next = creatHomogenSizeButton(nomBoutonSuivant);
            /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
            /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
            expecamille2.fenetre.gbc.gridx = 2;
            expecamille2.fenetre.gbc.gridy = 3;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            expecamille2.fenetre.gbc.gridwidth = 1;
            expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            expecamille2.fenetre.gbc.weightx = 0;
            expecamille2.fenetre.gbc.weighty = 0;

            expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            expecamille2.fenetre.gbc.insets = marge;
            expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
        }

        if (precedent) {
            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START;
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
              Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    public void ecran1Jpanel(JPanel panel, String nomBoutonSuivant, boolean precedent, boolean relancer) {
        expecamille2.fenetre.removeAll();
        nextScreen = false;
        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = marge;

        if (nomBoutonSuivant == null) {

            expecamille2.fenetre.gbc.weighty = 4;
            expecamille2.fenetre.gbc.gridheight = GridBagConstraints.REMAINDER;;
        }

        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;
        expecamille2.fenetre.add(panel, expecamille2.fenetre.gbc);
        if (nomBoutonSuivant != null) {
            Next = creatHomogenSizeButton(nomBoutonSuivant);
            /* réutilisons le même objet <code>expecamille2.fenetre.gbc</code>. */
            /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
            expecamille2.fenetre.gbc.gridx = 2;
            expecamille2.fenetre.gbc.gridy = 3;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            expecamille2.fenetre.gbc.gridwidth = 1;
            expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            expecamille2.fenetre.gbc.weightx = 0;
            expecamille2.fenetre.gbc.weighty = 0;

            expecamille2.fenetre.gbc.fill = GridBagConstraints.NONE;

            expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_END; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            expecamille2.fenetre.gbc.insets = marge;
            expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);
        }

        if (precedent) {
            JButton JbuttonPrecedent = creatHomogenSizeButton("Precedent");
            expecamille2.fenetre.gbc.gridx = 0;
            expecamille2.fenetre.add(JbuttonPrecedent, expecamille2.fenetre.gbc);
        }
        if (relancer) {
            relance = creatHomogenSizeButton("Relancer");
            expecamille2.fenetre.gbc.gridx = 1;
            expecamille2.fenetre.add(relance, expecamille2.fenetre.gbc);

        }
              Next.setVisible(true);
         buttonPrecedent.setVisible(true);
        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    public boolean getFinPartie() {

        return finPartie;
    }

    public void appuieOK() {
        Next.setVisible(false);
        buttonPrecedent.setVisible(false);
        nextScreen = true;
        screen++;
    }

    public void appuieRelancer() {
        nextScreen = true;
    }

    public void appuiePrecedent() {
        Next.setVisible(false);
        buttonPrecedent.setVisible(false);
        nextScreen = true;
        screen--;
    }

    public JButton creatHomogenSizeButton(String textButton) {

        JButton bouton = new javax.swing.JButton(textButton);
        bouton.addActionListener(this);
        bouton.setFont(expecamille2.fenetre.font);
        bouton.setMinimumSize(new Dimension((int) expecamille2.fenetre.tailleEcran.getWidth() / 5, (int) expecamille2.fenetre.tailleEcran.getHeight() / 10));
        bouton.setMaximumSize(new Dimension((int) expecamille2.fenetre.tailleEcran.getWidth() / 5, (int) expecamille2.fenetre.tailleEcran.getHeight() / 10));
        bouton.setPreferredSize(new Dimension((int) expecamille2.fenetre.tailleEcran.getWidth() / 5, (int) expecamille2.fenetre.tailleEcran.getHeight() / 10));
        return bouton;

    }

    public void attenteFinNextScreen() {

        while (nextScreen == false) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AffichageJeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void attenteF6() {

        while (!expecamille2.fenetre.getDoneF6()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AffichageJeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

 /*   public void setTempsDebut() {
        debutDecision = System.currentTimeMillis();

    }

    public void setTemps(int i) {
        tempsDecision[i] = System.currentTimeMillis() - debutDecision;
    }*/

}
