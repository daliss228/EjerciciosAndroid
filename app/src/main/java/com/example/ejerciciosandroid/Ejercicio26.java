package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class Ejercicio26 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio26);
    }

    public void ejecutar (View view){
        MediaPlayer mp = new MediaPlayer();

        try{
            //Probar con un enlace de música

            mp.setDataSource("http://192.168.100.230/ej26/musica/Liam-Payne-J-Balvin-Familiar-0.mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Toast.makeText(this, "No Funciona el Link", Toast.LENGTH_SHORT).show();
        }

    }

}
