import java.io.PrintStream;

public class Pokedex {
    private Pokemon fPokemons;
    private Pokemon lPokemons;
    private Pokemon courant;
    private int longeur;

    public Pokedex() {
        fPokemons = null;
        lPokemons = null;
        courant = null;
        longeur = 0;
    }

    public void afficher(PrintStream out) {
        if (fPokemons == null) {
            System.out.println("Pokedex vide");
        }
        courant = fPokemons;
        while (courant != null) {
            System.out.println(courant.toString() + "");
            courant = courant.getNexte();
        }

    }

    public void afficherType(String type) {
        if (fPokemons == null) {
            System.out.println("Aucun pokemons dans le pokedex");
        }
        else {
            courant = fPokemons;
            while (courant != null) {
                if (courant.getType1().equals(type) || courant.getType2().equals(type)) {
                    System.out.println(courant.toString() + "");
                    courant = courant.getNexte();
                } else {
                    courant = courant.getNexte();
                }
            }
        }
    }

    public Pokemon rechercher(int numero) {
        if (fPokemons == null ) {
            return null;
        }
        else {
            courant = fPokemons;
            while (courant != null) {
                if (courant.getNumero() == numero) {
                    return courant;
                }
                else {
                    courant = courant.getNexte();
                }
            }
        }
        return null;
    }

    public Pokemon rechercherNom(String nom) {
        if (fPokemons == null) {
            return null;
        }
        else {
            courant = fPokemons;
            while (courant != null) {
                if (courant.getNom().equals(nom)) {
                    return courant;
                }
                else {
                    courant = courant.getNexte();
                }
            }
        }
        return null;
    }

    public Pokemon ajouter(String nom, int numero, String type1, String type2) {
        Pokemon p = rechercher(numero);
        if (p != null) {
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).
        }
        p = new Pokemon(nom, numero, TableType.getType(type1), TableType.getType(type2));
        if (fPokemons == null) {
            fPokemons = p;
            lPokemons = p;
            longeur++;
            return fPokemons;
        }
        else {
            courant = fPokemons;
            Pokemon memoire = courant.getNexte();
            if (memoire == null) {
                courant.setNexte(p);
                lPokemons = p;
                return lPokemons;
            }
            else {
                while (courant.getNexte() != null) {
                    memoire = courant.getNexte();
                    if (lPokemons.getNumero() < p.getNumero() || courant.getNexte() == null) {
                        lPokemons.setNexte(p);
                        lPokemons = p;
                        return lPokemons;
                    }
                    if (courant.getNumero() < p.getNumero() && memoire.getNumero() > p.getNumero()) {
                        courant.setNexte(p);
                        p.setNexte(memoire);
                        return p;
                    }
                    else {
                        courant = courant.getNexte();
                    }
                }
                return p;
            }
        }
    }

    public Pokemon ajouter(String nom, int numero, String type1) {
        return ajouter(nom, numero, type1, TableType.SANS_TYPE);
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1, String type2) {
        Pokemon p1 = rechercher(pokemon.getNumero());
        if (p1 == null)
            return null; // Erreur: On verifie que le pokemon de base existe deja.

        Pokemon p2 = ajouter(nom, numero, type1, type2);
        if (p2 == null)
            return null; // Erreur: Pokemon deja ajoute (on conserve celui existant).

        p1.setEvolution(p2);
        return p2;
    }

    public Pokemon ajouterEvolution(Pokemon pokemon, String nom, int numero, String type1) {
        return ajouterEvolution(pokemon, nom, numero, type1, TableType.SANS_TYPE);
    }
}
