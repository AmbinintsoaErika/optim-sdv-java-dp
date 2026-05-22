package org.sebsy.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Commande {

    private static final double PRIX_UNITAIRE = 0.5;

    private CommandeState etat;
    private final List<Produit> produits = new ArrayList<>();
    private String adresseLivraison;
    private double prixTotal;

    public Commande() {
        this.etat = new CommandeCreation();
    }

    void changerEtat(CommandeState nouvelEtat) {
        this.etat = nouvelEtat;
    }

    void ajouterProduitInterne(Produit produit) {
        produits.add(produit);
    }

    List<Produit> getProduits() {
        return Collections.unmodifiableList(produits);
    }

    void setAdresseLivraison(String adresse) {
        this.adresseLivraison = adresse;
    }

    String getAdresseLivraison() {
        return adresseLivraison;
    }

    void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    double getPrixTotal() {
        return prixTotal;
    }

    double calculerPrixTotal() {
        return getProduits().size() * PRIX_UNITAIRE;
    }

    public void ajouterProduit(Produit produit) {
        etat.ajouterProduit(this, produit);
    }

    public void payer() {
        etat.payer(this);
    }

    public void livrer(String adresse) {
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }
}
