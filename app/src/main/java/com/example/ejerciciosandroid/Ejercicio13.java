package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio13 extends AppCompatActivity {

    private EditText editText;
    private TextView textView2;
    int num1, puntaje = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio13);

        editText = (EditText)findViewById(R.id.editText);
        textView2 = (TextView)findViewById(R.id.textView2);
        num1 = (int) (Math.random() * 50 + 1);
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String punto = String.valueOf(prefe.getInt("puntos", puntaje));
        textView2.setText(punto);
    }

    public void verificar(View v) {
        String num2 = editText.getText().toString();
        int num21 = Integer.parseInt(num2);

        if(num21 == num1 ){
            Toast.makeText(this,"Número correcto!", Toast.LENGTH_LONG).show();

            SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
            puntaje = preferencias.getInt("puntos", puntaje);
            SharedPreferences.Editor editor=preferencias.edit();
            puntaje++;
            textView2.setText(String.valueOf(puntaje));
            editor.putInt("puntos", puntaje);
            editor.commit();
            num1 = (int) (Math.random() * 50 + 1);
        }else if( num21 > num1){
            Toast.makeText(this,"El numero es menor!", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"El numero es mayor!", Toast.LENGTH_LONG).show();
        }
    }

    public void volver(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
