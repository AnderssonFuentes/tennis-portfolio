package com.tenis.reglas;

import com.tenis.dominio.Game;
import com.tenis.dominio.Participante;

import java.util.List;

public interface IReglasSet {
    /**
     * Indica si existe ganador del set dado el historial de games.
     */
    boolean hayGanador(List<Game> games);

    /**
     * Devuelve el participante ganador del set (o null si no hay ganador aún).
     */
    Participante obtenerGanador(List<Game> games);
}
