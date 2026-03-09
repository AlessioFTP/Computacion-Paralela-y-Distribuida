package org.paralela.distribuida.computacion.algoritmos;

public class HeapSort {

    public static void sort(float[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            float temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(float[] arr, int n, int indiceRaiz) {
        int mayor = indiceRaiz;
        int hijoIzquierdo = 2 * indiceRaiz + 1;
        int hijoDerecho = 2 * indiceRaiz + 2;

        if (hijoIzquierdo < n && arr[hijoIzquierdo] > arr[mayor]) {
            mayor = hijoIzquierdo;
        }

        if (hijoDerecho < n && arr[hijoDerecho] > arr[mayor]) {
            mayor = hijoDerecho;
        }

        if (mayor != indiceRaiz) {
            float cambio = arr[indiceRaiz];
            arr[indiceRaiz] = arr[mayor];
            arr[mayor] = cambio;

            heapify(arr, n, mayor);
        }
    }
}