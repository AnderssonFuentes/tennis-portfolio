package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Jugador;
import com.tenis.dominio.TipoEstadistica;
import com.tenis.reglas.IReglasGame;
import com.tenis.reglas.ReglasClasicasGame;

public class MainGameStatsDemo {

    public static void main(String[] args) {

        // 1) Creamos participantes
        Jugador rafa = new Jugador("Rafael Nadal");
        Jugador roger = new Jugador("Roger Federer");

        // 2) Reglas del Game (las mismas que ya tienes)
        IReglasGame reglasGame = new ReglasClasicasGame();

        // 3) Creamos un game
        Game game = new Game(rafa, roger, roger, reglasGame);

        // 4) Simulamos algunos puntos con eventos estadísticos (manuales, KISS)
        game.registrarPunto(rafa, TipoEstadistica.ACE);
        game.registrarPunto(rafa, TipoEstadistica.PRIMER_SAQUE_OK);

        game.registrarPunto(roger, TipoEstadistica.PRIMER_SAQUE_FALLADO);
        game.registrarPunto(roger, TipoEstadistica.ERROR);

        game.registrarPunto(rafa, TipoEstadistica.PRIMER_SAQUE_OK);
        //game.registrarPunto(rafa, TipoEstadistica.WINNER); // ⚠️ solo si existe en tu enum

        // 5) Imprimimos el estado del game
        System.out.println("=== Demo Phase 4B: Game + Estadísticas ===");
        System.out.println("¿Hay ganador del game? " + game.hayGanador());
        if (game.hayGanador()) {
            System.out.println("Ganador: " + game.getGanador().getNombre());
        }

        // 6) Mostramos estadísticas por jugador
        System.out.println("\n=== Estadísticas ===");
        System.out.println(rafa.getNombre() + " -> " + rafa.getEstadisticas());
        System.out.println(roger.getNombre() + " -> " + roger.getEstadisticas());
    }
}
