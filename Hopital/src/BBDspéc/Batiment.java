package BBDspéc;

public class Batiment {

    private String Nom;

    private String CodeService;

    public Batiment(String Nom, String CodeService) {
        this.Nom = Nom;
        this.CodeService = CodeService;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getCodeService() {
        return CodeService;
    }

    public void setCodeService(String CodeService) {
        this.CodeService = CodeService;
    }
    
}
