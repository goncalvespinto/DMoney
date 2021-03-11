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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

/**
 *
 * @author thevenet
 */
class PartieIntro extends Screen {

    int nbQuestionDone = 0;
    private JTextField jtf[] = new JTextField[11];

    Question quest1 = new Question(new String[]{"<html>4) Pour augmenter votre production de bien 1, que devez-vous faire? </html>", "Augmenter votre prêt lors de la décision 1 ",
        "Réduire votre prêt lors de la décision 1 ", "Réduire votre emprunt lors de la décision 2  ", "Augmenter la part de votre revenu que vous allouez à la consommation de bien 1 lors de la décision 3  "});
    Question quest2 = new Question(new String[]{"<html>5) Imaginez que vous soyez à la période 6 de l’expérience. A la période 5, le taux d’intérêt était de 3.00 et le produit marginal de la production de bien 1 de 1.02. Par rapport à cette période 5, vous choisissez: </html>",
        "d’augmenter le montant que vous prêtez (et de réduire ainsi votre production de bien 1). ",
        "de réduire le montant que vous prêtez (et d’augmenter ainsi votre production de bien 1)."});
    Question quest3 = new Question(new String[]{"<html>6) Imaginez que vous soyez à la période 24 de l’expérience. A la période 23, le taux d’intérêt était de 4.25 et le produit marginal de la production de bien 2 de 6.78. Par rapport à cette période 23, vous choisissez: </html>",
        "d’augmenter votre emprunt (et donc votre production de bien 2).",
        "de réduire votre emprunt (et donc votre production de bien 2)."});
    Question quest4 = new Question(new String[]{"<html>7) Imaginez que vous soyez à la période 40 de l’expérience. A la période 39, le prix relatif entre le bien 2 et le bien 1 était de 5.89 et le gain marginal relatif du bien 2 par rapport au bien 1 était de 4.76. Par rapport à cette période 39, vous choisissez:</html>",
        "d’augmenter votre consommation de bien 1 et de réduire votre consommation de bien 2.",
        "d’augmenter votre consommation de bien 2 et de réduire votre consommation de bien 1. "});
    Question quest5 = new Question(new String[]{"<html>8) De quelle information disposerez-vous pour prendre vos décisions lors de la période 1? </html>",
        "Vous prendrez vos décisions en période 1 comme lors de chacune des autres périodes, en comparant le taux d’intérêt avec le produit marginal de la production de bien 1 pour la décision 1, en comparant le taux d’intérêt avec le produit marginal de la production de bien 2 pour la décision 2, et en comparant le prix relatif entre le bien 2 et le bien 1 et le gain marginal relatif de la consommation du bien 2 par rapport au bien 1 pour la décision 3.  ",
        "Vous ne disposerez d’aucune information en période 1 (uniquement). Le résultat de la période 1 vous permettra d’améliorer vos décisions à la période 2, et ainsi de suite.   "});

    Question questComplet[] = {quest1, quest2, quest3, quest4, quest5
    };
    JTable tableauQuest;

    Object dataTabQuest[][] = {};
    String titleTabQuest[] = {"Etape", "Décisions 1 et 2 ", " Intervalle bas pour les décisions", " Intervalle haut pour les décisions"};
    int questAffiche = 0;
    int nbQuestAffiParEcran = 1;

    public PartieIntro() {

    }

