package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

//persistencia
import static com.example.guia7.MainActivity.numeroaleatorio;
import static com.example.guia7.MainActivity.clavepuntaje;
import static com.example.guia7.MainActivity.clavenombredatos;

public class verpuntaje extends AppCompatActivity {

    TextView txtpuntos;

    //persistencia
    private SharedPreferences configuracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verpuntaje);
//persistencia
        this.configuracion= this.getSharedPreferences(clavenombredatos,MODE_PRIVATE);
        txtpuntos = findViewById(R.id.txtpuntajealmacenado);

        int puntostotales = configuracion.getInt(clavepuntaje,0);

        if(puntostotales==20)
        {
            txtpuntos.setText(Integer.toString(puntostotales)+" Enhorabuena!!!!!");
        }
        else if(puntostotales>=17 && puntostotales<=19)
        {
            txtpuntos.setText(Integer.toString(puntostotales)+" Bien hecho!");
        }
        else if(puntostotales>0 && puntostotales<17)
        {
            txtpuntos.setText(Integer.toString(puntostotales));
        }
        else if(puntostotales==0)
        {
            txtpuntos.setText(puntostotales+"  Le invitamos a comenzar el juego para poder ver o tener mas puntuacion     ;)");
        }
        else
        {
            txtpuntos.setText(Integer.toString(puntostotales)+ " :(");
        }




    }


}
