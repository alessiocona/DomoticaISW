package it.unibs.domotica;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


//Classe che si occupa di tutte le azioni utente, si interfaccia con la UI
public class Domotica {
    private Utente manutentore;
    private Utente fruitore;
    private ArrayList<UnitaImmobiliare> unitaImmobiliari;
    private ArrayList<Categoria> categorie;
    private ServizioDati servizioDati;
    private String ultimoAggiornamento;
    private final String percorso = "domotica.txt";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Domotica(Utente manutentore, Utente fruitore) {
        this.manutentore = manutentore;
        this.fruitore = fruitore;
        this.unitaImmobiliari = new ArrayList<UnitaImmobiliare>();
        this.categorie = new ArrayList<Categoria>();
        this.servizioDati = new ServizioDati();
        salva();
    }

    public void salva(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.ultimoAggiornamento = sdf.format(timestamp);
        Memoria<Domotica> salvaMemoria = new SalvaMemoria(this.percorso); //could reuse that
        servizioDati.save( this, salvaMemoria);
    }

    public void creaUnitaImmobiliare(String nome, String tipologia, String descrizione){
        this.unitaImmobiliari.add(new UnitaImmobiliare(nome,tipologia,descrizione));
        salva();
    }

    public void creaCategoria(String nome,String descrizione){
        this.categorie.add(new Categoria(nome,descrizione));
        salva();
    }

    public Integer getDefUnitaImm(){
        if(this.unitaImmobiliari.size()==0){
            throw new IllegalArgumentException("Nessuna unità immobiliare presente");
        }
        return 0;
    }

    //di default crea la stanza sulla prima unità immobiliare (in futuro aggiungere un overload per gestire più unitàImm
    public void creaStanza(String nome){
        this.unitaImmobiliari.get(getDefUnitaImm()).aggiungiStanza(new Stanza(nome));
        salva();
    }

    public Stanza getStanza(String nome){
        return this.unitaImmobiliari.get(getDefUnitaImm()).getStanza(nome);
    }

    public Categoria getCategoria(String nome){
        for(Categoria c:this.categorie){
            if(c.getNome().equals(nome)) return c;
        }
        throw new IllegalArgumentException("Categoria non presente");
    }

    public void creaSensose(String codice, String um, Stanza stanza,Categoria categoria){
        stanza.aggiungiSensore(new Sensore(codice, um, stanza, categoria));
        salva();
    }

    public void creaSensose(String codice, String um, ArrayList<Stanza> stanze,Categoria categoria){
        for(Stanza s: stanze) {
            s.aggiungiSensore(new Sensore(codice, um, s, categoria));
        }
        salva();
    }

    public void creaArtefatto(String nome){
        if(this.unitaImmobiliari.size()==0){
            throw new IllegalArgumentException("Nessuna unità immobiliare presente");
        }
        this.unitaImmobiliari.get(0).aggiungiArtefatto(new Artefatto(nome));
        salva();
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
