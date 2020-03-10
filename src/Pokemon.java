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

    public String getFaiblesse() {
       int[] faiblesse1 = TableType.getFaiblesses(type1);
       int[] faiblesse2 = TableType.getFaiblesses(type2);
       String TypeFb1 = "Faiblesses du premier type:\n";
       String TypeFb2 = "Faiblesses du second type\n";
       for (int i = 0; i < faiblesse1.length; i++) {
           TypeFb1 += TableType.getType(faiblesse1[i]) + " ";
       }
       for (int i = 0; i < faiblesse2.length; i++) {
            TypeFb2 += TableType.getType(faiblesse2[i]) + " ";
       }
       return TypeFb1 +"\n"+ TypeFb2;
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
