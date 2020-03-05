import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Test {
    private Pokedex dex;
    private Pokemon p;

    public static void main(String[] args) {
        Test t = new Test();

        if (t.testAjouter() || t.testAjouterEvolution()) {
            System.err.println("Tests d'ajout echoues!");
            // Conseil: Utilisez le debogueur pour determiner precisement quel test echoue.
            return;
        }

        if (t.testRechercher()) { //TODO Ajoutez vos tests pour la recherche par nom et par type ici.
            System.err.println("Tests de recherche echoues!");
            return;
        }

        if (t.testAfficher()) {
            System.err.println("Test d'affichage echoue!");
            // Conseil: N'oubliez pas que l'affichage du pokedex doit etre fait en ordre du numero des pokemons.
            return;
        }

        System.out.println("Tous les tests reussis!");
    }

    public Test() {
        dex = new Pokedex();
    }

    // Tests existants ========================================================
    // Vous ne devriez pas modifier ces tests.

    public boolean testAjouter() {
        p = dex.ajouter("Squirtle", 7, "Eau");
        if (p == null || p.getNumero() != 7 || p.getNom() != "Squirtle")
            return true;

        p = dex.ajouter("Bulbasaur", 1, "Plante", "Poison");
        if (p == null || p.getNumero() != 1 || p.getNom() != "Bulbasaur")
            return true;

        p = dex.ajouter("Charmander", 4, "Feu");
        if (p == null || p.getNumero() != 4 || p.getNom() != "Charmander")
            return true;

        return false;
    }

    public boolean testAjouterEvolution() {
        Pokemon p2 = dex.ajouterEvolution(p, "Charmeleon", 5, "Feu");
        if (p2 == null || p2.getNumero() != 5 || p.getEvolution().getNom() != "Charmeleon")
            return true;

        p = dex.ajouterEvolution(p2, "Charizard", 6, "Feu", "Vol");
        if (p == null || p.getNom() != "Charizard" || p2.getEvolution().getNumero() != 6)
            return true;

        return false;
    }

    public boolean testRechercher() {
        p = dex.rechercher(1);
        if (p == null || p.getNumero() != 1 || p.getNom() != "Bulbasaur")
            return true;

        p = dex.rechercher(7);
        if (p == null || p.getNumero() != 7 || p.getNom() != "Squirtle")
            return true;

        p = dex.rechercher(5);
        if (p == null || p.getNumero() != 5 || p.getNom() != "Charmeleon")
            return true;

        p = dex.rechercher(100);
        if (p != null) // On ne devrait pas trouver un pokemon avec ce numero.
            return true;

        return false;
    }

    public boolean testAfficher() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        dex.afficher(new PrintStream(out));

        int last = -1;
        Scanner scan = new Scanner(out.toString());
        while (scan.hasNext()) {
            String s = scan.next();
            int num = Integer.parseInt(s.substring(1));
            if (num <= last)
                return true;

            p = dex.rechercher(num);
            s = scan.next();
            if (!s.equals(p.getNom()))
                return true;

            last = num;
            scan.nextLine();
        }

        return false;
    }

    // Tests a ajouter ========================================================
    // Ajoutez vos propres methodes de test ci-apres.
}
