package com.tenis.app;

import com.tenis.dominio.*;
import com.tenis.reglas.*;

public class MainRotacionSaqueDemo {
    public static void main(String[] args) {
        Participante p1 = new Jugador("Nadal");
        Participante p2 = new Jugador("Federer");

        IReglasSet reglasSet = new ReglasClasicasSet();
        IReglasGame reglasGame = new ReglasClasicasGame();

        Set set = new Set(reglasSet, p1, p2);

        Game g1 = set.crearPrimerGame(reglasGame, p1);
        System.out.println("Game 1 servidor: " + ((Jugador) g1.getServidor()).getNombre());

        Game g2 = set.crearSiguienteGame(reglasGame);
        System.out.println("Game 2 servidor: " + ((Jugador) g2.getServidor()).getNombre());

        Game g3 = set.crearSiguienteGame(reglasGame);
        System.out.println("Game 3 servidor: " + ((Jugador) g3.getServidor()).getNombre());

        Game g4 = set.crearSiguienteGame(reglasGame);
        System.out.println("Game 4 servidor: " + ((Jugador) g4.getServidor()).getNombre());
    }
}