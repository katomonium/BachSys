package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.exceptions.TamanhoMaximoComentario;
import br.ufla.dcc.ppoo.model.Comentario;
import br.ufla.dcc.ppoo.persistence.ComentarioDAO;
import br.ufla.dcc.ppoo.persistence.ComentarioDAOArquivo;
import java.io.IOException;
import java.util.List;

public class ComentarioController {
    
    private static ComentarioDAO COMENTARIO_DAO;
    private static ComentarioController INSTANCIA;

    private ComentarioController() throws IOException, ClassNotFoundException {
        COMENTARIO_DAO = ComentarioDAOArquivo.getInstancia();
    }
    
    
    public static ComentarioController getIntancia() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null) {
            INSTANCIA = new ComentarioController();
        }
        return INSTANCIA;
    }

    public void adicionarComentario(String emailComentarista, String emailDono, String musicaNome,
                                    String comentario) throws TamanhoMaximoComentario, IOException {
        
        Comentario c = new Comentario(emailComentarista, emailDono, musicaNome, comentario);
        
        COMENTARIO_DAO.adicionarComentario(emailDono, musicaNome, c);
    }
    
    public List<Comentario> getComentariosMusica(String emailDono, String musicaNome) {
        return COMENTARIO_DAO.getComentariosMusica(emailDono, musicaNome);
    }

    public void modificarChaveComentarios(String nomeMusicaAntigo, String nomeMusicaNovo, String emailDono) throws IOException {
        COMENTARIO_DAO.modificarComentario(nomeMusicaAntigo, nomeMusicaNovo, emailDono);
    }
    
    public void removerComentariosDaMusica(String nomeMusica, String emailDono) throws IOException {
        COMENTARIO_DAO.removerComentariosDaMusica(nomeMusica, emailDono);
    }

}
