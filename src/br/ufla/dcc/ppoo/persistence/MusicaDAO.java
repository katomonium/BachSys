package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Musica;
import java.util.HashMap;
import java.util.Map;

public class MusicaDAO {

//    private String caminho;
    private static final MusicaDAO INSTANCIA = new MusicaDAO();
    
    // Map<NomeDaMusica, Musica>
    private final Map<String, Musica> musicas;

    private MusicaDAO() {
        this.musicas = new HashMap<>();
    }

    public static MusicaDAO getINSTANCIA() {
        return INSTANCIA;
    }
    
    public Musica getMusica(String nome) {
        return this.musicas.get(nome);
    }
    
    public void addMusica(Musica m) {
        if(this.musicas.get(m.getNome()) == null) {
            this.musicas.put(m.getNome(), m);
        } else {
            System.out.println("ERROR: Música já cadastrada");
        }
    }
    
    public int getSize() {
        return this.musicas.size();
    }
    
    public void visualizarMusicas() {
        System.out.println("visualizarMusicas()");
        
        for(Map.Entry m : this.musicas.entrySet()) {
            System.out.println(m.getValue());
        }
        
        System.out.println("");
    }
    
    public Integer getQtdMusicas() {
        return musicas.size();
    }
    
}
