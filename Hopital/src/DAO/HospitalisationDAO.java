/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Chambre;
import BBDspéc.Hospitalisation;
import BBDspéc.Malade;
import BBDspéc.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class HospitalisationDAO extends DAO<Hospitalisation> {

    public HospitalisationDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Hospitalisation obj) {
        DAO<Malade> maladeDAO = new MaladeDAO(super.connect);
        DAO<Chambre> chambreDAO = new ChambreDAO(super.connect);
        String[] id = new String[2];
        id[0] = obj.getCode_service();
        id[1] = Integer.toString(obj.getNum_chambre());

        Chambre chambre = chambreDAO.find(id);
        Hospitalisation hospitalisation = find(obj.getNum_malade());
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM hospitalisation "
                    + "WHERE lit=" + obj.getNo_lit()
                    + " AND  no_chambre=" + obj.getNum_chambre());
            if (maladeDAO.find(obj.getNum_malade()) == null) {
                JOptionPane.showMessageDialog(null, "Le malade n'existe pas");
                return false;
            } else if (!chambre.getCode_service().equals(obj.getCode_service())) {
                JOptionPane.showMessageDialog(null, "La chambre indiqué n'est pas dans le service indiqué");
                return false;
            } else if (find(obj.getNum_malade()) != null) {
                JOptionPane.showMessageDialog(null, "Le malade est deja hospitalisé");
                return false;
            } else if (obj.getNo_lit() > chambre.getNb_lits()) {
                JOptionPane.showMessageDialog(null, "Il n'y a pas autant de lit");
                return false;
            } else if (result.first()) {
                JOptionPane.showMessageDialog(null, "Lit deja utilisé ! ");
                return false;
            } else {

                this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("INSERT INTO hospitalisation (no_malade,code_service,no_chambre,lit) "
                        + " VALUES('" + obj.getNum_malade()
                        + "','" + obj.getCode_service()
                        + "','" + obj.getNum_chambre()
                        + "' , '" + obj.getNo_lit()+"')"
                );
            }
        } catch (SQLException ex) {

            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
        return true;
    }

    @Override
    public boolean delete(Hospitalisation obj) {
        if (find(obj.getNum_malade()) == null) {
            JOptionPane.showMessageDialog(null, "Le malade n'est pas hospitalisé");
            return false;
        }
        try {

            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate("DELETE FROM hospitalisation WHERE no_malade ='"
                    + obj.getNum_malade() + "'"
            );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Hospitalisation obj) {
        DAO<Malade> maladeDAO = new MaladeDAO(super.connect);
        DAO<Chambre> chambreDAO = new ChambreDAO(super.connect);
        String[] id = new String[2];
        id[0] = obj.getCode_service();
        id[1] = Integer.toString(obj.getNum_chambre());

        Chambre chambre = chambreDAO.find(id);
        Hospitalisation hospitalisation = find(obj.getNum_malade());
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM hospitalisation "
                    + "WHERE lit=" + obj.getNo_lit()
                    + " AND  code_service='" + obj.getCode_service()+"'"
                    + " AND  no_chambre=" + obj.getNum_chambre()
                    + " AND  no_malade!=" + obj.getNum_malade()
            );
            if (maladeDAO.find(obj.getNum_malade()) == null) {
                JOptionPane.showMessageDialog(null, "Le malade n'existe pas");
                return false;
            } else if (!chambre.getCode_service().equals(obj.getCode_service())) {
                JOptionPane.showMessageDialog(null, "La chambre indiqué n'est pas dans le service indiqué");
                return false;
            } else if (find(obj.getNum_malade()) == null) {
                JOptionPane.showMessageDialog(null, "L'hospitalisation désigné n'éxiste pas");
                return false;
            } else if (obj.getNo_lit() > chambre.getNb_lits()) {
                JOptionPane.showMessageDialog(null, "Il n'y a pas autant de lit");
                return false;
            } else if (result.first()) {
                JOptionPane.showMessageDialog(null, "Lit deja utilisé ! ");
                return false;
            } else {

                this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                ).executeUpdate("UPDATE hospitalisation SET code_service='" +obj.getCode_service()
                        +"' , no_chambre='"+ obj.getNum_chambre() 
                        +"' , lit='"+ obj.getNo_lit()+"'" 
                        +   " WHERE no_malade='"+obj.getNum_malade()+"'"
                );
            }
        } catch (SQLException ex) {

            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
        return true;
    }

    /**
     *
     * @param id avec une clef de la forme string[2] hospitalisation.no_malade -
     * hospitalisation.no_chambre
     * @return hospitalisation complété
     */
    public Hospitalisation find(Object id) {
        Hospitalisation hospitalisation = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM hospitalisation "
                    + "WHERE hospitalisation.no_malade =  '" + id + "'"
            );
            if (result.first()) {
                hospitalisation = new Hospitalisation(result.getInt("no_malade"), result.getString("code_service"), result.getInt("no_chambre"), result.getInt("lit"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalisation;
    }

    @Override
    public ArrayList<Hospitalisation> findall() {
        ArrayList<Hospitalisation> list= new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM hospitalisation"  
            );
            if (result.first()) {
                list.add(new Hospitalisation(result.getInt("no_malade"), result.getString("code_service"), result.getInt("no_chambre"), result.getInt("lit")));
                while(result.next()){
                    list.add(new Hospitalisation(result.getInt("no_malade"), result.getString("code_service"), result.getInt("no_chambre"), result.getInt("lit")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list);
    }

}
