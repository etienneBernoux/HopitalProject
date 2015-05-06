package BBDspéc;

public enum Maladie {

    Rhume,
    Tuberculose,
    Colera,
    Peste,
    CancerDuRectum,
    EmboliePulmonaire;
    
    public static Maladie getRhume() {
        return Rhume;
    }

    public static Maladie getTuberculose() {
        return Tuberculose;
    }

    public static Maladie getColera() {
        return Colera;
    }

    public static Maladie getPeste() {
        return Peste;
    }

    public static Maladie getCancerDuRectum() {
        return CancerDuRectum;
    }

    public static Maladie getEmboliePulmonaire() {
        return EmboliePulmonaire;
    }
}
