/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Docteur;
import BBDspéc.Employe;
import Connection.ConnectionEce;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Etienne
 */
public class DocteurDAO extends DAO<Docteur> {

    public DocteurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Docteur obj) {
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getTel(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.create(employe);
        if(!test){
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("INSERT INTO docteur (numero,specialite) "
                        + "VALUES('" + obj.getNo_employe()
                        + "','" + obj.getSpecialite()
                        + "')"
            );

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(Docteur obj) {
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getTel(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.delete(employe);
        if(!test){
            return false;
        }
        try {
           
           this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
           ).executeUpdate("DELETE FROM docteur WHERE numero ='" 
                   + obj.getNo_employe()+"'"
           );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true; 
    }

    @Override
    public boolean update(Docteur obj) {
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getTel(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.update(employe);
        if(!test){
            return false;
        }
        try {
           
           this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
           ).executeUpdate("UPDATE docteur SET specialite='" + obj.getSpecialite() 
                   + "'" 
                   + " WHERE numero=" + obj.getNo_employe()
           );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public Docteur find(Object id) {
        int no_docteur = (int) id;
        Docteur docteur = null;
        DAO<Employe> empDAO = new EmployeDAO(super.connect);
        Employe employe = empDAO.find(id);
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM docteur "
                    + "WHERE docteur.numero = '" + no_docteur + "'"
            );

            if (result.first()) {
                docteur = new Docteur(employe.getNom(), employe.getPrenom(), employe.getTel(), employe.getAdresse(), no_docteur, result.getString("specialite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (docteur);
    }

    @Override
    public Docteur findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
