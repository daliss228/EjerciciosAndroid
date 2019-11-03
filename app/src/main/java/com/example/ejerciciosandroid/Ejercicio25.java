package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

public class Ejercicio25 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio25);
    }

    public void reproducir(View v) {
        Uri datos = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/storage/self/primary/naruto.mp3");
        MediaPlayer mp = MediaPlayer.create(this, datos);
        mp.start();
    }

    public void volver(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
