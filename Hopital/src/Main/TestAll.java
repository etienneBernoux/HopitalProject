/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BBDspéc.Batiment;
import BBDspéc.Chambre;
import BBDspéc.Docteur;
import BBDspéc.Employe;
import BBDspéc.Hospitalisation;
import BBDspéc.Infirmier;
import BBDspéc.Malade;
import BBDspéc.Service;
import BBDspéc.Soigne;
import Connection.ConnectionEce;
import DAO.BatimentDAO;
import DAO.ChambreDAO;
import DAO.DAO;
import DAO.DocteurDAO;
import DAO.EmployeDAO;
import DAO.HospitalisationDAO;
import DAO.InfirmierDAO;
import DAO.MaladeDAO;
import DAO.ServiceDAO;
import DAO.SoigneDAO;

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
        String[] id= new String[2];
        //Test de batiment
        DAO<Batiment> batDAO = new BatimentDAO(ConnectionEce.getConn());
        Batiment batiment = batDAO.find("A");
        System.out.println(batiment.toString());
        //Test de chambre
        
        id[0]="REA";
        id[1]="102";
        DAO<Chambre> chambreDAO = new ChambreDAO(ConnectionEce.getConn());
        Chambre chambre = chambreDAO.find(id);
        System.out.println(chambre.toString());
        //Test de docteur
        DAO<Docteur> docDAO = new DocteurDAO(ConnectionEce.getConn());
        Docteur docteur = docDAO.find(34);
        System.out.println(docteur.toString());
        //Test de employee
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        Employe employe = empDAO.find(10);
        System.out.println(employe.toString());
        //Test de hospitalisation
        id[0]="6";
        id[1]="103";
        DAO<Hospitalisation> hosDAO = new HospitalisationDAO(ConnectionEce.getConn());
        Hospitalisation hospitalisation = hosDAO.find(id);
        System.out.println(hospitalisation.toString());
        //Test de infirmier
        DAO<Infirmier> infDAO = new InfirmierDAO(ConnectionEce.getConn());
        Infirmier infirmier = infDAO.find(15);
        System.out.println(infirmier.toString());
        //Test de malade
        DAO<Malade> maladeDAO = new MaladeDAO(ConnectionEce.getConn());
        Malade malade = maladeDAO.find(1);
        System.out.println(malade.toString());
        //Test de Service
        DAO<Service> serviceDAO = new ServiceDAO(ConnectionEce.getConn());
        Service service = serviceDAO.find("REA");
        System.out.println(service.toString());
        //Test de Soigne
        id[0]="74";
        id[1]="80";
        DAO<Soigne> soigneDAO = new SoigneDAO(ConnectionEce.getConn());
        Soigne soigne = soigneDAO.find(id);
        System.out.println(soigne.toString());
    }
    
}
