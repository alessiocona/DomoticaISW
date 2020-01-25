package it.unibs.domotica;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ArrayList<Sensore> sensori;
    private ArrayList<Attuatore> attuatori;

    public Artefatto(String nome, UnitaImmobiliare unitaImmobiliare) {
        if (unitaImmobiliare.nomeArtefattoPresente(nome)){
            throw new IllegalArgumentException("Artefatto già presente");
        }
        this.nome = nome;
        this.sensori = new ArrayList<Sensore>();
        this.attuatori = new ArrayList<Attuatore>();
        unitaImmobiliare.aggiungiArtefatto(this);
    }

    public Artefatto(String nome, Stanza stanza) {
        if (stanza.nomeArtefattoPresente(nome)){
            throw new IllegalArgumentException("Artefatto già presente");
        }
        this.nome = nome;
        this.sensori = new ArrayList<Sensore>();
        this.attuatori = new ArrayList<Attuatore>();
        stanza.aggiungiArtefatto(this);
    }

    public String getNome() {
        return nome;
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

    //Verifico se categoria sensore già utilizzato
    public Boolean categoriaSensorePresente(Categoria categoria){
        for (Sensore s:this.sensori) {
            if (s.getCategoria().equals(categoria)) return true;
        }
        return false;
    }

    //Verifico se categoria attuatori già utilizzato
    public Boolean categoriaAttuatorePresente(Categoria categoria){
        for (Attuatore a:this.attuatori) {
            if (a.getCategoria().equals(categoria)) return true;
        }
        return false;
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
