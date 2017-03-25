package com.example.cice.descargaimagen;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by cice on 25/3/17.
 */

public class AsyncTaskDescargaImagen extends AsyncTask<String,Void,Bitmap> {

    private MainActivity mainActivity;

    public AsyncTaskDescargaImagen(MainActivity mainActivity){

        this.mainActivity=mainActivity;
    }


    @Override
    protected Bitmap doInBackground(String... url) {

        //VARARGS STRING ... string -> número indeterminado de  parámetros. de tipo String.
        Bitmap bitmap=null;
        String url_imagen=null;
        //Cogemos la ruta de la foto.
        URL url_foto=null;
        //Para envolver la funcionalidad http.
        HttpURLConnection http=null;
        //Código de respuesta de la petición http.
        int respuesta=-5;
        //Clase para recibir la foto;
        InputStream is=null;

        try {
            url_imagen=url[0];
            //Construimos la URL.
            url_foto = new URL(url_imagen);
            //Abrimos la conexion y por defecto se llama al método GET
            http=(HttpURLConnection)url_foto.openConnection();
            //http.setRequestMethod("GET") así especificamos el método HTTP a ejecutar;
            respuesta=http.getResponseCode();
            //Comprobamos si la petición fue correcta
            if(respuesta== HttpURLConnection.HTTP_OK){
                Log.d("MENSAJE","La petición se ha procesado correctamente");
                //Accedo al cuerpo del mensaje HTTP.
                is=http.getInputStream();
                bitmap=BitmapFactory.decodeStream(is);
            }else{
                Log.e("MENSAJE","La petición fue mal. No hay foto");

            }
        }catch(Throwable t){
            Log.e("MENSAJE","Algo fue mal",t);

        }finally{
            //Liberamos la conexión tanto si fue mal o no.
            http.disconnect();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.d("MENSAJE","Tarea de descarga finalizada");
        mainActivity.dibujarImagen(bitmap);

    }

}
