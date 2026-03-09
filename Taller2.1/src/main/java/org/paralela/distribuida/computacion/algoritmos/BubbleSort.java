package org.paralela.distribuida.computacion.algoritmos;

public class BubbleSort {

    public static void sort(float[] arr) {
        int n = arr.length;
        boolean cambio;

        for (int i = 0; i < n - 1; i++) {
            cambio = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    cambio = true;
                }
            }

            if (!cambio) break;
        }
    }
}
