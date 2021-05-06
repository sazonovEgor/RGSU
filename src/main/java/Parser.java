import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entity.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Parser {

    private List<Log> logs;

    public static StringBuilder getHTML(String dateLog) {

        String query = "http://www.dsdev.tech/logs/" + dateLog;
        HttpURLConnection connection = null;
        StringBuilder sb = new StringBuilder();
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(0);
            connection.setReadTimeout(0);
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);

                }

            } else {
                System.out.println("fail: " + connection.getResponseCode() + ", " + connection.getResponseMessage());
            }


        }  catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return sb;
    }

    public void parseJSON(StringBuilder html) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(html.toString());
        Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
        Type type = new TypeToken<List<Log>>(){}.getType();
        logs = gson.fromJson(jsonObject.get("logs").toString(), type);
        sort();
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void sort() {
        Collections.sort(logs);
    }
}
