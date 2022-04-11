package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redesocialbrq.banco.dados.rede.social.orkulture.BancoSQLite;
import com.example.redesocialbrq.banco.dados.rede.social.orkulture.Favoritos;
import com.example.redesocialbrq.banco.dados.rede.social.orkulture.Usuario;

public class Perfil extends AppCompatActivity {

    private ImageView botaocadastrodefavoritos, botaosairaplicativo;
    private ImageView botaoiralterarcadastro;
    private TextView  txtnomeusuario, txtserie,txtlivro,txtfilme,txtmusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        getSupportActionBar().hide();


        botaocadastrodefavoritos=findViewById(R.id.imgButton_cadastrarFavoritos_telaPerfil);
        botaosairaplicativo=findViewById(R.id.imgButton_sair_telaPerfil);
        botaoiralterarcadastro=findViewById(R.id.imgButton_alterarCadastro_telaPerfil);
        txtnomeusuario=findViewById(R.id.txt_nomedousuario_telaPerfil);
        txtserie=findViewById(R.id.txt_serieFavorita_telaPerfil);
        txtlivro=findViewById(R.id.txt_livroFavorito_telaPerfil);
        txtfilme=findViewById((R.id.txt_filmeFavorito_telaPerfil));
        txtmusica=findViewById(R.id.txt_musicaFavorita_telaPerfil);


        botaocadastrodefavoritos.setOnClickListener(view -> {
            Intent intent = new Intent(Perfil.this,CadastrarFavoritos.class);
            startActivity(intent);

        });
        botaosairaplicativo.setOnClickListener(view -> {
            Intent intent = new Intent( Perfil.this, TelaLogin.class);
            startActivity(intent);

        });

        botaoiralterarcadastro.setOnClickListener(view -> {
            Intent intent = new Intent (Perfil.this, AlterarDadosUsuario.class);
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        BancoSQLite db = new BancoSQLite(this);
        super.onStart();
        Usuario usuario = db.selecionarUsuarioPorID("1");
        txtnomeusuario.setText(usuario.getNome());

        buscarFavoritos();

    }

    private void buscarFavoritos() {

        BancoSQLite db = new BancoSQLite(this);

        try {
            Favoritos favoritos = db.selecionarFavoritos("1");
            txtserie.setText(favoritos.getSerie());
            txtlivro.setText(favoritos.getLivro());
            txtfilme.setText(favoritos.getFilme());
            txtmusica.setText(favoritos.getMusica());

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}