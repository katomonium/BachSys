package br.ufla.dcc.ppoo.controller;

import br.ufla.dcc.ppoo.model.Comentario;
import br.ufla.dcc.ppoo.persistence.ComentarioDAO;

public class ComentarioController {
    
    private static final ComentarioDAO COMENTARIO_DAO = ComentarioDAO.getINSTANCIA();
    private static final ComentarioController INSTANCIA = new ComentarioController();

    public static ComentarioController getINSTANCIA() {
        return INSTANCIA;
    }

    public void addComentario(String usuarioEmail, String musicaNome,
            String comentario) {
        
        COMENTARIO_DAO.addComentario(
                usuarioEmail, musicaNome,
                new Comentario(usuarioEmail, musicaNome, comentario)
        );
    }
    
    public Comentario getComentario(String usuarioEmail, String musicaNome) {
        return COMENTARIO_DAO.getComentario(usuarioEmail, musicaNome);
    }
    
    public void visualizarComentarios() {
        COMENTARIO_DAO.visualizarComentarios();
    }
    
}
