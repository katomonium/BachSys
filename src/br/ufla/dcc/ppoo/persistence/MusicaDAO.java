package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Musica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicaDAO {

//    private String caminho;
    private static final MusicaDAO INSTANCIA = new MusicaDAO();
    
    // Map<NomeDaMusica, Musica>
    private final Map<String[], Musica> musicas;

    private MusicaDAO() {
        this.musicas = new HashMap<>();
    }

    public static MusicaDAO getINSTANCIA() {
        return INSTANCIA;
    }
    
    public Musica getMusica(String nome, String email) {
        String[] key = new String[] {email, nome};
        return this.musicas.get(key);
    }
    
    public void addMusica(Musica m, String email) {
        String[] key = new String[] {email, m.getNome()};
        
        if(this.musicas.get(key) == null) {
            this.musicas.put(key, m);
        } else {
            System.out.println("ERROR: Música já cadastrada");
        }
    }
    
    public int getSize() {
        return this.musicas.size();
    }
    
    public void visualizarMusicas() {
        for(Map.Entry m : this.musicas.entrySet()) {
            System.out.println(m.getValue());
        }
        
        System.out.println("");
    }
    
    public int getQtdMusicas() {
        return musicas.size();
    }
    
    public int getQtdMusicas(String email) {
        return this.getMusicas(email).size();
    }
    
    public List<Musica> getMusicas(String email) {
        ArrayList<Musica> musicasDoUsuario = new ArrayList<>();
                
        for (Map.Entry<String[],Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            if(musica.getEmail().equals(email)) {
                musicasDoUsuario.add(musica);
            }
        }
        
        return musicasDoUsuario;
    }
    
    public List<Musica> getMusicas() {
        ArrayList<Musica> musicasDoUsuario = new ArrayList<>();
                
        for (Map.Entry<String[],Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            musicasDoUsuario.add(musica);
        }
        
        return musicasDoUsuario;
    }
    
    public void editarMusica(Musica m, String email) {
        String[] key = new String[] {email, m.getNome()};
        this.musicas.put(key, m);
    }
    
}
