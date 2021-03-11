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
public class ConditionQuest {

    int idQuest;
    int typeCondition; // 1 : =
    String nb;

    public ConditionQuest(int idQues,
            int typeConditio,
            String n) {
        idQuest = idQues;
        typeCondition = typeConditio;
        nb = n;

    }

    boolean valideCondition(Question[] questions) {
        boolean retour = false;

        System.out.println("reponse :" + questions[idQuest].answer + " question : " + questions[idQuest].text[0]);

        if (typeCondition == 1) {
            if (questions[idQuest].answer.equals(nb)) {
                retour = true;
            }

        }
        if (typeCondition == 2) {
            if (Integer.parseInt(questions[idQuest].answer) < Integer.parseInt(nb)) {
                retour = true;
            }

        }
        if (typeCondition == 3) {
            if (Integer.parseInt(questions[idQuest].answer) > Integer.parseInt(nb)) {
                retour = true;
            }
        }

        if (typeCondition == 4) {
            if (questions[idQuest].answer.contains(nb)) {
                retour = true;
            }
            else System.out.println(questions[idQuest].answer   +" ne contien pas 10 " +nb );
        }

           if (typeCondition == 5) {
            if (!questions[idQuest].answer.contains(nb)) {
                retour = true;
            }
            else System.out.println(questions[idQuest].answer   +" ne contien pas 10 " +nb );
        }
        return retour;

    }

}