    public void go() throws InterruptedException {

        ecran1Text1Titre("Bienvenue !", "<html> <center>Veuillez attendre s'il vous plait"
                + "<br\\></center></html> ", false, false);
        attenteF6();

        screen = 0;

        while (!finPartie) {

            if (screen == 0) {
                ecran1Text1Titre("Bienvenue !", "<html> <center>Merci de ne pas communiquer<br\\> entre vous et d’éteindre vos téléphones portables."
                        + "<br\\></center></html> ", false);
                attenteFinNextScreen();

            }
            if (screen == 1) {
                ecran1Text1Titre("<html> <center>Questionnaire de compréhension des instructions </center></html>", "<html> <center><br\\>"
                        + "<br\\>"
                        + "Avant de commencer l’expérience, nous vous proposons un questionnaire de compréhension sur écran."
                        + "<br\\>"
                        + " Une fois que tous les participants auront répondu correctement à ce questionnaire, "
                        + "<br\\>"
                        + "l’expérience à proprement parler pourra commencer.</center></html> ", false);
                attenteFinNextScreen();

            }

            if (screen == 2) {

                while (nbQuestionDone < 2) {
                    ecran1Jpanel(buildPanelQuest(nbQuestionDone + 1), "Valider", false, false);
                    attenteFinNextScreen();
                    nbQuestionDone++;
                }

                buildTableQuest();
                attenteFinNextScreen();
                nbQuestionDone++;
                while (questAffiche < questComplet.length) {

                    nextScreen = false;
                    EcranQuest();
                    if (questComplet[questAffiche].getQuestValid()) {
                        nextScreen = true;
                    }

                    while (nextScreen == false) {
                        Thread.sleep(1000);

                    }

                    questAffiche = questAffiche + nbQuestAffiParEcran;
                    nbQuestionDone++;
                }
                screen++;

            }

            if (screen == 3) {
                ecran1Text1Titre("<html> <center>Expérience</center></html> ", "<html> <center>L’expérience à laquelle vous participez comporte 45 périodes. Elle est divisée en 3 étapes de 15 périodes. " + "<br\\>"
                        + "<br\\>"
                        + "Un écran vous avertira à chaque changement d’étape.</center></html> ", false);
                attenteFinNextScreen();

                buildWaitScreen();
                Thread.sleep(1000);
                finPartie = true;
            }

        }

    }

    public void EcranQuest() {

        int nbQuestAffiParEcrantemp = nbQuestAffiParEcran;

        expecamille2.fenetre.removeAll();
        int positionElement = 1;

        expecamille2.fenetre.gbc.gridx = 0;
        expecamille2.fenetre.gbc.gridy = positionElement;

        expecamille2.fenetre.gbc.gridwidth = GridBagConstraints.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.

        expecamille2.fenetre.gbc.weightx = 1.;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.LINE_START; // pas WEST.

        expecamille2.fenetre.gbc.insets = marge;

        int nbButtonDone = 0;
        while (nbButtonDone < nbQuestAffiParEcrantemp) {
            expecamille2.fenetre.gbc.gridy = positionElement;

            positionElement++;
            expecamille2.fenetre.gbc.gridy = positionElement;
            expecamille2.fenetre.add(questComplet[questAffiche + nbButtonDone].buildQuest(), expecamille2.fenetre.gbc);
            nbButtonDone++;
            positionElement++;

        }

        positionElement++;
        expecamille2.fenetre.gbc.gridx = 2;
        expecamille2.fenetre.gbc.gridy = positionElement;
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

        JButton suivant = creatHomogenSizeButton("Valider");
        //JButton suivant = new javax.swing.JButton("OK");
        suivant.addActionListener(this);
        suivant.setFont(expecamille2.fenetre.font);

        expecamille2.fenetre.add(suivant, expecamille2.fenetre.gbc);

        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();

    }

