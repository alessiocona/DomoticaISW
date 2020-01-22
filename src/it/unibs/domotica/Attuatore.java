package it.unibs.domotica;

import java.util.ArrayList;
import java.util.Map;

public class Attuatore {
    private CategoriaAttuatore categoriaAttuatore;
    private String modoDefault;
    private Map<Integer, String> modalitaFunzionamento;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;

    public Attuatore(CategoriaAttuatore categoriaAttuatore, String modoDefault, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti) {
        this.categoriaAttuatore = categoriaAttuatore;
        this.modoDefault = modoDefault;
        this.stanze = stanze;
        this.artefatti = artefatti;
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

}
