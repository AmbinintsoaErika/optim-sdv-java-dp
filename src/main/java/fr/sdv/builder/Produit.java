package fr.sdv.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produit {

    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private List<Additif> additifs = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Allergene> allergenes = new ArrayList<>();

    public Produit(String nom, String grade) {
        this.nom = nom;
        this.grade = grade;
    }

    public Produit(String nom, String grade, Categorie categorie, Marque marque, List<Ingredient> ingredients, List<Allergene> allergenes, List<Additif> additifs) {
        this.nom = nom;
        this.grade = grade;
        this.categorie = categorie;
        this.marque = marque;
        this.ingredients = ingredients;
        this.allergenes = allergenes;
        this.additifs = additifs;
    }

    public String getNom() {
        return nom;
    }

    public String getGrade() {
        return grade;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    void setMarque(Marque marque) {
        this.marque = marque;
    }

    public List<Additif> getAdditifs() {
        return Collections.unmodifiableList(additifs);
    }

    void addAdditif(Additif additif) {
        additifs.add(additif);
    }

    public List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Allergene> getAllergenes() {
        return Collections.unmodifiableList(allergenes);
    }

    void addAllergene(Allergene allergene) {
        allergenes.add(allergene);
    }
}
