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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author thevenet
 */
class Jeu {

    static String url = "localhost:3306/camilleExp2";

    // static String url = "localhost:3306/camilleExp2";
    static String user = "root";
    static String password = "";
    static String path = "camilleExp2.sql";
    ConnexionBdD connexionBaseDeDonne;

    String nomPC;

    String dateDebut;
    String dateFin;
    int test = 0;
    int standAlone = 0;
    int IDParticipant;
    boolean BdD = false;
    int idSession;

    int period;

    int nbParticipantParGroup = 6;

    double[] decision1 = new double[nbParticipantParGroup];
    double[] decision2 = new double[nbParticipantParGroup];
    double[] decision3 = new double[nbParticipantParGroup];
    double[] Proportionconsommationbien2 = new double[nbParticipantParGroup];
    double[] Prixinput = new double[nbParticipantParGroup];
    double[] Interestrate = new double[nbParticipantParGroup];
    int[] idParticipants = new int[nbParticipantParGroup];
    double[] fi = new double[nbParticipantParGroup];
    double[] gi1 = new double[nbParticipantParGroup];
    double[] gi2 = new double[nbParticipantParGroup];

    double[] Prixbien1 = new double[nbParticipantParGroup];
    double[] Prixbien2 = new double[nbParticipantParGroup];
    double[] Produitmarginalbien1 = new double[nbParticipantParGroup];
    double[] Produitmarginalbien2 = new double[nbParticipantParGroup];
    double[] Money1 = new double[nbParticipantParGroup];
    double[] Money2 = new double[nbParticipantParGroup];
    double[] Gain1 = new double[nbParticipantParGroup];
    double[] Gain2 = new double[nbParticipantParGroup];
    double[] Gain3 = new double[nbParticipantParGroup];
    double[] ci1 = new double[nbParticipantParGroup];
    double[] ci2 = new double[nbParticipantParGroup];
    double[] Prixrelatif = new double[nbParticipantParGroup];
    double[] Gainmarginalrelatifconsommation = new double[nbParticipantParGroup];

    double gain1EtGain2;

    double Beta = (double) 0.8;
    double Alpha = (double) 0.25;
    double[] AlphaPossible = {0.25, 0.35, 0.45, 0.55, 0.65, 0.75};

    int Input = 20;
    int Money = 100;
    int Credit = 0;

    double tauxDeChange = 350;
    int group;

    boolean bot = false;

    boolean phaseDecision;

    int decision;
    double gain;
    double gainFinal = 0;
    double gainFinalEuro = 0;

    int nbPeriod = 30;

    String titleTab1[] = {"<html> <b> Période", "<html> <center><b>Investissement <br\\> production bien 1</center></html>", "<html> <b>Prêt", "<html> <b><center>Produit marginal de <br\\> la production du <br\\> bien 1</center></html>", "", "<html> <b>Taux d'intérêt", "", "<html> <b><center>Produit marginal de <br\\> la production du <br\\>bien 2</center></html>", "<html> <b>Emprunt", "", "<html> <b>Gains décisions 1 et 2"};
    Object[][] dataTab1 = {};
    String titleTab2[] = {"<html> <b>Période", "<html> <center><b>Proportion du<br\\> revenu alloué à la<br\\> consommation du<br\\> bien 1</center></html>", "<html> <center> <b>Proportion du<br\\> revenu alloué à la<br\\> consommation du<br\\> bien 2</center></html>", "<html> <b><center>Prix relatif du <br\\>bien 2 par rapport <br\\>au bien 1</center></html>", "<html> <b><center>Gain marginal relatif<br\\> de la consommation<br\\> du bien 2 par <br\\>rapport au bien 1</center></html>", "<html> <b>Gains décision 3", "", "<html> <b> <center>Gain total par <br\\>période</center></html>", "<html> <b>Gain total cumulé", ""};
    Object[][] dataTab2 = {};

    /*   String titleTabGain[] = {"<html> <b> <center>Gain total par <br\\>période</center></html>", "<html> <b>Gain total cumulé"};
     Object[][] dataTabGain = {};*/
    JTable tableau;
    JTable tableau2;
    //  JTable tableauGain;

