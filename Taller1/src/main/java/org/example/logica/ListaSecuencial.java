package org.example.logica;

import java.util.ArrayList;

public class ListaSecuencial {
    private final int limiteSuperior;
    private final int limiteInferior;
    private final int resultadoModulo; // 0 si es par, 1 si es impar
    private int sumaNumerosLista = 0;
    private long tiempoEjecucion;
    private final ArrayList<Integer> sublista;
    private final ArrayList<Integer> lista;

    public ListaSecuencial (int limiteSuperior, int limiteInferior, int resultadoModulo,ArrayList<Integer> sublista, ArrayList<Integer> lista){
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.resultadoModulo = resultadoModulo;
        this.sublista = sublista;
        this.lista = lista;
    }

    public int getSumaNumerosLista(){ return sumaNumerosLista;}

    public long getTiempoEjecucion(){ return tiempoEjecucion;}

    //public ArrayList<Integer> getSublista(){ return sublista;} Des comentar si se requiere saber cúal fue la sublista que se creó

    public void empezarMapeoSublistas(){
        long inicioTiempo = System.nanoTime();
        for (Integer numero : lista) {
            if (numero >= limiteInferior && numero < limiteSuperior && numero % 2 == resultadoModulo) {
                sublista.add(numero);
                sumaNumerosLista += numero;
            }
        }
        long finalTiempo = System.nanoTime();
        tiempoEjecucion = finalTiempo - inicioTiempo;
        String[] tipoDeLista = {"pares", "impares"};
        System.out.println("La lista de números " + tipoDeLista[resultadoModulo] + " con números entre " + limiteInferior + " y " + (limiteSuperior - 1) + ", duró " + tiempoEjecucion + " nanosegundos.");
    }
}
