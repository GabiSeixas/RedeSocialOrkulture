package com.example.redesocialbrq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.redesocialbrq.banco.dados.rede.social.orkulture.BancoSQLite;
import com.example.redesocialbrq.banco.dados.rede.social.orkulture.Usuario;

public class Cadastro extends AppCompatActivity {

    private Button button_finalizarCadastro;
    private EditText edt_nomeUsuario, edt_email,edt_senhaUsuario,edt_confirmarSenha,edt_numTelefone,edt_dataNascimento;

    String nome, email, senha, telefone, datanascimento, confirmarsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();

        IniciarComponetes();




        button_finalizarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Cadastro.this,TelaLogin.class);
                startActivity(intent);
            }
        });

        button_finalizarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome=edt_nomeUsuario.getText().toString();
                email=edt_email.getText().toString();
                senha=edt_senhaUsuario.getText().toString();
                telefone=edt_numTelefone.getText().toString();
                datanascimento=edt_dataNascimento.getText().toString();
                confirmarsenha=edt_confirmarSenha.getText().toString();

                if (nome.isEmpty() || senha.isEmpty() || email.isEmpty() || telefone.isEmpty() || datanascimento.isEmpty()
                || confirmarsenha.isEmpty()){
                    Toast.makeText(Cadastro.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
                  else if (!senha.equals(confirmarsenha) ){
                    Toast.makeText(Cadastro.this, "Senhas não conferem", Toast.LENGTH_SHORT).show();
                }
                  else {
                      CadastrarUsuario();
                }


            }
        });
    }

    private void CadastrarUsuario() {
        BancoSQLite db=new BancoSQLite(this);
        if (db.inserirUsuario(new Usuario(email,senha,nome,telefone,datanascimento))){
            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(Cadastro.this,TelaLogin.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "Cadastro não realizado", Toast.LENGTH_SHORT).show();
        }

    }



    private void IniciarComponetes() {


        button_finalizarCadastro=findViewById(R.id.button_finalizarCadastro_telaCadastro);
        edt_nomeUsuario=findViewById(R.id.edt_nomeUsuario_telaCadastro);
        edt_email=findViewById(R.id.edt_email_telaCadastro);
        edt_senhaUsuario=findViewById(R.id.edt_senhaUsuario_telaCadastro);
        edt_confirmarSenha=findViewById(R.id.edt_confirmarSenha_telaCadastro);
        edt_numTelefone=findViewById(R.id.edt_numTelefone_telaCadastro);
        edt_dataNascimento=findViewById(R.id.edt_dataNascimento_telaCadastro);



    }
}