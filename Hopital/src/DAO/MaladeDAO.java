/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Batiment;
import BBDspéc.Malade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etienne
 */
public class MaladeDAO extends DAO<Malade> {

    public MaladeDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Malade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Malade find(Object id) {
        String no_malade = (String) id;
        Malade malade = null;

        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM malade "
                    + "WHERE malade.numero  = " + no_malade
            );
            if (result.first()) {
                malade = new Malade(result.getInt("numero"), result.getString("mutuelle"), result.getString("nom"), result.getString("prenom"), result.getString("tel"), result.getString("adresse"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return malade;
    }

    @Override
    public Malade findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
