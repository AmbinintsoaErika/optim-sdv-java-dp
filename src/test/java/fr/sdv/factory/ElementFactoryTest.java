package fr.sdv.factory;

import junit.framework.TestCase;
import org.junit.Test;

public class ElementFactoryTest extends TestCase {

    private static final double DELTA = 0.0001;

    private final ElementFactory factory = new ElementFactory();

    @Test
    public void testCreerIngredient() {
        Element element = factory.creer(TypeElement.INGREDIENT, "Sucre", 12.5, Unite.MILLI_GRAMMES);

        assertTrue(element instanceof Ingredient);
        assertEquals("Sucre", element.getNom());
        assertEquals(12.5, element.getValeur(), DELTA);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAllergene() {
        Element element = factory.creer(TypeElement.ALLERGENE, "Arachide", 250.0, Unite.MICRO_GRAMMES);

        assertTrue(element instanceof Allergene);
        assertEquals("Arachide", element.getNom());
        assertEquals(250.0, element.getValeur(), DELTA);
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    public void testCreerAdditif() {
        Element element = factory.creer(TypeElement.ADDITIF, "Colorant E102", 0.8, Unite.MILLI_GRAMMES);

        assertTrue(element instanceof Additif);
        assertEquals("Colorant E102", element.getNom());
        assertEquals(0.8, element.getValeur(), DELTA);
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }
}
