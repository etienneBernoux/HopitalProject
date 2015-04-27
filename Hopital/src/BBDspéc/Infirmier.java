package BBDspéc;

public class Infirmier extends Employe {

    private String code_service;
    private String rotation;
    private double salaire;

    public Infirmier(String code_service, String rotation, double salaire, String Nom, String Prenom, String Tel, String Adresse, int no_employee) {
        super(Nom, Prenom, Tel, Adresse, no_employee);
        this.code_service = code_service;
        this.rotation = rotation;
        this.salaire = salaire;
    }

    public Infirmier() {
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
     * @return the rotation
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the salaire
     */
    public double getSalaire() {
        return salaire;
    }

    /**
     * @param salaire the salaire to set
     */
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "Infirmier{" + "code_service=" + code_service + ", rotation=" + rotation + ", salaire=" + salaire + '}';
    }

}
