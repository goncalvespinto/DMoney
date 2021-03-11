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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author thevenet
 */
public class TimeLine extends JPanel {

    Color colorBackground = Color.WHITE;

    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public TimeLine() {
        super();
setBackground(colorBackground);
        
             setLayout(new GridBagLayout());

      GridBagConstraints  gbc = new GridBagConstraints();
        gbc.gridx = gbc.gridy = 0; // la grille commence en (0, 0)

        gbc.gridwidth = 1; // seul composant de sa colonne, il est donc le dernier.
        gbc.gridheight = 1; // valeur par défaut - peut s'étendre sur une seule ligne.

        gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.
        gbc.fill= GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 15, 0, 0); // Marge à gauche de 15 et marge au dessus de 10.

        ImageIcon background;
        // background = new ImageIcon("CNRS.jpg"); // load the image to a imageIcon
        background = new ImageIcon("logo-universite-lyon.jpg");
        Image image = background.getImage(); // transform it 

        int heightImage = (int) ((int) expecamille2.fenetre.tailleEcran.getHeight() / 10);
        int widthImage = (int) expecamille2.fenetre.tailleEcran.getWidth() / 10;

        Image newimg = image.getScaledInstance(widthImage, heightImage, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        background = new ImageIcon(newimg);  // transform it back
        JPanel iconeHautgauche = new JPanel();
        iconeHautgauche.setBackground(colorBackground);
        JLabel haut = new JLabel(background);
        iconeHautgauche.add(haut);

//setLayout(new FlowLayout(FlowLayout.LEFT));
        add(iconeHautgauche, gbc);
 
      JPanel frise = new JPanel();
          frise.setMinimumSize(new Dimension((int) expecamille2.fenetre.tailleEcran.getWidth() *3 / 4, (int) expecamille2.fenetre.tailleEcran.getHeight() / 8));
      frise.setPreferredSize(new Dimension((int) expecamille2.fenetre.tailleEcran.getWidth()*3 / 4, (int) expecamille2.fenetre.tailleEcran.getHeight() / 8));
        GridLayout experimentLayout = new GridLayout(2, 1);
        frise.setLayout(experimentLayout);

        JPanel panelPart = new JPanel();

        GridLayout experimentLayoutPart = new GridLayout(1, expecamille2.fenetre.nbPart);
        panelPart.setLayout(experimentLayoutPart);
        int i = 1;
        while (i <= expecamille2.fenetre.nbPart) {
            JLabel labelPeriod;
            labelPeriod = new JLabel("<html> <center> Partie " + i + " </html>");
            labelPeriod.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            labelPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            labelPeriod.setBorder(border);
            labelPeriod.setBackground(new Color(204, 229, 255));
            labelPeriod.setOpaque(true);
            panelPart.add(labelPeriod);

            if (i == expecamille2.fenetre.partActive) {
                labelPeriod.setBackground(new Color(0, 150, 255));
            }
            i++;

        }

        JPanel panelPeriod = new JPanel();

        GridLayout experimentLayoutPeriod = new GridLayout(1, expecamille2.fenetre.nbPeriodMax );
        panelPart.setLayout(experimentLayoutPeriod);
        i = 0;

        while (i < expecamille2.fenetre.nbPeriodMax) {
            JLabel labelPeriod;
            if (i == 0) {
                labelPeriod = new JLabel("<html> <center> Introduction </html>");
                labelPeriod.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                labelPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelPeriod.setBorder(border);
                labelPeriod.setBackground(new Color(204, 229, 255));
                labelPeriod.setOpaque(true);
                panelPeriod.add(labelPeriod);

            }
             if (i == 1) {
                labelPeriod = new JLabel("<html> <center> Entrainement 1 </html>");
                labelPeriod.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                labelPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelPeriod.setBorder(border);
                labelPeriod.setBackground(new Color(204, 229, 255));
                labelPeriod.setOpaque(true);
                panelPeriod.add(labelPeriod);

            }
              if (i == 2) {
                labelPeriod = new JLabel("<html> <center> Entrainement 2 </html>");
                labelPeriod.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                labelPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelPeriod.setBorder(border);
                labelPeriod.setBackground(new Color(204, 229, 255));
                labelPeriod.setOpaque(true);
                panelPeriod.add(labelPeriod);

            }
             
             
             else {
                labelPeriod = new JLabel("<html> <center> Periode " + i + " </html>");
                labelPeriod.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                labelPeriod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                labelPeriod.setBorder(border);
                labelPeriod.setBackground(new Color(204, 229, 255));
                labelPeriod.setOpaque(true);
                panelPeriod.add(labelPeriod);

            }
            if (i == expecamille2.fenetre.periodActive) {
                labelPeriod.setBackground(new Color(0, 150, 255));

            }
            i++;

        }
       // System.out.println( " part active : "+expecamille2.fenetre.periodActive +  " nbPeriodMax " +  expecamille2.fenetre.nbPeriodMax );

        frise.add(panelPart);
        frise.add(panelPeriod);
        gbc.gridx =1;
        add(frise,gbc);

    }

}
