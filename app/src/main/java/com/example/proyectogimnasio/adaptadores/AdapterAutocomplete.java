package com.example.proyectogimnasio.adaptadores;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectogimnasio.R;
import com.example.proyectogimnasio.pojos.EjerEstir;

import java.util.ArrayList;

public class AdapterAutocomplete extends ArrayAdapter {
    private Activity contexto;
    private ArrayList<EjerEstir> ejerOestir;

    public AdapterAutocomplete(Activity contexto, int layout, ArrayList<EjerEstir> ejerOestir) {
        super(contexto, layout, ejerOestir);
        this.contexto = contexto;
        this.ejerOestir = ejerOestir;

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_dropdown_item_1line, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        EjerEstir ejer = ejerOestir.get(position);
        System.out.println(ejer.toString());
        if (ejer != null) {
            textView.setText(ejer.getNombre());
        }

        return convertView;
    }


}
