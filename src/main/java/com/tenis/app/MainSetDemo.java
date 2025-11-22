/*
package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Jugador;
import com.tenis.dominio.Participante;
import com.tenis.reglas.IReglasGame;
import com.tenis.reglas.IReglasSet;
import com.tenis.reglas.ReglasClasicasGame;
import com.tenis.reglas.ReglasClasicasSet;

public class MainSetDemo {

    public static void main(String[] args) {
        // Participantes
        Jugador rafa = new Jugador("Rafael Nadal");
        Jugador roger = new Jugador("Roger Federer");

        // Regla para games (usa las reglas que ya implementaste para Game)
        IReglasGame reglasGame = new ReglasClasicasGame();

        // Creamos un set con las reglas clásicas de set
        IReglasSet reglasSet = new ReglasClasicasSet();
        Set set = new Set(reglasSet);

        // Simulamos 6 games: por ejemplo, Rafa gana 6 - 4
        // Para cada game creamos la instancia y le damos puntos hasta que haya ganador
        for (int i = 0; i < 6; i++) {
            Game game = new Game(rafa, roger, reglasGame);
            // Simulamos puntos: en este demo Rafa gana 4 puntos seguidos
            while (!game.hayGanador()) {
                game.registrarPunto(rafa);
            }
            set.agregarGame(game);
        }

        // Añadimos 4 games ganados por Roger (para simular 6-4)
        for (int i = 0; i < 4; i++) {
            Game game = new Game(rafa, roger, reglasGame);
            while (!game.hayGanador()) {
                game.registrarPunto(roger);
            }
            set.agregarGame(game);
        }

        System.out.println("Total de games en set: " + set.getGames().size());
        System.out.println("¿Hay ganador del set? " + set.hayGanador());
        if (set.hayGanador()) {
            Participante ganador = set.getGanador();
            System.out.println("Ganador del set: " + (ganador != null ? ganador.getNombre() : "N/A"));
        } else {
            System.out.println("Aún no hay ganador del set.");
        }
    }
}
*/
package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Jugador;
import com.tenis.dominio.Participante;
import com.tenis.dominio.Set;
import com.tenis.reglas.IReglasGame;
import com.tenis.reglas.IReglasSet;
import com.tenis.reglas.IReglasTieBreak;
import com.tenis.reglas.ReglasClasicasGame;
import com.tenis.reglas.ReglasClasicasSet;
import com.tenis.reglas.ReglasClasicasTieBreak;

public class MainSetDemo {

    public static void main(String[] args) {

        // Participantes
        Jugador rafa = new Jugador("Rafael Nadal");
        Jugador roger = new Jugador("Roger Federer");

        // Reglas
        IReglasGame reglasGame = new ReglasClasicasGame();
        IReglasSet reglasSet = new ReglasClasicasSet();
        IReglasTieBreak reglasTieBreak = new ReglasClasicasTieBreak();

        // Creamos un Set especificando los jugadores (importante para TieBreak)
        Set set = new Set(reglasSet, rafa, roger);

        System.out.println("=== Simulación del Set ===");

        // Simulamos que cada jugador gana 6 games → 6-6
        for (int i = 0; i < 6; i++) {
            Game g1 = new Game(rafa, roger, reglasGame);
            while (!g1.hayGanador()) g1.registrarPunto(rafa);
            set.agregarGame(g1);

            Game g2 = new Game(rafa, roger, reglasGame);
            while (!g2.hayGanador()) g2.registrarPunto(roger);
            set.agregarGame(g2);
        }

        System.out.println("Games jugados: " + set.getGames().size());
        System.out.println("¿Set en 6-6? -> " + set.necesitaTieBreak());

        // Iniciar TieBreak
        if (set.necesitaTieBreak()) {
            System.out.println("Iniciando TieBreak...");
            set.iniciarTieBreak(reglasTieBreak);
        }

        // Simulación simple del tie-break → Rafa gana 7-5
        for (int i = 0; i < 7; i++) set.registrarPuntoTieBreak(rafa);
        for (int i = 0; i < 5; i++) set.registrarPuntoTieBreak(roger);

        // Verificar ganador
        System.out.println("¿Hay ganador del set? " + set.hayGanador());

        Participante ganador = set.getGanador();
        if (ganador != null) {
            System.out.println("Ganador del set: " + ganador.getNombre());
        } else {
            System.out.println("Aún no hay ganador.");
        }
    }
}