    Jeu() throws SQLException, FileNotFoundException {
        IDParticipant = 0;

        Scanner scanner = new Scanner(new FileReader("config.cfg"));
        String mot = null;
        while (scanner.hasNext()) {
            mot = scanner.next();
            System.out.println(mot);

            if (mot.compareTo("test=") == 0) {
                mot = scanner.next();
                System.out.println(mot);
                test = Integer.parseInt(mot);

            }

            if (mot.compareTo("idSession=") == 0) {
                mot = scanner.next();
                System.out.println(mot);
                idSession = Integer.parseInt(mot);

            }

        }

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd'_'HH'h'mm'm'ss's'");
        dateDebut = ft.format(dNow);
        nomPC = getName();
        System.out.println(dateDebut);

        connexionBaseDeDonne = new ConnexionBdD(url, user, password);

        connexionBaseDeDonne.connect();

        connexionBaseDeDonne.ecritTabParticipant(dateDebut, nomPC, test, idSession);

        IDParticipant = connexionBaseDeDonne.getIDParticipant(nomPC, dateDebut);

        Alpha = AlphaPossible[IDParticipant % nbParticipantParGroup];

    }

    void go() throws InterruptedException {
        group = connexionBaseDeDonne.getIDGroup(idSession, IDParticipant);
        connexionBaseDeDonne.ecritGroup(IDParticipant, group);

        System.out.println("ID participant : " + IDParticipant + " group : " + group);

        expecamille2.fenetre.pIntro.go();
        period = 1;

        while (period <= nbPeriod) {

            if (period == 16) {
                Credit = 40;
            }
            if (period == 31) {
                Money = 140;
                Credit = 0;
            }

            ajoutLignesTableaux();
            phaseDecision = true;
            expecamille2.fenetre.P1.uneDecision();
            connexionBaseDeDonne.ecritDecision();
            WaitTouteDecisionPrise();
            calculValeur();
            connexionBaseDeDonne.updateCalcul();
            phaseDecision = false;
            expecamille2.fenetre.P1.uneDecision();
            period++;

        }

        expecamille2.fenetre.Quest.go();
        System.out.println("Ecrit questionnaire");
        connexionBaseDeDonne.ecritQuest(IDParticipant, expecamille2.fenetre.Quest.questComplet);

        Thread.sleep(1000);

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd'_'HH'h'mm'm'ss's'");
        dateFin = ft.format(dNow);
        connexionBaseDeDonne.ecritDateFin(IDParticipant, dateFin);
        connexionBaseDeDonne.ecritGain(IDParticipant, gainFinalEuro);

        expecamille2.fenetre.Quest.ecran1Texte("<html>  <center>   L’expérience est maintenant terminée.<br\\>"
                + "Nous vous remercions d’avoir participé à cette expérience.<br\\>"
                + "<br\\>"
                + "</center></html>", false, false);
        expecamille2.fenetre.doneF6 = false;
        expecamille2.fenetre.Quest.attenteF6();

        System.out.println("FIN");

        expecamille2.fenetre.end();

        /*     expecamille2.fenetre.setDone(true);
        
         expecamille2.fenetre.dispose();
         expecamille2.fenetre.setVisible(false);*/
    }

