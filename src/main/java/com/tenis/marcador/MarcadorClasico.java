package com.tenis.marcador;

import com.tenis.dominio.*;

import java.util.List;

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

        Participante p1 = partido.getParticipante1();
        Participante p2 = partido.getParticipante2();

        int setsJugados = partido.getSets().size();
        int setsP1 = partido.setsGanadosPor(p1);
        int setsP2 = partido.setsGanadosPor(p2);

        System.out.println("\n--- Marcador (Clásico) ---");
        System.out.println("Sets jugados: " + setsJugados);
        System.out.println("Sets ganados: " + p1.getNombre() + " " + setsP1 + " - " + setsP2 + " " + p2.getNombre());

        boolean hayGanador = partido.hayGanador();
        System.out.println("¿Hay ganador del partido?: " + hayGanador);

        if (hayGanador) {
            Participante g = partido.getGanador();
            System.out.println("Ganador del partido: " + (g != null ? g.getNombre() : "N/A"));
        }

        // ===== Micro-avance #3: Set actual + TieBreak (solo lectura) =====
        List<Set> sets = partido.getSets();

        System.out.println("\n[Set actual]");
        if (sets.isEmpty()) {
            System.out.println("Aún no hay sets agregados al partido.");
            return;
        }

        Set setActual = sets.get(sets.size() - 1);
        System.out.println("Games jugados en este set: " + setActual.getGames().size());

        int gamesP1 = 0;
        int gamesP2 = 0;

        for (Game g : setActual.getGames()) {
            if (g.hayGanador()) {
                Participante ganadorGame = g.getGanador();

                if (ganadorGame != null && ganadorGame.equals(p1)) {
                    gamesP1++;
                } else if (ganadorGame != null && ganadorGame.equals(p2)) {
                    gamesP2++;
                }
            }
        }

        System.out.println("Games ganados en este set: "
                + p1.getNombre() + " " + gamesP1
                + " - "
                + gamesP2 + " " + p2.getNombre());

        // --- Micro #5: Game score (solo lectura, KISS) ---
        if (!setActual.getGames().isEmpty()) {
            Game gameActual = setActual.getGames().get(setActual.getGames().size() - 1);

            if (gameActual.hayGanador()) {
                Participante ganador = gameActual.getGanador();
                System.out.println("Game actual: TERMINADO (ganó " + ganador.getNombre() + ")");
            } else {
                String p1Score = gameActual.puntajePara(p1);
                String p2Score = gameActual.puntajePara(p2);

                System.out.println("Game actual: " + p1Score + " - " + p2Score);
            }
        } else {
            System.out.println("Game actual: Aún no hay games en el set actual.");
        }

        TieBreak tb = setActual.getTieBreak();

        if (tb != null) {
            System.out.println("TieBreak activo: SI");
            int tbP1 = tb.puntosDe(p1);
            int tbP2 = tb.puntosDe(p2);
            System.out.println("TieBreak: " + p1.getNombre() + " " + tbP1 + " - " + tbP2 + " " + p2.getNombre());
        } else {
            System.out.println("TieBreak activo: NO");
        }
    }
}