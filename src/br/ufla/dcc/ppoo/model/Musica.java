package br.ufla.dcc.ppoo.model;

public class Musica {

    private String nome;
    private String autor;
    private String album;
    private int ano;
    private String genero;
    private Usuario usuario;

    public Musica(String nome, String autor, String album, int ano, String genero, Usuario usuario) {
        this.nome = nome;
        this.autor = autor;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
        this.usuario = usuario;
    }

    
    
    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }
        
        

}
