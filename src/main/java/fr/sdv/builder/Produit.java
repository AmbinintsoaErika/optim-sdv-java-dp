package fr.sdv.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produit {

    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private final List<Additif> additifs = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Allergene> allergenes = new ArrayList<>();

    public String getNom() {
        return nom;
    }

    void setNom(String nom) {
        this.nom = nom;
    }

    public String getGrade() {
        return grade;
    }

    void setGrade(String grade) {
        this.grade = grade;
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
