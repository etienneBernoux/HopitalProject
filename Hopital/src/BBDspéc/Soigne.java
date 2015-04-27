package BBDspéc;

import java.sql.Timestamp;

public class Soigne {

    private Timestamp DateRdv;

    private String Maladie;

    private int DureeRdvMin;

    public Soigne(Timestamp DateRdv, String Maladie, int DureeRdvMin) {

        this.DateRdv = DateRdv;
        this.Maladie = Maladie;
        this.DureeRdvMin = DureeRdvMin;
    }

    public Soigne() {
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

    public int getDureeRdvMin() {
        return DureeRdvMin;
    }

    public void DureeRdvMin(int DureeRdv) {
        this.DureeRdvMin = DureeRdv;
    }

}
