package it.unibs.domotica;

import java.util.ArrayList;
import java.util.Scanner;



public class UI {

    private Utente manutentore;
    private Utente fruitore;
    private ArrayList<Categoria> categorie;
    private UnitaImmobiliare unita;
    private Scanner input;

    public UI(Utente manutentore, Utente fruitore, ArrayList<Categoria> categorie, UnitaImmobiliare unita) {
        this.manutentore = manutentore;
        this.fruitore = fruitore;
        this.categorie = categorie;
        this.unita = unita;
        this.input = new Scanner(System.in);
    }

    private void inizializazione()
    {
        //Necessita' di acquisire da disco le categorie pre-salvate
        UI grafica = new UI(new Utente(), new Utente(), categorie, new UnitaImmobiliare());

        //Se 1 loggato manutentore, se 2 loggato fruitore, se -1 esci dal programma
        int modalitaUtente = grafica.autenticazione();
        if (modalitaUtente == 1)
        {
            grafica.modalitaManutentore();
        }
        else if (modalitaUtente == 2)
        {
            grafica.modlitaFruitore();
        }
        return;


    }

    private int autenticazione()
    {
        do {
            System.out.println("Benvenuto nel sistema domotico.\n" +
                    "Selezionare la modalita' di utilizzo:\n\n" +
                    "1. Manutentore\n" +
                    "2. Fruitore\n" +
                    "0. Esci\n");
            int selezione = input.nextInt();
            if (selezione == 0)
                return 0;
            System.out.println("Benvenuto! " +
                    "Inserire username:");
            String username = input.nextLine();
            if(username.equals(this.manutentore.getUsername()) && selezione == 1 || username.equals(this.fruitore.getUsername()) && selezione == 0)
            {
                System.out.println("Inserire password:");
                String password = input.nextLine();
                if(password.equals(this.manutentore.getPassword()) && selezione == 1)
                {
                    return 1;
                }
                else if(password.equals(this.fruitore.getPassword()) && selezione == 0)
                {
                    return 2;
                }

            }
            System.out.println("Username o password errati!! \n\n");
        }while(true);

    }

    private void modalitaManutentore()
    {

    }
    private int modlitaFruitore()
    {
        //Prelevo solamente l'unica unita' immobiliare disponibile, cioe' solo la prima
        System.out.println("Questa e' la sua unita' immobiliare: \n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getNome() + "\n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getTipologia() + "\n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getDescrizione() + "\n");

        int i = 1;
        System.out.println("Lista dei sensori visualizzabili, 0 per tornare indietro:");
        for (Stanza s : this.fruitore.getUnitaImmobiliari().get(0).getStanze()) {
            System.out.println("-" + s.getNome() + "\n");
            for (Sensore sStanza : s.getSensori())
            {
                System.out.print(i + ". " + sStanza.getNome() + "\n");
                i++;
            }
            for (Artefatto a : s.getArtefatti())
            {
                for(Sensore sArtefatto : a.getSensori())
                {
                    System.out.print(i + ". " + sArtefatto.getNome() + "\n");
                    i++;
                }

            }
        }
        int selezione = input.nextInt();
        if (selezione == 0)
        {
            return 0;
        }

        return 1;
    }
}
