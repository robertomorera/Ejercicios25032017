package com.example.cice.myletradni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void calculaLetra(View view){
        EditText editText=(EditText)findViewById(R.id.cajadni);
        String dni=editText.getText().toString();
        AsyncTaskDni asyncTaskDni=new AsyncTaskDni(this);
        asyncTaskDni.execute(dni);
    }
}
