package org.sebsy.state;

public class CommandeCreation implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        commande.ajouterProduitInterne(produit);
    }

    @Override
    public void payer(Commande commande) {
        double prix = commande.calculerPrixTotal();
        commande.setPrixTotal(prix);
        System.out.println("Paiement effectué. Prix total : " + prix + " €");
        commande.changerEtat(new CommandePaiement());
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Erreur : la livraison n'est possible qu'après le paiement.");
    }

    @Override
    public void annuler(Commande commande) {
        commande.changerEtat(new CommandeAnnulee());
        System.out.println("Commande annulée.");
    }
}
