package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Jugador;
import com.tenis.dominio.Participante;
import com.tenis.reglas.IReglasGame;
import com.tenis.reglas.ReglasClasicasGame;

public class MainGameDemo {
    public static void main(String[] args) {
        Jugador j1 = new Jugador("Roger Federer");
        Jugador j2 = new Jugador("Rafael Nadal");

        IReglasGame reglas = new ReglasClasicasGame();
        Game game = new Game(j1, j2, j1, reglas);

        // Secuencia para forzar Deuce -> Ventaja -> Ganador
        game.registrarPunto(j1); // 15-0
        game.registrarPunto(j1); // 30-0
        game.registrarPunto(j2); // 30-15
        game.registrarPunto(j2); // 30-30
        game.registrarPunto(j1); // 40-30
        game.registrarPunto(j2); // Deuce

        System.out.println("Puntaje j1: " + game.puntajePara(j1));
        System.out.println("Puntaje j2: " + game.puntajePara(j2));
        System.out.println("Hay ganador? " + game.hayGanador());

        // Ventaja j1
        game.registrarPunto(j1);
        System.out.println("Puntaje j1: " + game.puntajePara(j1));
        System.out.println("Hay ganador? " + game.hayGanador());

        // j1 gana el punto siguiente -> gana game
        game.registrarPunto(j1);
        System.out.println("Hay ganador? " + game.hayGanador());
        if (game.hayGanador()) {
            Participante ganador = game.getGanador();
            System.out.println("Ganador del game: " + ganador.getNombre());
        }
    }
}
