package LegiestReyniers.support;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WGet {

    public WGet() {
    }

    public JsonObject getJson(String station){

        String s = null;

        try {

            String cmd = "wget -qO- "+  station +" | python -m json.tool";

            //Process aanmaken waarin we
            ProcessBuilder builder = new ProcessBuilder("/bin/sh","-c"
                    ,cmd);
            builder.redirectErrorStream(true);
            Process p = null;

            p = builder.start();


            //Reader die de output van het command zal uitlezen
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                if (!line.contains("Columns"))
                    sb.append(line);
            }

            s = sb.toString();


        }catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        JsonElement element = gson.fromJson (s, JsonElement.class);

        return element.getAsJsonObject();

    }
}
