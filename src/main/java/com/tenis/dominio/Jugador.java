package com.tenis.dominio;

public class Jugador extends Participante {
    private RegistroEstadisticas estadisticas;

    public Jugador(String nombre) {
        super(nombre);
        this.estadisticas = new RegistroEstadisticas();
    }

    public RegistroEstadisticas getEstadisticas() { return estadisticas; }
}
