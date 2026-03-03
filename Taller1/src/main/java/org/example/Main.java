package org.example;

import org.example.logica.HiloLista;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Random rn = new Random();
        for(int i = 0; i < 5000; i++) listaNumeros.add(rn.nextInt(10000));

        List<HiloLista> hilos = new ArrayList<>();

        hilos.add(new HiloLista(5000, 0, 1, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(5000, 0, 0, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(10000, 5000, 1, new ArrayList<>(), listaNumeros));
        hilos.add(new HiloLista(10000, 5000, 0, new ArrayList<>(), listaNumeros));

        hilos.forEach(Thread::start);

        int sumaTotal = 0;
        for (HiloLista hilo : hilos) {
            try {
                hilo.join();
                sumaTotal += hilo.getSumaNumerosLista();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Suma total: " + sumaTotal);
    }
}
