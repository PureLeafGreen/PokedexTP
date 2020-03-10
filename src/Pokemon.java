public class Pokemon {
    private final static int SANS_TYPE = 0;

    private String nom;
    private int numero;
    private int type1, type2;
    private Pokemon evolution;
    private Pokemon Nexte;

    public Pokemon(String nom, int numero, int type1, int type2) {
        this.nom = nom;
        this.numero  = numero;
        this.type1 = type1;
        this.type2 = type2;
        this.evolution = null;
        this.Nexte = null;
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

    public Pokemon getNexte() {
        return Nexte;
    }

    public void setNexte(Pokemon next) {
        this.Nexte = next;
    }

    public String getType1() {
        return TableType.getType(type1);
    }

    public String getType2() {
        return TableType.getType(type2);
    }

    public int[] getFaiblesse() {
       int[] fb1 = TableType.getFaiblesses(type1);
       return fb1;
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
