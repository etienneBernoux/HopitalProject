package BBDspéc;

public enum Maladie {

    Rhume,
    Tuberculose,
    Cholera,
    Peste,
    CancerDuRectum,
    EmboliePulmonaire;
    
    public static Maladie getRhume() {
        return Rhume;
    }

    public static Maladie getTuberculose() {
        return Tuberculose;
    }

    public static Maladie getCholera() {
        return Cholera;
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
