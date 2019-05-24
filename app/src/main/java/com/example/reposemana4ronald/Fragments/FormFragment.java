package com.example.reposemana4ronald.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.reposemana4ronald.Adapters.AdapterLista;
import com.example.reposemana4ronald.Models.Persona;
import com.example.reposemana4ronald.Models.Persona;
import com.example.reposemana4ronald.R;

import java.util.ArrayList;

public class FormFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        SetupUI(view);
        return  view;
    }

    public void SetupUI(final View view){
        Button mbutton=(Button)view.findViewById(R.id.btnEnviar);

        final EditText name=(EditText)view.findViewById(R.id.txtNombre);
        final EditText lastName=(EditText)view.findViewById(R.id.txtApellido);
        final EditText email=(EditText)view.findViewById(R.id.txtEmail);
        final EditText phoneNumber=(EditText)view.findViewById(R.id.txtTelefono);

        mbutton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
            //Agarrar los valores de los edittext


               String nombre = name.getText().toString();


               String apellido = lastName.getText().toString();


               String correo = email.getText().toString();


               String telefono = phoneNumber.getText().toString();


               // crear el obj persona
               Persona obj=new Persona(nombre,apellido,correo,telefono);


                //envio de persona al sig fragm
               FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
               ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

               MainFragment fragment2 = new MainFragment();
               Bundle bundle=new Bundle();
               bundle.putSerializable("objIncializado",obj);
               fragment2.setArguments(bundle);
               ft.replace(android.R.id.content,fragment2);
               ft.addToBackStack(null);
               ft.commit();




           }
       }
        );



    }


}
