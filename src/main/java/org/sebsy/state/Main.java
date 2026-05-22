package org.sebsy.state;

public class Main {

    public static void main(String[] args) {
        Produit cafe = new Produit();
        cafe.setNom("Café");
        cafe.setGrade("A");

        Produit the = new Produit();
        the.setNom("Thé");
        the.setGrade("B");

        System.out.println("=== Création et livraison commande ===");
        Commande commande = new Commande();
        commande.ajouterProduit(cafe);
        commande.ajouterProduit(the);
        commande.payer();
        commande.livrer("12 rue de la Paix, Paris");

        System.out.println("\n=== Annulation d'une commande créée ===");
        Commande commandeAnnulee = new Commande();
        commandeAnnulee.ajouterProduit(cafe);
        commandeAnnulee.annuler();
        commandeAnnulee.annuler();

        System.out.println("\n=== Annulation impossible en livraison ===");
        Commande commandeEnLivraison = new Commande();
        commandeEnLivraison.ajouterProduit(cafe);
        commandeEnLivraison.payer();
        commandeEnLivraison.livrer("5 avenue Victor Hugo, Lyon");
        commandeEnLivraison.annuler();
    }
}
