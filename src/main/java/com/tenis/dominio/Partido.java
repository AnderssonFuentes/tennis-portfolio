package com.tenis.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Partido {

    private final Participante participante1;
    private final Participante participante2;
    private final List<Set> sets;

    public Partido(Participante participante1, Participante participante2) {
        if (participante1 == null || participante2 == null) {
            throw new IllegalArgumentException("Los participantes no pueden ser nulos");
        }
        this.participante1 = participante1;
        this.participante2 = participante2;
        this.sets = new ArrayList<>();
    }

    public void iniciar() {
        System.out.println("Partido iniciado: " + participante1.getNombre() + " vs " + participante2.getNombre());
    }

    public void agregarSet(Set set) {
        if (set == null) throw new IllegalArgumentException("Set no puede ser nulo");
        sets.add(set);
    }

    public boolean hayGanador() {
        for (Set s : sets) {
            if (s.hayGanador()) return true;
        }
        return false;
    }

    public Participante getGanador() {
        for (Set s : sets) {
            if (s.hayGanador()) return s.getGanador();
        }
        return null;
    }

    public List<Set> getSets() {
        return Collections.unmodifiableList(sets);
    }

    public Participante getParticipante1() { return participante1; }
    public Participante getParticipante2() { return participante2; }
}
