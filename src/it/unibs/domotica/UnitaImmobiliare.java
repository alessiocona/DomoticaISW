package it.unibs.domotica;

import java.util.ArrayList;

public class UnitaImmobiliare {
    private String nome;
    private String tipologia;
    private String descrizione;
    private ArrayList<Artefatto> esterno;
    private ArrayList<Stanza> stanze;

    public UnitaImmobiliare(String nome, String tipologia, String descrizione, ArrayList<Artefatto> esterno, ArrayList<Stanza> stanze) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.esterno = esterno;
        this.stanze = stanze;
    }

    public void aggiungiStanza(Stanza stanza){
        this.stanze.add(stanza);
    }

    public void rimuoviStanza(Stanza stanza){
        this.stanze.remove(stanza);
    }

    public void aggiungiArtefatto(Artefatto artefatto){
        this.esterno.add(artefatto);
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.esterno.remove(artefatto);
    }
}
