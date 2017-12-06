
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import javax.swing.JTextField;

public class TelaCadastroMusica extends TelaLeDadosMusica {

    public TelaCadastroMusica(Tela t) {
        super("Cadastrar música", t);
        construirTela();
        super.adicionarAcoes();
    }

    @Override
    protected void construirTela() {

        
        setTxtNome(new JTextField(10));
        setTxtAlbum(new JTextField(10));
        setTxtAno(new JTextField(10));
        setTxtAutor(new JTextField(10));
        setTxtGenero(new JTextField(10));
        setTxtTags(new JTextField(10));
        
        super.construirTela();
        
    }

    @Override
    protected void executarAcaoSalvar(String nome, String autor, String album, Integer ano, String genero, String usuario, String[] tags) {
        MusicaController.getInstancia().addMusica(nome, autor, album, ano, genero, usuario, tags);

    }
  
}
