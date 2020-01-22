package it.unibs.domotica;

import java.util.ArrayList;

public class CategoriaAttuatore extends Categoria {
    ArrayList<ModalitaOperative> modalita;

    public CategoriaAttuatore(String nome, String descrizione, ArrayList<ModalitaOperative> modalita) {
        super(nome, descrizione);
        this.modalita = modalita;
    }
}
