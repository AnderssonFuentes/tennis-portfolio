package com.tenis.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partido {

    private final Participante participante1;
    private final Participante participante2;
    private final List<Set> sets;

    private final int setsParaGanar;

    public Partido(Participante p1, Participante p2) {
        this(p1, p2, 2); // Best of 3
    }

    public Partido(Participante p1, Participante p2, int setsParaGanar) {
        this.participante1 = p1;
        this.participante2 = p2;
        this.setsParaGanar = setsParaGanar;
        this.sets = new ArrayList<>();
    }

    public void iniciar() {
        System.out.println("Partido iniciado: " + participante1.getNombre() + " vs " + participante2.getNombre());
    }

    public void agregarSet(Set set) {
        if (set == null) throw new IllegalArgumentException("Set no puede ser nulo");
        sets.add(set);
    }

    public int setsGanadosPor(Participante p) {
        int ganados = 0;

        for (Set s : sets) {
            if (s.hayGanador()) {
                Participante ganador = s.getGanador();
                if (ganador != null && ganador.equals(p)) {
                    ganados++;
                }
            }
        }

        return ganados;
    }

    public boolean hayGanador() {
        return setsGanadosPor(participante1) >= setsParaGanar
                || setsGanadosPor(participante2) >= setsParaGanar;
    }


    public Participante getGanador() {
        if (setsGanadosPor(participante1) >= setsParaGanar) {
            return participante1;
        }
        if (setsGanadosPor(participante2) >= setsParaGanar) {
            return participante2;
        }
        return null;
    }

    public List<Set> getSets() {
        return Collections.unmodifiableList(sets);
    }

    public Participante getParticipante1() { return participante1; }
    public Participante getParticipante2() { return participante2; }
}
