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
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author thevenet
 */
class QuestionnaireFin extends Screen {

    Question questAge = new Question(2, 100, 0, new String[]{"<html>Quel est votre âge?<html>"});
    Question questSex = new Question(new String[]{"<html>Quelle est votre sexe? </html>", "féminin", "masculin"});

    Question questStudy = new Question(new String[]{"<html>Quel est votre niveau de diplôme ?</html>", "Sans diplôme", "Certificat des écoles", "Brevet", "BEP - CAP", "Baccalauréat général ou professionnel", "Bac +2 - DEUG - IUT - DUT - BTS", "Bac +3 - Licence", "Bac +4 - Maitrise", "Bac +5 - Master - DESS - DEA", "Plus de Bac +5 - Doctorat - Thèse"});
    Question questWork = new Question(new String[]{"<html>A quelle catégorie socioprofessionnelle appartenez-vous ?</html>", "Etudiant", "Salarié", "Chomeur", "Inactif (au foyer, rentier, invalide)"});
    Question questEcole = new Question(new String[]{"<html>Quelle est votre école si vous êtes étudiant? (\"Autre\" si vous n'êtes pas étudiant)</html>", "ECLyon", "EMLyon", "Fac de sciences économiques et gestion", "Autre"});
      Question questExpe = new Question(new String[]{"<html>Choisissez parmi les 3 options suivantes</html>", "Vous investissez 1000 euros dans un projet qui vous rapporte 1200 euros.", "Vous investissez 1000 euros dans un projet qui vous rapporte 2300 euros. Pour ce faire, vous avez aussi dû emprunter 1000 euros à 10%.", "Vous investissez 1000 euros dans un projet qui vous rapporte 3600. Pour ce faire, vous avez aussi dû emprunter 2000 euros à 20%. "});
    
    Question questComplet[] = {questAge, questSex, questStudy, questWork, questEcole,questExpe
    };

        int questAffiche = 0;
    int nbQuestAffiParEcran = 1;
    String titreGain = "Vos gains dans l’expérience";

    JFormattedTextField focusedButton;

    public void go() throws InterruptedException {

        expecamille2.fenetre.nbPeriodMax = 0;
        expecamille2.fenetre.periodActive = 0;

          ecran1Text1Titre("<html> <center>L’expérience est maintenant terminée.</center> </html>","<html> <center>Un questionnaire post-expérimental va maintenant s’afficher."+ "<br\\>"
                        +" Les réponses à ce questionnaire sont strictement confidentielles."+ "<br\\>"
                        +" Une fois que vous aurez répondu à ce questionnaire, nous procéderons au paiement.</center> </html>", false);
                while (nextScreen == false) {
                    Thread.sleep(1000);
                }
        
        
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
        }

        screen = 0;

        while (!finPartie) {

            if (screen == 0) {

                ecran1Text1Titre(titreGain, buildTextGain(), false);
                while (nextScreen == false) {
                    Thread.sleep(1000);
                }
                finPartie= true;

            }



        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String c = e.getActionCommand();

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

    private String buildTextGain() {

        //Part1
        double gainFinalEuro =  (expecamille2.j.gainFinal /expecamille2.j.tauxDeChange);
      expecamille2.j.gainFinalEuro =   arrondie(gainFinalEuro , 2);
        String retour = "<html> <b>Votre gain est de : " + arrondie(expecamille2.j.gainFinal,2) +" ECU"
                + "<br\\> Soit "+arrondie(gainFinalEuro,2)+" euros";

        return retour;

    }
        double arrondie(double i, int tailleArrondie)
    {
      return  (double)Math.round(i * (int)Math.pow(10,tailleArrondie)) / (int)Math.pow(10,tailleArrondie) ;
    }

    private void appuieValider() {
        boolean suivant = true;

        int j = 0;

        while (j < nbQuestAffiParEcran) {
            if (!questComplet[questAffiche + j].getQuestValid()) {
                suivant = false;
            }
            j++;
        }
        if (suivant == false) {
            JOptionPane.showMessageDialog(expecamille2.fenetre, "Prenez votre décision s'il vous plait", "Réponse incomplète ", JOptionPane.INFORMATION_MESSAGE);
        }
        nextScreen = suivant;

    }

}
