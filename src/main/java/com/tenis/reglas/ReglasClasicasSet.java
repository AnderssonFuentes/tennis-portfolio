package com.tenis.reglas;

import com.tenis.dominio.Game;
import com.tenis.dominio.Participante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReglasClasicasSet implements IReglasSet {

    @Override
    public boolean hayGanador(List<Game> games) {
        Map<Participante, Integer> contador = contarGamesGanados(games);
        // Requerimos 6 games y diferencia >= 2
        for (Entry<Participante, Integer> e : contador.entrySet()) {
            int ganados = e.getValue();
            if (ganados >= 6) {
                int opos = puntajeOponente(e.getKey(), contador);
                if (Math.abs(ganados - opos) >= 2) return true;
            }
        }
        return false;
    }

    @Override
    public Participante obtenerGanador(List<Game> games) {
        Map<Participante, Integer> contador = contarGamesGanados(games);
        return contador.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    private Map<Participante, Integer> contarGamesGanados(List<Game> games) {
        Map<Participante, Integer> contador = new HashMap<>();
        for (Game g : games) {
            if (g.hayGanador()) {
                Participante ganador = g.getGanador();
                if (ganador != null) {
                    contador.put(ganador, contador.getOrDefault(ganador, 0) + 1);
                }
            }
        }
        return contador;
    }

    private int puntajeOponente(Participante p, Map<Participante, Integer> mapa) {
        for (Entry<Participante, Integer> e : mapa.entrySet()) {
            if (!e.getKey().equals(p)) return e.getValue();
        }
        return 0;
    }
}
