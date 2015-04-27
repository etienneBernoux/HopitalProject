package BBDspéc;

public class Docteur extends Employe {

    private String Specialite;

    public Docteur(String Specialite, String Nom, String Prenom, String Tel, String Adresse, int NoEmployee) {
        super(Nom, Prenom, Tel, Adresse, NoEmployee);
        this.Specialite = Specialite;
    }

    public String getSpecialite() {
        return Specialite;
    }

    public void setSpecialite(String Specialite) {
        this.Specialite = Specialite;
    }
    
}
