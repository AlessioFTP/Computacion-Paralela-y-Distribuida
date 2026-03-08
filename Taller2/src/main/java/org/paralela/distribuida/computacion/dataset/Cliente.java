package org.paralela.distribuida.computacion.dataset;

public class Cliente {
    private final String cedula;

    Cliente(String cedula){
        this.cedula = cedula;
    }

    public String getCedula(){ return cedula;}
}