    private JPanel buildPanelQuest(int i) {
        JPanel retour = new JPanel();
        retour.setBackground(expecamille2.fenetre.colorBackground);

        retour.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        if (i == 1) {
            gbc.gridx = 0;
            gbc.gridy = 0;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            gbc.gridwidth = 1;
            gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            gbc.weightx = 2;
            gbc.weighty = 1.;

            gbc.fill = GridBagConstraints.CENTER;

            gbc.anchor = GridBagConstraints.EAST; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            gbc.insets = new Insets(0, 0, 0, 0);
            retour.add(new JLabel("1) Vous interagissez avec"), gbc);

            jtf[0] = new JTextField();
            jtf[0].setColumns(10);
            jtf[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.anchor = GridBagConstraints.CENTER; // pas WEST.
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1;
            retour.add(jtf[0], gbc);
            gbc.weightx = 2;
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST; // pas WEST.
            retour.add(new JLabel("autres participants à chaque période."), gbc);

        }
        if (i == 2) {
            gbc.gridx = 0;
            gbc.gridy = 0;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            gbc.gridwidth = 1;
            gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            gbc.weightx = 2;
            gbc.weighty = 1.;

            gbc.fill = GridBagConstraints.CENTER;

            gbc.anchor = GridBagConstraints.SOUTHEAST; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            gbc.insets = new Insets(0, 0, 0, 0);
            retour.add(new JLabel("2)  A chacune des "), gbc);

            jtf[0] = new JTextField();
            jtf[0].setColumns(25);
            jtf[0].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.anchor = GridBagConstraints.SOUTHWEST; // pas WEST.
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 1;
            retour.add(jtf[0], gbc);
            gbc.weightx = 2;
            gbc.gridx = 2;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.SOUTHWEST; // pas WEST.
            retour.add(new JLabel("périodes de l’expérience, vous devez"), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;

            /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
             * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
            gbc.gridwidth = 1;
            gbc.gridheight = 1; // valeur par défaut.

            /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
             * horizontalement que verticalement.
             * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
             * le container en récupérant l'espace supplémentaire.
             */
            gbc.weightx = 1;
            gbc.weighty = 1.;

            gbc.fill = GridBagConstraints.CENTER;

            gbc.anchor = GridBagConstraints.NORTHEAST; // pas WEST.

            /* Marge à gauche de 15 (gardons la même que précédemment)
             * Marge au dessus de 30 et
             * Marge à droite de 10. */
            gbc.insets = new Insets(0, 0, 0, 0);
            retour.add(new JLabel("prendre "), gbc);

            jtf[1] = new JTextField();
            jtf[1].setColumns(25);
            jtf[1].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.anchor = GridBagConstraints.NORTHWEST; // pas WEST.
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 1;
            retour.add(jtf[1], gbc);
            gbc.weightx = 2;
            gbc.gridx = 2;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.NORTHWEST; // pas WEST.
            retour.add(new JLabel(" décisions. "), gbc);
        }

        return retour;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();
        // System.out.println("appuie sur bouton: " + c);
        //  System.out.println(e.getActionCommand());

        int i = 0;

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
        int i = 0;
        if (!nextScreen) {

            if (nextScreen == false) {
                //debut 1
                if (nbQuestionDone == 0) {
                    try {
                        float valeurTape = Float.parseFloat((String) jtf[0].getText());

                        if (!jtf[0].getText().isEmpty()) {

                            if (Integer.valueOf(jtf[0].getText()) == 5) {
                                JOptionPane.showMessageDialog(expecamille2.fenetre, "Vous interagissez avec 5 autres participants à chaque période.", "Vrai", JOptionPane.INFORMATION_MESSAGE);
                                nextScreen = true;
                            } else {
                                jtf[0].setText("");
                                JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (NumberFormatException exe) {

                        JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre", "Type non définie", JOptionPane.INFORMATION_MESSAGE);
                        jtf[0].setText("");
                    }
                }
                // fin 1
                if (nbQuestionDone == 1) {
                    try {
                        float valeurTape = Float.parseFloat((String) jtf[0].getText());
                        valeurTape = Float.parseFloat((String) jtf[1].getText());

                        if (!jtf[0].getText().isEmpty() && !jtf[1].getText().isEmpty()) {
                            if (Integer.valueOf(jtf[0].getText()) == 45 && Integer.valueOf(jtf[1].getText()) == 3) {
                                JOptionPane.showMessageDialog(expecamille2.fenetre, "A chacune des 45 périodes de l’expérience, vous devez prendre 3 décisions.", "Vrai", JOptionPane.INFORMATION_MESSAGE);
                                nextScreen = true;
                            } else {
                                jtf[0].setText("");
                                jtf[1].setText("");
                                JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException exe) {

                        JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre", "Type non définie", JOptionPane.INFORMATION_MESSAGE);
                        jtf[0].setText("");
                        jtf[1].setText("");
                    }
                }

                if (nbQuestionDone == 2) {
                    if (!((String) tableauQuest.getValueAt(0, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(1, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(2, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(3, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(4, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(5, 2)).isEmpty()
                            && !((String) tableauQuest.getValueAt(0, 3)).isEmpty()
                            && !((String) tableauQuest.getValueAt(1, 3)).isEmpty()
                            && !((String) tableauQuest.getValueAt(2, 3)).isEmpty()
                            && !((String) tableauQuest.getValueAt(3, 3)).isEmpty()
                            && !((String) tableauQuest.getValueAt(4, 3)).isEmpty()
                            && !((String) tableauQuest.getValueAt(5, 3)).isEmpty()) {
                        if (Double.valueOf((String) tableauQuest.getValueAt(0, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(1, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(2, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(3, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(4, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(5, 2)) == 0.1
                                && Double.valueOf((String) tableauQuest.getValueAt(0, 3)) == 99.9
                                && Double.valueOf((String) tableauQuest.getValueAt(1, 3)) == 99.9
                                && Double.valueOf((String) tableauQuest.getValueAt(2, 3)) == 99.9
                                && Double.valueOf((String) tableauQuest.getValueAt(3, 3)) == 139.9
                                && Double.valueOf((String) tableauQuest.getValueAt(4, 3)) == 139.9
                                && Double.valueOf((String) tableauQuest.getValueAt(5, 3)) == 139.9) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center> Vous devez prendre une décision de prêt entre 0.1 et 99.9 ECU <br\\>et une décision d’emprunt entre 0.1 et 99.9 ECU à l’étape 1,<br\\> une décision de prêt entre 0.1 et 99.9 ECU et une décision d’emprunt entre 0.1 et 139.9 ECU à l’étape 2,<br\\> une décision de prêt entre 0.1 et 139.9 ECU et une décision d'emprunt entre 0.1 et 139.9 ECU à l’étape 3</center></html>", "Vrai", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                if (nbQuestionDone == 3) {
                    if (questComplet[questAffiche].getQuestValid()) {

                        if (Integer.valueOf(questComplet[questAffiche].answer) == 1) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center>Si vous désirez augmenter votre production de bien 1,<br\\>  vous devez réduire votre prêt lors de la décision 1.</center></html>", "Vrai ", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                if (nbQuestionDone == 4) {
                    if (questComplet[questAffiche].getQuestValid()) {

                        if (Integer.valueOf(questComplet[questAffiche].answer) == 0) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center>Imaginez que vous soyez à la période 6 de l’expérience.<br\\>  A la période 5, le taux d’intérêt était de 3.00 et le produit marginal de la production de bien 1 de 1.02.<br\\>  Par rapport à cette période 5, il est judicieux d’augmenter le montant que vous prêtez (et de réduire ainsi votre production de bien 1).</center></html>", "Vrai ", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                if (nbQuestionDone == 5) {
                    if (questComplet[questAffiche].getQuestValid()) {

                        if (Integer.valueOf(questComplet[questAffiche].answer) == 0) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center>Imaginez que vous soyez à la période 24 de l’expérience.<br\\>  A la période 23, le taux d’intérêt était de 4.25 et le produit marginal de la production de bien 2 de 6.78.<br\\>  Par rapport à cette période 23, il est judicieux d’augmenter votre emprunt (et donc votre production de bien 2).</center></html>", "Vrai ", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                if (nbQuestionDone == 6) {
                    if (questComplet[questAffiche].getQuestValid()) {

                        if (Integer.valueOf(questComplet[questAffiche].answer) == 0) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center> Imaginez que vous soyez à la période 40 de l’expérience. <br\\> A la période 39, le prix relatif entre le bien 2 et le bien 1 était de 5.89 et<br\\>  le gain marginal relatif du bien 2 par rapport au bien 1 était de 4.76.<br\\>  Par rapport à cette période 39, il est judicieux d’augmenter votre consommation de bien 1 et de réduire votre consommation de bien 2.</center></html>", "Vrai ", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                if (nbQuestionDone == 7) {
                    if (questComplet[questAffiche].getQuestValid()) {

                        if (Integer.valueOf(questComplet[questAffiche].answer) == 1) {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "<html> <center>Vous ne disposerez d’aucune information en période 1 (uniquement).<br\\>  Le résultat de la période 1 vous permettra d’améliorer vos décisions à la période 2, et ainsi de suite.</center></html> ", "Vrai ", JOptionPane.INFORMATION_MESSAGE);
                            nextScreen = true;
                        } else {
                            JOptionPane.showMessageDialog(expecamille2.fenetre, "Essayez à nouveau.", "Faux ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
        }
    }

    public void buildWaitScreen() {
        ecran1Texte("<html> <center>Veuillez patienter s'il vous plait</center></html> ", false, false);
    }

    private void buildTableQuest() {
        expecamille2.fenetre.removeAll();
        nextScreen = false;

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
        expecamille2.fenetre.gbc.weightx = 1;
        expecamille2.fenetre.gbc.weighty = 1.;

        expecamille2.fenetre.gbc.fill = GridBagConstraints.BOTH;

        expecamille2.fenetre.gbc.anchor = GridBagConstraints.CENTER; // pas WEST.
        expecamille2.fenetre.add(new JLabel("3) Remplissez le tableau suivant ( appuyez sur ENTREE après chacun de vos choix )  :"), expecamille2.fenetre.gbc);

        ZModel zModel = new ZModel(dataTabQuest, titleTabQuest);
        tableauQuest = new JTable(zModel) {

            public boolean isCellEditable(int row, int column) {

                if (column == 2 || column == 3) {
                    return true;
                }
                return false;

            }

        };

        TableColumn column = null;
        for (int i = 0; i < 4; i++) {
            column = tableauQuest.getColumnModel().getColumn(i);

            column.setMaxWidth(400);

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

                } catch (NumberFormatException exe) {

                    JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre", "Type non définie", JOptionPane.INFORMATION_MESSAGE);
                    tableauQuest.setValueAt("", tcl.getRow(), tcl.getColumn());
                }
            }
        };

        TableCellListener tcl = new TableCellListener(tableauQuest, action);

        tableauQuest.setColumnSelectionAllowed(false);
        tableauQuest.setCellSelectionEnabled(false);
        tableauQuest.getTableHeader().setReorderingAllowed(false);
        tableauQuest.getTableHeader().setFont(expecamille2.fenetre.fontTable);

        tableauQuest.getTableHeader().setBackground(Color.lightGray);
        tableauQuest.setDefaultRenderer(Object.class, new jTableRender(0));
        tableauQuest.getTableHeader().setPreferredSize(
                new Dimension(tableauQuest.getSize().width, 100)
        );
        tableauQuest.getTableHeader().setResizingAllowed(false);
        tableauQuest.setDefaultRenderer(Object.class, new jTableRender(0));
        Object[] donnee = new Object[]{"1", "Décision 1 (Prêt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);
        donnee = new Object[]{"1", "Décision 2 (Emprunt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);
        donnee = new Object[]{"2", "Décision 1 (Prêt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);
        donnee = new Object[]{"2", "Décision 2 (Emprunt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);
        donnee = new Object[]{"3", "Décision 1 (Prêt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);
        donnee = new Object[]{"3", "Décision 2 (Emprunt)", "", ""};
        ((ZModel) tableauQuest.getModel()).addRow(donnee);

        /* ce qui suit est inutile, nous avions déjà définie des valeurs pareilles pour le composant précédent.
         * cependant, il est toujours bon d'avoir toute les étapes dans un premier exemple. */
        expecamille2.fenetre.gbc.gridwidth = expecamille2.fenetre.gbc.REMAINDER;
        expecamille2.fenetre.gbc.gridheight = 3; // valeur par défaut.

        /* Nous pouvons le voir sur l'image à réaliser. Ce composant s'étend sur tout l'espace qu'il recoit aussi bien
         * horizontalement que verticalement.
         * Remarquons que c'est souvent le cas pour ce genre de composant de les laissez s'étendre un maximum possible dans 
         * le container en récupérant l'espace supplémentaire.
         */
        expecamille2.fenetre.gbc.gridy = 1;
        expecamille2.fenetre.gbc.weightx = 3;
        expecamille2.fenetre.gbc.weighty = 3;

        expecamille2.fenetre.add(new ScrollableJtable(tableauQuest), expecamille2.fenetre.gbc);
        Next.setText("Valider");
        Next.setFont(expecamille2.fenetre.fontTitre);
        Next.setMinimumSize(new Dimension(130, 50));
        Next.setMaximumSize(new Dimension(130, 50));
        Next.setPreferredSize(new Dimension(130, 50));

        expecamille2.fenetre.gbc.gridy = 4;
        expecamille2.fenetre.gbc.gridwidth = 1;
        expecamille2.fenetre.gbc.gridheight = 1; // valeur par défaut.
        expecamille2.fenetre.gbc.weightx = 1;
        expecamille2.fenetre.gbc.weighty = 1;

        expecamille2.fenetre.add(Next, expecamille2.fenetre.gbc);

        expecamille2.fenetre.pack();
        expecamille2.fenetre.repaint();
    }

}
