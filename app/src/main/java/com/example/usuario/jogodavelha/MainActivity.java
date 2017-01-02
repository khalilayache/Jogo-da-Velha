package com.example.usuario.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xInicia(View v){

        startGameActivity(v, "x");

    }

    public void oInicia(View v){

        startGameActivity(v, "o");

    }

    public void startGameActivity(View v, String jogador) {

        Intent gameActivity = new Intent(this, GameActivity.class);
        gameActivity.putExtra("jogador",jogador);
        startActivity(gameActivity);
        finish();
    }




}



