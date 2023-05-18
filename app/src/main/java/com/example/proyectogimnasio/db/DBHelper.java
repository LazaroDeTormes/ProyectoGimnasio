package com.example.proyectogimnasio.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;


import com.example.proyectogimnasio.Constantes;
import com.example.proyectogimnasio.pojos.EjerEstir;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;


public class DBHelper extends SQLiteAssetHelper {

    private Context context;

    public DBHelper(Context context) {
        super(context, Constantes.NOMBRE_BBDD, null, Constantes.VERSION);
        this.context = context;
    }

    public ArrayList<EjerEstir> getAllEjercicios(){
        ArrayList<EjerEstir> arrayList = new ArrayList<>();
        try{

            SQLiteDatabase bbdd = getReadableDatabase();
            if (bbdd != null){
                Cursor buscar = bbdd.rawQuery("select * from ejercicios", null);
                if (buscar.getCount()!=0){
                    while (buscar.moveToNext()){
                        String nombre = buscar.getString(1);
                        String descripcion = buscar.getString(2);
                        String grupo = buscar.getString(3);
                        arrayList.add(new EjerEstir(nombre, descripcion, grupo));
                    }
                    return arrayList;
                }
            }else {

                return arrayList;
            }

        }catch (Exception e){
            Toast.makeText(context, "No hay ejercicios", Toast.LENGTH_SHORT).show();
        }
        return arrayList;
    }

    public ArrayList<EjerEstir> getAllEstiramientos(){
        ArrayList<EjerEstir> arrayList = new ArrayList<>();
        try{

            SQLiteDatabase bbdd = getReadableDatabase();
            if (bbdd != null){
                Cursor buscar = bbdd.rawQuery("select * from estiramientos", null);
                if (buscar.getCount()!=0){
                    while (buscar.moveToNext()){
                        String nombre = buscar.getString(1);
                        String descripcion = buscar.getString(2);
                        String grupo = buscar.getString(3);
                        arrayList.add(new EjerEstir(nombre, descripcion, grupo));
                    }
                    return arrayList;
                }
            }else {

                return arrayList;
            }

        }catch (Exception e){
            Toast.makeText(context, "No hay estiramientos", Toast.LENGTH_SHORT).show();
        }
        return arrayList;
    }

    public ArrayList<EjerEstir> getBusquedaEjer(String busqueda){
        ArrayList<EjerEstir> arrayList = new ArrayList<>();
        String[] datos = {"id", "nombre", "descripcion", "grupo", "imagen"};
        try{
            SQLiteDatabase bbdd = getReadableDatabase();
            if (bbdd != null){
                Cursor buscar = bbdd.query("ejercicios", datos, "nombre='"+busqueda+"'", null, null, null, null, null);
                if (buscar.getCount()!=0){
                    while (buscar.moveToNext()){
                        String nombre = buscar.getString(1);
                        String descripcion = buscar.getString(2);
                        String grupo = buscar.getString(3);
                        arrayList.add(new EjerEstir(nombre, descripcion, grupo));
                    }
                    return arrayList;
                }
            }else {

                return arrayList;
            }
        }catch (Exception e){
            Toast.makeText(context, "No se han encontrado resultados", Toast.LENGTH_SHORT).show();
        }


        return arrayList;

    }

    public ArrayList<EjerEstir> getBusquedaEstir(String busqueda){
        ArrayList<EjerEstir> arrayList = new ArrayList<>();
        String[] datos = {"id", "nombre", "descripcion", "grupo", "imagen"};
        try{
            SQLiteDatabase bbdd = getReadableDatabase();
            if (bbdd != null){
                Cursor buscar = bbdd.query("estiramientos", datos, "grupo='"+busqueda+"'", null, null, null, null, null);
                if (buscar.getCount()!=0){
                    while (buscar.moveToNext()){
                        String nombre = buscar.getString(1);
                        String descripcion = buscar.getString(2);
                        String grupo = buscar.getString(3);
                        arrayList.add(new EjerEstir(nombre, descripcion, grupo));
                    }
                    return arrayList;
                }
            }else {

                return arrayList;
            }
        }catch (Exception e){
            Toast.makeText(context, "No se han encontrado resultados", Toast.LENGTH_SHORT).show();
        }

        return arrayList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
