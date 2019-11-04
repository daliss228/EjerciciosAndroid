package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginMiniProyecto extends AppCompatActivity {

    private EditText username, password;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mini_proyecto);

        username = (EditText) findViewById(R.id.editTextUser);
        password = (EditText) findViewById(R.id.editTextPass);

        preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void iniciarSesion(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        String user1 = preferences.getString("Puser", "null");
        String pass1 = preferences.getString("Ppass", "null");

        if (user.equals(user1) && pass.equals(pass1)) {
            Toast.makeText(this, "Usuario correcto!", Toast.LENGTH_SHORT);
            Intent intent = new Intent(LoginMiniProyecto.this, MiniProyecto.class);
            startActivity(intent);
            finish();
        }
    }

    public void nuevousuario(View view) {
        Intent intent = new Intent(LoginMiniProyecto.this, RegisterMiniProyecto.class);
        startActivity(intent);
        finish();
    }
}
