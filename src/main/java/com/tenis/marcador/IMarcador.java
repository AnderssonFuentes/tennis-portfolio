package com.tenis.marcador;

import com.tenis.dominio.Partido;

public interface IMarcador {

    void iniciarMarcador();

    void mostrarEstado(Partido partido);
}
