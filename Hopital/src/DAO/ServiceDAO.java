/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
import BBDspéc.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Service obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Service obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Service findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
