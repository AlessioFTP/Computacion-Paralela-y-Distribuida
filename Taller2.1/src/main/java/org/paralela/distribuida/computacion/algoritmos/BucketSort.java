package org.paralela.distribuida.computacion.algoritmos;

public class BucketSort {

    public static void sort(float[] arr) {
        int n = arr.length;
        if (n <= 1) return;

        int[] conteoBuckets = new int[n];
        for (float num : arr) {
            int indiceBuckets = (int) (num * n);
            if (indiceBuckets >= n) indiceBuckets = n - 1;
            conteoBuckets[indiceBuckets]++;
        }

        float[][] buckets = new float[n][];
        for (int i = 0; i < n; i++) {
            buckets[i] = new float[conteoBuckets[i]];
        }

        int[] indicesActuales = new int[n];
        for (float num : arr) {
            int indiceBuckets = (int) (num * n);
            if (indiceBuckets >= n) indiceBuckets = n - 1;
            buckets[indiceBuckets][indicesActuales[indiceBuckets]] = num;
            indicesActuales[indiceBuckets]++;
        }

        for (int i = 0; i < n; i++) {
            if (buckets[i].length > 0) {
                InsertionSort.sort(buckets[i]);
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }
}