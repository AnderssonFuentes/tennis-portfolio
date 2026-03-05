package com.tenis.dominio;

import com.tenis.reglas.IReglasGame;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Game {
    private final Map<Participante, Integer> puntos = new LinkedHashMap<>();
    private final IReglasGame reglas;
    private final Participante servidor;

    public Game(Participante p1, Participante p2, Participante servidor, IReglasGame reglas) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException("Se requieren 2 participantes");
        if (p1.equals(p2)) throw new IllegalArgumentException("Participantes deben ser distintos");
        if (reglas == null) throw new IllegalArgumentException("Reglas requeridas");

        if (servidor == null) throw new IllegalArgumentException("Servidor requerido");
        if (!servidor.equals(p1) && !servidor.equals(p2)) {
            throw new IllegalArgumentException("Servidor debe ser uno de los participantes");
        }

        this.puntos.put(p1, 0);
        this.puntos.put(p2, 0);

        this.servidor = servidor;
        this.reglas = reglas;
    }

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

    public Map<Participante, Integer> getPuntos() {
        return Map.copyOf(puntos);
    }

    public Set<Participante> getParticipantes() {
        return puntos.keySet();
    }

    public Participante getServidor() { return servidor; }

    public boolean hayGanador() { return reglas.hayGanador(this); }

    public Participante getGanador() { return reglas.obtenerGanador(this); }

    public String puntajePara(Participante p) { return reglas.puntajePara(this, p); }
}
