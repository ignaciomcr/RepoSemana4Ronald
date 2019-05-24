package com.example.reposemana4ronald.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.reposemana4ronald.Models.Persona;
import com.example.reposemana4ronald.R;

import java.util.List;

public class AdapterLista  extends ArrayAdapter<Persona> {

    int mLayoutId;
    public AdapterLista(Context context, int layoutId, List<Persona> items){
        super(context, layoutId, items);
        mLayoutId = layoutId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        Persona persona = getItem(position);
        String name =persona.getName();
        String lastname = persona.getLastName();
        String email = persona.getEmail();
        String phonenumber = persona.getPhoneNumber();

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(mLayoutId, parent, false);
        }

        TextView nameView = (TextView) view.findViewById(R.id.txtNombre);
        TextView lastnameView = (TextView) view.findViewById(R.id.txtApellido);
        TextView mailView = (TextView) view.findViewById(R.id.txtCorreo);
        TextView phoneView = (TextView) view.findViewById(R.id.txtTelefono);

        nameView.setText(name);
        lastnameView.setText(lastname);
        mailView.setText(email);
        phoneView.setText(phonenumber);

        return view;
    }

}
