package com.tenis.dominio;

import com.tenis.reglas.IReglasSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Set {

    private final List<Game> games;
    private final IReglasSet reglas;

    public Set(IReglasSet reglas) {
        this.reglas = reglas;
        this.games = new ArrayList<>();
    }

    public void agregarGame(Game game) {
        if (game == null) throw new IllegalArgumentException("Game no puede ser nulo");
        games.add(game);
    }

    public boolean hayGanador() {
        return reglas.hayGanador(games);
    }

    public Participante getGanador() {
        return reglas.obtenerGanador(games);
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }
}
