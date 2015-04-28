/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
import BBDspéc.Malade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Etienne
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Malade obj) {
        if(find(obj.getNo_malade())!=null){
            JOptionPane.showMessageDialog(null, " Malade déjà existant merci d'en saisir un nouveau");
        return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("INSERT INTO malade (numero,nom,prenom,adresse,tel,mutuelle) "
                        + "VALUES('" + obj.getNo_malade()
                        + "','" + obj.getNom()        
                        + "','" + obj.getPrenom()
                        + "' , '" + obj.getAdresse()
                        + "' , '" + obj.getTel()
                        + "' , '" + obj.getMutuelle() +"')"
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        return true;
    }

    @Override
    public boolean delete(Malade obj) {
        if(find(obj.getNo_malade())==null){
            JOptionPane.showMessageDialog(null, " Malade non existant ou déja supprimé merci d'en saisir un nouveau");
        return false;
        }
        try {
           
           this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
           ).executeUpdate("DELETE FROM malade "
                   + "WHERE numero =" + obj.getNo_malade()
           );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Malade obj) {
       if(find(obj.getNo_malade())==null){
            JOptionPane.showMessageDialog(null, " Malade non existant merci d'en saisir un nouveau");
        return false;
       }
       try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("UPDATE malade SET nom='" + obj.getNom()
                    + "' , prenom='" + obj.getPrenom()
                    + "' , adresse='" + obj.getAdresse()
                    + "' , tel='" + obj.getTel()
                    + "' , mutuelle='" + obj.getMutuelle()
                    + "'" + " WHERE numero=" + obj.getNo_malade()
            );
            
            } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Malade find(Object id) {
        int no_malade = (int) id;
        Malade malade = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM malade "
                    + "WHERE malade.numero  = '" + no_malade + "'"
            );
            if (result.first()) {
                malade = new Malade(result.getInt("numero"), result.getString("mutuelle"), result.getString("nom"), result.getString("prenom"), result.getString("tel"), result.getString("adresse"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return malade;
    }

    @Override
    public Malade findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
