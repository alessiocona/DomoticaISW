package it.unibs.domotica;

import java.util.ArrayList;

public class Stanza {
    private String nome;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Stanza(String nome, ArrayList<Artefatto> artefatti, ArrayList<Sensore> sensori, ArrayList<Attuatore> attuatori) {
        this.nome = nome;
        this.artefatti = artefatti;
        this.sensori = sensori;
        this.attuatori = attuatori;
    }
}
