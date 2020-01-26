package it.unibs.domotica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ServizioDati {
    public <T> void save(T data, Memoria<? super T> strategia ){
        if(strategia.primaSalva(data)){
            // persist the data
            Gson gson = new GsonBuilder().create();
            JsonElement jsonElement = gson.toJsonTree(data);
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(strategia.getPercorso()));
                writer.write(jsonElement.toString());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            strategia.dopoSalva(data);
        }
    }
}
