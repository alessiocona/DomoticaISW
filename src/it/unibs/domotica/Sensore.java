package it.unibs.domotica;

import java.util.ArrayList;

public class Sensore {
    CategoriaSensore categoriaSensore;
    ArrayList<Stanza> stanze;
    ArrayList<Artefatto> artefatti;
    private float valore;
    private String unitaDiMisura;

    public Sensore(CategoriaSensore categoriaSensore, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti) {
        this.categoriaSensore = categoriaSensore;
        this.stanze = stanze;
        this.artefatti = artefatti;
    }

    public void aggiungiStanza(Stanza stanza) {
        this.stanze.add(stanza);
        stanza.aggiungiSensore(this);
    }

    public void rimuoviStanza(Stanza stanza) {
        this.stanze.remove(stanza);
        stanza.rimuoviSensore(this);
    }

    public void aggiungiArtefatto(Artefatto artefatto){
        this.artefatti.add(artefatto);
        artefatto.aggiungiSensore(this);
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.artefatti.remove(artefatto);
        artefatto.rimuoviSensore(this);
    }
}
