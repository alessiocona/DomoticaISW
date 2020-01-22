package it.unibs.domotica;

import java.util.ArrayList;

public class Utente {
    private String username;
    private String nome;
    private String cognome;
    private String ruolo;
    private ArrayList<UnitaImmobiliare> unitaImmobiliari;


    public Utente(String username, String nome, String cognome, String ruolo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.ruolo = ruolo;
    }
}
