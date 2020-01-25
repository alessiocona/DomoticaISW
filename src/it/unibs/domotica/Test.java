package it.unibs.domotica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Test {


    public static void main(String[] args) {
        Utente manutentore = new Utente("m","m","m","m");
        Utente fruitore = new Utente("f","f","f","f");
        Domotica domotica = new Domotica(manutentore,fruitore);
        domotica.creaUnitaImmobiliare("1","appartamento1","unità abitativa");
        domotica.creaUnitaImmobiliare("2","casa campagna","unità abitativa");
        System.out.println(domotica);

        Gson gson = new GsonBuilder().create();
        JsonElement jsonElement = gson.toJsonTree(domotica);
        System.out.println("ZERO JSON : " + jsonElement);           // Root element
/*
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        jsonObject.addProperty("power", "300BHP");                      // add a new property

        jsonObject.remove("cost");                                      // remove an existing property

        jsonObject.getAsJsonArray("colors").set(0, new JsonPrimitive("RED"));// update an existing property

        System.out.println("Updated JSON : " + jsonObject);

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
