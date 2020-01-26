package it.unibs.domotica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Test {


    public static void main(String[] args) {
        Utente manutentore = new Utente("m","m","m","m");
        Utente fruitore = new Utente("f","f","f","f");
        Domotica domotica = new Domotica(manutentore,fruitore);
        domotica.creaUnitaImmobiliare("1","appartamento1","unità abitativa");
        domotica.creaCategoria("temperatura","sensore temperatura");
        domotica.creaCategoria("fumo","sensore fumo");
        domotica.creaStanza("cucina");
        domotica.creaStanza("soggiorno");
        domotica.creaArtefatto("cancello");
        domotica.creaArtefatto("antenna");
        String nome = "cancello";
        try{
            domotica.creaArtefatto(nome);
        }catch (Exception e){
            System.out.println("artefatto " + nome + " già presente");
        }
        domotica.creaSensose("f1","%",domotica.getStanza("cucina"),domotica.getCategoria("fumo"));
        ArrayList<Stanza> dovetemperatura = new ArrayList<Stanza>();
        dovetemperatura.add(domotica.getStanza("cucina"));
        dovetemperatura.add(domotica.getStanza("soggiorno"));
        domotica.creaSensose("t1","C°",dovetemperatura,domotica.getCategoria("temperatura"));
        System.out.println("fine");


        /*

        Categoria cs = new Categoria("t","sensore temperatura");
        Categoria ca = new Categoria("ce","cancello elettrico");


        UnitaImmobiliare u = new UnitaImmobiliare("p1","appartamento","unità di prova");
        Artefatto cancello = new Artefatto("cancello",u);
        //Artefatto cancello2 = new Artefatto("cancello",u);
        Stanza cucina = new Stanza("cucina",u);
        try {
            Stanza cucina2 = new Stanza("cucina", u);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            Sensore sensoreCucina = new Sensore(cucina,"sensore temperatura",cs,"Gradi");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            Sensore sensoreCucina2 = new Sensore(cucina,"sensore temperatura",cs,"Gradi");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.printf(u.toString());



       /* u.aggiungiArtefatto(cancello);


        s.aggiungiStanza(cucina);

        HashMap<Integer,String> modiAt1 = new HashMap<Integer, String>();
        modiAt1.put(0,"chiuso");
        modiAt1.put(1,"aperto");

        Attuatore at1 = new Attuatore(ca,0,modiAt1);
        at1.aggiungiArtefatto(cancello);


        System.out.printf(u.toString());
        */

    }
}
