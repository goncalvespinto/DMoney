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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author thevenet
 */
public class Question implements ActionListener {

    ConditionQuest condition;
    boolean questMultiChoix;
    int nbReponseParLigne;
    String[] text;
    String answer = "";
    JButton[] ChoiceQuestionnaryButton;
    Color colorBackgroundButtonNonAppuie = Color.WHITE;
    Color colorBackgroundButtonAppuie = new Color(0, 150, 255); //Color.BLUE ;
    boolean questValid = false;
    boolean onlyText = false;
    boolean onlyNumber = false;
    boolean onlyNumberAvecVirgule = false;

    JFormattedTextField retour;
    int valueMaxKeyBoardNumber = 10000000;
    int valueMinKeyBoardNumber = 0;

    public Question(int type, String[] te) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;
        if (type == 1) {
            onlyText = true;
        }
        if (type == 2) {
            onlyNumber = true;
        }

        if (type == 3) {
            onlyNumberAvecVirgule = true;
        }

    }

    public Question(int type, String[] te, int valueMin) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;
        if (type == 1) {
            onlyText = true;
        }
        if (type == 2) {
            onlyNumber = true;
            valueMinKeyBoardNumber = valueMin;
        }
        if (type == 3) {
            onlyNumberAvecVirgule = true;
        }

    }

    public Question(int type, int nbMax, String[] te) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;
        if (type == 1) {
            onlyText = true;
        }
        if (type == 2) {
            onlyNumber = true;
        }
        if (type == 3) {
            onlyNumberAvecVirgule = true;
        }
        valueMaxKeyBoardNumber = nbMax;

    }

    public Question(int type, int nbMax, int valueMin, String[] te) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;
        if (type == 1) {
            onlyText = true;
        }
        if (type == 2) {
            onlyNumber = true;
        }
        if (type == 3) {
            onlyNumberAvecVirgule = true;
        }
        valueMaxKeyBoardNumber = nbMax;
        valueMinKeyBoardNumber = valueMin;

    }

    public Question(int type, String[] te, ConditionQuest conditi) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;
        if (type == 1) {
            onlyText = true;
        }
        if (type == 2) {
            onlyNumber = true;
        }
        if (type == 3) {
            onlyNumberAvecVirgule = true;
        }
        condition = conditi;

    }

    public Question(String[] te) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = null;

    }

    public Question(String[] te, int nbReponseParLign) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = nbReponseParLign;
        condition = null;

    }

    public Question(String[] te, boolean multi) {
        text = te;
        questMultiChoix = multi;
        nbReponseParLigne = 2;
        condition = null;

    }

    public Question(String[] te, boolean multi, int nbReponseParLign) {
        text = te;
        questMultiChoix = multi;
        nbReponseParLigne = nbReponseParLign;
        condition = null;

    }

    public Question(String[] te, ConditionQuest conditi) {
        text = te;
        questMultiChoix = false;
        nbReponseParLigne = 2;
        condition = conditi;

    }

    public Question(String[] te, boolean multi, ConditionQuest conditi, int nbReponseParLign) {
        text = te;
        questMultiChoix = multi;
        condition = conditi;
        nbReponseParLigne = nbReponseParLign;

    }

    public JPanel buildQuest() {

        JPanel QuestPane = new JPanel();
        QuestPane.setBackground(expecamille2.fenetre.colorBackground);

        QuestPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        boolean build = true;
        if (condition != null) {
            if (!condition.valideCondition(expecamille2.fenetre.Quest.questComplet)) {
                build = false;

            }
        }
        if (build) {
            expecamille2.fenetre.gbc.gridy--;
            JLabel textQuest = new JLabel(text[0]);
            textQuest.setFont(expecamille2.fenetre.font);
            textQuest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            expecamille2.fenetre.add(textQuest, expecamille2.fenetre.gbc);
            
            //pour taille bouton egale
            JPanel buttonPanel =  new JPanel();
            GridLayout layoutButton = new GridLayout(0,2);
        buttonPanel.setLayout(layoutButton);
        //fin pour

            expecamille2.fenetre.gbc.gridy++;
            ChoiceQuestionnaryButton = new JButton[text.length - 1];

            gbc.gridx = 0;
            gbc.gridy = 0;

            gbc.gridwidth = 1;
            gbc.gridheight = 1;

            gbc.weightx = 1.;
            gbc.weighty = 1.;

            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.LINE_START; // ou BASELINE_LEADING mais pas WEST.

            gbc.insets = new Insets(10, 10, 10, 10); // Marge à gauche de 15 et marge au dessus de 10.
            // QuestPane.add(textQuest, gbc);
            //    int gry = 1;
            int nbButtonDone = 0;
            int grx = 0;
            int gry = 0;

            while (nbButtonDone + 1 < text.length) {
                gbc.gridx = grx;
                gbc.gridy = gry;
                ChoiceQuestionnaryButton[nbButtonDone] = new JButton("<html>" + text[nbButtonDone + 1] + "</html>");
                ChoiceQuestionnaryButton[nbButtonDone].setFont(expecamille2.fenetre.font);
                ChoiceQuestionnaryButton[nbButtonDone].addActionListener(this);
                ChoiceQuestionnaryButton[nbButtonDone].setBackground(colorBackgroundButtonNonAppuie);
                ChoiceQuestionnaryButton[nbButtonDone].setBorder(new ThreeDimensionalBorder(Color.GRAY, 40, 6));
               // QuestPane.add(ChoiceQuestionnaryButton[nbButtonDone], gbc);
                buttonPanel.add(ChoiceQuestionnaryButton[nbButtonDone]); // pour taille de boutons egale

                grx++;

                if (grx >= nbReponseParLigne) {
                    grx = 0;
                    gry++;
                }

                nbButtonDone++;
            }
  

            if (onlyNumber) {
                retour = buildonlyNumberField();
                GridLayout experimentLayout = new GridLayout(0, 1);
                JPanel tempDecision = new JPanel(experimentLayout);
                tempDecision.add(retour);
                QuestPane.add(retour, gbc);
            }

            if (onlyNumberAvecVirgule) {
                retour = buildonlyNumberNonDecimalField();
                GridLayout experimentLayout = new GridLayout(0, 1);
                JPanel tempDecision = new JPanel(experimentLayout);
                tempDecision.add(retour);
                QuestPane.add(retour, gbc);
            }

            if (onlyText) {
                retour = buildTextField();
                GridLayout experimentLayout = new GridLayout(0, 1);
                JPanel tempDecision = new JPanel(experimentLayout);
                tempDecision.add(retour);
                QuestPane.add(retour, gbc);
            }
            
            //rajouter pour taille de boutons egale
            else
            {
                gbc.gridx = 0;
            gbc.gridy = 0;
                          QuestPane.add(buttonPanel,gbc);
            }
                  
        }
        
        
        return QuestPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int i = 0;

        while (i < ChoiceQuestionnaryButton.length) {
            if (e.getSource() == ChoiceQuestionnaryButton[i]) {

                if (questMultiChoix) {
                    swapColorButton(i);
                } else {
                    swapColorButtonAndCancelOther(i);
                }
            }

            i++;
        }
        i = 0;

    }

    public boolean getQuestValid() {
        compilateQuestValid();
        return questValid;
    }

    private void compilateQuestValid() {
        boolean compilate = true;
        boolean firstAnswer = true;
        if (condition != null) {
            if (!condition.valideCondition(expecamille2.fenetre.Quest.questComplet)) {
                questValid = true;
                compilate = false;
            }

        }
        if (compilate) {
            if (onlyText) {

                if (retour.getText().compareTo("") != 0) {
                    questValid = true;

             
                }

            }
            if (onlyNumber) {
                if (retour.getText().compareTo("") != 0) {
                    if (Integer.valueOf(retour.getText()) >= valueMinKeyBoardNumber) {
                        answer = String.valueOf(retour.getText());
                        questValid = true;
                    } else {
                        questValid = false;
                    }

                } else {
                    questValid = false;
                }
            }
             if (onlyNumberAvecVirgule) {
                if (retour.getText().compareTo("") != 0) {
                    answer = String.valueOf(retour.getText());
                 
                        questValid = true;
                   

                } else {
                    questValid = false;
                }
            } else {
                int i = 0;
                while (i < ChoiceQuestionnaryButton.length) {
                    if (ChoiceQuestionnaryButton[i].getBackground() == colorBackgroundButtonAppuie) {
                        if (firstAnswer) {
                            answer = "";
                            firstAnswer = false;
                            answer = answer + i;
                        } else {
                            answer = answer + " " + i + " ";
                        }
                        questValid = true;
                    }
                    i++;
                }
            }
        }

    }

    private void swapColorButtonAndCancelOther(int idButton) {

        int i = 0;

        if (ChoiceQuestionnaryButton[idButton].getBackground() == colorBackgroundButtonAppuie) {
            ChoiceQuestionnaryButton[idButton].setBackground(colorBackgroundButtonNonAppuie);
        } else {
            while (i < ChoiceQuestionnaryButton.length) {
                if (i == idButton) {
                    ChoiceQuestionnaryButton[i].setBackground(colorBackgroundButtonAppuie);
                } else {
                    ChoiceQuestionnaryButton[i].setBackground(colorBackgroundButtonNonAppuie);
                }
                i++;
            }
        }

    }

    private void swapColorButton(int idButton) {

        if (ChoiceQuestionnaryButton[idButton].getBackground() == colorBackgroundButtonAppuie) {
            ChoiceQuestionnaryButton[idButton].setBackground(colorBackgroundButtonNonAppuie);
        } else {
            ChoiceQuestionnaryButton[idButton].setBackground(colorBackgroundButtonAppuie);
        }
    }

    private JFormattedTextField buildTextField() {

        JFormattedTextField field = new JFormattedTextField();
        field.setHorizontalAlignment(JTextField.CENTER);
   
         
        field.setFont(expecamille2.fenetre.font);
        return field;

    }

    private JFormattedTextField buildonlyNumberField() {
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(valueMaxKeyBoardNumber);
        // If you want the value to be committed on each keystroke instead of focus lost
        formatter.setCommitsOnValidEdit(true);
        JFormattedTextField field = new JFormattedTextField(formatter);
        field.setHorizontalAlignment(JTextField.CENTER);
   
        field.setFont(expecamille2.fenetre.font);
        return field;

    }

    private JFormattedTextField buildonlyNumberNonDecimalField() {

        JFormattedTextField field = new JFormattedTextField();
        field.setHorizontalAlignment(JTextField.CENTER);
        
        field.setFont(expecamille2.fenetre.font);
        return field;

    }
}
