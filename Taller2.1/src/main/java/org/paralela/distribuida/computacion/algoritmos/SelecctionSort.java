package org.paralela.distribuida.computacion.algoritmos;

public class SelecctionSort {

    public static void sort(float[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            float temp = arr[indiceMinimo];
            arr[indiceMinimo] = arr[i];
            arr[i] = temp;
        }
    }
}