package it.unibs.domotica;

import java.util.Date;

public class Rilevazione {
    private Sensore sensore;
    private Float valore;
    private Date data;

    public Rilevazione(Sensore sensore, Float valore, Date data) {
        this.sensore = sensore;
        this.valore = valore;
        this.data = data;
    }

    public Float getValore() {
        return valore;
    }
}
