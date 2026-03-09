package org.paralela.distribuida.computacion.paralelo;

import org.paralela.distribuida.computacion.dataset.ResultadoAnalisis;
import org.paralela.distribuida.computacion.dataset.Venta;

import java.util.concurrent.RecursiveTask;

public class AnalisisVentasParalelo extends RecursiveTask<ResultadoAnalisis> {

    private static final int UMBRAL = 100_000;

    private final Venta[] ventas;
    private final int inicio;
    private final int fin;

    public AnalisisVentasParalelo(Venta[] ventas, int inicio, int fin) {
        this.ventas = ventas;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    protected ResultadoAnalisis compute() {
        int cantidadElementos = fin - inicio;

        if (cantidadElementos <= UMBRAL) {
            return procesarSecuencialmente();
        }
        else {
            int medio = inicio + cantidadElementos / 2;

            AnalisisVentasParalelo tareaIzquierda = new AnalisisVentasParalelo(ventas, inicio, medio);
            AnalisisVentasParalelo tareaDerecha = new AnalisisVentasParalelo(ventas, medio, fin);

            tareaIzquierda.fork();

            ResultadoAnalisis resultadoDerecho = tareaDerecha.compute();

            ResultadoAnalisis resultadoIzquierdo = tareaIzquierda.join();

            resultadoIzquierdo.combinar(resultadoDerecho);

            return resultadoIzquierdo;
        }
    }

    private ResultadoAnalisis procesarSecuencialmente() {
        ResultadoAnalisis parcial = new ResultadoAnalisis();
        for (int i = inicio; i < fin; i++) {
            Venta ventaActual = ventas[i];
            if (ventaActual != null) {
                parcial.agregarVenta(ventaActual);
            }
        }
        return parcial;
    }
}