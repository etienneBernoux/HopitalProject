/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Employe;
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
public class EmployeDAO extends DAO<Employe> {

    public EmployeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Employe obj) {
        if (find(obj.getNo_employe()) != null) {
            JOptionPane.showMessageDialog(null, " Employé déjà existant merci d'en saisir un nouveau");
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("INSERT INTO employe (numero,nom,prenom,adresse,tel) "
                    + "VALUES('" + obj.getNo_employe()
                    + "','" + obj.getNom()
                    + "','" + obj.getPrenom()
                    + "','" + obj.getAdresse()
                    + "','" + obj.getTel()
                    + "')"
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Employe obj) {
        if (find(obj.getNo_employe()) == null) {
            JOptionPane.showMessageDialog(null, " Employé non existant ou déja supprimé merci d'en saisir un nouveau");
            return false;
        }
        try {

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("DELETE FROM employe WHERE numero ='"
                    + obj.getNo_employe() + "'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Employe obj) {
        if (find(obj.getNo_employe()) == null) {
            JOptionPane.showMessageDialog(null, " Batiment non existant ou déja supprimé merci d'en saisir un nouveau");
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("UPDATE employe SET nom='" + obj.getNom()
                    + "' , prenom='" + obj.getPrenom()
                    + "' , adresse='" + obj.getAdresse()
                    + "' , tel='" + obj.getTel()
                    + "'" + " WHERE numero=" + obj.getNo_employe()
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Employe find(Object id) {
        int no_employe = (int) id;
        Employe employe = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM employe "
                    + "WHERE employe.numero =  '" + no_employe + "'"
            );
            if (result.first()) {
                employe = new Employe(result.getString("employe.nom"), result.getString("employe.prenom"), result.getString("employe.tel"), result.getString("employe.adresse"), no_employe);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employe;
    }

    @Override
    public Employe findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
