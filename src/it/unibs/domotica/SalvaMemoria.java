package it.unibs.domotica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.io.*;

public class SalvaMemoria implements Memoria<Domotica> {
    private String percorso;//dove salvo

    public SalvaMemoria(String percorso) {
        this.percorso = percorso;
    }

    public String getPercorso() {
        return percorso;
    }

    @Override
    public boolean primaSalva(Domotica data) {
        Gson gson = new GsonBuilder().create();
        File file = new File(percorso);
        if (!file.exists()) {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(percorso));
                JsonElement jsonElement = gson.toJsonTree(data);
                writer.write(jsonElement.toString());
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
           return true;
        }
        return false;
    }

    @Override
    public void dopoSalva(Domotica data) {

    }
}
