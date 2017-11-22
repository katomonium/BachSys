package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Musica;
import java.util.HashMap;
import java.util.Map;

public class MusicaDAO {

    private static final MusicaDAO INSTANCIA = new MusicaDAO();
    
    
    private static Integer id = 0;
    private final Map<Integer, Musica> musicas;

    public MusicaDAO() {
        this.musicas = new HashMap<>();
    }
    
    
    
    
    
    
    
    
}
