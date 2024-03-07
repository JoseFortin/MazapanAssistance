package com.example.mazapanassistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mazapanassistance.db.DatabaseOpenHelper;

public class ClassEditor extends AppCompatActivity {

    EditText class_name;
    Button btn_agregarclase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_editor);

        class_name = findViewById(R.id.class_name);
        btn_agregarclase = findViewById(R.id.btnUpdateClass);



        btn_agregarclase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseOpenHelper myBD = new DatabaseOpenHelper(ClassEditor.this);
                myBD.agregarcurso(class_name.getText().toString().trim());
                Intent intent = new Intent(ClassEditor.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}