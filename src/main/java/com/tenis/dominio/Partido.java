package com.tenis.dominio;

import com.tenis.marcador.IMarcador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partido {

    private final Participante participante1;
    private final Participante participante2;
    private final List<Set> sets;
    private IMarcador marcador; // opcional, puede ser null


    private final int setsParaGanar;

    public Partido(Participante p1, Participante p2) {
        this(p1, p2, 2); // Best of 3
    }

    public Partido(Participante p1, Participante p2, int setsParaGanar) {
        if (p1 == null || p2 == null) throw new IllegalArgumentException("Participantes no pueden ser nulos");
        if (setsParaGanar <= 0) throw new IllegalArgumentException("setsParaGanar debe ser > 0");

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

        if (hayGanador()) {
            throw new IllegalStateException("El partido ya terminó: no se pueden agregar más sets");
        }

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
        int g1 = setsGanadosPor(participante1);
        int g2 = setsGanadosPor(participante2);
        return g1 >= setsParaGanar || g2 >= setsParaGanar;
    }

    public Participante getGanador() {
        int g1 = setsGanadosPor(participante1);
        int g2 = setsGanadosPor(participante2);

        if (g1 >= setsParaGanar) return participante1;
        if (g2 >= setsParaGanar) return participante2;
        return null;
    }


    public void setMarcador(IMarcador marcador) {
        this.marcador = marcador;
    }

    public IMarcador getMarcador() {
        return marcador;
    }

    public List<Set> getSets() {
        return Collections.unmodifiableList(sets);
    }


    public Participante getParticipante1() { return participante1; }
    public Participante getParticipante2() { return participante2; }
}
