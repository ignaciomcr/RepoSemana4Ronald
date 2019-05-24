package com.example.reposemana4ronald.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.reposemana4ronald.Adapters.AdapterLista;
import com.example.reposemana4ronald.Models.Persona;
import com.example.reposemana4ronald.R;

import java.util.ArrayList;

public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        setupUI(view);

        return view;

    }


    public void setupUI(final View view){

        FirstList(view);

        Button btnDatos = (Button) view.findViewById(R.id.btnllenardatos);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

                FormFragment fragment2 = new FormFragment();
                ft.replace(android.R.id.content, fragment2);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();

          }
        });

        ListPersona(view);


    }

    private void FirstList(View view){
        ArrayList<String> mItems = new ArrayList<String>();

        for (int i = 1; i <= 10; i++){
            mItems.add("Item : " + i);
        }

        int layoutId = android.R.layout.simple_list_item_1;
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>( getContext(), layoutId,mItems);
        ListView mListView = (ListView) view.findViewById(R.id.listfragment);
        mListView.setAdapter(mAdapter);
    }

    private void ListPersona(View view){

        //Llenar el listView 2 con lo enviado desde el formulario.
        Bundle bundle = getArguments();

        if (bundle != null){

            Persona objPer = (Persona)bundle.getSerializable("objIncializado");

            if (objPer != null){

                ArrayList<Persona> mInformacion = new ArrayList<Persona>();

                AdapterLista mAdapter = new AdapterLista(getContext(),R.layout.list,mInformacion);

                Persona objetoPersona=new Persona(objPer.getName().toString(),objPer.getLastName().toString(),objPer.getEmail().toString(),objPer.getPhoneNumber().toString());

                mAdapter.add(objetoPersona);

                ListView mListView = (ListView) view.findViewById(R.id.listview2);
                mListView.setAdapter(mAdapter);

            }

        }



    }


}
