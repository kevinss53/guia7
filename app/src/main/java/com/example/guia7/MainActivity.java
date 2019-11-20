package com.example.guia7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button misdatos, jugar,verpuntos,verrespuesta;

    public static int numeroaleatorio;

    //claves de recuperacion
    public static final String clavepuntaje="clavepuntaje";
    public static final String clavenombredatos="datos";

    //para controlar el Toast de bienvenida
    private static Boolean controlbienvenido=false;

    //para la persistencia
    private SharedPreferences puntajeshared;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnjugar, btnmisdatos, btnvariable, btnpuntajes;

        btnjugar = findViewById(R.id.btnjugar);
        btnmisdatos = findViewById(R.id.btnmisdatos);
        btnpuntajes = findViewById(R.id.btnverpuntaje);
        btnvariable = findViewById(R.id.btnverrespuesta);

        //controlando el bienvenido que se muestre 1 vez
        if(!controlbienvenido)
        {

            //usando el super toast de bienvenido
            SuperActivityToast.create(this, new Style(), Style.TYPE_BUTTON)
                    // .setButtonText("UNDO")
                    .setButtonIconResource(R.mipmap.ic_launcher)
                    .setOnButtonClickListener("good_tag_name", null, null)
                    .setProgressBarColor(Color.WHITE)
                    .setText("Bienvenido")
                    .setDuration(Style.DURATION_VERY_SHORT)
                    .setFrame(Style.FRAME_KITKAT)
                    .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE_GREY))
                    .setAnimations(Style.ANIMATIONS_SCALE).show();
            controlbienvenido = true;
        }

        //control de persistencia
        puntajeshared = getSharedPreferences(clavenombredatos,MODE_PRIVATE);

    //asignando el valor del numero sin que pierda su numero
        if(numeroaleatorio>0)
        {

        }
        else
        {
            numeroaleatorio = (int) (Math.random()*10+1);
        }


    }

    @Override
    public void onClick(View view) {



        switch (view.getId())
        {
            case R.id.btnjugar:
            {
            Intent as = new Intent(this, com.example.guia7.jugar.class);
            startActivity(as);
                break;
            }


            case R.id.btnverpuntaje:
            {
                Intent as = new Intent(this, verpuntaje.class);
                startActivity(as);
                break;
            }


            case R.id.btnverrespuesta:
            {
                Intent as = new Intent(this, verrespuestacorrecta.class);
                startActivity(as);
                break;
            }

            case R.id.btnmisdatos:
            {
                Intent as = new Intent(this, misdatos.class);
                startActivity(as);
                break;
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        //asignando el valor del numero sin que pierda su numero
        if(numeroaleatorio>0)
        {

        }
        else
        {
            numeroaleatorio = (int) (Math.random()*20+1);
        }

    }
}
