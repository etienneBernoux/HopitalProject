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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Employe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Employe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
