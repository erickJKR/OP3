package ec.edu.uce.optativa3.controlador;

import android.os.StrictMode;
import android.util.JsonReader;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ObtenerServicio {
    String sql = null;
    public String getDato(int dato){
        switch (dato){
            case 1:
                 sql = "http://test2.grupo02optativa3.dns-cloud.net/oper/1";
                break;
            case 2:
                 sql = "http://test2.grupo02optativa3.dns-cloud.net/oper/2";
                break;
            case 3:
                 sql = "http://test2.grupo02optativa3.dns-cloud.net/";
                break;

            default:
                 sql = "http://test2.grupo02optativa3.dns-cloud.net/oper/3";
                break;
    }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = null;
        String json = "";
        HttpURLConnection conn;
        JsonReader reader = null;
        Gson gson = new Gson();
        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();
            Mensaje msg  = new Gson().fromJson(json, Mensaje.class);
            return msg.getMsg();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "test prueba1";
        } catch (IOException e) {
            e.printStackTrace();
            return "test prueba2";
        }
    }

    class Mensaje{
        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }


}
