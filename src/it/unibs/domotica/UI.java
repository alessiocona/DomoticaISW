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

    private void menu()
    {
        //Necessita' di acquisire da disco le categorie pre-salvate
        int selezione = 0;
        UI grafica = new UI(new Utente(), new Utente(), categorie, new UnitaImmobiliare());
        //Se 1 loggato manutentore, se 2 loggato fruitore, se 0 esci dal programma
        System.out.println("Benvenuto nel sistema domotico.\n");

        do {
            System.out.println("Selezionare la modalita' di utilizzo:\n\n" +
                    "1. Manutentore\n" +
                    "2. Fruitore\n" +
                    "0. Esci\n");
            try
            {
                selezione = input.nextInt();
            }catch(Exception e)
            {
                System.out.print("\nParamentro non consentito, reiserire valore: ");
                continue;
            }
            switch (selezione) {
                case 1:
                    if (this.autenticazione(this.manutentore))
                    {
                        System.out.println("Selezionare l'operazione:\n\n" +
                                "1. Aggiungi categoria di sensori/attuatori\n" +
                                "2. Aggiungi unita' immobiliare\n" +
                                "3. Aggiungi sensore/attuatore ad una categoria\n" +
                                "4. Creare unita' abitativa\n" +
                                "5. Selezionare unita' abitativa\n" +
                                "0. Esci\n");
                        do {

                        }while(true);
                    }
                    break;
                case 2:
                    if (this.autenticazione(this.fruitore))
                    {
                        this.visualizzaUnitaImmobiliare();
                        System.out.print("Premere 1 per visualizzare tutti i sensori dell'unita' immobiliare: ");
                        do {
                            try{
                                selezione = input.nextInt();
                                if (selezione != 1)
                                    System.out.print("\nParamentro non consentito, reiserire valore: ");
                            }catch(Exception e)
                            {
                                System.out.print("\nParamentro non consentito, reiserire valore: ");
                            }
                        }while(selezione != 1);
                        this.visualizzaListaSensori();
                        do {
                            System.out.println("Premere 1 per aggiornare i valori, premere 0 per tornare al menu principale");
                            try{
                                selezione = input.nextInt();
                                if (selezione != 1 || selezione != 0)
                                    System.out.print("\nParamentro non consentito, reiserire valore: ");
                                else if (selezione == 1)
                                {
                                    this.visualizzaListaSensori();
                                }
                            }catch(Exception e)
                            {
                                System.out.print("\nParamentro non consentito, reiserire valore: ");
                            }
                        }while(selezione != 0);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.print("Input non valido, inserire nuovo valore: ");
                    break;
            }
        }while(selezione != 0);
    }

    private boolean autenticazione(Utente user)
    {
        System.out.print("Inserire username: ");
        String username = input.nextLine();
        if(username.equals(user.getUsername()))
        {
            System.out.print("Inserire password: ");
            String password = input.nextLine();
            if(password.equals(user.getPassword()))
            {
                return true;
            }
        }
        return false;
    }

    private void visualizzaUnitaImmobiliare()
    {
        //Prelevo solamente l'unica unita' immobiliare disponibile, cioe' solo la prima

        System.out.println("Questa e' la sua unita' immobiliare: \n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getNome() + "\n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getTipologia() + "\n" +
                "-" + this.fruitore.getUnitaImmobiliari().get(0).getDescrizione() + "\n");
    }

    private void visualizzaListaSensori()
    {
        System.out.println("Lista dei sensori: ");
        System.out.print("Stanze: \n");
        //Lista dei sensori delle stenza, e dei relativi artefatti all'interno delle stanze
        for (Stanza s : this.fruitore.getUnitaImmobiliari().get(0).getStanze()) {
            System.out.print(s.getNome() + "\t");
            for (Sensore sensoreStanza : s.getSensori())
            {
                System.out.print("\n" +sensoreStanza.getNome() + " " + sensoreStanza.getValore() + " " + sensoreStanza.getUnitaDiMisura());
            }
            for (Artefatto a : s.getArtefatti())
            {
                for(Sensore sensoreArtefatto : a.getSensori())
                {
                    System.out.print("\n" + sensoreArtefatto.getNome() + " " + sensoreArtefatto.getValore() + " " + sensoreArtefatto.getUnitaDiMisura());
                }
            }

        }
        System.out.print("Artefatti esterni: "); //Lista dei sensori degli artefatti esterni alla casa
        for(Artefatto arte : this.fruitore.getUnitaImmobiliari().get(0).getEsterno())
        {
            for(Sensore s : arte.getSensori())
            {
                System.out.print("\n" + s.getNome() + " " + s.getValore() + " " + s.getUnitaDiMisura());
            }
        }
    }

}
