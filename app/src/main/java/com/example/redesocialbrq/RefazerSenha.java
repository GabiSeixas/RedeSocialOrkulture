package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RefazerSenha extends AppCompatActivity {

    private Button confirmarefazersenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refazer_senha);
        getSupportActionBar().hide();

        confirmarefazersenha=findViewById(R.id.button_confirmarResgateSenha_telaRefazerSenha);

        confirmarefazersenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (RefazerSenha.this, Perfil.class);
                startActivity(intent
                );
            }
        });
    }
}