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

    public Service find(Object id) {
        String Code =(String)id;
        Service service = new Service();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM service "
                    + "LEFT JOIN docteur ON service.directeur = docteur.no "
                    + "LEFT JOIN employee ON employee.no = docteur.no "
                    + "WHERE batiment.nom  = " + Code
            );
            if (result.first()) {
                result.beforeFirst();
                DocteurDAO docteurDao = new DocteurDAO(this.connect);
                
                service = new Service(Code,result.getString("service.nom"),docteurDao.find(result.getInt("directeur"))
                        
                );
                result.beforeFirst();
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
