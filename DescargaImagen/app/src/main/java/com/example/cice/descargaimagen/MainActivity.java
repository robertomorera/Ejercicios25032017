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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void descargaImagen(View view){

        Log.d("MENSAJE","Tocó el botón de descargar");
        AsyncTaskDescargaImagen atdi=new AsyncTaskDescargaImagen(this);
        //Llamada al servicio de descarga de la imagen y llama al método doInBackgroud.
        atdi.execute(URL_IMAGEN);
        Log.d("MENSAJE","Tarea descarga lanzada");
        //Bloqueamos el boton para impedir que se puede pulsar múltiples veces.
        view.setEnabled(false);
    }


    public void dibujarImagen(Bitmap bitmap){

        Log.d("MENSAJE","Dibujamos la imagen descargada en el Image View");
        //Pintamos la imagen encapsula en el bitmap.
        ImageView imageView=(ImageView)findViewById(R.id.miImagen);
        imageView.setImageBitmap(bitmap);
        Log.d("MENSAJE","Imagen seteada");
        Button botonDescargar=(Button)findViewById(R.id.botondescarga);
        //Desbloqueamos el botón una vez descargada la imagen.
        botonDescargar.setEnabled(true);
    }


}
