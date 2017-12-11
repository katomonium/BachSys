package br.ufla.dcc.ppoo.model;

import java.io.Serializable;
import java.util.Arrays;

public class Musica implements Serializable{

    private final String nome;
    private final String autor;
    private final String album;
    private final int ano;
    private final String genero;
    private final String email;
    private final String[] tags;
    
    /**
     * 
     * @param nome
     * @param autor
     * @param album
     * @param ano
     * @param genero
     * @param email
     * @param tags 
     */
    public Musica(String nome, String autor, String album, int ano,
            String genero, String email, String[] tags) {
        
        this.nome = nome;
        this.autor = autor;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
        this.email = email;
        this.tags = tags;

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

    public String getEmail() {
        return email;
    }

    public String[] getTags() {
        return tags;
    }

    public int getNota() {
        return ano;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Musica) {
            Musica m = (Musica) o;
            if(m.getEmail().equals(this.email) && m.getNome().equals(this.nome)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Musica{" + "nome=" + nome + ", autor=" + autor + ", album="
                + album + ", ano=" + ano + ", genero=" + genero + ", usuario="
                + email + ", tags=" + tags + '}';
    }
    
}
