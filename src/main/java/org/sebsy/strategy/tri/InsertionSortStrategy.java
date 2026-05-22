package org.sebsy.strategy.tri;

import org.sebsy.strategy.Strategy;

/**
 * TRI PAR INSERTION
 * Insertion de chaque nouvel élément parmi les éléments déjà triés
 */
public class InsertionSortStrategy implements Strategy {

    @Override
    public void Trier(int[] arr) {
        for (int k = 1; k < arr.length - 1; k++) {
            int temp = arr[k];
            int j = k - 1;
            while (j >= 0 && temp <= arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = temp;
        }
    }

}
