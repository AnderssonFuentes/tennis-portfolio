package com.tenis.dominio;

import com.tenis.reglas.IReglasGame;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Representa un Game entre dos participantes.
 * Mantiene el estado (puntos) y delega la lógica de decisión a IReglasGame.
 */
public class Game {
    private final Map<Participante, Integer> puntos = new LinkedHashMap<>();
    private final IReglasGame reglas;

    public Game(Participante p1, Participante p2, IReglasGame reglas) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException("Se requieren 2 participantes");
        if (p1.equals(p2)) throw new IllegalArgumentException("Participantes deben ser distintos");
        this.puntos.put(p1, 0);
        this.puntos.put(p2, 0);
        this.reglas = reglas;
    }

    /**
     * Registra un punto para el participante indicado.
     */
    public void registrarPunto(Participante ganador) {
        if (!puntos.containsKey(ganador)) {
            throw new IllegalArgumentException("El participante no pertenece a este game");
        }
        puntos.compute(ganador, (k, v) -> v + 1);
    }

    public void registrarPunto(Participante p, TipoEstadistica evento) {
        // 1) registrar el punto normal (reutilizamos tu lógica existente)
        registrarPunto(p);

        // 2) registrar evento si aplica (simple)
        if (evento != null && p instanceof Jugador jugador) {
            jugador.getEstadisticas().registrar(evento);
        }
    }

    /**
     * Devuelve un mapa inmutable con los puntos (protege encapsulamiento).
     */
    public Map<Participante, Integer> getPuntos() {
        return Map.copyOf(puntos);
    }

    public Set<Participante> getParticipantes() {
        return puntos.keySet();
    }

    /* Delegaciones a la política de reglas */
    public boolean hayGanador() { return reglas.hayGanador(this); }

    public Participante getGanador() { return reglas.obtenerGanador(this); }

    public String puntajePara(Participante p) { return reglas.puntajePara(this, p); }
}
