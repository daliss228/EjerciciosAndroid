package com.example.ejerciciosandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1 ;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    public void ejercicio13(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio13.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio15(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio15.class);
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

    public void ejercicio39 (View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio33.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio26(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio26.class);
        startActivity(intent);
        finish();
    }


    public void ejercicio48(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio48.class);
        startActivity(intent);
        finish();
    }

    public void ejercicio50(View view){
        Intent intent = new Intent(getApplicationContext(), Ejercicio50.class);
        startActivity(intent);
        finish();
    }

    public void miniproyecto(View view){

        if(preferences.contains("Puser")){
            Intent intent = new Intent(getApplicationContext(), MiniProyecto.class);
            startActivity(intent);
            finish();
        }else{
            Intent intent = new Intent(getApplicationContext(), LoginMiniProyecto.class);
            startActivity(intent);
            finish();
        }

    }

}
