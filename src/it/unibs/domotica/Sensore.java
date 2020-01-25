package it.unibs.domotica;

import java.util.ArrayList;

public class Sensore {
    private Categoria categoria;
    private String codice;
    private Integer stato = 1;//sempre attivi
    ArrayList<Stanza> stanze;
    ArrayList<Artefatto> artefatti;
    /*
    private float valore;
    private boolean valoreNumerico; //Se il tipo e' 0 esso corrisponde ad uno stato, se 1 ad una misurazione numerica
    private int max;
    private int min;

     */
    private String unitaDiMisura;

    private ArrayList<Rilevazione> rilevazioni;

    public String getCodice() {
        return codice;
    }

    //ci pensiamo dopo:
    //Costruttore senza specificare il limite minimo del sensore(utilizzabile per esempio con sensori a stati, assumiamo
    // che lo stato minimo per ques't ultimi sia lo 0)


    public Sensore(Stanza stanza, String codice, Categoria categoria, String unitaDiMisura)
    {
        if (stanza.categoriaSensorePresente(categoria)){
            throw new IllegalArgumentException("Categoria già presente");
        }
        this.categoria = categoria;
        this.unitaDiMisura = unitaDiMisura;
        this.codice = codice;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();

        stanza.aggiungiSensore(this);
    }

    public Sensore(Artefatto artefatto, String codice, Categoria categoria, String unitaDiMisura)
    {
        if (artefatto.categoriaSensorePresente(categoria)){
            throw new IllegalArgumentException("Categoria già presente");
        }
        this.categoria = categoria;
        this.unitaDiMisura = unitaDiMisura;
        this.codice = codice;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();

        artefatto.aggiungiSensore(this);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Stanza> getStanze() {
        return stanze;
    }

    public void setStanze(ArrayList<Stanza> stanze) {
        this.stanze = stanze;
    }

    public ArrayList<Artefatto> getArtefatti() {
        return artefatti;
    }

    public void setArtefatti(ArrayList<Artefatto> artefatti) {
        this.artefatti = artefatti;
    }

    /*
    public float getValore() {
        if (this.valoreNumerico) //Se e' un numero
        {
            if (this.valore == 0) //Se il sensore e' stato appena inizializzato
            {
                this.valore = ThreadLocalRandom.current().nextInt(min, max + 1); //Generazione casuale di un valore per il sensore numerico

            }
            else //Se il valore casuale e' gia stato generato, genero un numero prossimo al casuale
            {
                this.valore += (ThreadLocalRandom.current().nextInt(1, 5))/ 0.6;
            }
        }
        else //Se e' uno stato
        {
            this.valore = ThreadLocalRandom.current().nextInt(0, max + 1); //Generazione casuale di un valore per il sensore a stati
        }

        return valore;
    }

    public void setValore(float valore) {
        this.valore = valore;
    }
    */

    public String getUnitaDiMisura() {
        return unitaDiMisura;
    }

    public void setUnitaDiMisura(String unitaDiMisura) {
        this.unitaDiMisura = unitaDiMisura;
    }

    public void aggiungiStanza(Stanza stanza) {
        this.stanze.add(stanza);
        stanza.aggiungiSensore(this);
    }

    public void rimuoviStanza(Stanza stanza) {
        this.stanze.remove(stanza);
        stanza.rimuoviSensore(this);
    }

    public void aggiungiArtefatto(Artefatto artefatto){
        this.artefatti.add(artefatto);
        artefatto.aggiungiSensore(this);
    }

    public void rimuoviArtefatto(Artefatto artefatto){
        this.artefatti.remove(artefatto);
        artefatto.rimuoviSensore(this);
    }

    public Rilevazione getUltimaRilevazione(){
        return this.rilevazioni.get(rilevazioni.size()-1);
    }

    //nome come da formato richiesto
    public String getNome(){
        return this.codice + "_" + this.categoria.getNome();
    }
}
