package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redesocialbrq.banco.dados.rede.social.orkulture.BancoSQLite;
import com.example.redesocialbrq.banco.dados.rede.social.orkulture.Favoritos;

public class CadastrarFavoritos extends AppCompatActivity {

    private Button botaosalvarfavoritos;
    private ImageButton botaovoltartelaperfil;
    private EditText serie, livro, filme,musica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_favoritos);
        getSupportActionBar().hide();

        botaosalvarfavoritos=findViewById(R.id.button_salvarFavoritos_telaCadastrarFavoritos);
        botaovoltartelaperfil=findViewById(R.id.imgbutton_voltarPerfil_telaCadastrarFavoritos);
        serie=findViewById(R.id.edt_cadastrarSerieFavorita_telaCadastrarFavoritos);
        livro=findViewById(R.id.edt_cadastrarLivroFavorito_telaCadastrarFavoritos);
        filme=findViewById(R.id.edt_cadastrarFilmeFavorito_telaCadastrarFavoritos);
        musica=findViewById(R.id.edt_cadastrarMusicaFavorita_telaCadastrarFavoritos);



        botaosalvarfavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              CadastrarFavoritos();

            }
        });

        botaovoltartelaperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( CadastrarFavoritos.this, Perfil.class);
                startActivity(intent);
            }
        });
        }

    private void CadastrarFavoritos() {
        BancoSQLite db=new BancoSQLite(this);
        if (db.inserirFavoritos(new Favoritos(serie.getText().toString(),livro.getText().toString(),filme.getText().toString(),
                musica.getText().toString()))){
            Toast.makeText(this, "Favoritos cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(CadastrarFavoritos.this,Perfil.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Cadastro não realizado", Toast.LENGTH_SHORT).show();
        }

    }

    }
