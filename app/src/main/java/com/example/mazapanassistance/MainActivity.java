package com.example.mazapanassistance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mazapanassistance.Adaptador.CustomAdapter;
import com.example.mazapanassistance.db.DatabaseOpenHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaCursos;
    Button newClassButton;
    DatabaseOpenHelper myBD;
    ArrayList<String>Id_Cursos,Nombre_Curso;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén una referencia al botón
        newClassButton = findViewById(R.id.new_class);

        // LIST VIEW
        listaCursos = findViewById(R.id.listaCursos);


        // Asigna un listener al botón
        newClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanza la segunda actividad al hacer clic en el botón
                Intent intent = new Intent(MainActivity.this, ClassEditor.class);
                startActivity(intent);
            }
        });
        myBD = new DatabaseOpenHelper(MainActivity.this);
        Id_Cursos = new ArrayList<>();
        Nombre_Curso = new ArrayList<>();
        Informacionalmacenadaenarrays();

        customAdapter = new CustomAdapter(MainActivity.this,Id_Cursos,Nombre_Curso);
        listaCursos.setAdapter(customAdapter);
        listaCursos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void Informacionalmacenadaenarrays(){
        Cursor cursor = myBD.VerCursos();
        if (cursor.getCount()==0){
            Toast.makeText(this, "Sin Cursos", Toast.LENGTH_SHORT).show();
        }else{
            while  (cursor.moveToNext()){
                Id_Cursos.add(cursor.getString(0));
                Nombre_Curso.add(cursor.getString(1));
            }
        }
    }

}

