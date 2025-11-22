package com.tenis.reglas;

import com.tenis.dominio.Participante;

public class ReglasClasicasTieBreak implements IReglasTieBreak {

    @Override
    public Participante definirGanadorTieBreak(Participante p1, int puntosP1,
                                               Participante p2, int puntosP2) {
        // Regla básica: gana quien tenga >= 7 y diferencia >= 2
        if (puntosP1 >= 7 && (puntosP1 - puntosP2) >= 2) return p1;
        if (puntosP2 >= 7 && (puntosP2 - puntosP1) >= 2) return p2;
        return null;
    }
}
