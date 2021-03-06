/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Chambre;
import BBDspéc.Docteur;
import BBDspéc.Employe;
import Connection.ConnectionEce;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getAdresse(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.create(employe);
        if(!test){
            JOptionPane.showMessageDialog(null, "L'employé existe déja");
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
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Docteur obj) {
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getAdresse(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.delete(employe);
        if(!test){
            JOptionPane.showMessageDialog(null, "L'employé n'existe pas et n'a pas été supprimé");
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
            return false;
        }
        return true; 
    }

    @Override
    public boolean update(Docteur obj) {
        Employe employe = new Employe(obj.getNom(),obj.getPrenom(),obj.getTel(),obj.getAdresse(),obj.getNo_employe());
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        boolean test=empDAO.update(employe);
        if(!test){
            JOptionPane.showMessageDialog(null, "erreur employé");
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
            return false;
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
    public ArrayList<Docteur> findall() {
        ArrayList<Docteur> list= new ArrayList<>();
        DAO<Employe> empDAO = new EmployeDAO(super.connect);
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM docteur ORDER BY numero"  
            );
            if (result.first()) {
                Employe employe = empDAO.find(result.getInt("numero"));
                list.add(new Docteur(employe.getNom(), employe.getPrenom(), employe.getTel(), employe.getAdresse(), result.getInt("numero"), result.getString("specialite")));
                while(result.next()){
                    employe = empDAO.find(result.getInt("numero"));
                    list.add(new Docteur(employe.getNom(), employe.getPrenom(), employe.getTel(), employe.getAdresse(), result.getInt("numero"), result.getString("specialite")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list);
    }
}
