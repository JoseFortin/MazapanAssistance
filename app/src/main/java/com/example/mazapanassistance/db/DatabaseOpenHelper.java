package com.example.mazapanassistance.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseOpenHelper extends SQLiteOpenHelper {


    //DATOS QUE IRAN PARA LA BASE DE DATOS , COMO LA VERSION , EL NOMBRE Y LAS TABLAS QUE QUIERO CREAR
    //LA VERSION ES POR SI QUIERO CAMBIAR O AGREGAR MAS CAMBIOS EN LAS BASE DE DATOS
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "mazapan.db";
    public static final String COLUMN_ID= "Id_Cursos";
    public static final String COLUMN_NOMBRE= "Nombre_Curso";
    public static final String TABLE_CURSOS= "table_cursos";
    public static final String TABLE_AlUMNOS= "table_alumnos";
    private final Context context;


    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        this.context =context;


    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CURSOS+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NOMBRE+" TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSOS);
     onCreate(sqLiteDatabase);
    }

    //funcion para agregar cursos
    public void agregarcurso(String Nombre_Curso){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOMBRE,Nombre_Curso);

       long result  =  db.insert(TABLE_CURSOS,null,cv);
       if(result ==-1){
           Toast.makeText(context, "ERROR AL QUERER INSERTAR", Toast.LENGTH_SHORT).show();

       }else{
           Toast.makeText(context, "AGREGADO CORRECTAMENTE", Toast.LENGTH_SHORT).show();

       }
    }
    //FUNCION PARA VER LA LISTA DE LOS CURSOS QUE AGREGAMOS
    public Cursor VerCursos(){
        String query ="SELECT * FROM "+ TABLE_CURSOS;
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);

        }
        return cursor;
    }

}
