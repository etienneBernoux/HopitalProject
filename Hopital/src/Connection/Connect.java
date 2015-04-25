/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Etienne
 */
//CTRL + SHIFT + O pour générer les imports
public class Connect {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private static Connection conn;
    private static Statement stmt;
  

    public static void main(String[] args) {

        try {

            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Ok !");

            // Connexion via le tunnel SSH avec le username et le password ECE
            SSHTunnel ssh = new SSHTunnel("ebernoux", "J@hab16AR");

            if (ssh.connect()) {
                System.out.println("Connexion reussie");
                // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
                String urlDatabase = "jdbc:mysql://localhost:3305/" + "ebernoux";
                String user = "ebernoux-rw";
                String passwd = "erWVgk63";

                //création d'une connexion JDBC à la base
                conn = DriverManager.getConnection(urlDatabase, user, passwd);
                
                System.out.println("Connexion fonctionel !");

                // création d'un ordre SQL (statement)
                stmt = conn.createStatement();

                
                String requete = "SELECT * FROM chambre";
                //L'objet ResultSet contient le résultat de la requête SQL
                ResultSet result = stmt.executeQuery(requete);
                //On récupère les MetaData
                ResultSetMetaData resultMeta = result.getMetaData();

                System.out.println("\n**********************************");
                //On affiche le nom des colonnes
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
                }

                System.out.println("\n**********************************");

                while (result.next()) {
                    for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                        System.out.print("\t" + result.getObject(i).toString() + "\t |");
                    }

                    System.out.println("\n---------------------------------");

                }

                result.close();
                stmt.close();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("erreur de connection");
        }

    }
}
