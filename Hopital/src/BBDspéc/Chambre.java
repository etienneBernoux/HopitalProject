package BBDspéc;

import java.util.HashSet;
import java.util.Set;

public class Chambre {

    private int NoChambre;

    private Infirmier Surveillant;

    private int NbLits;
    
    //Liste des hospitalisés logés
    private Set<Hospitalisation> listHospitalisation = new HashSet<>();

    public Chambre(int NoChambre, Infirmier Surveillant, int NbLits) {
        this.NoChambre = NoChambre;
        this.Surveillant = Surveillant;
        this.NbLits = NbLits;
    }

    public int getNoChambre() {
        return NoChambre;
    }

    public void setNoChambre(int NoChambre) {
        this.NoChambre = NoChambre;
    }

    public Infirmier getSurveillant() {
        return Surveillant;
    }

    public void setSurveillant(Infirmier Surveillant) {
        this.Surveillant = Surveillant;
    }

    public int getNbLits() {
        return NbLits;
    }

    public void setNbLits(int NbLits) {
        this.NbLits = NbLits;
    }

    public Set<Hospitalisation> getListHospitalisation() {
        return listHospitalisation;
    }

    public void setListHospitalisation(Set<Hospitalisation> listHospitalisation) {
        this.listHospitalisation = listHospitalisation;
    }
    //Ajoute une Hospitalisation a une chambre
  public void addHospitalisation(Hospitalisation hospitalisation){
    this.listHospitalisation.add(hospitalisation);
  }

  //Supprime une Hospitalisation a une chambre
  public void removeHospitalisation(Hospitalisation hospitalisation){
    this.listHospitalisation.remove(hospitalisation);
  }

   
    
}
