package BBDspéc;

import java.util.HashSet;
import java.util.Set;

public class Batiment {

    private String Nom;
//Liste des services logés
    private Set<Service> listService = new HashSet<>();

    public Batiment(String Nom) {
        this.Nom = Nom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public Set<Service> getListService() {
        return listService;
    }

    public void setListService(Set<Service> listMatiere) {
        this.listService = listMatiere;
    }
    
    //Ajoute un service a un batiment
  public void addService(Service service){
    this.listService.add(service);
  }

  //Supprime un service a un batiment
  public void removeService(Service service){
    this.listService.remove(service);
  }

   
}
