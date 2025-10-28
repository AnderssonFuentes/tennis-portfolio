package com.tenis.app;

import com.tenis.dominio.*;

public class MainDomainDemo {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Roger Federer");
        Jugador j2 = new Jugador("Rafael Nadal");

        // Simular estadísticas
        j1.getEstadisticas().registrarAce();
        j1.getEstadisticas().registrarAce();
        j1.getEstadisticas().registrarError();

        j2.getEstadisticas().registrarPrimerSaque(true);
        j2.getEstadisticas().registrarPrimerSaque(false);
        j2.getEstadisticas().registrarError();

        System.out.println("=== Estadísticas ===");
        System.out.println(j1.getNombre() + " -> " + j1.getEstadisticas());
        System.out.println(j2.getNombre() + " -> " + j2.getEstadisticas());

        // Equipo ejemplo
        Jugador j3 = new Jugador("Novak Djokovic");
        Jugador j4 = new Jugador("Andy Murray");
        Equipo equipo = new Equipo("Dream Team", j3, j4);
        System.out.println("\nEquipo: " + equipo.getNombre());
        for (Jugador j : equipo.getJugadores()) System.out.println(" - " + j.getNombre());
    }
}
