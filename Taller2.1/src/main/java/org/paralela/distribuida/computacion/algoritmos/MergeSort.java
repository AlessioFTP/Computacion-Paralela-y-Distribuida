package org.paralela.distribuida.computacion.algoritmos;

public class MergeSort {

    public static void sort(float[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(float[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int mitad = izquierda + (derecha - izquierda) / 2;

            mergeSort(arr, izquierda, mitad);
            mergeSort(arr, mitad + 1, derecha);

            merge(arr, izquierda, mitad, derecha);
        }
    }

    public static void merge(float[] arr, int inicio, int medio, int fin) {
        int tamanoIzquierda = medio - inicio + 1;
        int tamanoDerecha = fin - medio;

        float[] arregloIzquierdo = new float[tamanoIzquierda];
        float[] arregloDerecho = new float[tamanoDerecha];

        System.arraycopy(arr, inicio, arregloIzquierdo, 0, tamanoIzquierda);
        System.arraycopy(arr, medio + 1, arregloDerecho, 0, tamanoDerecha);

        int i = 0, j = 0, k = inicio;

        while (i < tamanoIzquierda && j < tamanoDerecha) {
            if (arregloIzquierdo[i] <= arregloDerecho[j]) {
                arr[k] = arregloIzquierdo[i];
                i++;
            } else {
                arr[k] = arregloDerecho[j];
                j++;
            }
            k++;
        }

        while (i < tamanoIzquierda) {
            arr[k++] = arregloIzquierdo[i++];
        }

        while (j < tamanoDerecha) {
            arr[k++] = arregloDerecho[j++];
        }
    }
}