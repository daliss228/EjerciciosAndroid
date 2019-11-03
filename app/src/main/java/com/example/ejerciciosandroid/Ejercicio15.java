package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ejercicio15 extends AppCompatActivity {

    private EditText edtGrande;
    private EditText edtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio15);

        edtGrande = (EditText) findViewById(R.id.edtGrand);
        edtNombre = (EditText) findViewById(R.id.edtNomb);
    }

    public void guardar (View view){
        String nombreArchivo = edtNombre.getText().toString();
        String contenido = edtGrande.getText().toString();

        try{
            File tarjeta = Environment.getExternalStorageDirectory();
            Toast.makeText(this, tarjeta.getAbsolutePath(), Toast.LENGTH_LONG).show();
            File file = new File(tarjeta.getAbsolutePath(), nombreArchivo);
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
            osw.write(contenido);
            osw.flush();
            osw.close();
            Toast.makeText(this, "Los datos fueron grabados correctamente", Toast.LENGTH_SHORT).show();
            edtNombre.setText("");
            edtGrande.setText("");

        }catch (FileNotFoundException e) {
            Toast.makeText(this, "No se pudo guardar SUUU", Toast.LENGTH_SHORT).show();
        } catch (IOException ioe) {
            Toast.makeText(this, "No se pudo guardar", Toast.LENGTH_SHORT).show();
        }
    }

}
