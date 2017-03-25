package com.example.cice.descargaimagen;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //URL de la imagen a descargar de Internet en el dispositivo móvil.
    private static final String URL_IMAGEN="http://images.performgroup.com/di/library/goal_de/76/43/antoine-griezmann-atletico-madrid-champions-league-03052016_1fl7g2ws0nyj16hewzbt5lgnl.jpg";
    //URL de la imagen 2.
    private static final String URL_IMAGEN2="http://estaticos.marca.com/imagenes/2015/01/18/futbol/equipos/atletico/1421611936_extras_noticia_foton_7_1.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void descargaImagen(View view){

        Log.d("MENSAJE","Tocó el botón de descargar");
        AsyncTaskDescargaImagen atdi=new AsyncTaskDescargaImagen(this);
        //Llamada al servicio de descarga de la imagen y llama al método doInBackgroud.
        atdi.execute(URL_IMAGEN,URL_IMAGEN2);
        Log.d("MENSAJE","Tarea descarga lanzada");
        //Bloqueamos el boton para impedir que se puede pulsar múltiples veces.
        view.setEnabled(false);
    }


    public void dibujarImagen(Bitmap[] listaBitmap) {

        Log.d("MENSAJE", "Dibujamos la imagen descargada en el Image View");
        Button botonDescargar = (Button) findViewById(R.id.botondescarga);
        //Desbloqueamos el botón una vez descargada la imagen.
        botonDescargar.setEnabled(true);
        ImageView imageView=null;
        for (int i = 0; i < listaBitmap.length; i++) {

            //Pintamos la imagen encapsula en el bitmap.
            //Construimos los id de forma dinámica (parte comun, destino,paquete de la clase).
            int id=getResources().getIdentifier("miImagen"+i,"id","com.example.cice.descargaimagen");
            imageView = (ImageView) findViewById(id);
            Bitmap bitmap=listaBitmap[i];
            imageView.setImageBitmap(bitmap);
            Log.d("MENSAJE", "Imagen seteada");

        }

    }

}
