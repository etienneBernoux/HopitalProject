/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Soigne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etienne
 */
public class SoigneDAO extends DAO<Soigne> {

    public SoigneDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Soigne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Soigne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Soigne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id avec une clef de la forme string[2] no_malade - no_docteur
     * @return soigne complété
     */
    @Override
    public Soigne find(Object id) {
        Soigne soigne = null;
        String[] cle = (String[]) id;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM soigne "
                    + "WHERE soigne.no_malade =  " + cle[0]
                    + "AND soigne.no_docteur =  " + cle[1]
            );
            if (result.first()) {
                soigne = new Soigne(result.getInt("no_malade"),result.getInt("no_docteur"), result.getString("maladie"),result.getTimestamp("date_rdv"), result.getTimestamp("fin_rdv"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soigne;
    }

    @Override
    public Soigne findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
