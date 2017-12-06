package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicaDAO {

    private static MusicaDAO INSTANCIA;
    // Map<NomeDaMusica, Musica>
    private final Map<List<String>, Musica> musicas;

    public MusicaDAO() throws IOException, ClassNotFoundException {
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("musica.bin"));
        this.musicas = (Map<String[], Musica>) ois.readObject();
        ois.close();
        
    }

    public static MusicaDAO getINSTANCIA() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null) {
            INSTANCIA = new MusicaDAO();
        }
        return INSTANCIA;
    }
    
    public void escreverNoArquivo() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new 
        FileOutputStream("musica.bin"));
        oos.writeObject(this.musicas);
        oos.close();
    }
    
    public Musica getMusica(String nome, String email) {
        return this.musicas.get(Arrays.asList(nome, email));
    }
    
    public void addMusica(Musica m, String email) throws MusicaJaCadastradaException, IOException {
        List<String> key = Arrays.asList(m.getNome(), email);
        
        if(this.musicas.get(key) != null) {
            System.out.println("Eu ja existo!!!!");
            throw new MusicaJaCadastradaException();
        }
        escreverNoArquivo();
        this.musicas.put(key, m);
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
                
        for (Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            if(musica.getEmail().equals(email)) {
                musicasDoUsuario.add(musica);
            }
        }
        
        return musicasDoUsuario;
    }
    
    public List<Musica> getMusicas() {
        ArrayList<Musica> musicasDoUsuario = new ArrayList<>();
                
        for (Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            musicasDoUsuario.add(musica);
        }
        
        return musicasDoUsuario;
    }
    
    public void editarMusica(Musica m, String email) {
        List<String> key = Arrays.asList(m.getNome(), email);
        this.musicas.put(key, m);
    }
    
}
