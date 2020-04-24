package com.example.digitalhouse.floatbuttonbase;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MensajeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //recibe el intent desde el main
        Intent desdeMain = getIntent();
        //se obtiene el bundle del intent recibido
        Bundle bundleDesdeMain = desdeMain.getExtras();

        //creo fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //instancio el fragment que despues pegare y creo la transaction
        MensajeFragment fragmentAPegar = new MensajeFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //le agrego el bundle al fragment ANTES DE PEGARLO EN LA ACTIVIDAD
        fragmentAPegar.setArguments(bundleDesdeMain);

        //pego el fragment e inicio
        fragmentTransaction.replace(R.id.activityMensajeContenedorDeFragments, fragmentAPegar);
        fragmentTransaction.commit();



    }
}
