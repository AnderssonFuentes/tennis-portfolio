package com.tenis.dominio;

public class Equipo extends Participante {
    private Jugador[] jugadores = new Jugador[2];

    public Equipo(String nombre, Jugador jugador1, Jugador jugador2) {
        super(nombre);
        this.jugadores[0] = jugador1;
        this.jugadores[1] = jugador2;
    }

    public Jugador[] getJugadores() { return jugadores; }
}
