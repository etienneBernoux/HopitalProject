package BBDspéc;

public class Employe extends Personne {

    private int no_employe;

    public Employe(String Nom, String Prenom, String Tel, String Adresse, int no_employe) {
        super(Nom, Prenom, Tel, Adresse);
        this.no_employe = no_employe;
    }

    public Employe() {
    }

    /**
     * @return the no_employee
     */
    public int getNo_employe() {
        return no_employe;
    }

    /**
     * @param no_employee the no_employee to set
     */
    public void setNo_employe(int no_employe) {
        this.no_employe = no_employe;
    }

    @Override
    public String toString() {
        return "Employe{" + "no_employee=" + no_employe + '}';
    }

}
