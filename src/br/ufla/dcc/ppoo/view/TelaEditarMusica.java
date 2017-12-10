
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.exceptions.CampoMinimoException;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.MusicaNaoEncontradaException;
import br.ufla.dcc.ppoo.model.Musica;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaEditarMusica extends TelaLeDadosMusica {
    private String chave;
    
    
    public TelaEditarMusica(String chave, Musica m, Tela t) {
        super("Editar Música", t);
        this.chave = chave;
        this.construirTela(m);
        super.adicionarAcoes();
    }

    protected void construirTela(Musica m) {

        
        setTxtNome(new JTextField(m.getNome(), 10));
        setTxtAlbum(new JTextField(m.getAlbum(), 10));
        setTxtAno(new JTextField(Integer.toString(m.getAno()), 10));
        setTxtAutor(new JTextField(m.getAutor(), 10));
        setTxtGenero(new JTextField(m.getGenero(), 10));
        
        String[] t = m.getTags();
        String tags = "";
        
        for(String aux : t) {
            tags += " " + aux;
        }
        setTxtTags(new JTextField(tags, 10));
        
        super.construirTela();
        
    }

    @Override
    protected boolean executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        try {
            MusicaController.getInstancia().modificarMusica(chave, nome, autor, album, ano, genero, usuario, tags);
            return true;
        } catch (IOException | ClassNotFoundException | CampoVazioException |
                MusicaJaCadastradaException | CampoMinimoException | MusicaNaoEncontradaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    
    
}
