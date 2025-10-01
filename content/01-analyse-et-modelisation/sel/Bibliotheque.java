public class Bibliotheque {

    private boolean disponible = true;
    private String emprunteur = null;

    // Use case : emprunter un livre
    public void emprunter(String utilisateur) {
        if (disponible) { // Étape 1 : vérifier disponibilité
            disponible = false; // Étape 2 : associer le livre
            emprunteur = utilisateur;
            System.out.println("Livre emprunté par " + utilisateur); // Étape 3
        } else {
            System.out.println("Erreur : le livre est déjà emprunté."); // Scénario alternatif
        }
    }

    // Use case : retourner un livre
    public void retourner(String utilisateur) {
        if (!disponible && utilisateur.equals(emprunteur)) { // Étape 1 : vérifier
            disponible = true; // Étape 2 : libérer le livre
            emprunteur = null;
            System.out.println("Livre retourné par " + utilisateur); // Étape 3
        } else {
            System.out.println("Erreur : ce livre n’a pas été emprunté par " + utilisateur); // Scénario alternatif
        }
    }
}
