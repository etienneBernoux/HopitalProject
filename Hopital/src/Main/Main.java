package Main;


import BBDspéc.Employe;
import Connection.ConnectionEce;
import DAO.DAO;
import DAO.EmployeDAO;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Etienne
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //On lance la connection
        ConnectionEce connection = new ConnectionEce("ebernoux","J@hab16AR"," ebernoux-rw","erWVgk63");
        //connection.Selectiontest("SELECT code_service FROM chambre WHERE code_service='REA'");
        //connection.affichageresultconsole();
        TestAll test=new TestAll(connection);
        
        
        test.testFind();
        test.testCreate();
        test.testupdate();
        test.testdelete();
        //On ferme la connection
        connection.fermerConnection();
        System.exit(0);
             
    }
    
}
