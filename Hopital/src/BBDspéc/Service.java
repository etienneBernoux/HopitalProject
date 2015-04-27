package BBDspéc;

public class Service {

    private String CodeService;

    private String Nom;

    private String Batiment;

    private int Directeur;

    public Service(String CodeService, String Nom, String Batiment, int Directeur) {
        this.CodeService = CodeService;
        this.Nom = Nom;
        this.Batiment = Batiment;
        this.Directeur = Directeur;
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

    public String getBatiment() {
        return Batiment;
    }

    public void setBatiment(String Batiment) {
        this.Batiment = Batiment;
    }

    public int getDirecteur() {
        return Directeur;
    }

    public void setDirecteur(int Directeur) {
        this.Directeur = Directeur;
    }
    
}
