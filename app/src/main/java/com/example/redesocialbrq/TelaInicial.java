package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class TelaInicial extends AppCompatActivity {


    private ProgressBar barradetempo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        getSupportActionBar().hide();


        barradetempo=findViewById(R.id.progressBar_barraTempo_telaInicial);

        }

    @Override //método a ser executado assim que a tela é aberta
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(TelaInicial.this, TelaLogin.class);
                startActivity(intent);
            }
        },3000);
    }
}