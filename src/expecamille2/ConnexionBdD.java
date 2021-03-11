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
/**
 *
 * @author thevenet
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionBdD {

    private Connection connection = null;
    private Statement statement = null;
    String url;
    String user;
    String passwd;
    String path = null;

    public ConnexionBdD(String pat) {
        path = pat;

    }

    public ConnexionBdD(String ur, String use, String pass) {
        url = ur;
        user = use;
        passwd = pass;

    }

    public void connect() {
        if (path != null) {
            System.out.println("SQLITE!");
            try {

                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:" + path);

                statement = connection.createStatement();
                System.out.println("Connexion a " + path + " avec succès");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println("Erreur de connecxion");
            } catch (ClassNotFoundException notFoundException) {
                notFoundException.printStackTrace();
                System.out.println("Erreur de connecxion, Pas trouve");
            }
        } else {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + url, user, passwd);

                statement = connection.createStatement();
                System.out.println("Connexion a " + url + " avec succès");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
                System.out.println("Erreur de connecxion");
            } catch (ClassNotFoundException notFoundException) {
                notFoundException.printStackTrace();
                System.out.println("Erreur de connecxion, Pas trouve");
            }
        }
    }

    public void close() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String requet) {
        //  System.out.println("requete: " + requet);
        ResultSet resultat = null;
        boolean done = false;
        while (!done) {
            done = true;
            try {
                resultat = statement.executeQuery(requet);
            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("Erreur dans la requet : " + requet);
                if (e.toString().compareTo("java.sql.SQLException: [SQLITE_BUSY]  The database file is locked (database is locked)") == 0) {
                    System.out.println("Attente que la base de donné se libere");
                    done = false;

                }

            }
        }
        return resultat;

    }

    public void querySansRetour(String requet) {
        //     System.out.println("requete: " + requet);
        boolean done = false;
        while (!done) {
            done = true;
            try {
                statement.executeUpdate(requet);
            } catch (SQLException ex) {
//              ex.printStackTrace();

                if (ex.toString().compareTo("java.sql.SQLException: [SQLITE_BUSY]  The database file is locked (database is locked)") == 0) {
                    System.out.println("Attente que la base de donné se libere");
                    done = false;
                }
                System.out.println(ex);
                //Logger.getLogger(ConnexionBdD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void ecritTabParticipant(String dateDebut, String nomPC, int test, int idSession) {

        querySansRetour("INSERT INTO PARTICIPANT (COMPUTER,START,TEST,SESSION) VALUES ( '" + nomPC + "', '"
                + dateDebut + "', '"
                + test + "', '"
                + idSession
                + "' );");

    }

    void ecritAttributionGroup(int session, int periode, int idSubject, int type) {
        double randomGroup = Math.random();

        querySansRetour("INSERT INTO ATTRIBUTIONGROUP (SESSION,PERIOD,IDPARTICIPANT,RANDOMGROUP,TYPE,IDGROUP) VALUES ( '" + session + "', '"
                + periode + "', '"
                + idSubject + "', '"
                + String.valueOf(randomGroup) + "', '"
                + type
                + "', '"
                + "-1"
                + "' );");

    }

    int getIDParticipant(String nomPC, String dateDebut) throws SQLException {
        ResultSet resultSet = query("SELECT * FROM PARTICIPANT WHERE COMPUTER = '" + nomPC + "' AND START  = '" + dateDebut + "'");
        resultSet.next();
        return resultSet.getInt("IDPARTICIPANT");

    }

    void ecritQuest(int IDParticipant, Question[] questComplet) {
        querySansRetour("INSERT INTO QUESTIONNAIRE (IDPARTICIPANT) VALUES ( '" + IDParticipant + "');");
        int i = 0;

        while (i < questComplet.length) {
            int temp1 = i + 1;
            querySansRetour("UPDATE QUESTIONNAIRE set Quest" + temp1 + " = '" + questComplet[i].answer + "' WHERE IDPARTICIPANT = '" + IDParticipant + "';");
            System.out.println("UPDATE QUESTIONNAIRE set Quest" + temp1 + " = '" + questComplet[i].answer + "' WHERE IDPARTICIPANT = '" + IDParticipant + "';");
            i++;
        }
    }

    void ecritDateFin(int IDParticipant, String dateFin) {
        querySansRetour("UPDATE PARTICIPANT set END = '" + dateFin + "' WHERE IDPARTICIPANT = '" + IDParticipant + "';");
    }

    void ecritGroup(int idParticipant, int group) {
        querySansRetour("UPDATE PARTICIPANT set IDGROUP = '" + group + "' WHERE IDPARTICIPANT = '" + idParticipant + "';");

    }

    void ecritDecision() {
        
        System.out.println( "INSERT INTO DATA (SESSION,IDGROUP,IDPARTICIPANT,Periode,DECISION1,DECISION2,DECISION3,Beta,Alpha,Input,Money,Credit,Proportionconsommationbien2) VALUES ( '"
                + expecamille2.j.idSession + "', '"
                + expecamille2.j.group + "', '"
                + expecamille2.j.IDParticipant + "', '"
                + expecamille2.j.period + "', '"
                + expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 2) + "', '"
                + expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 8) + "', '"
                + expecamille2.j.tableau2.getValueAt(expecamille2.j.period - 1, 1) + "', '"
                + expecamille2.j.Beta + "', '"
                + expecamille2.j.Alpha + "', '"
                + expecamille2.j.Input + "', '"
                + expecamille2.j.Money + "', '"
                + expecamille2.j.Credit + "', '"
                + expecamille2.j.tableau2.getValueAt(expecamille2.j.period - 1, 2)
                + "' );");
        querySansRetour("INSERT INTO DATA (SESSION,IDGROUP,IDPARTICIPANT,Periode,DECISION1,DECISION2,DECISION3,Beta,Alpha,Input,Money,Credit,Proportionconsommationbien2) VALUES ( '"
                + expecamille2.j.idSession + "', '"
                + expecamille2.j.group + "', '"
                + expecamille2.j.IDParticipant + "', '"
                + expecamille2.j.period + "', '"
                + expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 2) + "', '"
                + expecamille2.j.tableau.getValueAt(expecamille2.j.period - 1, 8) + "', '"
                + expecamille2.j.tableau2.getValueAt(expecamille2.j.period - 1, 1) + "', '"
                + expecamille2.j.Beta + "', '"
                + expecamille2.j.Alpha + "', '"
                + expecamille2.j.Input + "', '"
                + expecamille2.j.Money + "', '"
                + expecamille2.j.Credit + "', '"
                + expecamille2.j.tableau2.getValueAt(expecamille2.j.period - 1, 2)
                + "' );");
        
        System.out.println("fin ecrit decision");
    }

    void updateCalcul() {
        int i = 0;
        int idDansTableau = 0;
        while (i < expecamille2.j.nbParticipantParGroup) {
            if (expecamille2.j.idParticipants[i] == expecamille2.j.IDParticipant) {
                idDansTableau = i;
            }
            i++;
        }
        querySansRetour("UPDATE DATA set "
                + "Prixinput  = '" + expecamille2.j.Prixinput[idDansTableau]
                + "',Interestrate  = '" + expecamille2.j.Interestrate[idDansTableau]
                + "',fi  = '" + expecamille2.j.fi[idDansTableau]
                + "',gi1  = '" + expecamille2.j.gi1[idDansTableau]
                + "',gi2  = '" + expecamille2.j.gi2[idDansTableau]
                + "',Prixbien1  = '" + expecamille2.j.Prixbien1[idDansTableau]
                + "',Prixbien2  = '" + expecamille2.j.Prixbien2[idDansTableau]
                + "',Produitmarginalbien1  = '" + expecamille2.j.Produitmarginalbien1[idDansTableau]
                + "',Produitmarginalbien2  = '" + expecamille2.j.Produitmarginalbien2[idDansTableau]
                + "',Money1  = '" + expecamille2.j.Money1[idDansTableau]
                + "',Money2  = '" + expecamille2.j.Money2[idDansTableau]
                + "',Gain1  = '" + expecamille2.j.Gain1[idDansTableau]
                + "',Gain2  = '" + expecamille2.j.Gain2[idDansTableau]
                + "',ci1  = '" + expecamille2.j.ci1[idDansTableau]
                + "',ci2  = '" + expecamille2.j.ci2[idDansTableau]
                + "',Prixrelatif  = '" + expecamille2.j.Prixrelatif[idDansTableau]
                + "',Gainmarginalrelatifconsommation  = '" + expecamille2.j.Gainmarginalrelatifconsommation[idDansTableau]
                + "',Gain3  = '" + expecamille2.j.Gain3[idDansTableau]
                + "',Gainperiode  = '" + expecamille2.j.gain
                + "',Gaincumulé  = '" + expecamille2.j.gainFinal
                +"',GAIN1ETGAIN2  = '" + expecamille2.j.gain1EtGain2
                
                + "' WHERE IDPARTICIPANT = '" + expecamille2.j.IDParticipant + "' AND Periode = '" + expecamille2.j.period + "';");

    }

    int getIDGroup(int idSession, int idParticipant) {
        int group = 1;
        int i = 0;
        try {
            ResultSet resultSet = query("SELECT * FROM PARTICIPANT WHERE SESSION = '" + idSession + "'");
            while (resultSet.next()) {
                if (resultSet.getInt("IDPARTICIPANT") == idParticipant) {
                    return group;
                }
                i++;
                if (i == expecamille2.j.nbParticipantParGroup) {
                    group++;
                    i = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return group;
    }

    void ecritGain(int IDParticipant, double gainFinalEuro) {
     
         querySansRetour("UPDATE PARTICIPANT set GAINFINAL = '" + gainFinalEuro + "' WHERE IDPARTICIPANT = '" + IDParticipant + "';");
        
    }

}