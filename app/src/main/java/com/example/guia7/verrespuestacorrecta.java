package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.example.guia7.MainActivity.numeroaleatorio;

public class verrespuestacorrecta extends AppCompatActivity {

    TextView puntaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verrespuestacorrecta);
        puntaje = findViewById(R.id.txtnumerogenerado);
        puntaje.setText(Integer.toString(numeroaleatorio));

    }
}
