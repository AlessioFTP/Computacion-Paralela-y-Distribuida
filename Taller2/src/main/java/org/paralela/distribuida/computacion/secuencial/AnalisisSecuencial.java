package org.paralela.distribuida.computacion.secuencial;

import org.paralela.distribuida.computacion.dataset.ResultadoAnalisis;
import org.paralela.distribuida.computacion.dataset.Venta;

public class AnalisisSecuencial {

    public static ResultadoAnalisis ejecutar(Venta[] ventas) {
        ResultadoAnalisis resultado = new ResultadoAnalisis();

        for (Venta ventaActual : ventas) {
            if (ventaActual != null) {
                resultado.agregarVenta(ventaActual);
            }
        }

        return resultado;
    }
}