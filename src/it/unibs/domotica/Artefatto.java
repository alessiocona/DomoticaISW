package it.unibs.domotica;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Artefatto(String nome) {
        this.nome = nome;
        this.sensori = new ArrayList<Sensore>();
        this.attuatori = new ArrayList<Attuatore>();
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void aggiungiAttuatore(Attuatore attuatore) {
        this.attuatori.add(attuatore);
    }

    public void rimuoviAttuatore(Attuatore attuatore) {
        this.attuatori.remove(attuatore);
    }

    public void aggiungiSensore(Sensore sensore) {
        this.sensori.add(sensore);
    }

    public void rimuoviSensore(Sensore sensore) {
        this.sensori.remove(sensore);
    }

    @Override
    public String toString() {
        return "Artefatto{" +
                "nome='" + nome + '\'' +
                ", sensori=" + sensori +
                ", attuatori=" + attuatori +
                '}';
    }
}
