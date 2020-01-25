package it.unibs.domotica;

import java.util.ArrayList;
//Classe che si occupa di tutte le azioni utente, si interfaccia con la UI
public class Domotica {
    private Utente manutentore;
    private Utente fruitore;
    private ArrayList<UnitaImmobiliare> unitaImmobiliari;
    private DataHelper dataHelper;

    public Domotica(Utente manutentore, Utente fruitore) {
        this.manutentore = manutentore;
        this.fruitore = fruitore;
        this.unitaImmobiliari = new ArrayList<UnitaImmobiliare>();
        this.dataHelper = new DataHelper("",this);
    }

    public void creaUnitaImmobiliare(String nome, String tipologia, String descrizione){
        this.unitaImmobiliari.add(new UnitaImmobiliare(nome,tipologia,descrizione));
        this.dataHelper.update(this);
    }

    public void caricaUnitaImmobiliare(){

    }

    @Override
    public String toString() {
        return "Domotica{" +
                "manutentore=" + manutentore +
                ", fruitore=" + fruitore +
                ", unitaImmobiliari=" + unitaImmobiliari +
                '}';
    }
}
