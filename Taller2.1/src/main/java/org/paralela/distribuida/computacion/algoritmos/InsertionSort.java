package org.paralela.distribuida.computacion.algoritmos;

public class InsertionSort {

    public static void sort(float[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            float valorActual = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > valorActual) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = valorActual;
        }
    }
}