/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
import BBDspéc.Chambre;
import BBDspéc.Docteur;
import BBDspéc.Service;
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
public class ServiceDAO extends DAO<Service> {

    public ServiceDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Service obj) {
        DAO<Docteur> docteurDAO = new DocteurDAO(super.connect);
        DAO<Batiment> batimentDAO = new BatimentDAO(super.connect);
        if (docteurDAO.find(obj.getDirecteur()) == null) {
            JOptionPane.showMessageDialog(null, "Le docteur rentré n'existe pas");
            return false;
        } else if (batimentDAO.find(obj.getBatiment()) == null) {
            JOptionPane.showMessageDialog(null, "Le batiment rentré n'existe pas");
            return false;
        } else if (find(obj.getCode_service()) != null) {
            JOptionPane.showMessageDialog(null, "Le service existe déja");
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "INSERT INTO service (code,nom,batiment,directeur) "
                    + "VALUES('" + obj.getCode_service()
                    + "','" + obj.getNom()
                    + "','" + obj.getBatiment()
                    + "' , '" + obj.getDirecteur()
                    + "')"
            );
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public boolean delete(Service obj) {
        if (find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service n'existe pas, il ne peut pas être suprimé");
            return false;
        }
        try {

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("DELETE FROM service "
                    + "WHERE code ='" + obj.getCode_service() + "'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Service obj) {
        DAO<Docteur> docteurDAO = new DocteurDAO(super.connect);
        DAO<Batiment> batimentDAO = new BatimentDAO(super.connect);
        if (docteurDAO.find(obj.getDirecteur()) == null) {
            JOptionPane.showMessageDialog(null, "Le docteur rentré n'existe pas");
            return false;
        } else if (batimentDAO.find(obj.getBatiment()) == null) {
            JOptionPane.showMessageDialog(null, "Le batiment rentré n'existe pas");
            return false;
        } else if (find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service n'existe pas");
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(
                    "UPDATE service SET nom = '" + obj.getNom()
                    + "' , batiment='" + obj.getBatiment()
                    + "' , directeur='" + obj.getDirecteur()
                    + "'" + " WHERE code ='" + obj.getCode_service() + "'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    @Override
    public Service find(Object id) {
        String code = (String) id;
        Service service = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM service "
                    + "WHERE service.code  = '" + code + "'"
            );
            if (result.first()) {
                service = new Service(code, result.getString("service.nom"), result.getString("service.batiment"), result.getInt("directeur")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public ArrayList<Service> findall() {
        ArrayList<Service> list= new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM service"  
            );
            if (result.first()) {
                list.add(new Service(result.getString("code"), result.getString("service.nom"), result.getString("service.batiment"), result.getInt("directeur")));
                while(result.next()){
                    list.add(new Service(result.getString("code"), result.getString("service.nom"), result.getString("service.batiment"), result.getInt("directeur")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list);
    }
}
