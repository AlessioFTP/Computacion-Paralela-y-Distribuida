package org.example;

import org.example.logica.HiloLista;
import org.example.logica.ListaSecuencial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.gc();
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Random rn = new Random();
        for(int i = 0; i < 5000; i++) listaNumeros.add(rn.nextInt(10000));

        List<HiloLista> hilos = new ArrayList<>();

        hilos.add(new HiloLista(5000, 0, 1, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(5000, 0, 0, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(10000, 5000, 1, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(10000, 5000, 0, new ArrayList<>(), listaNumeros));

        List<ListaSecuencial> secuenciales = new ArrayList<>();
        secuenciales.add(new ListaSecuencial(5000, 0, 1, new ArrayList<>(), listaNumeros));
        secuenciales.add(new ListaSecuencial(5000, 0, 0, new ArrayList<>(), listaNumeros));
        secuenciales.add(new ListaSecuencial(10000, 5000, 1, new ArrayList<>(), listaNumeros));
        secuenciales.add(new ListaSecuencial(10000, 5000, 0, new ArrayList<>(), listaNumeros));

        hilos.forEach(Thread::start);

        int sumaTotalParalelo = 0;
        long tiempoInicioParalelo = System.nanoTime();

        for (HiloLista hilo : hilos) {
            try {
                hilo.join();
                sumaTotalParalelo += hilo.getSumaNumerosLista();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sumaTotalParalelo += 5000;

        long tiempoFinParalelo = System.nanoTime();
        long tiempoTotalParalelo = tiempoFinParalelo - tiempoInicioParalelo;
        System.out.println("Suma total: " + sumaTotalParalelo);
        System.out.println("Tiempo total: " + tiempoTotalParalelo + " nanosegundos");
        System.out.println();

        int sumaTotalSecuencial = 0;
        long tiempoInicioSecuencial = System.nanoTime();
        for (ListaSecuencial sec : secuenciales) {
            sec.empezarMapeoSublistas();
            sumaTotalSecuencial += sec.getSumaNumerosLista();
        }
        sumaTotalSecuencial += 5000;
        long tiempoFinalSecuencial = System.nanoTime();
        long tiempoTotalSecuencial = tiempoFinalSecuencial - tiempoInicioSecuencial;

        double mejoraTiempoPorcentual = ((double)(tiempoTotalSecuencial - tiempoTotalParalelo) / tiempoTotalSecuencial) * 100;
        System.out.println("Suma total en secuencial: " + sumaTotalSecuencial);
        System.out.println("Tiempo total en secuencial: " + tiempoTotalSecuencial + " nanosegundos");
        System.out.println();

        System.out.println("La diferencia porcentual de tiempo de ejecución secuencial frente al paralelo es de: " + String.format("%.2f", mejoraTiempoPorcentual) + "%");

    }
}
