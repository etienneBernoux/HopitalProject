package BBDspéc;

public class Chambre {

    private int NoChambre;

    private String CodeService;

    private int Surveillant;

    private int NbLits;

    public Chambre(int NoChambre, String CodeService, int Surveillant, int NbLits) {
        this.NoChambre = NoChambre;
        this.CodeService = CodeService;
        this.Surveillant = Surveillant;
        this.NbLits = NbLits;
    }

    public int getNoChambre() {
        return NoChambre;
    }

    public void setNoChambre(int NoChambre) {
        this.NoChambre = NoChambre;
    }

    public String getCodeService() {
        return CodeService;
    }

    public void setCodeService(String CodeService) {
        this.CodeService = CodeService;
    }

    public int getSurveillant() {
        return Surveillant;
    }

    public void setSurveillant(int Surveillant) {
        this.Surveillant = Surveillant;
    }

    public int getNbLits() {
        return NbLits;
    }

    public void setNbLits(int NbLits) {
        this.NbLits = NbLits;
    }
    
}
