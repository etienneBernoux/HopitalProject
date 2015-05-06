/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Etienne
 */
public class ConnectionEce {
    
    ///Attribut lié à la connection
    private static Connection conn;//connexion JDBC
    private static Statement stmt;//Statement
    
    private ResultSet rset;//ordre requete
    private ResultSetMetaData rsetMeta;//resultat requete
    
    ///Attribut de test
    private boolean etat;
    private boolean requeteactive;
    
    public ConnectionEce(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase){
        
    
        try {

            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Ok !");

            // Connexion via le tunnel SSH avec le username et le password ECE
            SSHTunnel ssh = new SSHTunnel("ebernoux", "J@hab16AR");

            if (ssh.connect()) {
                this.etat=true;
                System.out.println("Connexion reussie");
                // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
                String urlDatabase = "jdbc:mysql://localhost:3305/" + "ebernoux";
                String user = "ebernoux-rw";
                String passwd = "erWVgk63";

                //création d'une connexion JDBC à la base
                ConnectionEce.conn = DriverManager.getConnection(urlDatabase, user, passwd);
                
                System.out.println("Connexion fonctionel !");
                this.requeteactive=false;
            }
            else {
                etat=false;
                System.out.println("Erreur de connection");
            }
        
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("erreur de connection");
        }
    }
    public void Selectiontest (String requete) throws SQLException{
        // création d'un ordre SQL (statement)
                ConnectionEce.stmt = ConnectionEce.conn.createStatement();
                
                //L'objet ResultSet contient le résultat de la requête SQL
                this.rset = ConnectionEce.stmt.executeQuery(requete);
                //On récupère les MetaData
                this.rsetMeta =this.rset.getMetaData();
                this.requeteactive=true;
    }
    public void affichageresultconsole() throws SQLException{
        if (!this.requeteactive)
        {
            System.out.println("Pas de requète active");
            return;
        }
        System.out.println("\n**********************************");
                //On affiche le nom des colonnes
                for (int i = 1; i <= this.rsetMeta.getColumnCount(); i++) {
                    System.out.print("\t" + this.rsetMeta.getColumnName(i).toUpperCase() + "\t *");
                }

                System.out.println("\n**********************************");

                while (this.rset.next()) {
                    for (int i = 1; i <= this.rsetMeta.getColumnCount(); i++) {
                        System.out.print("\t" +this.rset.getObject(i).toString() + "\t |");
                    }

                    System.out.println("\n---------------------------------");

                }

                this.rset.close();
                this.stmt.close();
    
    }
    public void fermerConnection() throws SQLException{
        this.conn.close();
        System.out.println("connection fermé");
    }
    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection aConn) {
        conn = aConn;
    }

    public static Statement getStmt() {
        return stmt;
    }

    public static void setStmt(Statement aStmt) {
        stmt = aStmt;
    }

    public ResultSet getRset() {
        return rset;
    }

    public void setRset(ResultSet rset) {
        this.rset = rset;
    }

    public ResultSetMetaData getRsetMeta() {
        return rsetMeta;
    }

    public void setRsetMeta(ResultSetMetaData rsetMeta) {
        this.rsetMeta = rsetMeta;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public boolean isRequeteactive() {
        return requeteactive;
    }

    public void setRequeteactive(boolean requeteactive) {
        this.requeteactive = requeteactive;
    }
}

