package BBDspéc;

public class Malade extends Personne {

    private int no_malade;

    private String mutuelle;

    public Malade() {
    }

    public Malade(int no_malade, String mutuelle, String Nom, String Prenom, String Tel, String Adresse) {
        super(Nom, Prenom, Tel, Adresse);
        this.no_malade = no_malade;
        this.mutuelle = mutuelle;
    }

    /**
     * @return the no_malade
     */
    public int getNo_malade() {
        return no_malade;
    }

    /**
     * @param no_malade the no_malade to set
     */
    public void setNo_malade(int no_malade) {
        this.no_malade = no_malade;
    }

    /**
     * @return the mutuelle
     */
    public String getMutuelle() {
        return mutuelle;
    }

    /**
     * @param mutuelle the mutuelle to set
     */
    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }

    @Override
    public String toString() {
        return "Malade{" + "no_malade=" + no_malade + ", mutuelle=" + mutuelle + '}';
    }

}