    public static String getName() {
        String tR = "";
        try {
            tR = InetAddress.getLocalHost().getHostName();
            System.out.println("Name computer : " + tR);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return tR;
    }

    private boolean WaitTouteDecisionPrise() {

        int i = 0;
        while (i != nbParticipantParGroup) {
            try {
                ResultSet resultSet = connexionBaseDeDonne.query("SELECT * FROM  DATA  WHERE  SESSION = " + idSession + " AND Periode = " + period + " AND IDGROUP = " + group
                );
                i = 0;

                while (resultSet.next()) {

                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return true;
    }

    void calculValeur() {
        System.out.println("calcul valeur");
        try {

            int i = 0;

            ResultSet resultSet = connexionBaseDeDonne.query("SELECT * FROM  DATA  WHERE  SESSION = " + idSession + " AND Periode = " + period + " AND IDGROUP = " + group
            );

            while (resultSet.next()) {
                decision1[i] = Float.valueOf(resultSet.getString("DECISION1"));
                decision2[i] = Float.valueOf(resultSet.getString("DECISION2"));
                decision3[i] = Float.valueOf(resultSet.getString("DECISION3"));
                idParticipants[i] = Integer.valueOf(resultSet.getString("IDPARTICIPANT"));
                Proportionconsommationbien2[i] = 1 - decision3[i];
                Prixinput[i] = ((Money + Credit) / Input);
                gi1[i] = ((Money - decision1[i]) / Prixinput[i]);

                i++;
            }

            calculInterestRate();
            calculFi();
            calculGi2();
            calculPrixBien();
            calculproduitMarginalBien1();
            calculproduitMarginalBien2();
            calculMoney();
            calculGain();
            calculCi();
            calculPrixRelatif();
            calculGainMarginalRelatifConso();
            calculGain3();
            calculGainPeriod();

            gainFinal = (gain + gainFinal);
            updateTable();

            /* 
             Object[] donnee = new Object[]{String.valueOf(gain), String.valueOf(gainFinal)};
             ((ZModel) tableauGain.getModel()).addRow(donnee);*/
        } catch (SQLException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ajoutLignesTableaux() {
        if (!bot) {
            Object[] donnee = new Object[]{String.valueOf(period), "", "", "", "", "", "", "", "", "", ""};
            ((ZModel) tableau.getModel()).addRow(donnee);
            donnee = new Object[]{String.valueOf(period), "", "", "", "", "", "", "", "", ""};
            ((ZModel) tableau2.getModel()).addRow(donnee);
        }
        if (bot) {
            double decision3 = (0.1 + (Math.random() * (0.9 - 0.1)));
            double decision1 = (0.1 + (Math.random() * (Money - 0.1)));

            Object[] donnee = new Object[]{String.valueOf(period), String.valueOf(Money - decision1), String.valueOf(decision1), "", "", "", "", "", String.valueOf(0.1 + (Math.random() * (Money - 0.1))),"", ""};
            ((ZModel) tableau.getModel()).addRow(donnee);
            donnee = new Object[]{String.valueOf(period), String.valueOf(decision3), String.valueOf(1 - decision3), "", "", "", "", "", "", ""};
            ((ZModel) tableau2.getModel()).addRow(donnee);
        }

        /*  donnee = new Object[]{ "", ""};
         ((ZModel) tableauGain.getModel()).addRow(donnee);*/
    }

    private void calculInterestRate() {
        double sumD1 = 0;
        double sumD2 = 0;
        double sumCredit = 0;

        int i = 0;
        while (i < nbParticipantParGroup) {
            sumD1 = decision1[i] + sumD1;
            sumD2 = decision2[i] + sumD2;
            sumCredit = sumCredit + Credit;

            i++;
        }
        i = 0;
        while (i < nbParticipantParGroup) {
            Interestrate[i] = (sumD2 / (sumD1 + sumCredit));
            i++;
        }

    }

    private void calculFi() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            fi[i] = (Interestrate[i] * decision1[i] - decision2[i] + Credit * Interestrate[i]);
            i++;
        }

    }

    private void calculGi2() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            gi2[i] = (Math.pow((decision2[i] / Interestrate[i] / Prixinput[i]), Beta));
            i++;
        }
    }

    private void calculPrixBien() {
        double temp1 = 0;
        double temp2 = 0;
        double temp3 = 0;
        double temp4 = 0;

        double temp5 = 0;
        double temp6 = 0;
        double temp7 = 0;

        int i = 0;
        while (i < nbParticipantParGroup) {
            temp1 = decision3[i] * gi2[i] + temp1;
            temp2 = Money + Credit + temp2;
            temp3 = Proportionconsommationbien2[i] * fi[i] + temp3;
            temp4 = temp4 + gi2[i];
            temp5 = Proportionconsommationbien2[i] * gi1[i] + temp5;
            temp6 = gi1[i] + temp6;
            temp7 = decision3[i] * fi[i] + temp7;
            i++;

        }
        i = 0;

        while (i < nbParticipantParGroup) {
            Prixbien1[i] = ((temp1 * temp2 - temp3 * temp4) / (temp5 * temp4 + temp1 * temp6));

            Prixbien2[i] = ((temp5 * temp2 - temp7 * temp6) / (temp5 * temp4 + temp1 * temp6));

            i++;
        }

    }

    private void calculproduitMarginalBien1() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Produitmarginalbien1[i] = (Prixbien1[i] / Prixinput[i]);

            i++;

        }
    }

