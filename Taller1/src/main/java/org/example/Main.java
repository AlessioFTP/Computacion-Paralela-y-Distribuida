package org.example;

import org.example.logica.HiloLista;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        int sumaTotal = 0;

        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listaImparesMenorQue5000 = new ArrayList<>();
        ArrayList<Integer> listaParesMenorQue5000 = new ArrayList<>();
        ArrayList<Integer> listaImparesMayorQue5000 = new ArrayList<>();
        ArrayList<Integer> listaParesMayorQue5000 = new ArrayList<>();

        Random rn = new Random();
        for(int i = 0; i < 5000; i++){
            lista.add(rn.nextInt(10000));
        }

        HiloLista hiloImparMenor5000 = new HiloLista(5000, 0, 1, listaImparesMenorQue5000, lista);
        HiloLista hiloParMenor5000 = new HiloLista(5000, 0, 0, listaParesMenorQue5000, lista);
        HiloLista hiloImparMayor5000 = new HiloLista(10000, 5000, 1, listaImparesMayorQue5000, lista);
        HiloLista hiloParMayor5000 = new HiloLista(10000, 5000, 0, listaParesMayorQue5000, lista);

        hiloImparMenor5000.start();
        hiloParMenor5000.start();
        hiloImparMayor5000.start();
        hiloParMayor5000.start();

        try{
            hiloImparMenor5000.join();
            hiloParMenor5000.join();
            hiloImparMayor5000.join();
            hiloParMayor5000.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        sumaTotal += 5000
                + hiloImparMenor5000.getSumaNumerosLista()
                + hiloParMenor5000.getSumaNumerosLista()
                + hiloImparMayor5000.getSumaNumerosLista()
                + hiloParMayor5000.getSumaNumerosLista();

        mostrarResultado(1, 0, listaImparesMenorQue5000);
        mostrarResultado(0, 0, listaParesMenorQue5000);
        mostrarResultado(1, 1, listaImparesMayorQue5000);
        mostrarResultado(0, 1, listaParesMayorQue5000);

        System.out.println();
        System.out.println("Suma total de las listas: " + sumaTotal);

    }

    public static void mostrarResultado(int indiceTipoDeLista, int indiceLimiteDeLista, ArrayList<Integer> lista){
        String[] tipoDeLista = {"pares", "impares"};
        String[] limitesDeLista = {"mayores o iguales a 0 y menores a 5000:", "mayores o iguales a 5000 y menores a 10000:" };

        System.out.println();
        System.out.println("Lista de los números " + tipoDeLista[indiceTipoDeLista] + " " + limitesDeLista[indiceLimiteDeLista]);
        System.out.println(lista);
    }

}
