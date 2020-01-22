package it.unibs.domotica;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Artefatto(String nome, ArrayList<Sensore> sensori, ArrayList<Attuatore> attuatori) {
        this.nome = nome;
        this.sensori = sensori;
        this.attuatori = attuatori;
    }
}
