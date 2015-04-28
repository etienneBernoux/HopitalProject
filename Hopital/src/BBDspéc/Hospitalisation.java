package BBDspéc;

import java.sql.Timestamp;

public class Hospitalisation {

    private int num_malade;
    private String code_service;
    private int num_chambre;
    private int no_lit;

    public Hospitalisation(int num_malade, String code_service, int num_chambre, int no_lit) {
        this.num_malade = num_malade;
        this.code_service = code_service;
        this.num_chambre = num_chambre;
        this.no_lit = no_lit;
    }

    public Hospitalisation() {
    }

    /**
     * @return the num_malade
     */
    public int getNum_malade() {
        return num_malade;
    }

    /**
     * @param num_malade the num_malade to set
     */
    public void setNum_malade(int num_malade) {
        this.num_malade = num_malade;
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
     * @return the num_chambre
     */
    public int getNum_chambre() {
        return num_chambre;
    }

    /**
     * @param num_chambre the num_chambre to set
     */
    public void setNum_chambre(int num_chambre) {
        this.num_chambre = num_chambre;
    }

    /**
     * @return the no_lit
     */
    public int getNo_lit() {
        return no_lit;
    }

    /**
     * @param no_lit the no_lit to set
     */
    public void setLit(int no_lit) {
        this.no_lit = no_lit;
    }

    @Override
    public String toString() {
        return "Hospitalisation{" + "num_malade=" + num_malade + ", code_service=" + code_service + ", num_chambre=" + num_chambre + ", no_lit=" + no_lit + '}';
    }

}
