package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redesocialbrq.banco.dados.rede.social.orkulture.BancoSQLite;
import com.example.redesocialbrq.banco.dados.rede.social.orkulture.Usuario;

public class TelaLogin extends AppCompatActivity {

    private Button botaotelalogincadastro, botaotelaloginentrar;
    private TextView textesqueceuasenha;
    private EditText edt_email, edt_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        getSupportActionBar().hide();

        botaotelalogincadastro=findViewById(R.id.button_cadastroUsuario_telaLogin);
        botaotelaloginentrar=findViewById(R.id.button_acessarApp_telaLogin);
        textesqueceuasenha=findViewById(R.id.buttonTxt_esqueceuSenha_telaLogin);

        edt_email=findViewById(R.id.edt_email_telaLogin);
        edt_senha=findViewById(R.id.edt_senha_telaLogin);



        textesqueceuasenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this,RefazerSenha.class);
                startActivity(intent);
            }
        });


        botaotelalogincadastro.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaLogin.this,Cadastro.class);
                startActivity(intent);
            }
        });

        botaotelaloginentrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String email = edt_email.toString(), senha = edt_senha.toString();
                if (email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(TelaLogin.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                else {
                   Usuario_Valido();

                }



            }
        });

    }

    private void Usuario_Valido() {
        BancoSQLite db=new BancoSQLite(this);
        try {
            Usuario usuario = db.selecionarUsuario(edt_email.getText().toString());

            if (usuario.getSenha().equals(edt_senha.getText().toString())){
                Intent intent= new Intent(TelaLogin.this, Perfil.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "E-mail e/ou senha inválido.", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "E-mail e/ou senha inválido." + e, Toast.LENGTH_SHORT).show();
        }
    }


}