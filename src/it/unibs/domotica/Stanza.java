package it.unibs.domotica;

import java.util.ArrayList;

public class Stanza {
    private String nome;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Stanza(String nome) {
        this.nome = nome;
        this.artefatti = new ArrayList<Artefatto>();
        this.sensori = new ArrayList<Sensore>();
        this.attuatori = new ArrayList<Attuatore>();
    }

    public void aggiungiArtefatto(Artefatto artefatto){
        this.artefatti.add(artefatto);
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.artefatti.remove(artefatto);
    }

    public void aggiungiSensore(Sensore sensore){
        this.sensori.add(sensore);
    }

    public void rimuoviSensore(Sensore sensore){
        this.sensori.remove(sensore);
    }

    public void aggiungiAttuatore(Attuatore attuatore){
        this.attuatori.add(attuatore);
    }

    public void rimuoviAttuatore(Attuatore attuatore){
        this.attuatori.remove(attuatore);
    }

    @Override
    public String toString() {
        return "Stanza{" +
                "nome='" + nome + '\'' +
                ", artefatti=" + artefatti +
                ", sensori=" + sensori +
                ", attuatori=" + attuatori +
                '}';
    }
}
