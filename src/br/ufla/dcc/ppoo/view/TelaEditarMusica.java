
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.model.Musica;
import javax.swing.JTextField;

public class TelaEditarMusica extends TelaLeDadosMusica {
    
    public TelaEditarMusica(Musica m, Tela t) {
        super("Editar Música", t);
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
    protected void executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        MusicaController.getInstancia().modificarMusica(nome, autor, album, ano, genero, usuario, tags);
    }
    
    
    
}
