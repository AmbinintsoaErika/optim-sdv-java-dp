package org.sebsy.state;

public class CommandeAnnulee implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        System.out.println("Erreur : impossible d'ajouter un produit, la commande a été annulée.");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Erreur : impossible de payer, la commande a été annulée.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Erreur : impossible de livrer, la commande a été annulée.");
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Erreur : la commande a déjà été annulée.");
    }
}
