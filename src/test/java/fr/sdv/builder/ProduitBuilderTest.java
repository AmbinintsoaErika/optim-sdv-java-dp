package fr.sdv.builder;

import junit.framework.TestCase;
import org.junit.Test;

public class ProduitBuilderTest extends TestCase {

    private static final double DELTA = 0.0001;

    @Test
    public void testBuildProduitNominal() {
        Produit produit = new ProduitBuilder()
                .nom("Yaourt nature")
                .grade("A")
                .categorie("Produits laitiers")
                .marque("Danone")
                .ingredient("Lait", 850.0)
                .ingredient("Ferments lactiques", 12.5)
                .additif("Colorant E150d", 0.5)
                .allergene("Lait", 850.0)
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

    @Test
    public void testBuildProduitMinimal() {
        Produit produit = new ProduitBuilder()
                .nom("Eau minérale")
                .grade("B")
                .categorie("Boissons")
                .marque("Evian")
                .build();

        assertEquals("Eau minérale", produit.getNom());
        assertEquals("B", produit.getGrade());
        assertTrue(produit.getIngredients().isEmpty());
        assertTrue(produit.getAdditifs().isEmpty());
        assertTrue(produit.getAllergenes().isEmpty());
    }

    @Test
    public void testBuildProduitPlusieursAdditifsEtAllergenes() {
        Produit produit = new ProduitBuilder()
                .nom("Biscuit")
                .grade("C")
                .categorie("Snacks")
                .marque("Lu")
                .additif("Lécithine", 2.0)
                .additif("Vanilline", 0.1)
                .allergene("Gluten", 450.0)
                .allergene("Œuf", 30.0)
                .build();

        assertEquals(2, produit.getAdditifs().size());
        assertEquals(2, produit.getAllergenes().size());
        assertEquals(0.1, produit.getAdditifs().get(1).getQteMilligrammes(), DELTA);
    }
}
