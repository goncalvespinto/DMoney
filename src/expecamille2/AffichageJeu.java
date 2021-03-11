/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridBagConstraints;

import java.awt.Insets;
import java.awt.event.ActionEvent;

import java.math.BigDecimal;

import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

import javax.swing.JTable;

import javax.swing.table.TableColumn;

/**
 *
 * @author thevenet
 */
class AffichageJeu extends Screen {

    ScrollableJtable tab1;
    ScrollableJtable tab2;
    //ScrollableJtable tab3;
    int timeDecision = 120000;
    int timer;
    JLabel labelTimer;
    java.util.Timer t;

    public AffichageJeu() {

        createTable(1);
        createTable(2);
        //createTable(3);
        buildTab();
    }

    public void uneDecision() {
        expecamille2.fenetre.removeAll();
        if (expecamille2.j.period == 1 && expecamille2.j.phaseDecision) {

            ecran1Text1Titre("<html> <center> <b> Première étape de l’expérience</b> </center></html>", "<html> <center>A chacune des 15 périodes, vous devez prendre 3 décisions: une décision de prêt, une décision d’emprunt et une décision de consommation. <br\\> <br\\>"
                    + "Lors de cette première étape, vous <b>disposez </b> à chaque période, de <b>100 ECU</b>.<br\\> Vous pouvez en prêter une part sur le marché du crédit. Le montant que vous ne prêtez pas sera investi dans la production de bien 1. <br\\><br\\>"
                    + "Vous pouvez <b>emprunter</b> sur le marché du crédit un montant <b>entre 0.1 et 99.9 ECU</b>. <br\\> Le montant emprunté sera investi dans la production de bien 2. "
                    + "<br\\></center></html> ", false, new Font("TimesRoman", Font.PLAIN, 26), new Font("TimesRoman", Font.PLAIN, 22));
            attenteFinNextScreen();
        }
        if (expecamille2.j.period == 16 && expecamille2.j.phaseDecision) {

            ecran1Text1Titre("<html> <center><b> Deuxième étape de l’expérience</b> </center></html>", "<html> <center>A chacune des 15 périodes, vous devez prendre 3 décisions: une décision de prêt, une décision d’emprunt et une décision de consommation. <br\\><br\\>"
                    + "Lors de cette première étape, vous <b>disposez</b> à chaque période, de <b>100 ECU</b>.<br\\> Vous pouvez en prêter une part sur le marché du crédit. Le montant que vous ne prêtez pas sera investi dans la production de bien 1. <br\\><br\\>"
                    + "Vous pouvez <b>emprunter</b> sur le marché du crédit un montant <b>entre 0.1 et 139.9 ECU</b>. <br\\> Le montant emprunté sera investi dans la production de bien 2. "
                    + "<br\\></center></html> ", false, new Font("TimesRoman", Font.PLAIN, 26), new Font("TimesRoman", Font.PLAIN, 22));
            attenteFinNextScreen();
        }
        if (expecamille2.j.period == 31 && expecamille2.j.phaseDecision) {

            ecran1Text1Titre("<html> <center><b> Troisième étape de l’expérience</b> </center></html>", "<html> <center>A chacune des 15 périodes, vous devez prendre 3 décisions: une décision de prêt, une décision d’emprunt et une décision de consommation. <br\\><br\\>"
                    + "Lors de cette première étape, vous <b>disposez</b> à chaque période, de <b>140 ECU</b>.<br\\> Vous pouvez en prêter une part sur le marché du crédit. Le montant que vous ne prêtez pas sera investi dans la production de bien 1. <br\\><br\\>"
                    + "Vous pouvez <b>emprunter</b> sur le marché du crédit un montant <b>entre 0.1 et 139.9 ECU</b>. <br\\> Le montant emprunté sera investi dans la production de bien 2. "
                    + "<br\\></center></html> ", false, new Font("TimesRoman", Font.PLAIN, 26), new Font("TimesRoman", Font.PLAIN, 22));
            attenteFinNextScreen();
        }

        buildScreen();

        //  expecamille2.fenetre.add(buildTab(2),expecamille2.fenetre.gbc);
        if (expecamille2.j.bot) {
            //nextScreen = true;
        }
        attenteFinNextScreen();

        buildWaitScreen();

    }

