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


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void setArtefatti(ArrayList<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    public ArrayList<Sensore> getSensori() {
        return sensori;
    }

    public void setSensori(ArrayList<Sensore> sensori) {
        this.sensori = sensori;
    }

    public ArrayList<Attuatore> getAttuatori() {
        return attuatori;
    }

    public void setAttuatori(ArrayList<Attuatore> attuatori) {
        this.attuatori = attuatori;
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.artefatti.remove(artefatto);
    }

    public void aggiungiSensore(Sensore sensore){
        if (categoriaSensorePresente(sensore.getCategoria())){
            throw new IllegalArgumentException("Categoria già presente");
        }
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
        return nome;
    }

    //Verifico se nome artefatto già utilizzato
    public Boolean nomeArtefattoPresente(String nome){
        for (Artefatto a:this.artefatti) {
            if (a.getNome().equals(nome)) return true;
        }
        return false;
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

}
