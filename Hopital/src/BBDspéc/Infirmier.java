package BBDspéc;

public class Infirmier extends Employe {

    private String CodeService;

    private String Rotation;

    private float Salaire;

    public Infirmier(String CodeService, String Rotation, float Salaire, String Nom, String Prenom, String Tel, String Adresse, int NoEmployee) {
        super(Nom, Prenom, Tel, Adresse, NoEmployee);
        this.CodeService = CodeService;
        this.Rotation = Rotation;
        this.Salaire = Salaire;
    }

    public String getCodeService() {
        return CodeService;
    }

    public void setCodeService(String CodeService) {
        this.CodeService = CodeService;
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
    
    
}
