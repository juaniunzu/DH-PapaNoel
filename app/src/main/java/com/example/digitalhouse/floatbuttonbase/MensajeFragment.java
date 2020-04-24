package com.example.digitalhouse.floatbuttonbase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MensajeFragment extends Fragment {

    private TextView fragmentMensajeTextViewMensaje;
    private TextView fragmentMensajeTextViewRegalos;


    public MensajeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mensaje, container, false);

        //enlazo los atributos con los elementos del xml
        fragmentMensajeTextViewMensaje = view.findViewById(R.id.fragmentMensajeTextViewMensaje);
        fragmentMensajeTextViewRegalos = view.findViewById(R.id.fragmentMensajeTextViewRegalos);

        //recibo el bundle desde la actividad donde está pegado el fragment
        Bundle bundleDesdeMensajeActivity = getArguments();
        String mensajeRecibido = bundleDesdeMensajeActivity.getString("mensaje");
        String regalosRecibidos = bundleDesdeMensajeActivity.getString("regalos");

        //pego los datos traidos por el bundle en los elementos del xml
        fragmentMensajeTextViewMensaje.setText(mensajeRecibido);
        if(mensajeVacio(regalosRecibidos)){
            fragmentMensajeTextViewRegalos.setText("No pidio regalos");
        } else {
            fragmentMensajeTextViewRegalos.setText(regalosRecibidos);
        }

        //retorno el fragment inflado
        return view;
    }

    public Boolean mensajeVacio(String mensaje){
        return mensaje.isEmpty();
    }
}
