package BBDspéc;

public class Chambre {

    private String code_service;
    private int no_chambre;
    private int surveillant;
    private int nb_lits;

    public Chambre() {
    }

    public Chambre(String code_service, int no_chambre, int surveillant, int nb_lits) {
        this.code_service = code_service;
        this.no_chambre = no_chambre;
        this.surveillant = surveillant;
        this.nb_lits = nb_lits;
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
     * @return the no_chambre
     */
    public int getNo_chambre() {
        return no_chambre;
    }

    /**
     * @param no_chambre the no_chambre to set
     */
    public void setNo_chambre(int no_chambre) {
        this.no_chambre = no_chambre;
    }

    /**
     * @return the surveillant
     */
    public int getSurveillant() {
        return surveillant;
    }

    /**
     * @param surveillant the surveillant to set
     */
    public void setSurveillant(int surveillant) {
        this.surveillant = surveillant;
    }

    /**
     * @return the nb_lits
     */
    public int getNb_lits() {
        return nb_lits;
    }

    /**
     * @param nb_lits the nb_lits to set
     */
    public void setNb_lits(int nb_lits) {
        this.nb_lits = nb_lits;
    }

    @Override
    public String toString() {
        return "Chambre{" + "code_service=" + code_service + ", no_chambre=" + no_chambre + ", surveillant=" + surveillant + ", nb_lits=" + nb_lits + '}';
    }

}
