/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Hospitalisation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etienne
 */
public class HospitalisationDAO extends DAO<Hospitalisation> {

    public HospitalisationDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Hospitalisation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id avec une clef de la forme string[2] hospitalisation.no_malade -
     * hospitalisation.no_chambre
     * @return hospitalisation complété
     */
    public Hospitalisation find(Object id) {
        Hospitalisation hospitalisation = null;
        String[] cle = (String[]) id;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM hospitalisation "
                    + "WHERE hospitalisation.no_malade =  '" + cle[0] + "'"
                    + "AND hospitalisation.no_chambre =  '" + cle[1] + "'"
            );
            if (result.first()) {
                hospitalisation = new Hospitalisation(result.getInt("no_malade"), result.getString("code_service"), result.getInt("no_chambre"), result.getInt("lit"), result.getTimestamp("date_debut"), result.getTimestamp("date_fin"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitalisation;
    }

    @Override
    public Hospitalisation findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
