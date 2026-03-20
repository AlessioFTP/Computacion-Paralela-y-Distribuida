package org.paralela.distribuida.computacion.recursivo;

import java.util.concurrent.RecursiveTask;

public class TareaAsincrona extends RecursiveTask<String> {

    private final String nombre;
    private final Integer tiempo;

    public TareaAsincrona(String nombre, Integer tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    @Override
    protected String compute(){
        try{
            Thread.sleep(tiempo);
            return "Resultado de: " + nombre + ", la cual demoró: " + tiempo;

        }catch (InterruptedException e){
            return "Error: " + e;
        }
    }
}
