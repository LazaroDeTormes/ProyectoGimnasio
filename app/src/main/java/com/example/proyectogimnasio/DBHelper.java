package com.example.proyectogimnasio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
                        String nombre = buscar.getString(0);
                        String descripcion = buscar.getString(1);
                        String grupo = buscar.getString(2);
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
                        String nombre = buscar.getString(0);
                        String descripcion = buscar.getString(1);
                        String grupo = buscar.getString(2);
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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
