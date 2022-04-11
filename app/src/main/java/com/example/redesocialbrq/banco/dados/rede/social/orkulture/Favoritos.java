package com.example.redesocialbrq.banco.dados.rede.social.orkulture;

public class Favoritos implements Cloneable {

    private int id;
    private String serie, livro, filme, musica;

    public Favoritos(){}


    public Favoritos( String serie, String livro, String filme, String musica){
        this.serie = serie;
        this.livro = livro;
        this.filme = filme;
        this.musica = musica;

    }

    public Favoritos ( int id, String serie, String livro, String filme, String musica){
        this.id = id;
        this.serie = serie;
        this.livro = livro;
        this.filme = filme;
        this.musica = musica;

    }

    public Favoritos( Favoritos f){
        this.id = f.id;
        this.serie = f.serie;
        this.livro = f.livro;
        this.filme = f.filme;
        this.musica = f.musica;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSerie() {
        return this.serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public String getLivro() {
        return this.livro;
    }
    public void setLivro(String livro) {
        this.livro = livro;
    }

    public String getFilme() {
        return this.filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getMusica() {
        return this.musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    @Override
    public Object clone(){

        Favoritos clone = new Favoritos(this);
        return clone;

    }
}
