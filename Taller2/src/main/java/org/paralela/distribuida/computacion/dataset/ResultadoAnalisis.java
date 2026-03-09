package org.paralela.distribuida.computacion.dataset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ResultadoAnalisis {

    private long totalVentas = 0;

    private final Set<String> clientesUnicos = new HashSet<>();

    private final Map<Producto, Integer> conteoProductos = new HashMap<>();

    public void agregarVenta(Venta venta) {
        if (venta == null) return;

        this.totalVentas++;

        if (venta.getComprador() != null) {
            this.clientesUnicos.add(venta.getComprador().getCedula());
        }

        if (venta.getProductos() != null) {
            for (Producto producto : venta.getProductos()) {
                this.conteoProductos.put(
                        producto,
                        this.conteoProductos.getOrDefault(producto, 0) + 1
                );
            }
        }
    }

    public void combinar(ResultadoAnalisis otro) {
        if (otro == null) return;

        this.totalVentas += otro.totalVentas;

        this.clientesUnicos.addAll(otro.clientesUnicos);

        for (Map.Entry<Producto, Integer> entrada : otro.conteoProductos.entrySet()) {
            Producto producto = entrada.getKey();
            int cantidadAdicional = entrada.getValue();

            this.conteoProductos.put(
                    producto,
                    this.conteoProductos.getOrDefault(producto, 0) + cantidadAdicional
            );
        }
    }

    public long getTotalVentas() {
        return totalVentas;
    }

    public int getNumeroClientesUnicos() {
        return clientesUnicos.size();
    }

    public Producto getProductoMasVendido() {
        Producto masVendido = null;
        int maxCantidad = -1;

        for (Map.Entry<Producto, Integer> entrada : conteoProductos.entrySet()) {
            if (entrada.getValue() > maxCantidad) {
                maxCantidad = entrada.getValue();
                masVendido = entrada.getKey();
            }
        }

        return masVendido;
    }

    public int getCantidadProductoMasVendido() {
        Producto p = getProductoMasVendido();
        return p != null ? conteoProductos.get(p) : 0;
    }
}