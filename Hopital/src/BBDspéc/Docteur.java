package BBDspéc;

import java.util.HashSet;
import java.util.Set;

public class Docteur extends Employe {

    private String Specialite;
    private Service service;
    //Liste des soins du docteur
    private Set<Soigne> listSoigne = new HashSet<>();

    public Docteur(String Specialite, Service service, String Nom, String Prenom, String Tel, String Adresse, int NoEmployee) {
        super(Nom, Prenom, Tel, Adresse, NoEmployee);
        this.Specialite = Specialite;
        this.service = service;
    }

    public Docteur() {
        super();
    }
    

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Set<Soigne> getListSoigne() {
        return listSoigne;
    }

    public void setListSoigne(Set<Soigne> listSoigne) {
        this.listSoigne = listSoigne;
    }

//Ajoute un soin a un docteur
    public void addSoigne(Soigne soigne) {
        this.listSoigne.add(soigne);
    }

    //Supprime un soin a un docteur
    public void removeSoigne(Soigne soigne) {
        this.listSoigne.remove(soigne);

    }
}
