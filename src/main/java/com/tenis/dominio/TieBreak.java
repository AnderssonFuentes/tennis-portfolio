package com.tenis.dominio;

import com.tenis.reglas.IReglasTieBreak;

import java.util.HashMap;
import java.util.Map;

public class TieBreak {

    private final Participante p1;
    private final Participante p2;
    private final Map<Participante, Integer> puntos = new HashMap<>();
    private final IReglasTieBreak reglas;

    public TieBreak(Participante p1, Participante p2, IReglasTieBreak reglas) {
        this.p1 = p1;
        this.p2 = p2;
        this.reglas = reglas;
        puntos.put(p1, 0);
        puntos.put(p2, 0);
    }

    public void ganarPunto(Participante jugador) {
        if (!puntos.containsKey(jugador)) throw new IllegalArgumentException("Jugador no participa en este tie-break");
        puntos.put(jugador, puntos.get(jugador) + 1);
    }

    public Participante obtenerGanador() {
        return reglas.definirGanadorTieBreak(p1, puntos.get(p1), p2, puntos.get(p2));
    }

    public int puntosDe(Participante jugador) {
        return puntos.getOrDefault(jugador, 0);
    }

    public Map<Participante, Integer> getPuntos() {
        return new HashMap<>(puntos);
    }
}
 