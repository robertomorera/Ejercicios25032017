package com.example.cice.myletradni;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cice on 25/3/17.
 */

public class AsyncTaskDni extends AsyncTask<String,Void,String> {

    private MainActivity mainActivity;
    private static final String URL_DNI="http://192.168.3.18:9090/DniApp/ServletCalculaDni?dni=";

    public AsyncTaskDni(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        String mensaje_dni=null;
        URL url=null;
        HttpURLConnection http= null;
        InputStream is=null;
        int aux_c;
        try {
            url = new URL(URL_DNI+strings[0]);
            http=(HttpURLConnection)url.openConnection();
            if(http.getResponseCode()==HttpURLConnection.HTTP_OK) {
                is = http.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br= new BufferedReader(isr);
                mensaje_dni=br.readLine();
            }
        }catch(Throwable t){

        }finally{
            http.disconnect();
        }

        return mensaje_dni;
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(mainActivity,s,Toast.LENGTH_LONG).show();
    }
}
