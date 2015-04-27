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
        String lettre =(String)id;
        Batiment batiment = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM batiment "
                    + "WHERE batiment.nom  = " + lettre
            );
            if (result.first()) {
                batiment = new Batiment(lettre,result.getString("nom"));
 
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
