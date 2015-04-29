/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Etienne
 */
public class Requete {

    private Connection connect = null;

    public Requete(Connection connect) {
        this.connect = connect;
    }

    public ArrayList Requete1() {
        ArrayList res = new ArrayList();
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT malade.nom , malade.prenom "
                    + "FROM malade"
                    + "WHERE malade.mutuelle = 'MAAF'"
            );
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();
            String[] titre = new String[resultMeta.getColumnCount()];
            for (int i = 0; i < resultMeta.getColumnCount(); i++) {
                titre[i] = resultMeta.getCatalogName(i);
            }
            res.add(titre);
            while (result.next()) {
                String[] element = new String[resultMeta.getColumnCount()];
                for (int i = 0; i < resultMeta.getColumnCount(); i++) {
                    element[i] = result.getNString(i);
                }
                res.add(element);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

}
