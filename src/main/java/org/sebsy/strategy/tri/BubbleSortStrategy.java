package org.sebsy.strategy.tri;

import org.sebsy.strategy.Strategy;

/**
 * TRI À BULLES
 * Comparaison deux à deux les éléments 1 et 2 consécutifs d'un tableau
 * puis permutation si e1 > e2
 */
public class BubbleSortStrategy implements Strategy {

    @Override
    public void Trier(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
