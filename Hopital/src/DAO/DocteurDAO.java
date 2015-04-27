/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Docteur;
import BBDspéc.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Docteur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
