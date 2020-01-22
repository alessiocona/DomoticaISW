package it.unibs.domotica;

import java.util.ArrayList;

public class CategoriaSensore extends Categoria {
    ArrayList<InfoRilevabili> info;

    public CategoriaSensore(String nome, String descrizione, ArrayList<InfoRilevabili> info) {
        super(nome, descrizione);
        this.info = info;
    }
}
