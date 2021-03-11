/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expecamille2;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

/**
/**
 *
 * @author thevenet
 */
public class expecamille2 {

public static  Fenetre fenetre;
public static Jeu j;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, FileNotFoundException, InterruptedException {
    
 /*   try {
        
        expecamille2.fenetre = new Fenetre();
        expecamille2.fenetre.creatPart();
        expecamille2.fenetre.P1.uneDecision();
       
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(expecamille2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        Logger.getLogger(expecamille2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        Logger.getLogger(expecamille2.class.getName()).log(Level.SEVERE, null, ex);
    } catch (UnsupportedLookAndFeelException ex) {
        Logger.getLogger(expecamille2.class.getName()).log(Level.SEVERE, null, ex);
    }*/
    
    
     j = new Jeu();
           try {
            expecamille2.fenetre = new Fenetre();
            expecamille2.fenetre.creatPart();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, ex);

        }
        j.go();
    }
    
}
