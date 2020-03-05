public class Pokemon {
    private final static int SANS_TYPE = 0;

    private String nom;
    private int numero;
    private int type1, type2;
    private Pokemon evolution;

    public Pokemon(String nom, int numero, int type1, int type2) {
        this.nom = nom;
        this.numero  = numero;
        this.type1 = type1;
        this.type2 = type2;
        this.evolution = null;
    }

    public Pokemon(String nom, int numero, int type1) {
        this(nom, numero, type1, SANS_TYPE);
    }

    public String getNom() {
        return nom;
    }

    public int getNumero() {
        return numero;
    }

    public Pokemon getEvolution() {
        return evolution;
    }

    public void setEvolution(Pokemon evolution) {
        this.evolution = evolution;
    }

    public String toString() {
        String str = nom + " #" + numero;
        str += " (" + TableType.getType(type1);
        if (type2 != SANS_TYPE)
            str += "/" + TableType.getType(type2);
        str += ")";
        return str;
    }
}
