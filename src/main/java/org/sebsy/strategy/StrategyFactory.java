package org.sebsy.strategy;

import org.sebsy.strategy.tri.BubbleSortStrategy;
import org.sebsy.strategy.tri.InsertionSortStrategy;
import org.sebsy.strategy.tri.SelectionSortStrategy;

public class StrategyFactory {
    public Strategy Trier(TypeTri type, int[] arr) {
        switch (type) {
            case BUBBLESORT:
                return new BubbleSortStrategy();

            case INSERTIONSORT:
                return new InsertionSortStrategy();

            default:
                return new SelectionSortStrategy();

        }
    }
}
