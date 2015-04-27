/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Docteur;
import BBDspéc.Employe;
import BBDspéc.Infirmier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Infirmier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Infirmier obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
