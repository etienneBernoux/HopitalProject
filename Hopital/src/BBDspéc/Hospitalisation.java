package BBDspéc;


import sun.util.calendar.BaseCalendar.Date;

public class Hospitalisation {

    private int NoMalade;

    private int NoChambre;

    private int Lit;

    private Date DateEntree;

    private int DureeJour;

    public Hospitalisation(int NoMalade, int NoChambre, int Lit, Date DateEntree, int DureeJour) {
        this.NoMalade = NoMalade;
        this.NoChambre = NoChambre;
        this.Lit = Lit;
        this.DateEntree = DateEntree;
        this.DureeJour = DureeJour;
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

    public Date getDateEntree() {
        return DateEntree;
    }

    public void setDateEntree(Date DateEntree) {
        this.DateEntree = DateEntree;
    }

    public int getDureeJour() {
        return DureeJour;
    }

    public void setDureeJour(int DureeJour) {
        this.DureeJour = DureeJour;
    }
    
}
