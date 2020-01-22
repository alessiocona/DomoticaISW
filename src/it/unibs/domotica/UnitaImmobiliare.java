package it.unibs.domotica;

import java.util.ArrayList;

public class UnitaImmobiliare {
    private String nome;
    private String tipologia;
    private String descrizione;
    private ArrayList<Artefatto> esterno;
    private ArrayList<Stanza> stanze;

    public UnitaImmobiliare(String nome, String tipologia, String descrizione) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.esterno = new ArrayList<Artefatto>();
        this.stanze = new ArrayList<Stanza>();
    }

    public void aggiungiStanza(Stanza stanza){
        this.stanze.add(stanza);
    }

    public String getNome() {
        return nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ArrayList<Artefatto> getEsterno() {
        return esterno;
    }

    public ArrayList<Stanza> getStanze() {
        return stanze;
    }
}
