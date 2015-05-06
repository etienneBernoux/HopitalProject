/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import BBDspéc.Employe;
import Connection.ConnectionEce;
import DAO.DAO;
import DAO.EmployeDAO;
import java.sql.SQLException;
/**
 *
 * @author travail
 */
public class SecondMain {

    public SecondMain(String id1, String mdp1, String id2, String mdp2) throws SQLException
    {
            // TODO code application logic here
            //On lance la connection
            ConnectionEce connection = new ConnectionEce(id1,mdp1,id2,mdp2);
            //connection.Selectiontest("SELECT code_service FROM chambre WHERE code_service='REA'");
            //connection.affichageresultconsole();
            TestAll test=new TestAll(connection);

            test.testFind();
            test.testFindall();
            test.testCreate();
            test.testupdate();
            test.testdelete();
            //On ferme la connection
            connection.fermerConnection();
            //System.exit(0);

        }
    
}
