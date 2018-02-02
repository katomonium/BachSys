package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Comentario;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ComentarioDAO {
    
    public void adicionarComentario(String usuarioEmail, String musicaNome, Comentario comentario) 
                                    throws IOException;
    public void modificarComentario(String nomeMusicaAntigo, String nomeMusicaNovo, String emailDono)
                                    throws IOException;
    public List<Comentario> getComentariosMusica(String emailDono, String musicaNome);
    
    public void salvar() throws IOException;

    public void removerComentariosDaMusica(String nomeMusica, String emailDono) throws IOException;
    
}
