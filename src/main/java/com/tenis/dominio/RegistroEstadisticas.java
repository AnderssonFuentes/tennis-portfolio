package com.tenis.dominio;

public class RegistroEstadisticas {
    private int aces = 0;
    private int errores = 0;
    private int primerosSaques = 0;

    public void registrarAce() { aces++; }
    public void registrarError() { errores++; }
    public void registrarPrimerSaque(boolean acertado) { if (acertado) primerosSaques++; }

    public int getAces() { return aces; }
    public int getErrores() { return errores; }
    public int getPrimerosSaques() { return primerosSaques; }

    @Override
    public String toString() {
        return "Aces=" + aces + ", Errores=" + errores + ", PrimerosSaqueAcertados=" + primerosSaques;
    }

    public void registrar(TipoEstadistica tipo) {
        switch (tipo) {
            case ACE -> registrarAce();
            case ERROR -> registrarError();
            case PRIMER_SAQUE_OK -> registrarPrimerSaque(true);
            case PRIMER_SAQUE_FALLADO -> registrarPrimerSaque(false);
        }
    }

}
