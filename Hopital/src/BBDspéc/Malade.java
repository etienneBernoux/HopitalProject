package BBDspéc;

public class Malade extends Personne {

    private int NoMalade;

    private String Mutuelle;

    public Malade(int NoMalade, String Mutuelle, String Nom, String Prenom, String Tel, String Adresse) {
        super(Nom, Prenom, Tel, Adresse);
        this.NoMalade = NoMalade;
        this.Mutuelle = Mutuelle;
    }

    public int getNoMalade() {
        return NoMalade;
    }

    public void setNoMalade(int NoMalade) {
        this.NoMalade = NoMalade;
    }

    public String getMutuelle() {
        return Mutuelle;
    }

    public void setMutuelle(String Mutuelle) {
        this.Mutuelle = Mutuelle;
    }
    
}
