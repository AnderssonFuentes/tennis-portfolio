/*package com.tenis.dominio;

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
}*/
package com.tenis.dominio;

import com.tenis.reglas.IReglasSet;
import com.tenis.reglas.IReglasTieBreak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Set {

    private final List<Game> games;
    private final IReglasSet reglas;
    private TieBreak tieBreak; // null si no hay tie-break activo
    private final Participante participante1;
    private final Participante participante2;
    private boolean terminado = false;

    // Constructor original (sin participantes explícitos)
    public Set(IReglasSet reglas) {
        this(reglas, null, null);
    }

    // Nuevo constructor para pasar participantes (útil para tie-break)
    public Set(IReglasSet reglas, Participante p1, Participante p2) {
        this.reglas = reglas;
        this.games = new ArrayList<>();
        this.participante1 = p1;
        this.participante2 = p2;
        this.tieBreak = null;
    }

    public void agregarGame(Game game) {
        if (game == null) throw new IllegalArgumentException("Game no puede ser nulo");
        games.add(game);
        // luego de agregar un game evaluamos si el set terminó normalmente
        if (reglas.hayGanador(games)) {
            terminado = true;
        }
        // no auto-iniciamos tie-break: se ofrece método explícito iniciarTieBreak()
    }

    public boolean hayGanador() {
        // si hay ganador por conteo de games
        if (reglas.hayGanador(games)) return true;
        // si tie-break activo y tiene ganador
        if (tieBreak != null && tieBreak.obtenerGanador() != null) return true;
        return false;
    }

    public Participante getGanador() {
        // si set decidido por games
        if (reglas.hayGanador(games)) {
            return reglas.obtenerGanador(games);
        }
        // si tie-break existió y tiene ganador, retornar ese ganador
        if (tieBreak != null) {
            return tieBreak.obtenerGanador();
        }
        return null;
    }

    public List<Game> getGames() {
        return Collections.unmodifiableList(games);
    }

    /**
     * Comprueba si el set está en situación de 6-6 y por tanto necesita tie-break.
     * No inicia automáticamente el tie-break: devuelve true para que el caller lo haga.
     */
    public boolean necesitaTieBreak() {
        // conteo sencillo: asumimos que reglas y games están consistentes
        int contador1 = 0;
        int contador2 = 0;
        for (Game g : games) {
            if (g.hayGanador()) {
                Participante ganador = g.getGanador();
                if (ganador.equals(participante1)) contador1++;
                else if (ganador.equals(participante2)) contador2++;
            }
        }
        return contador1 == 6 && contador2 == 6;
    }

    /**
     * Inicia un tie-break si no existe y si ya conocemos participantes.
     */
    public void iniciarTieBreak(IReglasTieBreak reglasTieBreak) {
        if (tieBreak != null) return; // ya iniciado
        if (participante1 == null || participante2 == null) {
            throw new IllegalStateException("No se conocen participantes para iniciar tie-break");
        }
        this.tieBreak = new TieBreak(participante1, participante2, reglasTieBreak);
    }

    /**
     * Registra un punto en el tie-break (debe haber sido iniciado).
     * Devuelve true si con ese punto el tie-break terminó y por tanto el set también.
     */
    public boolean registrarPuntoTieBreak(Participante jugador) {
        if (tieBreak == null) throw new IllegalStateException("TieBreak no iniciado");
        tieBreak.ganarPunto(jugador);
        Participante ganadorTB = tieBreak.obtenerGanador();
        if (ganadorTB != null) {
            // opción simple: marcar set como terminado (ganador determinado por tie-break)
            terminado = true;
            return true;
        }
        return false;
    }

    public TieBreak getTieBreak() {
        return tieBreak;
    }
}
