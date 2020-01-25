package it.unibs.domotica;

import java.util.ArrayList;
import java.util.HashMap;

public class Attuatore {
    private String codice;
    private Integer stato = 1;//sempre attivi
    private Categoria categoria;
    private Integer modoDefault;
    private HashMap<Integer, String> modalitaFunzionamento;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;

    public Attuatore(Stanza stanza, String codice, Categoria categoria, Integer modoDefault, HashMap<Integer, String> modalitaFunzionamento) {
        if(stanza.categoriaAttuatorePresente(categoria)){
            throw new IllegalArgumentException("Categoria già presente");
        }
        this.codice = codice;
        this.categoria = categoria;
        this.modoDefault = modoDefault;
        this.modalitaFunzionamento = modalitaFunzionamento;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();
        stanza.aggiungiAttuatore(this);
    }

    public Attuatore(Artefatto artefatto, String codice, Categoria categoria, Integer modoDefault, HashMap<Integer, String> modalitaFunzionamento) {
        if(artefatto.categoriaAttuatorePresente(categoria)){
            throw new IllegalArgumentException("Categoria già presente");
        }
        this.codice = codice;
        this.categoria = categoria;
        this.modoDefault = modoDefault;
        this.modalitaFunzionamento = modalitaFunzionamento;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();
        artefatto.aggiungiAttuatore(this);
    }


    public void aggiungiStanza(Stanza stanza) {
        this.stanze.add(stanza);
        stanza.aggiungiAttuatore(this);
    }

    public void rimuoviStanza(Stanza stanza) {
        this.stanze.remove(stanza);
        stanza.rimuoviAttuatore(this);
    }

    public void aggiungiArtefatto(Artefatto artefatto){
        this.artefatti.add(artefatto);
        artefatto.aggiungiAttuatore(this);
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.artefatti.add(artefatto);
        artefatto.rimuoviAttuatore(this);
    }

    @Override
    public String toString() {
        return "Attuatore{" +
                "categoria=" + categoria +
                ", modoDefault=" + modoDefault +
                ", modalitaFunzionamento=" + modalitaFunzionamento +

                '}';
    }

    public Categoria getCategoria() {
        return categoria;
    }
    //nome come da formato richiesto
    public String getNome(){
        return this.codice + "_" + this.categoria.getNome();
    }
}
