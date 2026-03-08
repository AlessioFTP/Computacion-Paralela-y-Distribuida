package org.paralela.distribuida.computacion.dataset;

import java.util.ArrayList;

public class Venta {
    private final Cliente comprador;
    private final ArrayList<Producto> productos;

    Venta(Cliente comprador, ArrayList<Producto> productos){
        this.comprador = comprador;
        this.productos = productos;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }

}
