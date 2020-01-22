package it.unibs.domotica;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Sensore {
    CategoriaSensore categoriaSensore;
    ArrayList<Stanza> stanze;
    ArrayList<Artefatto> artefatti;
    private float valore;
    private boolean tipo; //Se il tipo e' 0 esso corrisponde ad uno stato, se 1 ad una misurazione numerica
    private int max;
    private int min;
    private String unitaDiMisura;

    public Sensore(CategoriaSensore categoriaSensore, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti, boolean tipo, int max, int min)
    {
        this.categoriaSensore = categoriaSensore;
        this.stanze = stanze;
        this.artefatti = artefatti;
        this.tipo = tipo;
        this.max = max;
        this.min = min;
        this.valore = 0;
    }

    public Sensore(CategoriaSensore categoriaSensore, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti, boolean tipo, int max) //Costruttore senza specificare il limite minimo del sensore(utilizzabile per esempio con sensori a stati, assumiamo che lo stato minimo per ques't ultimi sia lo 0)
    {
        this.categoriaSensore = categoriaSensore;
        this.stanze = stanze;
        this.artefatti = artefatti;
        this.tipo = tipo;
        this.max = max;
        this.min = 0;
        this.valore = 0;
    }

    public CategoriaSensore getCategoriaSensore() {
        return categoriaSensore;
    }

    public void setCategoriaSensore(CategoriaSensore categoriaSensore) {
        this.categoriaSensore = categoriaSensore;
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
        if (this.tipo) //Se e' un numero
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
}
