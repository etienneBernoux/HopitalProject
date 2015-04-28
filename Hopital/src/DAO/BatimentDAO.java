/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
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
public class BatimentDAO extends DAO<Batiment> {

    public BatimentDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Batiment obj) {
        if(find(obj.getLettre())!=null){
            JOptionPane.showMessageDialog(null, " Batiment déjà existant merci d'en saisir un nouveau");
        return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("INSERT INTO batiment (lettre,nom) "
                        + "VALUES('" + obj.getLettre()
                        + "','" + obj.getNom() +"')"
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        return true;
    }

    @Override
    public boolean delete(Batiment obj) {
        if(find(obj.getLettre())==null){
            JOptionPane.showMessageDialog(null, " Batiment non existant ou déja supprimé merci d'en saisir un nouveau");
        return false;
        }
        try {
           
           this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
           ).executeUpdate("DELETE FROM batiment"
                   + "  where batiment.lettre ='" + obj.getLettre()+"'" );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Batiment obj) {
        if(find(obj.getLettre())==null){
            JOptionPane.showMessageDialog(null, " Batiment non existant ou déja supprimé merci d'en saisir un nouveau");
        return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(" UPDATE batiment"
                        + " SET batiment.nom='" + obj.getNom()+"'"
                        + " WHERE batiment.lettre ='" + obj.getLettre()+"'"
            );
            
            } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    }

    @Override
    public Batiment find(Object id) {
        String lettre = (String) id;
        Batiment batiment = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM batiment "
                    + "WHERE batiment.lettre  = '" + lettre + "'"
            );
            if (result.first()) {
                batiment = new Batiment(lettre, result.getString("nom"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return batiment;
    }

    @Override
    public Batiment findall() {
        return (null);
    }

}
