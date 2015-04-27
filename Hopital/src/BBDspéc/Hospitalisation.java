package BBDspéc;

import java.sql.Timestamp;

public class Hospitalisation {

    private int NoMalade;

    private int NoChambre;

    private int Lit;

    private Timestamp DateEntree;

    private Timestamp DateSortie;

    public Hospitalisation(int NoMalade, int NoChambre, int Lit, Timestamp DateEntree, Timestamp DateSortie) {
        this.NoMalade = NoMalade;
        this.NoChambre = NoChambre;
        this.Lit = Lit;
        this.DateEntree = DateEntree;
        this.DateSortie = DateSortie;
    }

    public int getNoMalade() {
        return NoMalade;
    }

    public void setNoMalade(int NoMalade) {
        this.NoMalade = NoMalade;
    }

    public int getNoChambre() {
        return NoChambre;
    }

    public void setNoChambre(int NoChambre) {
        this.NoChambre = NoChambre;
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
