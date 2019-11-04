package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;

public class Ejercicio50 extends AppCompatActivity {

    private ImageView imagen1;
    private EditText edt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio50);

        imagen1 = (ImageView) findViewById(R.id.imageView);
        edt1 = (EditText) findViewById(R.id.editText);


    }

    public void tomarfoto (View view){
        Intent intento1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File foto = new File(getExternalFilesDir(null), edt1.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(foto));
        startActivity(intento1);
    }


    public void recuperarfoto(View view){
        Bitmap bitmap1 = BitmapFactory.decodeFile(getExternalFilesDir(null)+"/"+edt1.getText().toString());
        imagen1.setImageBitmap(bitmap1);

    }

    public void ver(View view){
        Intent intento1 = new Intent(this, Actividad2.class);
        startActivity(intento1);
    }





}
