package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Participante;
import com.tenis.dominio.Set;
import com.tenis.dominio.Jugador;
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
