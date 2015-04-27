/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etienne
 */
public class BatimentDAO extends DAO<Batiment> {

    public BatimentDAO(Connection conn) {
        super(conn);
    }
@Override
    public boolean create(Batiment obj) {
        return false;
    }
@Override
    public boolean delete(Batiment obj) {
        return false;
    }
@Override
    public boolean update(Batiment obj) {
        return false;
    }

    public Batiment find(Object id) {
        String Nom =(String)id;
        Batiment batiment = new Batiment();

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM batiment "
                    + "LEFT JOIN service ON batiment.nom = service.batiment "
                    + "WHERE batiment.nom  = " + Nom
            );
            if (result.first()) {
                batiment = new Batiment(Nom);
                result.beforeFirst();
                ServiceDAO serviceDao = new ServiceDAO(this.connect);

                while (result.next()) {
                    batiment.addService(serviceDao.find(result.getInt("batiment")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batiment;
    }
@Override
    public Batiment findall() {
        return (null);
    }

}
