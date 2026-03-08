package org.paralela.distribuida.computacion.dataset;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Dataset {

    private final String[] cedulas = new String[10000];

    private final Venta[] ventas = new Venta[5000000];

    public Dataset() {
        generarCedulas();
        generarVentas();
    }

    private void generarCedulas() {
        for (int i = 0; i < cedulas.length; i++) {
            long num = ThreadLocalRandom.current().nextLong(500000L, 10000000000L);
            cedulas[i] = String.valueOf(num);
        }
    }

    public void generarVentas(){

        String ruta = "src/main/java/org/paralela/distribuida/computacion/dataset/dataset_ventas.csv";
        File archivo = new File(ruta);

        if (archivo.exists() && archivo.isFile()) {
            System.out.println("Leido");
            leerDataset();
            return;
        }

        Producto[] productos = Producto.values();

        for(int i = 0; i < 5000000; i++){
            Cliente cliente = new Cliente(cedulas[ThreadLocalRandom.current().nextInt(0, cedulas.length)]);

            int cantidadProductos = ThreadLocalRandom.current().nextInt(1, 151);

            ArrayList<Producto> productosComprados = new ArrayList<>(cantidadProductos);

            for(int j = 0; j < cantidadProductos; j++){
                productosComprados.add(productos[ThreadLocalRandom.current().nextInt(0, productos.length)]);
            }

            Venta venta = new Venta(cliente, productosComprados);

            ventas[i] = venta;
        }

        guardarEnCSV();
        System.out.println("Guardado");
    }

    public void guardarEnCSV() {
        File archivo = new File("src/main/java/org/paralela/distribuida/computacion/dataset/dataset_ventas.csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write("Cedula,Productos");
            writer.newLine();

            for (Venta venta : ventas) {
                StringBuilder linea = new StringBuilder();

                linea.append(venta.getComprador().getCedula()).append(",");

                ArrayList<Producto> productos = venta.getProductos();
                for (int i = 0; i < productos.size(); i++) {
                    linea.append(productos.get(i).name());

                    if (i < productos.size() - 1) {
                        linea.append("|");
                    }
                }

                writer.write(linea.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    public void leerDataset() {
        File archivo = new File("src/main/java/org/paralela/distribuida/computacion/dataset/dataset_ventas.csv");

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            reader.readLine();

            int i = 0;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 2) continue;

                String cedula = partes[0];
                String productosString = partes[1];

                Cliente cliente = new Cliente(cedula);

                String[] nombresProductos = productosString.split("\\|");
                ArrayList<Producto> productosComprados = new ArrayList<>();

                for (String nombre : nombresProductos) {
                    try {
                        productosComprados.add(Producto.valueOf(nombre));
                    } catch (IllegalArgumentException ignored) {
                    }
                }
                ventas[i++] = new Venta(cliente, productosComprados);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Venta[] getVentas() {
        return ventas;
    }

}