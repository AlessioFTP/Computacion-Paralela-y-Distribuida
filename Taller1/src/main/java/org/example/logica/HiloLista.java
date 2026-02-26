package org.example.logica;

import java.util.ArrayList;

public class HiloLista extends Thread{
    private final int limiteSuperior;
    private final int limiteInferior;
    private final int resultadoModulo; // 0 si es par, 1 si es impar
    private int sumaNumerosLista = 0;
    private final ArrayList<Integer> sublista;
    private final ArrayList<Integer> lista;

    public HiloLista (int limiteSuperior, int limiteInferior, int resultadoModulo,ArrayList<Integer> sublista, ArrayList<Integer> lista){
        this.limiteSuperior = limiteSuperior;
        this.limiteInferior = limiteInferior;
        this.resultadoModulo = resultadoModulo;
        this.sublista = sublista;
        this.lista = lista;
    }

    public int getSumaNumerosLista(){
        return sumaNumerosLista;
    }

    @Override
    public void run(){
        for (Integer numero : lista) {
            if (numero >= limiteInferior && numero < limiteSuperior && numero % 2 == resultadoModulo) {
                sublista.add(numero);
                sumaNumerosLista += numero;
            }
        }
    }
}
