package BBDspéc;

public class Infirmier extends Employe {

    private String Rotation;
    private float Salaire;
    private Chambre Chambre;

    public Infirmier(String Rotation, float Salaire, Chambre Chambre, String Nom, String Prenom, String Tel, String Adresse, int NoEmployee) {
        super(Nom, Prenom, Tel, Adresse, NoEmployee);
        this.Rotation = Rotation;
        this.Salaire = Salaire;
        this.Chambre = Chambre;
    }

    public Infirmier() {
    }
    


    public String getRotation() {
        return Rotation;
    }

    public void setRotation(String Rotation) {
        this.Rotation = Rotation;
    }

    public float getSalaire() {
        return Salaire;
    }

    public void setSalaire(float Salaire) {
        this.Salaire = Salaire;
    }

    public Chambre getChambre() {
        return Chambre;
    }

    public void setChambre(Chambre Chambre) {
        this.Chambre = Chambre;
    }
    

}
