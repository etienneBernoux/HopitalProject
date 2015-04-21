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

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

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
            conn = DriverManager.getConnection(urlDatabase,user,passwd);

            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();
            
            System.out.println("Connexion effective !");
        }

    }
}
