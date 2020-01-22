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
}
