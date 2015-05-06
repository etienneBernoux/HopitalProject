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
    
    public ArrayList<ArrayList> Requete4() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT DISTINCT hospitalisation.lit, chambre.no_chambre, malade.nom, malade.prenom, malade.mutuelle" +
                            " FROM batiment, service, chambre, hospitalisation, malade" +
                            " WHERE hospitalisation.no_chambre = chambre.no_chambre " +
                            " AND chambre.code_service = service.code " +
                            " AND batiment.lettre = service.batiment " +
                            " AND hospitalisation.no_malade = malade.numero" +
                            " AND malade.mutuelle LIKE 'MN%'" +
                            " AND batiment.lettre = 'B' "
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete5() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT DISTINCT service.code, AVG( infirmier.salaire ) " +
                            " FROM service, infirmier" +
                            " WHERE service.code = infirmier.code_service" +
                            " GROUP BY code_service" +
                            " LIMIT 0 , 100"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete6() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT DISTINCT service.code, AVG(chambre.nb_lits)" +
                            " FROM service, batiment, chambre" +
                            " WHERE service.batiment = 'A' " +
                            " AND service.code = chambre.code_service" +
                            " GROUP BY code_service "
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete7() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT malade.prenom, malade.nom,COUNT(docteur.numero) AS NB_soignant, COUNT(DISTINCT docteur.specialite) AS Nb_specialite" +
" FROM malade JOIN soigne ON malade.numero = soigne.no_malade JOIN docteur ON soigne.no_docteur = docteur.numero" +
" GROUP BY malade.numero" +
" HAVING COUNT(docteur.numero)>=3"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete8() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT A.nom," +
                            " (SELECT COUNT(infirmier.rotation) " +
                            " FROM infirmier,service " +
                            " WHERE infirmier.code_service=service.code " +
                            " AND A.code = infirmier.code_service)/" +
                            " (SELECT COUNT(malade.nom) " +
                            " FROM hospitalisation,malade " +
                            " WHERE  malade.numero = hospitalisation.no_malade " +
                            " AND hospitalisation.code_service = A.code) AS NB_AVG-lit" +
                            " FROM service A"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete9() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT  employe.nom, employe.prenom, employe.numero" +
                            " FROM docteur,employe" +
                            " WHERE docteur.numero = employe.numero" +
                            " AND employe.numero IN (SELECT DISTINCT soigne.no_docteur FROM soigne)" +
                            " ORDER BY employe.nom ASC"
            );
            res=Fabrique(result);

        } catch (SQLException ex) {
            Logger.getLogger(MaladeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }
    public ArrayList<ArrayList> Requete10() {
        ArrayList<ArrayList> res = null;
        try {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            ).executeQuery("SELECT DISTINCT employe.nom, employe.Prenom" +
" FROM docteur JOIN employe ON docteur.numero = employe.numero JOIN soigne ON soigne.no_docteur = docteur.numero JOIN malade ON malade.numero = soigne.no_malade JOIN hospitalisation " +
" WHERE docteur.numero NOT IN (SELECT soigne.no_docteur FROM hospitalisation JOIN malade ON hospitalisation.no_malade = malade.numero JOIN soigne ON malade.numero = soigne.no_malade)" +
" ORDER BY employe.nom DESC"
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
