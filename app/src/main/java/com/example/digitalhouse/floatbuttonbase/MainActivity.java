package com.example.digitalhouse.floatbuttonbase;



import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//la clase main implementa el listener del fragment que contiene, hay q sobreescribir
//el metodo para indicar qué hacer con los datos que llegan desde el fragment
public class MainActivity extends AppCompatActivity implements SantaFragment.SantaFragmentListener {

    private FragmentManager miFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miFragmentManager = getSupportFragmentManager();

        SantaFragment santaFragment = new SantaFragment();

        FragmentTransaction unaTransaccion = miFragmentManager.beginTransaction();
        unaTransaccion.replace(R.id.activityMainContenedorDeFragments, santaFragment);
        unaTransaccion.commit();

    }

    //se reciben los datos del fragment y se mandan en un intent a la actividad que los mostrará
    @Override
    public void recibirMensaje(String mensaje, String regalos) {
        Intent deMainAMensaje = new Intent(MainActivity.this, MensajeActivity.class);
        Bundle bundleConDatos = new Bundle();
        bundleConDatos.putString("mensaje", mensaje);
        bundleConDatos.putString("regalos", regalos);
        deMainAMensaje.putExtras(bundleConDatos);
        startActivity(deMainAMensaje);
    }
}
