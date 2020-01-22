package it.unibs.domotica;

import java.util.Map;

public class ModalitaOperative {
    private String descrizione;
    private Map<Integer,String> valori;

    public ModalitaOperative(String descrizione, Map<Integer, String> valori) {
        this.descrizione = descrizione;
        this.valori = valori;
    }
}
