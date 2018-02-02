package br.ufla.dcc.ppoo.model;

import br.ufla.dcc.ppoo.exceptions.TamanhoMaximoComentario;
import java.io.Serializable;

public class Comentario implements Serializable {
    
    private final String emailComentarista;
    private final String emailDono;
    private final String musicaNome;
    private String comentario;

    public Comentario(String emailComentarista, String emailDono, String musicaNome, String comentario) throws TamanhoMaximoComentario {
        if(comentario.length() > 144) {
            throw new TamanhoMaximoComentario(144);
        }
        
        this.emailComentarista = emailComentarista;
        this.emailDono = emailDono;
        this.musicaNome = musicaNome;
        this.comentario = comentario;
    }

    public String getEmailComentarista() {
        return emailComentarista;
    }

    public String getMusicaNome() {
        return musicaNome;
    }

    public String getComentario() {
        return comentario;
    }

    public String getEmailDono() {
        return emailDono;
    }
    
    @Override
    public String toString() {
        return "Comentario{" + "usuarioEmail=" + emailComentarista + ", musicaNome=" + musicaNome + ", comentario=" + comentario + '}';
    }
    
}
