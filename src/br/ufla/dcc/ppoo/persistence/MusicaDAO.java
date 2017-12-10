package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.File;
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

public class MusicaDAO extends DAO{
    
    private static MusicaDAO INSTANCIA;
    // Map<NomeDaMusica, Musica>
    private Map<List<String>, Musica> musicas;

    public MusicaDAO() throws IOException, ClassNotFoundException {
        super("src/br/ufla/dcc/ppoo/arquivos/musicas.bin");
        FileInputStream fis = new FileInputStream(getNomeArquivo());
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.musicas = (Map<List<String>, Musica>) ois.readObject();
        } catch (IOException ioe) {
            musicas = new HashMap<>();
        }
        
    }
    
    public static MusicaDAO getINSTANCIA() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null) {
            INSTANCIA = new MusicaDAO();
        }
        return INSTANCIA;
    }
    
    public void escreverNoArquivo() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new 
        FileOutputStream(getNomeArquivo()));
        oos.writeObject(this.musicas);
        oos.close();
    }
    
    public Musica getMusica(String nome, String email) throws MusicaNaoEncontradaException {
        List<String> key = Arrays.asList(nome, email);
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        return this.musicas.get(key);
    }
    
    public void addMusica(String chave, Musica m, String email) throws MusicaJaCadastradaException, IOException {
        List<String> key = Arrays.asList(chave, email);
        
        if(this.musicas.get(key) != null) {
            throw new MusicaJaCadastradaException();
        }
        this.musicas.put(key, m);
        escreverNoArquivo();
        
    }
    
    public int getSize() {
        return this.musicas.size();
    }
    
    //TODO: o que e isso? bora apagar?
//    public void visualizarMusicas() {
//        for(Map.Entry m : this.musicas.entrySet()) {
//            System.out.println(m.getValue());
//        }
//        
//        System.out.println("");
//    }
    
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
    
    public void editarMusica(String chave ,Musica m, String email) throws IOException, MusicaNaoEncontradaException, MusicaJaCadastradaException {
        List<String> key = Arrays.asList(chave, email);
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        List<String> novaKey = Arrays.asList(m.getNome(), email);
        if(this.musicas.get(novaKey) != null) {
            throw new MusicaJaCadastradaException();
        }
        this.musicas.remove(key);
        this.musicas.put(novaKey, m);
        escreverNoArquivo();
    }

    public void remover(String nome, String email) throws IOException, MusicaNaoEncontradaException {
        List<String> key = Arrays.asList(nome, email);
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        musicas.remove(key);
        escreverNoArquivo();
    }
    
}
