package br.ufla.dcc.ppoo.persistence;

import br.ufla.dcc.ppoo.model.Comentario;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComentarioDAOArquivo extends DAOArquivo implements ComentarioDAO {
    
    private static ComentarioDAOArquivo INSTANCIA;
    
    private Map<List<String>, List<Comentario>> comentarios;
    
    private ComentarioDAOArquivo() throws ClassNotFoundException, IOException {
        super("comentarios.bin");
        FileInputStream fis = new FileInputStream(getNomeArquivo());
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            this.comentarios = (Map<List<String>, List<Comentario>>) ois.readObject();
        } catch (IOException ioe) {
            this.comentarios = new HashMap<>();
        }
    }
    
    public static ComentarioDAOArquivo getInstancia() throws IOException, ClassNotFoundException {
        if(INSTANCIA == null) {
            INSTANCIA = new ComentarioDAOArquivo();
        }
        return INSTANCIA;
    }
    
    public void adicionarComentario(String emailDono, String musicaNome,
                                    Comentario comentario ) throws IOException {
        List<String> chave = Arrays.asList(emailDono, musicaNome);
        List<Comentario> cs = getComentariosMusica(emailDono, musicaNome);
        if(cs == null) {
            cs = new ArrayList<Comentario>();
        }
        cs.add(comentario);
        this.comentarios.put(chave, cs);
        salvar();
        
    }
    
    @Override
    public List<Comentario> getComentariosMusica(String emailDono, String musicaNome) {
        List<String> chave = Arrays.asList(emailDono, musicaNome);
        return this.comentarios.get(chave);
    }

    
    @Override
    public void salvar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new 
        FileOutputStream(getNomeArquivo()));
        oos.writeObject(this.comentarios);
        oos.close();
    }
    
}