    public void buildScreen() {

        expecamille2.fenetre.removeAll();
        nextScreen = false;

        JLabel textTitre1 = new JLabel("<html> <b>Décision 1: production de bien 1 et prêt </b>  <br><br>"
                + "<table width=\"100%\" border =\"1\" cellspacing=\"1\" cellpadding=\"1\"><tr><td><div align=center> Les ECU dont vous disposez initialement peuvent être soit dépensés pour la<br>"
                + " production de bien 1, soit prêtés sur le marché du crédit. Veuillez décider le <br>"
                + "montant d'ECU que vous prêtez sur le marché du crédit. Le montant résiduel<br>"
                + "sera investi pour la production de bien 1.  </div></td><tr></table></html>");

        textTitre1.setFont(expecamille2.fenetre.font);
        textTitre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textTitre1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        /* positionnons notre composant suivant (notre JScrollPane) sur la ligne suivante. */
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 0;

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

        expecamille2.fenetre.gbc.fill = GridBagConstraints.WEST;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.WEST; // pas WEST.

        /* Marge à gauche de 15 (gardons la même que précédemment)
         * Marge au dessus de 30 et
         * Marge à droite de 10. */
        expecamille2.fenetre.gbc.insets = new Insets(5, 70, 5, 5);

        expecamille2.fenetre.add(textTitre1, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.fill = GridBagConstraints.WEST;
        expecamille2.fenetre.gbc.insets = new Insets(5, 35, 5, 5);
        expecamille2.fenetre.gbc.anchor = GridBagConstraints.WEST; // pas WEST.
        expecamille2.fenetre.gbc.gridx = 3;

        JLabel textTitre2 = new JLabel("<html> <b>Décision 2: production de bien 2 et emprunt </b> <br><br>"
                + " <table width=\"100%\" border =\"1\" cellspacing=\"1\" cellpadding=\"1\"><tr><td><div align=center>Veuillez décider le montant d'ECU que vous empruntez sur le <br>"
                + " marché du crédit pour la production de bien 2. </div></td><tr></table></html>");

        textTitre2.setFont(expecamille2.fenetre.font);
        expecamille2.fenetre.add(textTitre2, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.fill = GridBagConstraints.CENTER;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 3;
        expecamille2.fenetre.gbc.insets = new Insets(5, 70, 5, 5);
        JLabel textTitre3 = new JLabel("<html> <b>Décision 3: consommation et utilité </b> <br><br>"
                + " <table width=\"100%\" border =\"1\" cellspacing=\"1\" cellpadding=\"1\"><tr><td><div align=center>Veuillez décider la proportion de votre revenu que vous souhaitez allouer à la consommation<br> du bien 1. "
                + " <br>La proportion résiduelle est allouée à la consommation du bien 2. </div></td><tr></table></html>");

        textTitre3.setFont(expecamille2.fenetre.font);
        expecamille2.fenetre.add(textTitre3, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.gridx = 3;
        expecamille2.fenetre.gbc.gridy = 3;
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1;

        Next.setText("Valider");
        Next.setVisible(true);
        Next.setFont(expecamille2.fenetre.fontTitre);
        Next.setMinimumSize(new Dimension(130, 50));
        Next.setMaximumSize(new Dimension(130, 50));
        Next.setPreferredSize(new Dimension(130, 50));

        JPanel panelButton = new JPanel();
        /*  GridLayout experimentLayout = new GridLayout(3, 3);

         panelButton.setLayout(experimentLayout);*/
        panelButton.setBackground(expecamille2.fenetre.colorBackground);

        /*  panelButton.add(new JLabel());
         panelButton.add(new JLabel());
         panelButton.add(new JLabel());
         panelButton.add(new JLabel());*/
        panelButton.add(Next);
        /*   panelButton.add(new JLabel());
         panelButton.add(new JLabel());
         panelButton.add(new JLabel());
         panelButton.add(new JLabel());*/

        expecamille2.fenetre.gbc.insets = new Insets(5, 100, 5, 5);
        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.
        expecamille2.fenetre.gbc.gridwidth = 4;
        expecamille2.fenetre.gbc.gridheight = 2;
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 1;
        expecamille2.fenetre.gbc.weightx = 1;
        expecamille2.fenetre.gbc.weighty = 1;
        expecamille2.fenetre.gbc.insets = marge;
        expecamille2.fenetre.add(tab1, expecamille2.fenetre.gbc);

        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1;
        expecamille2.fenetre.gbc.fill = GridBagConstraints.CENTER;
        expecamille2.fenetre.gbc.weightx = 0;
        expecamille2.fenetre.gbc.weighty = 0;
        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.
        expecamille2.fenetre.gbc.gridwidth = 4;
        expecamille2.fenetre.gbc.gridheight = 2;
        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = 4;
        expecamille2.fenetre.gbc.weightx = 1;
        expecamille2.fenetre.gbc.weighty = 1;
        expecamille2.fenetre.add(tab2, expecamille2.fenetre.gbc);

        /*expecamille2.fenetre.gbc.gridwidth = 1;
         expecamille2.fenetre.gbc.gridheight = 1;
         expecamille2.fenetre.gbc.gridx = 3;
         expecamille2.fenetre.gbc.gridy = 3;
         expecamille2.fenetre.add(tab3, expecamille2.fenetre.gbc);*/
        /* expecamille2.fenetre.gbc.gridy = 6;
         expecamille2.fenetre.gbc.fill = GridBagConstraints.EAST;

         expecamille2.fenetre.gbc.anchor = GridBagConstraints.EAST; // pas WEST.
        
        
         timer = timeDecision / 1000;
         buildTimer();

         labelTimer = new JLabel(timer + " secondes ");
         labelTimer.setFont(expecamille2.fenetre.font);
        
         expecamille2.fenetre.add(labelTimer, expecamille2.fenetre.gbc);*/

        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    private void buildTimer() {
        t = new java.util.Timer();
        t.schedule(new TimerTask() {
            public void run() {

                if (timer == 0) {
                    labelTimer.setText(timer + " secondes ");
                    t.purge();
                    t.cancel();
                } else {
                    timer--;
                    labelTimer.setText(timer + " secondes ");
                    buildTimer();
                }

            }
        }, 1000);

    }

    private void createTable(int idtab) {

        if (idtab == 1) {
            ZModel zModel = new ZModel(expecamille2.j.dataTab1, expecamille2.j.titleTab1);

            expecamille2.j.tableau = new JTable(zModel) {

                public boolean isCellEditable(int row, int column) {

                    if (((column == 2 && row == expecamille2.j.period - 1) || (column == 8 && row == expecamille2.j.period - 1)) && expecamille2.j.phaseDecision) {
                        return true;
                    }
                    return false;

                }

            };

            TableColumn column = null;
            for (int i = 0; i < 10; i++) {
                column = expecamille2.j.tableau.getColumnModel().getColumn(i);
                if (i == 4 || i == 6 || i == 9) {
                    column.setMaxWidth(30);
                }

                if (i == 0) {
                    column.setMaxWidth(50);
                }
            }

            Action action = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    TableCellListener tcl = (TableCellListener) e.getSource();
                    System.out.println("Row   : " + tcl.getRow());
                    System.out.println("Column: " + tcl.getColumn());
                    System.out.println("Old   : " + tcl.getOldValue());
                    System.out.println("New   : " + tcl.getNewValue());

                    try {
                        float valeurTape = Float.parseFloat((String) tcl.getNewValue());
                        float min = 0;
                        if (tcl.getColumn() == 2) {
                            min = (float) (expecamille2.j.Money - 0.1);
                        }
                        if (tcl.getColumn() == 8) {
                            min = (float) (expecamille2.j.Money - 0.1 + expecamille2.j.Credit);
                        }

                        if (valeurTape < 0.1 || valeurTape > min) {

                            JOptionPane.showMessageDialog(null, "Doit être compris entre 0.1 et " + min, " La valeur ne rentre pas dans les borne définie", JOptionPane.INFORMATION_MESSAGE);
                            expecamille2.j.tableau.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());

                        } else if (compteNbDecimal((String) tcl.getNewValue()) > 1) {
                            JOptionPane.showMessageDialog(null, "Doit contenir une décimale", "La valeur ne rentre pas dans les borne définie", JOptionPane.INFORMATION_MESSAGE);
                            expecamille2.j.tableau.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());

                        } else {
                            if (compteNbDecimal((String) tcl.getNewValue()) == 0) {
                                expecamille2.j.tableau.getModel().setValueAt((String) tcl.getNewValue() + "0", tcl.getRow(), tcl.getColumn());
                            } else if (compteNbDecimal((String) tcl.getNewValue()) == -1) {
                                expecamille2.j.tableau.getModel().setValueAt((String) tcl.getNewValue() + ".0", tcl.getRow(), tcl.getColumn());
                            }
                            if (tcl.getColumn() == 2) {

                                BigDecimal bd1 = new BigDecimal(String.valueOf(valeurTape));
                                BigDecimal bd2 = new BigDecimal(String.valueOf(expecamille2.j.Money));

                                expecamille2.j.tableau.getModel().setValueAt(bd2.subtract((bd1)), tcl.getRow(), 1);
                                expecamille2.j.tableau.repaint();
                            }

                        }

                    } catch (NumberFormatException exe) {

                        JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre", "Type non définie", JOptionPane.INFORMATION_MESSAGE);
                        expecamille2.j.tableau.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());
                    }
                }
            };

            TableCellListener tcl = new TableCellListener(expecamille2.j.tableau, action);

            expecamille2.j.tableau.setColumnSelectionAllowed(false);
            expecamille2.j.tableau.setCellSelectionEnabled(false);
            expecamille2.j.tableau.getTableHeader().setReorderingAllowed(false);
            expecamille2.j.tableau.getTableHeader().setFont(expecamille2.fenetre.fontTable);

            expecamille2.j.tableau.getTableHeader().setBackground(Color.lightGray);

            expecamille2.j.tableau.setDefaultRenderer(Object.class, new jTableRender(idtab));

            expecamille2.j.tableau.getTableHeader().setPreferredSize(
                    new Dimension(expecamille2.j.tableau.getSize().width, 100)
            );
            expecamille2.j.tableau.getTableHeader().setResizingAllowed(false);
        }
        if (idtab == 2) {
            

            ZModel zModel = new ZModel(expecamille2.j.dataTab2, expecamille2.j.titleTab2);

            expecamille2.j.tableau2 = new JTable(zModel) {

                public boolean isCellEditable(int row, int column) {

                    if ((column == 1 && row == expecamille2.j.period - 1)) {
                        return true;
                    }
                    return false;

                }

            };

            Action action = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {

                    TableCellListener tcl = (TableCellListener) e.getSource();
                    System.out.println("Row   : " + tcl.getRow());
                    System.out.println("Column: " + tcl.getColumn());
                    System.out.println("Old   : " + tcl.getOldValue());
                    System.out.println("New   : " + tcl.getNewValue());

                    try {
                        float valeurTape = Float.parseFloat((String) tcl.getNewValue());
                        if (valeurTape < 0.009 || valeurTape > 0.991) {
                            JOptionPane.showMessageDialog(null, "Doit être compris entre 0.01 et 0.99", "La valeur ne rentre pas dans les borne définie", JOptionPane.INFORMATION_MESSAGE);
                            expecamille2.j.tableau2.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());

                        } else if (compteNbDecimal((String) tcl.getNewValue()) > 2) {
                            JOptionPane.showMessageDialog(null, "Doit contenir deux décimales", "La valeur ne rentre pas dans les borne définie", JOptionPane.INFORMATION_MESSAGE);
                            expecamille2.j.tableau2.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());

                        } else {
                            if (compteNbDecimal((String) tcl.getNewValue()) == 1) {
                                expecamille2.j.tableau2.getModel().setValueAt((String) tcl.getNewValue() + "0", tcl.getRow(), tcl.getColumn());
                            }
                            if (tcl.getColumn() == 1) {

                                BigDecimal bd1 = new BigDecimal(String.valueOf(valeurTape));
                                BigDecimal bd2 = new BigDecimal("1.00");
                                expecamille2.j.tableau2.getModel().setValueAt(bd2.subtract((bd1)), tcl.getRow(), 2);
                                expecamille2.j.tableau2.repaint();

                            }
                        }

                    } catch (NumberFormatException exe) {

                        JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre", "Type non définie", JOptionPane.INFORMATION_MESSAGE);
                        expecamille2.j.tableau2.getModel().setValueAt("", tcl.getRow(), tcl.getColumn());
                    }
                }
            };

            TableCellListener tcl = new TableCellListener(expecamille2.j.tableau2, action);

            expecamille2.j.tableau2.setColumnSelectionAllowed(false);
            expecamille2.j.tableau2.setCellSelectionEnabled(false);
            expecamille2.j.tableau2.getTableHeader().setReorderingAllowed(false);

            expecamille2.j.tableau2.getTableHeader().setBackground(Color.lightGray);
            expecamille2.j.tableau2.getTableHeader().setFont(expecamille2.fenetre.fontTable);
            expecamille2.j.tableau2.setDefaultRenderer(Object.class, new jTableRender(idtab));

            expecamille2.j.tableau2.getTableHeader().setPreferredSize(
                    new Dimension(expecamille2.j.tableau2.getSize().width, 100)
            );
            TableColumn column = null;
            for (int i = 0; i < 1; i++) {
                column = expecamille2.j.tableau2.getColumnModel().getColumn(i);

                if (i == 0) {
                    column.setMaxWidth(50);
                }
            }

            expecamille2.j.tableau2.getTableHeader().setResizingAllowed(false);
        }

        /*if (idtab == 3) {
         ZModel zModel = new ZModel(expecamille2.j.dataTabGain, expecamille2.j.titleTabGain);

         expecamille2.j.tableauGain = new JTable(zModel);

         expecamille2.j.tableauGain.setColumnSelectionAllowed(false);
         expecamille2.j.tableauGain.setCellSelectionEnabled(false);
         expecamille2.j.tableauGain.getTableHeader().setReorderingAllowed(false);

         expecamille2.j.tableauGain.getTableHeader().setBackground(Color.lightGray);

         expecamille2.j.tableauGain.setDefaultRenderer(Object.class, new jTableRender(idtab));
         expecamille2.j.tableauGain.getTableHeader().setFont(expecamille2.fenetre.fontTable);
         expecamille2.j.tableauGain.getTableHeader().setPreferredSize(
         new Dimension(expecamille2.j.tableauGain.getSize().width, 100)
         );
         expecamille2.j.tableauGain.getTableHeader().setResizingAllowed(false);
      
         }*/
    }

    private void buildTab() {

        tab1 = new ScrollableJtable(expecamille2.j.tableau);

        tab2 = new ScrollableJtable(expecamille2.j.tableau2);

        // tab3 = new ScrollableJtable(expecamille2.j.tableauGain);

        /*tab3.scrollPane.setVerticalScrollBar(tab2.scrollPane.getVerticalScrollBar());
         tab2.scrollPane.setVerticalScrollBar(tab1.scrollPane.getVerticalScrollBar());*/
        tab2.scrollPane.getVerticalScrollBar().setModel(
                tab1.scrollPane.getVerticalScrollBar().getModel());
        //   tab2.scrollPane.getHorizontalScrollBar().setModel(tab3.scrollPane.getHorizontalScrollBar().getModel());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String c = e.getActionCommand();
        // System.out.println("appuie sur bouton: " + c);
        //  System.out.println(e.getActionCommand());

        switch (c) {

            case "OK":
                appuieOK();
                break;
            case "Valider":
                appuieValider();
                break;
            case "Precedent":
                appuiePrecedent();
                break;

            default:
                break;
        }
    }

    private void appuieValider() {
        if (!nextScreen) {
            if (((String) expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 2)).compareTo("") != 0 && ((String) expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 8)).compareTo("") != 0
                    && ((String) expecamille2.j.tableau2.getValueAt(expecamille2.j.period - 1, 1)).compareTo("") != 0) {
                nextScreen = true;
            }

        }

        if (nextScreen == false) {
            JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void buildWaitScreen() {
        ecran1Texte("<html> <center>Veuillez patienter s'il vous plait</center></html> ", false, false);
    }

    private void buildAccueilPeriod() {
        ecran1Texte("<html> <center> Nouvelle période </center></html> ", false, true);

    }

    private int compteNbDecimal(String nb) {
        if (nb.indexOf('.') == -1) {
            return -1;
        }
        int retour = nb.length() - nb.indexOf('.') - 1;
        System.out.println(nb + ", nb decimal : " + retour + " index of . : " + nb.indexOf('.') + " size : " + nb.length());
        return retour;

    }

    private String addToIDecimal(String nb, int i) {

        while (compteNbDecimal(nb) != i) {
            nb = nb + '0';
        }
        return nb;

    }

}
