/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BBDspéc.Chambre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Etienne
 */
public class ChambreDAO extends DAO<Chambre> {

    public ChambreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Chambre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id avec une clef de la forme string[2] chambre.code_service -
     * chambre.no_chambre
     * @return chambre complété
     */
    @Override
    public Chambre find(Object id) {
        String[] cle = (String[]) id;
        Chambre chambre = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT * FROM chambre "
                    + "WHERE chambre.code_service =  '" + cle[0] + "'"
                    + "AND chambre.no_chambre =  '" + cle[1] + "'"
            );
            if (result.first()) {
                chambre = new Chambre(result.getString("chambre.code_service"), result.getInt("no_chambre"), result.getInt("surveillant"), result.getInt("nb_lits"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chambre;
    }

    @Override
    public Chambre findall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
