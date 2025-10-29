package com.tenis.reglas;

import com.tenis.dominio.Game;
import com.tenis.dominio.Participante;

import java.util.Iterator;
import java.util.Map;

/**
 * Reglas clásicas de un game de tenis:
 * - 0 -> "0", 1 -> "15", 2 -> "30", 3 -> "40"
 * - Si ambos >= 3: "Deuce" (empate) o "Ventaja"
 * - Ganador: >=4 y diferencia >=2
 */
public class ReglasClasicasGame implements IReglasGame {

    @Override
    public boolean hayGanador(Game game) {
        return obtenerGanador(game) != null;
    }

    @Override
    public Participante obtenerGanador(Game game) {
        Map<Participante, Integer> puntos = game.getPuntos();
        if (puntos.size() < 2) return null;

        Iterator<Map.Entry<Participante,Integer>> it = puntos.entrySet().iterator();
        Map.Entry<Participante,Integer> e1 = it.next();
        Map.Entry<Participante,Integer> e2 = it.next();

        int a = e1.getValue();
        int b = e2.getValue();

        if ((a >= 4 || b >= 4) && Math.abs(a - b) >= 2) {
            return a > b ? e1.getKey() : e2.getKey();
        }
        return null;
    }

    @Override
    public String puntajePara(Game game, Participante participante) {
        Map<Participante, Integer> puntos = game.getPuntos();
        Integer p = puntos.get(participante);
        if (p == null) return "0";

        // obtener otro participante (suponente 2 jugadores)
        Iterator<Map.Entry<Participante,Integer>> it = puntos.entrySet().iterator();
        Map.Entry<Participante,Integer> e1 = it.next();
        Map.Entry<Participante,Integer> e2 = it.next();
        int a = e1.getValue();
        int b = e2.getValue();
        int other = (participante.equals(e1.getKey())) ? b : a;

        // Si ambos >=3 -> Deuce / Ventaja
        if (a >= 3 && b >= 3) {
            if (a == b) return "Deuce";
            // el que tenga más puntos tiene "Ventaja"
            return (p > other) ? "Ventaja" : "40";
        }

        return switch (p) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> Integer.toString(p);
        };
    }
}
