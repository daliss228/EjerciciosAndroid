package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejercicio13(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio13.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio25(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio25.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio33(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio33.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio48(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio48.class);
        startActivity(intent);
        finish();
    }
}
