package com.tenis.reglas;

import com.tenis.dominio.Participante;

public interface IReglasTieBreak {
    /**
     * Devuelve el ganador del tie-break si existe (null si aún no hay ganador).
     */
    Participante definirGanadorTieBreak(Participante p1, int puntosP1,
                                        Participante p2, int puntosP2);
}
