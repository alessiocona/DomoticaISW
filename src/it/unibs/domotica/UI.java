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

    public static void main(String[] args)
    {
        //Necessita' di acquisire da disco le categorie pre-salvate

    }

    private int autenticazione()
    {
        System.out.println("Benvenuto nel sistema domotico.\n" +
                "Selezionare la modalita' di utilizzo:\n\n" +
                "1.Manutentore\n" +
                "2.Fruitore\n");
        int selezione = input.nextInt();

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
                    return 0;
                }

            }
        return -1;
    }
}
