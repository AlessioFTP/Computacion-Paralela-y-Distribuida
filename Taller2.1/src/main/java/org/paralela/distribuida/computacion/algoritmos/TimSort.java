package org.paralela.distribuida.computacion.algoritmos;

public class TimSort {

    public static void sort(float[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        for (int tamanoBloque = 1; tamanoBloque < n; tamanoBloque = 2 * tamanoBloque) {

            for (int izquierda = 0; izquierda < n; izquierda += 2 * tamanoBloque) {

                int medio = izquierda + tamanoBloque - 1;
                int derecha = Math.min((izquierda + 2 * tamanoBloque - 1), (n - 1));

                if (medio < derecha) {
                    MergeSort.merge(arr, izquierda, medio, derecha);
                }
            }
        }
    }
}