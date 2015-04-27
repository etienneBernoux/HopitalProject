package BBDspéc;


import java.sql.Timestamp;
import sun.util.calendar.BaseCalendar.Date;

public class Soigne {

    private int NoDocteur;

    private int NoMalade;

    private Timestamp DateRdv;

    private String Maladie;

    private int DureeRdv;

    public Soigne(int NoDocteur, int NoMalade, Timestamp DateRdv, String Maladie, int DureeRdv) {
        this.NoDocteur = NoDocteur;
        this.NoMalade = NoMalade;
        this.DateRdv = DateRdv;
        this.Maladie = Maladie;
        this.DureeRdv = DureeRdv;
    }

    public int getNoDocteur() {
        return NoDocteur;
    }

    public void setNoDocteur(int NoDocteur) {
        this.NoDocteur = NoDocteur;
    }

    public int getNoMalade() {
        return NoMalade;
    }

    public void setNoMalade(int NoMalade) {
        this.NoMalade = NoMalade;
    }

    public Timestamp getDateRdv() {
        return DateRdv;
    }

    public void setDateRdv(Timestamp DateRdv) {
        this.DateRdv = DateRdv;
    }

    public String getMaladie() {
        return Maladie;
    }

    public void setMaladie(String Maladie) {
        this.Maladie = Maladie;
    }

    public int getDureeRdv() {
        return DureeRdv;
    }

    public void setDureeRdv(int DureeRdv) {
        this.DureeRdv = DureeRdv;
    }
    
}
