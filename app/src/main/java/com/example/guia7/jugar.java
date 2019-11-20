package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.guia7.MainActivity.numeroaleatorio;
import static com.example.guia7.MainActivity.clavepuntaje;
import static com.example.guia7.MainActivity.clavenombredatos;



public class jugar extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences configuracion;
    public static int puntos =10;
    Button procesar;
    TextView txtestado, txtpuntaje;
    EditText txtnumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        procesar = findViewById(R.id.btnprocesar);
        txtestado = findViewById(R.id.txtestado);
        txtpuntaje = findViewById(R.id.txtpuntos);
        txtnumero = findViewById(R.id.txtnumero);

        //persistencia
        this.configuracion= this.getSharedPreferences(clavenombredatos,MODE_PRIVATE);


    }



    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnprocesar:
            {
                if(!txtnumero.getText().toString().equals(""))
                {
                    int numeroagregado = Integer.parseInt(txtnumero.getText().toString());
                    if(numeroagregado== numeroaleatorio)
                    {
                        puntos=puntos+10;
                        txtestado.setText("Felicidades adivino el numero");
                        SharedPreferences.Editor editorconfiguracion = this.configuracion.edit();
                        editorconfiguracion.putInt(clavepuntaje,puntos);
                        //aqui se guarda la informacion
                        editorconfiguracion.commit();
                        txtpuntaje.setText("Su puntaje final es "+puntos);
                        puntos = 10;
                        Toast.makeText(this, "Felicidades, encontro el numero", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        puntos--;
                        txtestado.setText("Numero incorrecto");
                        txtpuntaje.setText("Puntos: "+Integer.toString(puntos));
                    }
                }

                break;
            }
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        //cargando los controles
    txtpuntaje.setText("Puntos: "+Integer.toString(puntos));
    }
}
