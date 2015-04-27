package BBDspéc;

import java.util.HashSet;
import java.util.Set;

public class Malade extends Personne {

    private int NoMalade;

    private String Mutuelle;
    //Liste des Soins reçu
    private Set<Soigne> listSoigne = new HashSet<>();
    //Liste des hospitalisations vécus
    private Set<Hospitalisation> listHospitalisation = new HashSet<>();

    public Malade(int NoMalade, String Mutuelle, String Nom, String Prenom, String Tel, String Adresse) {
        super(Nom, Prenom, Tel, Adresse);
        this.NoMalade = NoMalade;
        this.Mutuelle = Mutuelle;
    }

    public int getNoMalade() {
        return NoMalade;
    }

    public void setNoMalade(int NoMalade) {
        this.NoMalade = NoMalade;
    }

    public String getMutuelle() {
        return Mutuelle;
    }

    public void setMutuelle(String Mutuelle) {
        this.Mutuelle = Mutuelle;
    }

    public Set<Soigne> getListSoigne() {
        return listSoigne;
    }

    public void setListSoigne(Set<Soigne> listSoigne) {
        this.listSoigne = listSoigne;
    }

    public Set<Hospitalisation> getListHospitalisation() {
        return listHospitalisation;
    }

    public void setListHospitalisation(Set<Hospitalisation> listHospitalisation) {
        this.listHospitalisation = listHospitalisation;
    }
    //Ajoute un Soin a un malade
  public void addSoigne(Soigne soigne){
    this.listSoigne.add(soigne);
  }

  //Supprime un Soin a un malade
  public void removeSoigne(Soigne soigne){
    this.listSoigne.remove(soigne);
  }
  //Ajoute une hospitalisation a un malade
  public void addHospitalisation(Hospitalisation hospitalisation){
    this.listHospitalisation.add(hospitalisation);
  }

  //Supprime une hospitalisation a un malade
  public void removeHospitalisation(Hospitalisation hospitalisation){
    this.listHospitalisation.remove(hospitalisation);
  }
    
}
