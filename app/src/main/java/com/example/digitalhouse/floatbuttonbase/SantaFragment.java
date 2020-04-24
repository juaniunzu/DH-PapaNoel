package com.example.digitalhouse.floatbuttonbase;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by andres on 04/10/16.
 */
public class SantaFragment extends Fragment {

    //tiene un atributo del tipo escuchador, interfaz definida abajo
    private SantaFragmentListener santaFragmentListener;

    private TextInputLayout santaFragmentTextInputLayoutMensaje;
    private TextInputEditText santaFragmentEditTextMensaje;
    private TextInputLayout santaFragmentTextInputLayoutRegalos;
    private TextInputEditText santaFragmentEditTextRegalos;
    private FloatingActionButton santaFragmentFloatingButton;

    public Boolean editTextVacio(String texto){
        return texto.isEmpty();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.santa_fragment, container, false);

        santaFragmentTextInputLayoutMensaje = view.findViewById(R.id.santaFragmentTextInputLayoutMensaje);
        santaFragmentEditTextMensaje = view.findViewById(R.id.santaFragmentEditTextMensaje);
        santaFragmentTextInputLayoutRegalos = view.findViewById(R.id.santaFragmentTextInputLayoutRegalos);
        santaFragmentEditTextRegalos = view.findViewById(R.id.santaFragmentEditTextRegalos);
        santaFragmentFloatingButton = view.findViewById(R.id.santaFragmentFloatingButton);

        santaFragmentFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextVacio(santaFragmentEditTextMensaje.getText().toString())){
                    santaFragmentTextInputLayoutMensaje.setError("Campo obligatorio");
                } else {
                    santaFragmentListener.recibirMensaje(santaFragmentEditTextMensaje.getText().toString(), santaFragmentEditTextRegalos.getText().toString());
                }

            }
        });

        return view;

    }

    //se sobreescribe el onAttach que es quien relaciona el fragment con el activity donde se pegará.
    //se sobreescribe para que el context donde se pega se castee a forma Listener y que de esa manera
    //conozca el metodo recibirMensaje
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.santaFragmentListener = (SantaFragmentListener) context;
    }

    //se crea interface escuchadora que debera ser implementada por cualquier actividad
    //que se desee sea escuchadora de este fragment. como este fragment tiene dos datos que
    //puede entregar, se le pasan dos parametros
    public interface SantaFragmentListener{
        public void recibirMensaje(String mensaje, String regalos);
    }

}
