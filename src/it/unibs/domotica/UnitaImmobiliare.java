package it.unibs.domotica;

import java.util.ArrayList;

public class UnitaImmobiliare {
    private String nome;
    private String tipologia;
    private String descrizione;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Stanza> stanze;

    public UnitaImmobiliare(String nome, String tipologia, String descrizione) {
        this.nome = nome;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.artefatti = new ArrayList<Artefatto>();
        this.stanze = new ArrayList<Stanza>();
    }

    public void aggiungiStanza(Stanza stanza){
        if (this.nomeStanzaPresente(stanza.getNome())){
            throw new IllegalArgumentException("Stanza già presente");
        }
        this.stanze.add(stanza);
    }

    public void aggiungiArtefatto(Artefatto artefatto) {
        if (this.nomeArtefattoPresente(artefatto.getNome())){
            throw new IllegalArgumentException("Artefatto già presente");
        }
        this.artefatti.add(artefatto);
    }


    public String getNome() {
        return nome;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public Stanza getStanza(String nome) {
        for (Stanza s:this.stanze) {
            if (s.getNome().equals(nome)) return s;
        }
        throw new IllegalArgumentException("Stanza non presente");
    }

    //Verifico se nome stanza già utilizzato
    public Boolean nomeStanzaPresente(String nome){
        try{
            Stanza s = getStanza(nome);
            return true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }

    //Verifico se nome artefatto già utilizzato
    public Boolean nomeArtefattoPresente(String nome){
        for (Artefatto a:this.artefatti) {
            if (a.getNome().equals(nome)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "UnitaImmobiliare{" +
                "nome='" + nome + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", artefatti=" + artefatti +
                ", stanze=" + stanze +
                '}';
    }
}
