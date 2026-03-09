package org.paralela.distribuida.computacion;

import org.paralela.distribuida.computacion.dataset.Dataset;
import org.paralela.distribuida.computacion.dataset.ResultadoAnalisis;

import org.paralela.distribuida.computacion.secuencial.AnalisisSecuencial;
import org.paralela.distribuida.computacion.paralelo.AnalisisVentasParalelo;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cargando dataset");

        Dataset dataset = new Dataset();
        System.out.println("Dataset cargado\n");

        System.gc();

        System.out.println("Iniciando procesamiento SECUENCIAL");
        long inicioSecuencial = System.nanoTime();

        ResultadoAnalisis resultadoSecuencial = AnalisisSecuencial.ejecutar(dataset.getVentas());

        long finSecuencial = System.nanoTime();
        long tiempoSecuencial = (finSecuencial - inicioSecuencial) / 1_000_000;

        System.out.println("========== Resultados Secuenciales ==========");
        System.out.println("Total ventas: " + resultadoSecuencial.getTotalVentas());
        System.out.println("Clientes únicos: " + resultadoSecuencial.getNumeroClientesUnicos());
        System.out.println("Producto más vendido: " + resultadoSecuencial.getProductoMasVendido().getNombre() + " (" + resultadoSecuencial.getCantidadProductoMasVendido() + " unidades)");
        System.out.println("Tiempo Secuencial: " + tiempoSecuencial + " ms\n");


        System.gc();

        System.out.println("Iniciando procesamiento PARALELO");
        long inicioParalelo = System.nanoTime();

        ForkJoinPool pool = new ForkJoinPool();

        AnalisisVentasParalelo tareaRaiz = new AnalisisVentasParalelo(dataset.getVentas(), 0, dataset.getVentas().length);

        ResultadoAnalisis resultadoParalelo = pool.invoke(tareaRaiz);

        pool.close();

        long finParalelo = System.nanoTime();
        long tiempoParalelo = (finParalelo - inicioParalelo) / 1_000_000;

        System.out.println("========== Resultados Paralelos ==========");
        System.out.println("Total ventas: " + resultadoParalelo.getTotalVentas());
        System.out.println("Clientes únicos: " + resultadoParalelo.getNumeroClientesUnicos());
        System.out.println("Producto más vendido: " + resultadoParalelo.getProductoMasVendido().getNombre() + " (" + resultadoParalelo.getCantidadProductoMasVendido() + " unidades)");
        System.out.println("Tiempo Paralelo: " + tiempoParalelo + " ms\n");

        System.out.println("Tiempo Secuencial : " + tiempoSecuencial + " ms");
        System.out.println("Tiempo Paralelo   : " + tiempoParalelo + " ms");

        double mejoraTiempoPorcentual = ((double)(tiempoSecuencial - tiempoParalelo) / tiempoSecuencial) * 100;
        System.out.println("La diferencia porcentual de tiempo de ejecución secuencial frente al paralelo es de: " + String.format("%.2f", mejoraTiempoPorcentual) + "%");

    }
}