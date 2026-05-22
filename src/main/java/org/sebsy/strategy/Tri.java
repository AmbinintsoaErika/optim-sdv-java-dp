package org.sebsy.strategy;

public class Tri {

    private StrategyFactory factory = new StrategyFactory();

    public void exec(TypeTri type, Integer[] arr) {
        Strategy strategy = factory.Trier(type, null);
        int[] tableau = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tableau[i] = arr[i];
        }
        strategy.Trier(tableau);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tableau[i];
        }
    }
}
