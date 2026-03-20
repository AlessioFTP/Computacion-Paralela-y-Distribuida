package org.paralela.distribuida.computacion;

import org.paralela.distribuida.computacion.recursivo.TareaAsincrona;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        System.out.println("Empezando las tareas asíncronas");

        TareaAsincrona descargaDatosUsuarios = new TareaAsincrona("Descargar datos de usuarios", ThreadLocalRandom.current().nextInt(1000, 10000));
        TareaAsincrona procesoDeInformacion = new TareaAsincrona("Procesar información", ThreadLocalRandom.current().nextInt(1000, 10000));
        TareaAsincrona consultaEstadoServicioExterno = new TareaAsincrona("Consultar estado de un servicio externo", ThreadLocalRandom.current().nextInt(1000, 10000));

        long tiempoInicio = System.currentTimeMillis();

        descargaDatosUsuarios.fork();
        procesoDeInformacion.fork();
        consultaEstadoServicioExterno.fork();

        System.out.println("El programa no se está deteniendo mientras se realizan las tareas." + "\n");

        String resutladoTarea1 = descargaDatosUsuarios.join();
        System.out.println("Finalizada " + resutladoTarea1 + "\n");

        String resutladoTarea2 = procesoDeInformacion.join();
        System.out.println("Finalizada " + resutladoTarea2 + "\n");

        String resutladoTarea3 = consultaEstadoServicioExterno.join();
        System.out.println("Finalizada " + resutladoTarea3 + "\n");

        long tiempoFinal = System.currentTimeMillis() - tiempoInicio;

        System.out.println("Todas las tareas han finalizado con un tiempo de: " + tiempoFinal);

        pool.close();
    }
}