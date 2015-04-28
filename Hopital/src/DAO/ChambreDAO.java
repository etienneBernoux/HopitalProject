/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Chambre;
import BBDspéc.Hospitalisation;
import BBDspéc.Infirmier;
import BBDspéc.Service;
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
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Chambre obj) {
        DAO<Infirmier> infirmier = new InfirmierDAO(super.connect);
        DAO<Service> service = new ServiceDAO(super.connect);
        String[] cle = new String[2];
        cle[0] = obj.getCode_service();
        cle[1] = Integer.toString(obj.getNo_chambre());

        if (find(cle) != null) {
            JOptionPane.showMessageDialog(null, " Chambre déjà existante merci d'en saisir une nouvelle");
            return false;
        } else if (infirmier.find(obj.getSurveillant()) == null) {
            JOptionPane.showMessageDialog(null, "L'infirmier rentré n'existe pas");
            return false;
        } else if (service.find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service rentrée n'existe pas ");
            return false;
        } else {
            try {
                this.connect.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE
                ).executeUpdate(
                        "INSERT INTO chambre (code_service,no_chambre,surveillant,nb_lits) "
                        + "VALUES('" + obj.getCode_service()+ "'"
                        + ",'" + obj.getNo_chambre()+ "'"
                        + ",'" + obj.getSurveillant()+ "'"
                        + ",'" + obj.getNb_lits()+ "')"
                );
            } catch (SQLException ex) {
                Logger.getLogger(ChambreDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    @Override
    public boolean delete(Chambre obj) {
        String[] cle = new String[2];
        cle[0] = obj.getCode_service();
        cle[1] = Integer.toString(obj.getNo_chambre());
        if (find(cle) == null) {
            JOptionPane.showMessageDialog(null, " Chambre non existante merci d'en saisir une nouvelle");
            return false;   
        }
        try {
           
           this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
           ).executeUpdate("DELETE FROM chambre"
                   + "  WHERE chambre.code_service ='" + obj.getCode_service()+"'" 
                   + "  AND chambre.no_chambre ='" + obj.getNo_chambre()+"'" 
           
           );
        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;

    }

    @Override
    public boolean update(Chambre obj) {
        DAO<Infirmier> infirmier = new InfirmierDAO(super.connect);
        DAO<Service> service = new ServiceDAO(super.connect);
        String[] cle = new String[2];
        cle[0] = obj.getCode_service();
        cle[1] = Integer.toString(obj.getNo_chambre());
        if (find(cle) == null) {
            JOptionPane.showMessageDialog(null, " Chambre non existante merci d'en saisir une nouvelle");
            return false;
        } else if (infirmier.find(obj.getSurveillant()) == null) {
            JOptionPane.showMessageDialog(null, "L'infirmier rentré n'existe pas");
            return false;
        } else if (service.find(obj.getCode_service()) == null) {
            JOptionPane.showMessageDialog(null, "Le service rentrée n'existe pas ");
            return false;
        }
        try {
            this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            ).executeUpdate(" UPDATE chambre"
                        + " SET chambre.surveillant='" + obj.getSurveillant()+"'"
                        + " ,chambre.nb_lits='" + obj.getNb_lits()+"'"
                        + " WHERE chambre.code_service ='" + obj.getCode_service()+"'"
                        + " AND chambre.no_chambre ='" + obj.getNo_chambre()+"'"
            );
            
            } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
        
    }

    /**
     *
     * @param id avec une clef de la forme string[2] chambre.code_service -
     * chambre.no_chambre
     * @return chambre complété
     */
    @Override
    public Chambre find(Object id) {
        String[] cle = (String[]) id;
        Chambre chambre = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM chambre "
                    + "WHERE chambre.code_service =  '" + cle[0] + "'"
                    + "AND chambre.no_chambre =  '" + cle[1] + "'"
            );
            if (result.first()) {
                chambre = new Chambre(result.getString("chambre.code_service"), result.getInt("no_chambre"), result.getInt("surveillant"), result.getInt("nb_lits"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chambre;
    }

    @Override
    public Chambre findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
