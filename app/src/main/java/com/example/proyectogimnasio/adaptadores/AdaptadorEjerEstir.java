package com.example.proyectogimnasio.adaptadores;

import android.app.Activity;
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

public class AdaptadorEjerEstir extends ArrayAdapter {

    private Activity contexto;
    private ArrayList<EjerEstir> ejerOestir;

    public AdaptadorEjerEstir(Activity contexto, int layout, ArrayList<EjerEstir> ejerOestir) {
        super(contexto, layout, ejerOestir);
        this.contexto = contexto;
        this.ejerOestir = ejerOestir;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila =convertView;

        AdaptadorEjerEstir.ViewHolder vh;

        vh = new AdaptadorEjerEstir.ViewHolder();

        if (fila == null){
            LayoutInflater inflador = contexto.getLayoutInflater();
            fila = inflador.inflate(R.layout.fila_ejercicios_estiramientos, null);

            vh.nombre = fila.findViewById(R.id.nombreEjerEstir);
            vh.descripcion = fila.findViewById(R.id.descripcionEjerEstir);
            vh.grupo = fila.findViewById(R.id.grupoEjerEstir);
            vh.imagen = fila.findViewById(R.id.imagenEjerEstir);

            fila.setTag(vh);
        } else {
            vh = (AdaptadorEjerEstir.ViewHolder) fila.getTag();
        }

        TextView nombre = fila.findViewById(R.id.nombreEjerEstir);
        TextView descripcion = fila.findViewById(R.id.descripcionEjerEstir);
        TextView grupo = fila.findViewById(R.id.grupoEjerEstir);
        ImageView imagen = fila.findViewById(R.id.imagenEjerEstir);

        nombre.setText(ejerOestir.get(position).getNombre());
        descripcion.setText(ejerOestir.get(position).getDescripcion());
        grupo.setText(ejerOestir.get(position).getGrupo());
        //imagen

        return fila;

    }

    public class ViewHolder{
        TextView nombre, descripcion, grupo;
        ImageView imagen;

    }
}
