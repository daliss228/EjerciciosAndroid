package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterMiniProyecto extends AppCompatActivity {

    private EditText username1, email1, password1;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_mini_proyecto);

        username1 = (EditText)findViewById(R.id.editTextUser2);
        email1 = (EditText)findViewById(R.id.editTextEmail2);
        password1 = (EditText)findViewById(R.id.editTextPass2);

        preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void register(View view){
        String usuario = username1.getText().toString();
        String email = email1.getText().toString();
        String password = password1.getText().toString();

        if(!usuario.equals("")&&!email.equals("")&&!password.equals("")){
            //if(password.length() >= 6){
            if(comprobar()){
                editor.putString("Puser1", usuario);
                editor.putString("Pemail1", email);
                editor.putString("Ppass1", password);
                editor.commit();
                Toast.makeText(this, "Usuario resgistrado!", Toast.LENGTH_SHORT);
                Intent intent = new Intent(RegisterMiniProyecto.this, LoginMiniProyecto.class);
                startActivity(intent);
                finish();
            }else{
                editor.putString("Puser", usuario);
                editor.putString("Pemail", email);
                editor.putString("Ppass", password);
                editor.commit();
                Toast.makeText(this, "Usuario resgistrado!", Toast.LENGTH_SHORT);
                Intent intent = new Intent(RegisterMiniProyecto.this, LoginMiniProyecto.class);
                startActivity(intent);
                finish();
            //}else{
                //Toast.makeText(this, "El password debe tener al menos 6 caracteres!", Toast.LENGTH_SHORT);
            //}
            }
        }else{
            Toast.makeText(this, "Llene todos los campos!", Toast.LENGTH_SHORT);
        }
    }
    public boolean comprobar(){
        if(preferences.contains("Puser")){
            return true;
        }else{
            return false;
        }
    }
}
