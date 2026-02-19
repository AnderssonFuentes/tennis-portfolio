package com.tenis.marcador;

import com.tenis.dominio.Participante;
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
        System.out.println("\n--- Estado del Partido ---");
        System.out.println("Sets jugados: " + setsJugados);
        System.out.println("¿Hay ganador del partido?: " + partido.hayGanador());

        if (partido.hayGanador()) {
            Participante g = partido.getGanador();
            System.out.println("Ganador del partido: " + (g != null ? g.getNombre() : "N/A"));
        }
    }
}
