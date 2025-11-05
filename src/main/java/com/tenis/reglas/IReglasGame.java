package com.tenis.reglas;

import com.tenis.dominio.Game;
import com.tenis.dominio.Participante;

/**
 * Contrato para políticas de puntuación de un Game.
 */
public interface IReglasGame {
    /**
     * Indica si según la política ya hay ganador del game.
     */
    boolean hayGanador(Game game);

    /**
     * Devuelve el ganador si lo hay, o null si aún no hay ganador.
     */
    Participante obtenerGanador(Game game);

    /**
     * Devuelve la representación textual del puntaje (ej: "15", "40", "Deuce", "Ventaja").
     */
    String puntajePara(Game game, Participante participante);
}
