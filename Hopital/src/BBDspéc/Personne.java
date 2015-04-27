package BBDspéc;

public class Personne {

    private String Nom;

    private String Prenom;

    private String Tel;

    private String Adresse;

    public Personne(String Nom, String Prenom, String Tel, String Adresse) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Tel = Tel;
        this.Adresse = Adresse;
    }

    public Personne() {
    }
    

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }
    
}
