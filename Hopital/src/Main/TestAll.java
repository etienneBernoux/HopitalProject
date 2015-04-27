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

/**
 *
 * @author Etienne
 */
public class TestAll {
    ConnectionEce connectionEce;

    public TestAll(ConnectionEce connectionEce) {
        this.connectionEce = connectionEce;
    }
    
    public void testFind(){
        //Test de batiment
        //Test de chambre
        //Test de docteur
        //Test de employee
        
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        Employe employe = empDAO.find("10");
        employe.toString();
        //Test de hospitalisation
        //Test de infirmier
        //Test de malade
        //Test de Service
        //Test de Soigne
    }
    
}
