package BBDspéc;

public class Employe extends Personne {

    private int NoEmployee;

    public Employe(String Nom, String Prenom, String Tel, String Adresse,int NoEmployee) {
        super(Nom, Prenom, Tel, Adresse);
        this.NoEmployee=NoEmployee;
    }
    public Employe() {
    }
    

    public int getNoEmployee() {
        return NoEmployee;
    }

    public void setNoEmployee(int NoEmployee) {
        this.NoEmployee = NoEmployee;
    }

   
    
}
