/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Employe;
import BBDspéc.Infirmier;
import BBDspéc.Service;
import Connection.ConnectionEce;
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
public class InfirmierDAO extends DAO<Infirmier> {

    public InfirmierDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Infirmier obj) {
        DAO<Service> service = new ServiceDAO(super.connect);
        if (service.find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service rentrée n'existe pas ");
            return false;
        }
        Employe employe = new Employe(obj.getNom(), obj.getPrenom(), obj.getTel(), obj.getAdresse(), obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test = empDAO.create(employe);
        if (!test) {
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("INSERT INTO infirmier   (numero,code_service,rotation,salaire) "
                    + "VALUES('" + obj.getNo_employe()
                    + "' , '" + obj.getCode_service()
                    + "' , '" + obj.getRotation()
                    + "' , '" + obj.getSalaire()
                    + "')"
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(Infirmier obj) {
        Employe employe = new Employe(obj.getNom(), obj.getPrenom(), obj.getTel(), obj.getAdresse(), obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test = empDAO.delete(employe);
        if (!test) {
            JOptionPane.showMessageDialog(null, "L'employé n'existe pas et n'a pas été supprimé");
            return false;
        }
        try {

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("DELETE FROM infirmier  "
                    + "WHERE numero =" + obj.getNo_employe()
            );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean update(Infirmier obj) {
        DAO<Service> service = new ServiceDAO(super.connect);
        if (service.find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service rentrée n'existe pas ");
            return false;
        }
        Employe employe = new Employe(obj.getNom(), obj.getPrenom(), obj.getTel(), obj.getAdresse(), obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test = empDAO.update(employe);
        if (!test) {
            JOptionPane.showMessageDialog(null, "erreur mise à jour infirmier(employé)");
            return false;
        }
        try {

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("UPDATE infirmier"
                    + " SET rotation='" + obj.getRotation()
                    + "' , code_service='" + obj.getCode_service()
                    + "' , salaire='" + obj.getSalaire()
                    + "'" + " WHERE numero=" + obj.getNo_employe()
            );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Infirmier find(Object id) {
        int no_infirmier = (int) id;
        Infirmier infirmier = null;
        DAO<Employe> empDAO = new EmployeDAO(super.connect);
        Employe employe = empDAO.find(id);
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM infirmier "
                    + "WHERE infirmier.numero = '" + no_infirmier + "'"
            );

            if (result.first()) {
                infirmier = new Infirmier(result.getString("code_service"), result.getString("rotation"), result.getDouble("salaire"), employe.getNom(), employe.getPrenom(), employe.getTel(), employe.getAdresse(), no_infirmier);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (infirmier);
    }

    @Override
    public Infirmier findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
