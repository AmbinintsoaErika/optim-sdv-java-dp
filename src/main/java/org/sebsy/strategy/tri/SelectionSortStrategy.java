package org.sebsy.strategy.tri;

import org.sebsy.strategy.Strategy;

/**
 * TRI PAR SÉLECTION
 * A chaque itération, identification de l'indice de la plus petite valeur 
 * puis permutation avec celle qui occupe sa place (indice 0)
 */

public class SelectionSortStrategy implements Strategy {

    @Override
    public void Trier(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

}
