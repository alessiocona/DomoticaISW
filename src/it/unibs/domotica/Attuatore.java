package it.unibs.domotica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Attuatore {
    private Categoria categoria;
    private Integer modoDefault;
    private HashMap<Integer, String> modalitaFunzionamento;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;

    public Attuatore(Categoria categoria, Integer modoDefault, HashMap<Integer, String> modalitaFunzionamento) {
        this.categoria = categoria;
        this.modoDefault = modoDefault;
        this.modalitaFunzionamento = modalitaFunzionamento;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();
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
}
