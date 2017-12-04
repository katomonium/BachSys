package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Comentario;
import java.util.HashMap;
import java.util.Map;

public class ComentarioDAO {
    
    private static final ComentarioDAO INSTANCIA = new ComentarioDAO();
    
    private final Map<String[], Comentario> comentarios;
    
    private ComentarioDAO() {
        comentarios = new HashMap<>();
    }
    
    public static ComentarioDAO getINSTANCIA() {
        return INSTANCIA;
    }
    
    public void addComentario(String usuarioEmail, String musicaNome,
            Comentario comentario ) {
        
        this.comentarios.put(new String[] {usuarioEmail, musicaNome}, comentario);
    }
    
    public Comentario getComentario(String usuarioEmail, String musicaNome) {
        return this.comentarios.get(new String[] {usuarioEmail, musicaNome});
    }
    
    public void visualizarComentarios() {
        System.out.println("visualizarComentarios()");
        
        for (Map.Entry m : this.comentarios.entrySet()) {
            System.out.println(m.getValue());
        }
        
        System.out.println("");
    }
    
}
