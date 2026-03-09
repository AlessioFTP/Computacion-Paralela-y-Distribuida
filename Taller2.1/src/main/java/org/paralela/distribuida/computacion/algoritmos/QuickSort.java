package org.paralela.distribuida.computacion.algoritmos;

public class QuickSort {

    public static void sort(float[] arr) {
        if (arr == null || arr.length == 0) return;
        ordenarQuick(arr, 0, arr.length - 1);
    }

    private static void ordenarQuick(float[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int indiceParticion = particion(arr, bajo, alto);

            ordenarQuick(arr, bajo, indiceParticion - 1);
            ordenarQuick(arr, indiceParticion + 1, alto);
        }
    }

    private static int particion(float[] arr, int bajo, int alto) {
        float pivote = arr[alto];
        int i = (bajo - 1);

        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                float temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        float temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }
}