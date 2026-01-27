package com.tenis.app;

import com.tenis.dominio.Game;
import com.tenis.dominio.Jugador;
import com.tenis.dominio.Participante;
import com.tenis.dominio.Set;
import com.tenis.dominio.Partido;
import com.tenis.reglas.IReglasGame;
import com.tenis.reglas.IReglasSet;
import com.tenis.reglas.IReglasTieBreak;
import com.tenis.reglas.ReglasClasicasGame;
import com.tenis.reglas.ReglasClasicasSet;
import com.tenis.reglas.ReglasClasicasTieBreak;

public class MainPartidoDemo {

    public static void main(String[] args) {

        Jugador rafa = new Jugador("Rafael Nadal");
        Jugador roger = new Jugador("Roger Federer");

        IReglasGame reglasGame = new ReglasClasicasGame();
        IReglasSet reglasSet = new ReglasClasicasSet();
        IReglasTieBreak reglasTieBreak = new ReglasClasicasTieBreak();

        Partido partido = new Partido(rafa, roger);

        Set set = new Set(reglasSet, rafa, roger);

        for (int i = 0; i < 6; i++) {
            Game g1 = new Game(rafa, roger, reglasGame);
            while (!g1.hayGanador()) g1.registrarPunto(rafa);
            set.agregarGame(g1);

            Game g2 = new Game(rafa, roger, reglasGame);
            while (!g2.hayGanador()) g2.registrarPunto(roger);
            set.agregarGame(g2);
        }

        System.out.println("Games jugados: " + set.getGames().size());
        System.out.println("¿Set en 6-6?: " + set.necesitaTieBreak());

        if (set.necesitaTieBreak()) {
            set.iniciarTieBreak(reglasTieBreak);
            System.out.println("Iniciando TieBreak...");

            // Ejemplo simple: Rafa gana 7-5
            for (int i = 0; i < 7; i++) set.registrarPuntoTieBreak(rafa);
            for (int i = 0; i < 5; i++) set.registrarPuntoTieBreak(roger);
        }

        partido.agregarSet(set);

        System.out.println("¿Hay ganador del set?: " + set.hayGanador());
        if (set.hayGanador()) {
            Participante ganadorSet = set.getGanador();
            System.out.println("Ganador del set: " + (ganadorSet != null ? ganadorSet.getNombre() : "N/A"));
        }

        System.out.println("¿Hay ganador del partido?: " + partido.hayGanador());
        if (partido.hayGanador()) {
            System.out.println("Ganador del partido: " + partido.getGanador().getNombre());
        }
    }
}
