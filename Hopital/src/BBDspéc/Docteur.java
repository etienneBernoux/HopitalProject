package BBDspéc;

public class Docteur extends Employe {

    private String specialite;

    public Docteur(String Nom, String Prenom, String Tel, String Adresse, int no_employee,String specialite) {
        super(Nom, Prenom, Tel, Adresse, no_employee);
        this.specialite=specialite; 
    }

    public Docteur() {
        super();
    }


    /**
     * @return the Specialite
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * @param Specialite the Specialite to set
     */
    public void setSpecialite(String Specialite) {
        this.specialite = Specialite;
    }

    @Override
    public String toString() {
        return "Docteur{" + "specialite=" + specialite + '}';
    }

}
