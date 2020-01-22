package it.unibs.domotica;

import java.util.ArrayList;

public class Attuatore {
    private CategoriaAttuatore categoriaAttuatore;
    private String modoDefault;
    ArrayList<Stanza> stanze;
    ArrayList<Artefatto> artefatti;

    public Attuatore(CategoriaAttuatore categoriaAttuatore, String modoDefault, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti) {
        this.categoriaAttuatore = categoriaAttuatore;
        this.modoDefault = modoDefault;
        this.stanze = stanze;
        this.artefatti = artefatti;
    }


}
