package fr.sdv.builder;

public class ProduitBuilder {

    private final Produit produit = new Produit();

    public ProduitBuilder nom(String nom) {
        produit.setNom(nom);
        return this;
    }

    public ProduitBuilder grade(String grade) {
        produit.setGrade(grade);
        return this;
    }

    public ProduitBuilder categorie(String nomCategorie) {
        produit.setCategorie(new Categorie(nomCategorie));
        return this;
    }

    public ProduitBuilder marque(String nomMarque) {
        produit.setMarque(new Marque(nomMarque));
        return this;
    }

    public ProduitBuilder additif(String nom, double qteMilligrammes) {
        produit.addAdditif(new Additif(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder ingredient(String nom, double qteMilligrammes) {
        produit.addIngredient(new Ingredient(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder allergene(String nom, double qteMilligrammes) {
        produit.addAllergene(new Allergene(nom, qteMilligrammes));
        return this;
    }

    public Produit build() {
        return produit;
    }
}
