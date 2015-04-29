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

    public ArrayList<ArrayList> Requete1() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT malade.prenom,malade.nom "
                    + " FROM malade"
                    + " WHERE malade.mutuelle = 'MAAF'"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    
    public ArrayList<ArrayList> Requete2() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT employe.prenom,employe.nom "
                    + " FROM infirmier NATURAL JOIN employe"
                    + " WHERE infirmier.rotation = 'NUIT'"
                    + " ORDER BY employe.nom"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    
    public ArrayList<ArrayList> Requete3() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT service.nom,service.batiment,employe.prenom,employe.nom,docteur.specialite"
                    + " FROM docteur NATURAL JOIN employe INNER JOIN service ON service.directeur=docteur.numero"
                    + " ORDER BY service.nom"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public ArrayList<ArrayList> Fabrique(ResultSet result) {
        ArrayList<ArrayList> res = new ArrayList();
        try {
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();
            ArrayList titre = new ArrayList();
            for (int i = 1; i < resultMeta.getColumnCount()+1; i++) {
                titre.add(resultMeta.getColumnName(i).toUpperCase());
            }
            res.add(titre);
            while (result.next()) {
                ArrayList element = new ArrayList();
                for (int i = 1; i < resultMeta.getColumnCount()+1; i++) {
                    element.add(result.getObject(i).toString());
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