    private void calculproduitMarginalBien2() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Produitmarginalbien2[i] = ((Beta * Prixbien2[i]) / (Prixinput[i]) * Math.pow(decision2[i] / (Interestrate[i] * Prixinput[i]), Beta - 1));
            i++;

        }
    }

    private void calculMoney() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Money1[i] = (gi1[i] * Prixbien1[i] + decision1[i] * Interestrate[i]);
            Money2[i] = (gi2[i] * Prixbien2[i] - decision2[i] + Credit * Interestrate[i]);

            i++;
        }
    }

    private void calculGain() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Gain1[i] = (Money1[i] - Money * 0.9 + 10);
            Gain2[i] = (Money2[i] - Credit - (Money - 100) * 0.1);

            i++;
        }
    }

    private void calculCi() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            ci1[i] = ((Money1[i] + Money2[i]) * decision3[i] / Prixbien1[i]);
            ci2[i] = ((Money1[i] + Money2[i]) * Proportionconsommationbien2[i] / Prixbien2[i]);
            i++;
        }
    }

    private void calculPrixRelatif() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Prixrelatif[i] = (Prixbien2[i] / Prixbien1[i]);
            i++;
        }
    }

    private void calculGainMarginalRelatifConso() {
        int i = 0;
        while (i < nbParticipantParGroup) {

            Gainmarginalrelatifconsommation[i] = (((1 - Alpha) * ci1[i]) / (Alpha * ci2[i]));
            i++;

        }
    }

    private void calculGain3() {
        int i = 0;
        while (i < nbParticipantParGroup) {
            Gain3[i] = (50 * (1 - Math.abs(Prixrelatif[i] - Gainmarginalrelatifconsommation[i]) / (Prixrelatif[i] + Gainmarginalrelatifconsommation[i])));

            i++;

        }

    }

    private void calculGainPeriod() {
        int i = 0;

        int idDansTableau = 0;
        while (i < nbParticipantParGroup) {
            if (idParticipants[i] == IDParticipant) {
                idDansTableau = i;
            }
            i++;
        }

        gain1EtGain2 = (Money1[idDansTableau] + Money2[idDansTableau] - (Money + Credit - 20)) * ((Money + Credit) / 20);
        gain = (gain1EtGain2 + Gain3[idDansTableau]);

    }

    private void updateTable() {
        int i = 0;
        int idDansTableau = 0;
        while (i < nbParticipantParGroup) {
            if (idParticipants[i] == IDParticipant) {
                idDansTableau = i;
            }
            i++;
        }

        tableau.getModel().setValueAt(arrondie(Produitmarginalbien1[idDansTableau], 2), period - 1, 3);
        tableau.getModel().setValueAt(arrondie(Interestrate[idDansTableau], 2), period - 1, 5);
        tableau.getModel().setValueAt(arrondie(Produitmarginalbien2[idDansTableau], 2), period - 1, 7);
        tableau.getModel().setValueAt(arrondie(gain1EtGain2, 2), period - 1, 10);

        tableau2.getModel().setValueAt(arrondie(Prixrelatif[idDansTableau], 2), period - 1, 3);
        tableau2.getModel().setValueAt(arrondie(Gainmarginalrelatifconsommation[idDansTableau], 2), period - 1, 4);
        tableau2.getModel().setValueAt(arrondie(Gain3[idDansTableau], 2), period - 1, 5);
        tableau2.getModel().setValueAt(arrondie(gain, 2), period - 1, 7);
        tableau2.getModel().setValueAt(arrondie(gainFinal, 2), period - 1, 8);

    }

    double arrondie(double i, int tailleArrondie) {
        return (double) Math.round(i * (int) Math.pow(10, tailleArrondie)) / (int) Math.pow(10, tailleArrondie);
    }

}
