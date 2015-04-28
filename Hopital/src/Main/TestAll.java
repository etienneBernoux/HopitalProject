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

    public void testFind() {
        String[] id = new String[2];
        //Test de batiment
        DAO<Batiment> batDAO = new BatimentDAO(ConnectionEce.getConn());
        Batiment batiment = batDAO.find("A");
        System.out.println(batiment.toString());
        //Test de chambre

        id[0] = "REA";
        id[1] = "102";
        DAO<Chambre> chambreDAO = new ChambreDAO(ConnectionEce.getConn());
        Chambre chambre = chambreDAO.find(id);
        System.out.println(chambre.toString());
        //Test de docteur
        DAO<Docteur> docDAO = new DocteurDAO(ConnectionEce.getConn());
        Docteur docteur = docDAO.find(34);
        System.out.println(docteur.toString());
        //Test de employe
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        Employe employe = empDAO.find(10);
        System.out.println(employe.toString());
        //Test de hospitalisation
        DAO<Hospitalisation> hosDAO = new HospitalisationDAO(ConnectionEce.getConn());
        Hospitalisation hospitalisation = hosDAO.find(6);
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
        id[0] = "74";
        id[1] = "80";
        DAO<Soigne> soigneDAO = new SoigneDAO(ConnectionEce.getConn());
        Soigne soigne = soigneDAO.find(id);
        System.out.println(soigne.toString());
    }

    public void testCreate() {
        Boolean test;

        //Test de batiment
        Batiment batiment = new Batiment("C", "Alexis Carrel");
        DAO<Batiment> batDAO = new BatimentDAO(ConnectionEce.getConn());
        test = batDAO.create(batiment);
        if (test) {
            System.out.println("Création de " + batiment.toString());
        }
        //Test de chambre
        Chambre chambre = new Chambre("REA", 109, 22, 2);
        DAO<Chambre> chambreDAO = new ChambreDAO(ConnectionEce.getConn());
        test = chambreDAO.create(chambre);
        if (test) {
            System.out.println("Création de " + chambre.toString());
        }
        //Test de docteur
        Docteur docteur = new Docteur("Safin1", "Marat1", "01 06 70 38 91", "61 rue Fermee, 78430 Louveciennes1", 20, "Cardiologue");
        DAO<Docteur> docDAO = new DocteurDAO(ConnectionEce.getConn());
        test = docDAO.create(docteur);
        if (test) {
            System.out.println("Création de " + docteur.toString());
        }
        //Test de employe
        Employe employe = new Employe("Nadal1", "Rafael1", "01 29 71 13 76", "18 place Bellegarde 78990 Elancourt", 3);
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        test = empDAO.create(employe);
        if (test) {
            System.out.println("Création de " + employe.toString());
        }
        //Test de hospitalisation
        DAO<Hospitalisation> hosDAO = new HospitalisationDAO(ConnectionEce.getConn());
        Hospitalisation hospitalisation = new Hospitalisation(13, "CAR", 101, 2);
        test = hosDAO.create(hospitalisation);
        if (test) {
            System.out.println("Création de " + hospitalisation.toString());
        }
        //Test de infirmier
        Infirmier infirmier = new Infirmier("CAR", "NUIT", 1536.28, "Potter", "Harry", "01 04 70 01 68", "56 rue des Muletiers, 78660 Ablis", 74);
        DAO<Infirmier> infDAO = new InfirmierDAO(ConnectionEce.getConn());
        test = infDAO.create(infirmier);
        if (test) {
            System.out.println("Création de " + infirmier.toString());
        }
        //Test de malade
        Malade malade = new Malade(193, "MAAF", "Luczakp", "Louane", "01 96 37 45 73", "39 rue Manuel, 78000 Versailles");
        DAO<Malade> maladeDAO = new MaladeDAO(ConnectionEce.getConn());
        test = maladeDAO.create(malade);
        if (test) {
            System.out.println("Création de " + malade.toString());
        }
        //Test de Service
        Service service = new Service("PAL", "Soin Paliatif", "B", 140);
        DAO<Service> serviceDAO = new ServiceDAO(ConnectionEce.getConn());
        test = serviceDAO.create(service);
        if (test) {
            System.out.println("Création de " + service.toString());
        }

    }

    public void testdelete() {
        Boolean test;
        //Test de batiment
        Batiment batiment = new Batiment("C", null);
        DAO<Batiment> batDAO = new BatimentDAO(ConnectionEce.getConn());
        test = batDAO.delete(batiment);
        if (test) {
            System.out.println("Supression de " + batiment.toString());
        }
        //Test de chambre
        Chambre chambre = new Chambre("REA", 109, 0, 0);
        DAO<Chambre> chambreDAO = new ChambreDAO(ConnectionEce.getConn());
        test = chambreDAO.delete(chambre);
        if (test) {
            System.out.println("Supression de " + chambre.toString());
        }
        //Test de docteur
        Docteur docteur = new Docteur(null, null, null, null, 20, null);
        DAO<Docteur> docDAO = new DocteurDAO(ConnectionEce.getConn());
        test = docDAO.delete(docteur);
        if (test) {
            System.out.println("Supression de " + docteur.toString());
        }
        //Test de employe
        Employe employe = new Employe(null, null, null, null, 3);
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        test = empDAO.delete(employe);
        if (test) {
            System.out.println("Supression de " + employe.toString());
        }
        //Test de hospitalisation
        Hospitalisation hospitalisation = new Hospitalisation(13, null, 0, 0);
        DAO<Hospitalisation> hosDAO = new HospitalisationDAO(ConnectionEce.getConn());
        test = hosDAO.delete(hospitalisation);
        if (test) {
            System.out.println("Supression de " + hospitalisation.toString());
        }
        //Test de infirmier
        Infirmier infirmier = new Infirmier(null, null, 0, null, null, null, null, 74);
        DAO<Infirmier> infDAO = new InfirmierDAO(ConnectionEce.getConn());
        test = infDAO.delete(infirmier);
        if (test) {
            System.out.println("Supression de " + infirmier.toString());
        }
        //Test de malade
        Malade malade = new Malade(193, null, null, null, null, null);
        DAO<Malade> maladeDAO = new MaladeDAO(ConnectionEce.getConn());
        test = maladeDAO.delete(malade);
        if (test) {
            System.out.println("Supression de " + malade.toString());
        }
        //Test de Service
        Service service = new Service("PAL", null, null, 0);
        DAO<Service> serviceDAO = new ServiceDAO(ConnectionEce.getConn());
        test = serviceDAO.delete(service);
        if (test) {
            System.out.println("Supression de " + service.toString());
        }
    }

    public void testupdate() {
        Boolean test;
        //Test de batiment
        Batiment batiment = new Batiment("C", "COCO");
        DAO<Batiment> batDAO = new BatimentDAO(ConnectionEce.getConn());
        test = batDAO.update(batiment);
        if (test) {
            System.out.println("Mise à jour de " + batiment.toString());
        }
        //Test de chambre
        Chambre chambre = new Chambre("REA", 109, 22, 3);
        DAO<Chambre> chambreDAO = new ChambreDAO(ConnectionEce.getConn());
        test = chambreDAO.update(chambre);
        if (test) {
            System.out.println("Mise à jour de " + chambre.toString());
        }
        //Test de docteur
        Docteur docteur = new Docteur("Safin2", "Marat2", "01 06 70 38 91", "61 rue Fermee, 78430 Louveciennes1", 20, "Pneumologue");
        DAO<Docteur> docDAO = new DocteurDAO(ConnectionEce.getConn());
        test = docDAO.update(docteur);
        if (test) {
            System.out.println("Mise à jour de " + docteur.toString());
        }
        //Test de employe
        Employe employe = new Employe("Nadal2", "Rafael2", "01 29 71 13 76", "19 place Bellegarde 78990 Elancourt", 3);
        DAO<Employe> empDAO = new EmployeDAO(ConnectionEce.getConn());
        test = empDAO.update(employe);
        if (test) {
            System.out.println("Mise à jour de " + employe.toString());
        }
        //Test de hospitalisation
        Hospitalisation hospitalisation = new Hospitalisation(13, "REA", 106, 1);
        DAO<Hospitalisation> hosDAO = new HospitalisationDAO(ConnectionEce.getConn());
        test = hosDAO.update(hospitalisation);
        if (test) {
            System.out.println("Mise à jour de " + hospitalisation.toString());
        }
        //Test de infirmier
        Infirmier infirmier = new Infirmier("REA", "JOUR", 1536.28, "Potter", "Harry", "01 04 70 01 68", "56 rue des Muletiers, 78660 Ablis", 74);
        DAO<Infirmier> infDAO = new InfirmierDAO(ConnectionEce.getConn());
        test = infDAO.update(infirmier);
        if (test) {
            System.out.println("Mise à jour de " + infirmier.toString());
        }
        //Test de malade
        Malade malade = new Malade(193, "MGEN", "Luczakp", "Louane", "01 96 34 45 73", "39 rue Manuel, 78001 Versailles");
        DAO<Malade> maladeDAO = new MaladeDAO(ConnectionEce.getConn());
        test = maladeDAO.update(malade);
        if (test) {
            System.out.println("Mise à jour de " + malade.toString());
        }
        //Test de Service
        Service service = new Service("PAL", "Soin Paliatif et aide", "B", 50);
        DAO<Service> serviceDAO = new ServiceDAO(ConnectionEce.getConn());
        test = serviceDAO.update(service);
        if (test) {
            System.out.println("Création de " + service.toString());
        }
    }

}
