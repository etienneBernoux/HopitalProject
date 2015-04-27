package BBDspéc;

import java.sql.Timestamp;

public class Hospitalisation {

    private int Lit;

    private Timestamp DateEntree;

    private Timestamp DateSortie;

    public Hospitalisation(int Lit, Timestamp DateEntree, Timestamp DateSortie) {
        this.Lit = Lit;
        this.DateEntree = DateEntree;
        this.DateSortie = DateSortie;
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
}
