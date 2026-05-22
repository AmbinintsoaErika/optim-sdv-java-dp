package org.sebsy.state;

public class CommandePaiement implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        System.out.println("Erreur : impossible d'ajouter un produit, la commande n'est plus en création.");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Erreur : la commande a déjà été payée.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        commande.setAdresseLivraison(adresse);
        commande.changerEtat(new CommandeEnLivraison());
        System.out.println("Commande en livraison à l'adresse : " + adresse);
    }

    @Override
    public void annuler(Commande commande) {
        commande.changerEtat(new CommandeAnnulee());
        System.out.println("Commande annulée.");
    }
}
