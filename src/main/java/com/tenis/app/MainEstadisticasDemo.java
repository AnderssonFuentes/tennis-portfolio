package com.tenis.app;

import com.tenis.dominio.Jugador;
import com.tenis.dominio.TipoEstadistica;

public class MainEstadisticasDemo {

    public static void main(String[] args) {

        Jugador rafa = new Jugador("Rafael Nadal");

        rafa.getEstadisticas().registrar(TipoEstadistica.ACE);
        rafa.getEstadisticas().registrar(TipoEstadistica.ACE);
        rafa.getEstadisticas().registrar(TipoEstadistica.ERROR);
        rafa.getEstadisticas().registrar(TipoEstadistica.PRIMER_SAQUE_OK);
        rafa.getEstadisticas().registrar(TipoEstadistica.PRIMER_SAQUE_FALLADO);

        System.out.println("=== Estadísticas ===");
        System.out.println(rafa.getNombre());
        System.out.println(rafa.getEstadisticas());
    }
}
