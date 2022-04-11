package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AlterarDadosUsuario extends AppCompatActivity {

       private Button salvaralteracoesdecadastro;
       private ImageButton sairtelalaterardadosusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_dados_usuario);
        getSupportActionBar().hide();


        salvaralteracoesdecadastro.findViewById(R.id.button_salvarAlteracoes_telaAlterarDadosUsuario);
        sairtelalaterardadosusuario.findViewById(R.id.imgbutton_voltarPerfil_telaAlterarDadosUsuario);


        salvaralteracoesdecadastro.setOnClickListener(view -> {
            Intent intent = new Intent(AlterarDadosUsuario.this, Perfil.class);
            startActivity(intent);
        });

        sairtelalaterardadosusuario.setOnClickListener(view -> {
            Intent intent = new Intent(AlterarDadosUsuario.this, Perfil.class);
                });
    }
}