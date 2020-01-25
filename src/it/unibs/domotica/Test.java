package it.unibs.domotica;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
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
