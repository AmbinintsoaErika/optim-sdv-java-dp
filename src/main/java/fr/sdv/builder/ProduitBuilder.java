package fr.sdv.builder;
import java.util.ArrayList;
import java.util.List;

public class ProduitBuilder {

    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private List<Additif> additifs = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Allergene> allergenes = new ArrayList<>();

    public ProduitBuilder(){};

    public ProduitBuilder withNom(String nom){
        this.nom = nom;
        return this;
    }
    public ProduitBuilder withGrade(String grade){
        this.grade = grade;
        return this;
    }

    public ProduitBuilder withCategorie(String nomCategorie) {
    this.categorie = new Categorie(nomCategorie);
    return this;
}

    public ProduitBuilder withMarque(String nomMarque) {
        this.marque = new Marque(nomMarque);
        return this;
    }

    public ProduitBuilder withIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public ProduitBuilder withAllergene(Allergene allergene) {
        this.allergenes.add(allergene);
        return this;
    }

    public ProduitBuilder withAdditif(Additif additif) {
        this.additifs.add(additif);
        return this;
    }

    public Produit build() {
        return new Produit(nom, grade, categorie, marque, ingredients, allergenes, additifs);
    }

}
