package org.paralela.distribuida.computacion.algoritmos;

public class CountingSort {

    public static void sort(int[] arr) {
        if (arr.length == 0) return;

        int maximo = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximo) maximo = arr[i];
        }

        int[] conteoFrecuencias = new int[maximo + 1];

        for (int num : arr) {
            conteoFrecuencias[num]++;
        }

        for (int i = 1; i <= maximo; i++) {
            conteoFrecuencias[i] += conteoFrecuencias[i - 1];
        }

        int[] arregloSalida = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int valorActual = arr[i];
            int posicionFinal = conteoFrecuencias[valorActual] - 1;

            arregloSalida[posicionFinal] = valorActual;
            conteoFrecuencias[valorActual]--;
        }

        System.arraycopy(arregloSalida, 0, arr, 0, arr.length);
    }
}