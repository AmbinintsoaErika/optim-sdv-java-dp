package fr.sdv.builder;

import junit.framework.TestCase;
import org.junit.Test;

public class ProduitBuilderTest extends TestCase {

    private static final double DELTA = 0.0001;

    public void testBuildProduitNominal() {
        Ingredient lait = new Ingredient("Lait", 850.0);
        Ingredient ferments = new Ingredient("Ferments lactiques", 12.5);

        Additif e150d = new Additif("Colorant E150d", 0.5);
        Allergene allergenelait = new Allergene("Lait", 850.0);

        Produit produit = new ProduitBuilder()
                .withNom("Yaourt nature")
                .withGrade("A")
                .withCategorie("Produits laitiers")
                .withMarque("Danone")
                .withIngredient(lait)
                .withIngredient(ferments)
                .withAdditif(e150d)
                .withAllergene(allergenelait)
                .build();

        assertEquals("Yaourt nature", produit.getNom());
        assertEquals("A", produit.getGrade());
        assertEquals("Produits laitiers", produit.getCategorie().getNom());
        assertEquals("Danone", produit.getMarque().getNom());
        assertEquals(2, produit.getIngredients().size());
        assertEquals("Lait", produit.getIngredients().get(0).getNom());
        assertEquals(850.0, produit.getIngredients().get(0).getQteMilligrammes(), DELTA);
        assertEquals(1, produit.getAdditifs().size());
        assertEquals("Colorant E150d", produit.getAdditifs().get(0).getNom());
        assertEquals(1, produit.getAllergenes().size());
        assertEquals("Lait", produit.getAllergenes().get(0).getNom());
    }

    public void testBuildProduitMinimal() {
        Produit produit = new ProduitBuilder()
                .withNom("Eau minérale")
                .withGrade("B")
                .withCategorie("Boissons")
                .withMarque("Evian")
                .build();

        assertEquals("Eau minérale", produit.getNom());
        assertEquals("B", produit.getGrade());
        assertTrue(produit.getIngredients().isEmpty());
        assertTrue(produit.getAdditifs().isEmpty());
        assertTrue(produit.getAllergenes().isEmpty());
    }

    public void testBuildProduitPlusieursAdditifsEtAllergenes() {
        Additif lecithine = new Additif("Lécithine", 2.0);
        Additif vanilline = new Additif("Vanilline", 0.1);

        Allergene gluten = new Allergene("Gluten", 450.0);
        Allergene oeuf = new Allergene("Oeuf", 30.0);

        Produit produit = new ProduitBuilder()
                .withNom("Biscuit")
                .withGrade("C")
                .withCategorie("Snacks")
                .withMarque("Lu")
                .withAdditif(lecithine)
                .withAdditif(vanilline)
                .withAllergene(gluten)
                .withAllergene(oeuf)
                .build();

        assertEquals(2, produit.getAdditifs().size());
        assertEquals(2, produit.getAllergenes().size());
        assertEquals(0.1, produit.getAdditifs().get(1).getQteMilligrammes(), DELTA);
    }
}
