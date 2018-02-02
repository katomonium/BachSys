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

public class MusicaDAOArquivo extends DAOArquivo implements MusicaDAO {
    
    private static MusicaDAOArquivo INSTANCIA;
    // Map<NomeDaMusica, Musica>
    private Map<List<String>, Musica> musicas;

    private MusicaDAOArquivo() throws IOException, ClassNotFoundException {
        super("musicas.bin");
        FileInputStream fis = new FileInputStream(getNomeArquivo());
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.musicas = (Map<List<String>, Musica>) ois.readObject();
        } catch (IOException ioe) {
            musicas = new HashMap<>();
        }
        
    }
    
    public static MusicaDAOArquivo getINSTANCIA() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null) {
            INSTANCIA = new MusicaDAOArquivo();
        }
        return INSTANCIA;
    }
    
    @Override
    public void salvar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new 
        FileOutputStream(getNomeArquivo()));
        oos.writeObject(this.musicas);
        oos.close();
    }
    
    @Override
    public Musica getMusica(String nome, String email) throws MusicaNaoEncontradaException {
        List<String> key = Arrays.asList(nome, email);
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        return this.musicas.get(key);
    }
    
    @Override
    public void adicionarMusica(String chave, Musica m, String email) throws MusicaJaCadastradaException, IOException {
        List<String> key = Arrays.asList(chave, email);
        
        if(this.musicas.get(key) != null) {
            throw new MusicaJaCadastradaException();
        }
        this.musicas.put(key, m);
        salvar();
        
    }
    
    @Override
    public int getSize() {
        return this.musicas.size();
    }
    
    @Override
    public int getQtdMusicas() {
        return musicas.size();
    }
    
    @Override
    public int getQtdMusicas(String email) {
        return this.getMusicas(email).size();
    }
    
    @Override
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
    
    @Override
    public List<Musica> getMusicas() {
        ArrayList<Musica> musicasDoUsuario = new ArrayList<>();
                
        for (Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            musicasDoUsuario.add(musica);
        }
        return musicasDoUsuario;
    }
    
    @Override
    public void editarMusica(String chave ,Musica m, String email) throws IOException, MusicaNaoEncontradaException, MusicaJaCadastradaException {
        List<String> key = Arrays.asList(chave, email);
        
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        Musica musicaAntiga = this.musicas.get(key);
        this.musicas.remove(key);
        List<String> novaKey = Arrays.asList(m.getNome(), email);
        if(this.musicas.get(novaKey) != null) {
            this.musicas.put(key, musicaAntiga);
            throw new MusicaJaCadastradaException();
        }
        this.musicas.put(novaKey, m);
        salvar();
    }
    
    @Override
    public void remover(String nome, String email) throws IOException, MusicaNaoEncontradaException {
        List<String> key = Arrays.asList(nome, email);
        if(this.musicas.get(key) == null) {
            throw new MusicaNaoEncontradaException();
        }
        musicas.remove(key);
        salvar();
    }

    @Override
    public List<Musica> getMusicasPeloNome(String nome) {
        nome = nome.toLowerCase();
        List<Musica> retorno = new ArrayList<Musica>();
        for(Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica m = entry.getValue();
            String nomeMusica = m.getNome().toLowerCase();
            if(nomeMusica.contains(nome)) {
                retorno.add(m);
            }
        }
        return retorno;
    }

    @Override
    public List<Musica> getMusicasPelaTag(String tag) {
        List<Musica> retorno = new ArrayList<Musica>();
        for(Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica m = entry.getValue();
            Boolean achou = false;
            String[] tags = m.getTags();
            for(int i = 0; (i < tags.length) && !(achou); i++) {
                if(tags[i].equals(tag)) {
                    retorno.add(m);
                }
            }
        }
        return retorno;
    }

    @Override
    public String getGeneroMaiorNumero(String email) {
        List<Musica> musicas = getMusicas(email);
        int contador = 0;
        String genero = "";
        for(Musica m1 : musicas) {
            int contador2 = 0;
            String generoAux = m1.getGenero();
            for(Musica m2 : musicas) {
                if(m2.getGenero().equals(generoAux)) {
                    contador2++;
                }
            }
            if(contador < contador2) {
                genero = generoAux;
                contador = contador2;
            }
        }
        return genero;
    }

    @Override
    public List<Musica> getRecomendacoes(String email) {
        String genero = getGeneroMaiorNumero(email);
        List<Musica> musicasDoGenero = new ArrayList<Musica>();
        for (Map.Entry<List<String>,Musica> entry : musicas.entrySet()) {
            Musica musica = entry.getValue();
            // se a musica nao pertence ao usuario e o genero é igual ao "favorito" do usuario
            if(!(email.equals(musica.getEmail())) &&
                    genero.equals(musica.getGenero())) {
                // se o usuario nao cadastrou uma musica com aquele nome
                List<String> key = Arrays.asList(musica.getNome(), email);                
                if(this.musicas.get(key) == null) {
                    musicasDoGenero.add(musica);
                }
            }
        }
        return musicasDoGenero;
    }
    
}
