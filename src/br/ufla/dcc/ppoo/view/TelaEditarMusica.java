
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarMusica extends TelaLeDadosMusica {
    private String nomeAntigo;
    private Musica musica;
    
    
    public TelaEditarMusica(String nomeAntigo, Musica m, Tela t) {
        super("Editar Música", t);
        this.nomeAntigo = nomeAntigo;
        this.musica = m;
        this.construirTela();
        super.adicionarAcoes();
    }

    protected void construirTela() {

        
        setTxtNome(new JTextField(musica.getNome(), 10));
        setTxtAlbum(new JTextField(musica.getAlbum(), 10));
        setTxtAno(new JTextField(Integer.toString(musica.getAno()), 10));
        setTxtAutor(new JTextField(musica.getAutor(), 10));
        setTxtGenero(new JTextField(musica.getGenero(), 10));
        
        String[] t = musica.getTags();
        String tags = "";
        
        for(String aux : t) {
            tags += aux + " ";
        }
        setTxtTags(new JTextField(tags, 10));
        super.construirTela();
        
    }

    @Override
    protected boolean executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        try {
            MusicaController.getInstancia().modificarMusica(nomeAntigo, nome, autor, album, ano, genero, usuario, tags);
            musica = MusicaController.getInstancia().getMusica(nome, usuario);
            return true;
        } catch (IOException | ClassNotFoundException | CampoVazioException |
                MusicaJaCadastradaException | CampoMinimoException | MusicaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public Musica getMusica() {
        return musica;
    }
    
    
    
}
