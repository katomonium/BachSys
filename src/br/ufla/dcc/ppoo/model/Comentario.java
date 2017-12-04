package br.ufla.dcc.ppoo.model;

public class Comentario {
    
    private final String usuarioEmail;
    private final String musicaNome;
    private String comentario;

    public Comentario(String usiarioEmail, String musicaNome, String comentario) throws Exception {
        if(comentario.length() >= 144) {
            throw new Exception("Comentario maior que 144");
        }
        
        this.usuarioEmail = usiarioEmail;
        this.musicaNome = musicaNome;
        this.comentario = comentario;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public String getMusicaNome() {
        return musicaNome;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" + "usuarioEmail=" + usuarioEmail + ", musicaNome=" + musicaNome + ", comentario=" + comentario + '}';
    }
    
}
