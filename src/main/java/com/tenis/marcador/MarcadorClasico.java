package com.tenis.marcador;

import com.tenis.dominio.Partido;

public class MarcadorClasico implements IMarcador {

    @Override
    public void iniciarMarcador() {
        System.out.println("=== Marcador Clásico ===");
    }

    @Override
    public void mostrarEstado(Partido partido) {
        if (partido == null) {
            System.out.println("[Marcador] Partido no disponible.");
            return;
        }

        int setsJugados = partido.getSets().size();
        var p1 = partido.getParticipante1();
        var p2 = partido.getParticipante2();

        int setsP1 = partido.setsGanadosPor(p1);
        int setsP2 = partido.setsGanadosPor(p2);

        System.out.println("\n--- Marcador (Clásico) ---");
        System.out.println("Sets jugados: " + setsJugados);
        System.out.println("Sets ganados: " + p1.getNombre() + " " + setsP1 + " - " + setsP2 + " " + p2.getNombre());

        boolean hayGanador = partido.hayGanador();
        System.out.println("¿Hay ganador del partido?: " + hayGanador);

        if (hayGanador) {
            var g = partido.getGanador();
            System.out.println("Ganador del partido: " + (g != null ? g.getNombre() : "N/A"));
        }
    }
}
