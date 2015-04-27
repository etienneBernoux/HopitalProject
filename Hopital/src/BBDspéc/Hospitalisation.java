package BBDspéc;

import java.sql.Timestamp;

public class Hospitalisation {

    private int Lit;

    private Chambre Chambre;

    private Timestamp DateEntree;

    private Timestamp DateSortie;

    public Hospitalisation(int Lit, Chambre Chambre, Timestamp DateEntree, Timestamp DateSortie) {
        this.Lit = Lit;
        this.Chambre = Chambre;
        this.DateEntree = DateEntree;
        this.DateSortie = DateSortie;
    }

    public Hospitalisation() {
    }

    public int getLit() {
        return Lit;
    }

    public void setLit(int Lit) {
        this.Lit = Lit;
    }

    public Timestamp getDateEntree() {
        return DateEntree;
    }

    public void setDateEntree(Timestamp DateEntree) {
        this.DateEntree = DateEntree;
    }

    public Timestamp getDateSortie() {
        return DateSortie;
    }

    public void setDateSortie(Timestamp DateSortie) {
        this.DateSortie = DateSortie;
    }

    public Chambre getChambre() {
        return Chambre;
    }

    public void setChambre(Chambre Chambre) {
        this.Chambre = Chambre;
    }

}
