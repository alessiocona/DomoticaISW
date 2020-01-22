package it.unibs.domotica;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Sensore {
    Categoria categoria;
    private String nome;
    ArrayList<Stanza> stanze;
    ArrayList<Artefatto> artefatti;
    private float valore;
    private boolean valoreNumerico; //Se il tipo e' 0 esso corrisponde ad uno stato, se 1 ad una misurazione numerica
    private int max;
    private int min;
    private String unitaDiMisura;

    public Sensore(Categoria categoria, boolean valoreNumerico,String unitaDiMisura, int max, int min, String nome)
    {
        this.categoria = categoria;
        this.unitaDiMisura = unitaDiMisura;
        this.nome = nome;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();
        this.valoreNumerico = valoreNumerico;
        this.max = max;
        this.min = min;
        this.valore = 0;
    }

    public Sensore(Categoria categoria, boolean valoreNumerico,String unitaDiMisura, int max, String nome) //Costruttore senza specificare il limite minimo del sensore(utilizzabile per esempio con sensori a stati, assumiamo che lo stato minimo per ques't ultimi sia lo 0)
    {
        this.categoria = categoria;
        this.unitaDiMisura = unitaDiMisura;
        this.nome = nome;
        this.stanze = new ArrayList<Stanza>();
        this.artefatti = new ArrayList<Artefatto>();
        this.valoreNumerico = valoreNumerico;
        this.max = max;
        this.min = 0;
        this.valore = 0;
    }

    public String getNome() {
        return nome;
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

    @Override
    public String toString() {
        return "Sensore{" +
                "categoria=" + categoria +

                ", valore=" + valore +
                ", valoreNumerico=" + valoreNumerico +
                ", max=" + max +
                ", min=" + min +
                ", unitaDiMisura='" + unitaDiMisura + '\'' +
                '}';
    }
}
