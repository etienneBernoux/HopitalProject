package BBDspéc;

import java.sql.Timestamp;

public class Soigne {

    private int no_malade;
    private int no_docteur;
    private String maladie;
    private Timestamp date_rdv;
    private Timestamp fin_rdv;

    public Soigne() {
    }

    public Soigne(int no_malade, int no_docteur, String maladie, Timestamp date_rdv, Timestamp fin_rdv) {
        this.no_malade = no_malade;
        this.no_docteur = no_docteur;
        this.maladie = maladie;
        this.date_rdv = date_rdv;
        this.fin_rdv = fin_rdv;
    }

    /**
     * @return the no_malade
     */
    public int getNo_malade() {
        return no_malade;
    }

    /**
     * @param no_malade the no_malade to set
     */
    public void setNo_malade(int no_malade) {
        this.no_malade = no_malade;
    }

    /**
     * @return the no_docteur
     */
    public int getNo_docteur() {
        return no_docteur;
    }

    /**
     * @param no_docteur the no_docteur to set
     */
    public void setNo_docteur(int no_docteur) {
        this.no_docteur = no_docteur;
    }

    /**
     * @return the maladie
     */
    public String getMaladie() {
        return maladie;
    }

    /**
     * @param maladie the maladie to set
     */
    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    /**
     * @return the date_rdv
     */
    public Timestamp getDate_rdv() {
        return date_rdv;
    }

    /**
     * @param date_rdv the date_rdv to set
     */
    public void setDate_rdv(Timestamp date_rdv) {
        this.date_rdv = date_rdv;
    }

    /**
     * @return the fin_rdv
     */
    public Timestamp getFin_rdv() {
        return fin_rdv;
    }

    /**
     * @param fin_rdv the fin_rdvto set
     */
    public void setFin_rdv(Timestamp fin_rdv) {
        this.fin_rdv = fin_rdv;
    }

    @Override
    public String toString() {
        return "Soigne{" + "no_malade=" + no_malade + ", no_docteur=" + no_docteur + ", maladie=" + maladie + ", date_rdv=" + date_rdv + ", duree_rdv_min=" + fin_rdv + '}';
    }

}
