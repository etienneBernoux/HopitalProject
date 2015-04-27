package BBDspéc;

import java.util.HashSet;
import java.util.Set;

public class Service {

    private String CodeService;

    private String Nom;

    private Docteur directeur;
    //Liste des infirmiers employés
    private Set<Infirmier> listInfirmier = new HashSet<>();
    //Liste des chambres du service 
    private Set<Chambre> listChambre = new HashSet<>();

    public Service(String CodeService, String Nom, Docteur directeur) {
        this.CodeService = CodeService;
        this.Nom = Nom;
        this.directeur = directeur;
    }

    public String getCodeService() {
        return CodeService;
    }

    public void setCodeService(String CodeService) {
        this.CodeService = CodeService;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Docteur getDirecteur() {
        return directeur;
    }

    public void setDirecteur(Docteur directeur) {
        this.directeur = directeur;
    }

    public Set<Infirmier> getListInfirmier() {
        return listInfirmier;
    }

    public void setListInfirmier(Set<Infirmier> listInfirmier) {
        this.listInfirmier = listInfirmier;
    }

    public Set<Chambre> getListChambre() {
        return listChambre;
    }

    public void setListChambre(Set<Chambre> listChambre) {
        this.listChambre = listChambre;
    }
     //Ajoute un infirmier a un service
  public void addInfirmier(Infirmier infirmier){
    this.listInfirmier.add(infirmier);
  }

  //Supprime un infirmier a service
  public void removeMatiere(Infirmier infirmier){
    this.listInfirmier.remove(infirmier);
  }
    //Ajoute une chambre a un service
  public void addChambre(Chambre chambre){
    this.listChambre.add(chambre);
  }

  //Supprime un chambre a un service
  public void removeChambre(Chambre chambre){
    this.listChambre.remove(chambre);
  }
}
