import java.util.Arrays;

public class TableType {
    public final static String SANS_TYPE = "<inconnu>";
    private final static String[] NOMS_TYPES = { SANS_TYPE,     // Type 0
            "combat", "dragon", "eau", "electrique", "feu",     // Types 1 a 5
            "glace", "insecte", "normal",  "plante", "poison",  // Types 6 a 10
            "psychique", "roche", "sol", "spectre", "vol" };    // Types 11 a 15

    public static String getType(int idType) {
        return NOMS_TYPES[idType];
    }

    public static int getType(String nomType) {
        // NOMS_TYPES doit etre en ordre alphabetique pour que la recherche fonctionne.
        int index = Arrays.binarySearch(NOMS_TYPES, nomType.toLowerCase());
        return index > 0 ? index : 0;
    }

    public static int[] getFaiblesses(int idType) {
        int[][] faiblesses = { {0}, // <inconnu>
                {11, 15},           // combat
                {2, 6},             // dragon
                {4, 9},             // eau
                {13},               // electrique
                {3, 12, 13},        // feu
                {1, 5, 12},         // glace
                {5, 12, 15},        // insecte
                {1},                // normal
                {5, 6, 7, 10, 15},  // plante
                {11, 13},           // poison
                {7, 14},            // psychique
                {1, 3, 9, 13},      // roche
                {3, 6, 9},          // sol
                {14},               // spectre
                {4, 6, 12}          // plante
        };
        return faiblesses[idType];
    }
}
