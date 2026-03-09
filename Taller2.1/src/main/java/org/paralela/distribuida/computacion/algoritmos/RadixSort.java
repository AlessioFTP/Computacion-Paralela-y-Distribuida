package org.paralela.distribuida.computacion.algoritmos;

public class RadixSort {

    public static void sort(int[] arr) {
        if (arr.length == 0) return;

        int valorMaximo = obtenerMaximo(arr);

        for (int exponente = 1; valorMaximo / exponente > 0; exponente *= 10) {
            ordenarPorConteo(arr, exponente);
        }
    }

    private static int obtenerMaximo(int[] arr) {
        int maximo = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maximo) maximo = arr[i];
        }
        return maximo;
    }

    private static void ordenarPorConteo(int[] arr, int exponente) {
        int n = arr.length;
        int[] arregloSalida = new int[n];
        int[] conteoDigitos = new int[10];

        for (int num : arr) {
            int digito = (num / exponente) % 10;
            conteoDigitos[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            conteoDigitos[i] += conteoDigitos[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digito = (arr[i] / exponente) % 10;
            arregloSalida[conteoDigitos[digito] - 1] = arr[i];
            conteoDigitos[digito]--;
        }

        System.arraycopy(arregloSalida, 0, arr, 0, n);
    }
}