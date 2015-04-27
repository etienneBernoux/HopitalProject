package BBDspéc;

public class Batiment {

    private String lettre;
    private String nom;

    public Batiment(String lettre, String nom) {
        this.lettre = lettre;
        this.nom = nom;
    }

    public Batiment() {
    }

    /**
     * @return the lettre
     */
    public String getLettre() {
        return lettre;
    }

    /**
     * @param lettre the lettre to set
     */
    public void setId(String lettre) {
        this.lettre = lettre;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Batiment{" + "lettre=" + lettre + ", nom=" + nom + '}';
    }
    

}
