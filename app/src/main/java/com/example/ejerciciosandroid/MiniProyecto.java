package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MiniProyecto extends AppCompatActivity {


    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2, posicion = 0;

    MediaPlayer vectormp[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_proyecto);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView2);

        vectormp [0] = MediaPlayer.create(this, R.raw.race);
        vectormp [1] = MediaPlayer.create(this, R.raw.sound);
        vectormp [2] = MediaPlayer.create(this, R.raw.tea);
    }


    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Leyendas("PAUSA");
        }else{
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Leyendas("PLAY");
        }
    }

    public void Stop(View view){
        if(vectormp[posicion] != null){
            vectormp[posicion].stop();

            vectormp [0] = MediaPlayer.create(this, R.raw.race);
            vectormp [1] = MediaPlayer.create(this, R.raw.sound);
            vectormp [2] = MediaPlayer.create(this, R.raw.tea);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            iv.setImageResource(R.drawable.portada1);
            Leyendas("STOP");
        }
    }


    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Leyendas("No repetir");
            vectormp[posicion].setLooping(false);
            repetir = 2;
        }else{
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Leyendas("Repetir");
            vectormp[posicion].setLooping(true);
            repetir = 1;
        }
    }


    public void Siguiete(View view){
        if(posicion < vectormp.length -1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
                CambioPortada();
            }else{
                posicion++;
                CambioPortada();
            }
        }else{
            Leyendas("No hay más canciones");
        }
    }

    public void Anterior(View view){
        if(posicion >= 1){
            if(vectormp[posicion].isPlaying()){
                vectormp[posicion].stop();
                vectormp [0] = MediaPlayer.create(this, R.raw.race);
                vectormp [1] = MediaPlayer.create(this, R.raw.sound);
                vectormp [2] = MediaPlayer.create(this, R.raw.tea);
                posicion--;

                CambioPortada();
                vectormp[posicion].start();
            }else{
                posicion--;
                CambioPortada();
            }
        }else{
            Leyendas("NO hay más canciones");
        }
    }

    public void Leyendas(String leyenda){
        Toast.makeText(this, leyenda, Toast.LENGTH_SHORT).show();
    }
    public  void CambioPortada (){
        if(posicion == 0){
            iv.setImageResource(R.drawable.portada1);
        }else if(posicion == 1){
            iv.setImageResource(R.drawable.portada2);
        }else if (posicion == 2){
            iv.setImageResource(R.drawable.portada3);
        }
    }

    public void cerrarSesion(View views){
        Toast.makeText(this, "Usuario resgistrado!", Toast.LENGTH_SHORT);
        Intent intent = new Intent(MiniProyecto.this, LoginMiniProyecto.class);
        startActivity(intent);
        finish();
    }

}
