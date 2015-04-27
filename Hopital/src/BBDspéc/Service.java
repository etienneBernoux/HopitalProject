package BBDspéc;

public class Service {

    private String code_service;
    private String nom;
    private String batiment;
    private int directeur;

    public Service(String code_service, String nom, String batiment, int directeur) {
        this.code_service = code_service;
        this.nom = nom;
        this.batiment = batiment;
        this.directeur = directeur;
    }

    public Service() {
    }

    /**
     * @return the code_service
     */
    public String getCode_service() {
        return code_service;
    }

    /**
     * @param code_service the code_service to set
     */
    public void setCode_service(String code_service) {
        this.code_service = code_service;
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

    /**
     * @return the batiment
     */
    public String getBatiment() {
        return batiment;
    }

    /**
     * @param batiment the batiment to set
     */
    public void setBatiment(String batiment) {
        this.batiment = batiment;
    }

    /**
     * @return the directeur
     */
    public int getDirecteur() {
        return directeur;
    }

    /**
     * @param directeur the directeur to set
     */
    public void setDirecteur(int directeur) {
        this.directeur = directeur;
    }

    @Override
    public String toString() {
        return "Service{" + "code_service=" + code_service + ", nom=" + nom + ", batiment=" + batiment + ", directeur=" + directeur + '}';
    }

}
