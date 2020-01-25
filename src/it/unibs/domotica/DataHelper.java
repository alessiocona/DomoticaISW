package it.unibs.domotica;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;


import java.io.*;

public class DataHelper {
    private String rootDir;
    private final String domoticaFile = "domotica.txt";
    private File filetesto;


    public DataHelper(String rootDir,Domotica domotica) {
        this.rootDir = rootDir;
        Gson gson = new GsonBuilder().create();
        File file = new File(rootDir + domoticaFile);
        if (!file.exists()) {
            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(domoticaFile));
                JsonElement jsonElement = gson.toJsonTree(domotica);
                //System.out.println("Original JSON : " + jsonElement);
                writer.write(jsonElement.toString());
                writer.close();
                this.filetesto = file;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.filetesto = file;
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }

                Domotica domoticaLetto = gson.fromJson( sb.toString(), Domotica.class );
                //System.out.println(domoticaLetto);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void update(Domotica domotica){
        Gson gson = new GsonBuilder().create();
        System.out.println(domotica);
        JsonElement jsonElement = gson.toJsonTree(domotica);
        System.out.println(jsonElement.toString());
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filetesto));
            writer.write(jsonElement.toString());
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*

this.gson = new Gson();
        String json = gson.toJson(domotica);
        System.out.println(json);


 */
/*
        File file = new File(rootDir + domoticaFile);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();

            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(domoticaFile));
                writer.write(gson.toJson(domotica));
                writer.close();

                br = new BufferedReader(new FileReader(file));


            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

/*


        try{
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

           // jsonDomotica = new JsonReader(new StringReader(br.toString()));
            Gson gson = new Gson();
            this.domotica = gson.fromJson( sb.toString(), Domotica.class );


        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }




 */


}



