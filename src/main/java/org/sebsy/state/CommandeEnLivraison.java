package org.sebsy.state;

public class CommandeEnLivraison implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        System.out.println("Erreur : impossible d'ajouter un produit, la commande est en livraison.");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Erreur : la commande a déjà été payée.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Erreur : la commande est déjà en cours de livraison.");
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Erreur : la commande est déjà en cours de livraison et l'annulation est impossible.");
    }
}
