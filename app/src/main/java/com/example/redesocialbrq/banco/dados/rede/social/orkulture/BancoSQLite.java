package com.example.redesocialbrq.banco.dados.rede.social.orkulture;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;





    public class BancoSQLite extends SQLiteOpenHelper {


        private static final String NOME_BANCO = "Dados_Orkulture.db";
        private static final String ID = "id";
        private static final String EMAIL = "email";
        private static final String SENHA = "senha";
        private static final String NOME = "nome";
        private static final String TELEFONE = "telefone";
        private static final String DATA_NASCIMENTO = "data_nascimento";

        private static final String IDFAVORITOS = "idfavoritos";
        private static final String SERIE = "serie";
        private static final String LIVRO = "livro";
        private static final String FILME = "filme";
        private static final String MUSICA = "musica";


        private static final String TABELA = "usuario";
        private static final String TABELAFAVORITOS = "favoritos";
        private static final int VERSAO = 1;

        public BancoSQLite(Context context) {
            super(context, NOME_BANCO, null, VERSAO);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String CREATE_TABLE_USUARIO = "CREATE TABLE " + TABELA + " ( " +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    EMAIL + " TEXT, " + SENHA + " TEXT, " + NOME + " TEXT, " +
                    TELEFONE + " TEXT, " + DATA_NASCIMENTO + " TEXT, " +
                    " TEXT )";
            db.execSQL(CREATE_TABLE_USUARIO);

            String CREATE_TABLE_FAVORITOS = "CREATE TABLE " + TABELAFAVORITOS + " ( " +
                    IDFAVORITOS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SERIE + " TEXT, " + LIVRO + " TEXT, " + FILME + " TEXT, " +
                    MUSICA + " TEXT )";
            db.execSQL(CREATE_TABLE_FAVORITOS);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            db.execSQL("DROP TABLE IF EXISTS " + TABELA);
            db.execSQL("DROP TABLE IF EXISTS " + TABELAFAVORITOS);
            onCreate(db);

        }

        public boolean inserirUsuario(Usuario u) {
            long result;
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(EMAIL, u.getEmail());
            values.put(SENHA, u.getSenha());
            values.put(NOME, u.getNome());
            values.put(TELEFONE, u.getTelefone());
            values.put(DATA_NASCIMENTO, u.getData_nascimento());

            result = db.insert(TABELA, null, values);
            db.close();

            if (result == -1)
                return false;
            else
                return true;

        }
        public boolean inserirFavoritos(Favoritos f) {
            long result;
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(SERIE, f.getSerie());
            values.put(LIVRO, f.getLivro());
            values.put(FILME, f.getFilme());
            values.put(MUSICA, f.getMusica());

            result = db.insert(TABELAFAVORITOS, null, values);
            db.close();

            if (result == -1)
                return false;
            else
                return true;

        }


        public Usuario selecionarUsuario(String email){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(
                    TABELA,
                    new String[]{ID,EMAIL,SENHA,NOME,TELEFONE,DATA_NASCIMENTO},
                    EMAIL + " = ?",
                    new String[]{ String.valueOf(email) }, null, null, null, null);

            if (cursor != null){
                cursor.moveToFirst();

                Usuario user = new Usuario(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5));

                return (Usuario) user.clone();
            }else
                return null;
        }

        public Favoritos selecionarFavoritos(String id){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(
                    TABELAFAVORITOS,
                    new String[]{IDFAVORITOS,SERIE,LIVRO,FILME,MUSICA},
                    IDFAVORITOS + " = ?",
                    new String[]{ String.valueOf(id) }, null, null, null, null);

            if (cursor != null){
                cursor.moveToFirst();

                Favoritos favs = new Favoritos(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));


                return (Favoritos) favs.clone();
            }else
                return null;
        }


        public Usuario selecionarUsuarioPorID(String id){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(
                    TABELA,
                    new String[]{ID,EMAIL,SENHA,NOME,TELEFONE,DATA_NASCIMENTO},
                    ID + " = ?",
                    new String[]{ String.valueOf(id) }, null, null, null, null);

            if (cursor != null){
                cursor.moveToFirst();

                Usuario user = new Usuario(
                        Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5));

                return (Usuario) user.clone();

            }else{
                return null;
            }
        }

    }