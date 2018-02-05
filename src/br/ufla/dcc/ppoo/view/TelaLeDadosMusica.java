
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public abstract class TelaLeDadosMusica  extends Tela {
    
    private JLabel lbNome;
    private JLabel lbAutor;
    private JLabel lbAlbum;
    private JLabel lbAno;
    private JLabel lbGenero;
    private JLabel lbTags;
    
    private JTextField txtNome;
    private JTextField txtAutor;
    private JTextField txtAlbum;
    private JTextField txtAno;
    private JTextField txtGenero;
    private JTextField txtTags;
    
    private JButton btnSalvar;
    private JButton btnCancelar;
    
    
    
    public TelaLeDadosMusica(String titulo, Tela t) {
        super(titulo, 350, 250, t);
    }

    
    @Override
    protected void construirTela() {
        lbNome = new JLabel("Nome:");
        lbAlbum = new JLabel("Album:");
        lbAno = new JLabel("Ano:");
        lbAutor = new JLabel("Autor:");
        lbGenero = new JLabel("Gênero:");
        lbTags = new JLabel("Tags:");
        
        btnCancelar = new JButton("Cancelar");
        btnSalvar = new JButton("Salvar");
        
        adicionarComponente(lbNome, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 0, 0, 1, 1);
        adicionarComponente(txtNome, GridBagConstraints.WEST, 
                            GridBagConstraints.HORIZONTAL, 0, 1, 3, 1);
        
        adicionarComponente(lbAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 1, 0, 1, 1);
        adicionarComponente(txtAutor, GridBagConstraints.WEST, 
                            GridBagConstraints.HORIZONTAL, 1, 1, 3, 1);
        
        
        adicionarComponente(lbAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 2, 0, 1, 1);
        adicionarComponente(txtAlbum, GridBagConstraints.WEST, 
                            GridBagConstraints.HORIZONTAL, 2, 1, 3, 1);
        
        
        adicionarComponente(lbGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 0, 1, 1);
        adicionarComponente(txtGenero, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 1, 1, 1);
        
        
        adicionarComponente(lbAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 2, 1, 1);
        adicionarComponente(txtAno, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 3, 3, 1, 1);
        
        
        adicionarComponente(lbTags, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 4, 0, 1, 1);
        adicionarComponente(txtTags, GridBagConstraints.WEST, 
                            GridBagConstraints.HORIZONTAL, 4, 1, 3, 1);
        
        
        adicionarComponente(btnCancelar, GridBagConstraints.EAST, 
                            GridBagConstraints.NONE, 5, 0, 2, 1);
        adicionarComponente(btnSalvar, GridBagConstraints.WEST, 
                            GridBagConstraints.NONE, 5, 2, 2, 1);

    }
    
    
    
    @Override
    protected void adicionarAcoes() {
        Tela t = this;
        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nome = txtNome.getText();
                String album = txtAlbum.getText();
                String autor = txtAutor.getText();
                String genero = txtGenero.getText();
                String[] tags = txtTags.getText().replaceAll("\\s+", " ").split(" ");
                String[] aux = new String[tags.length];
                int contador = 0;
                for(int i = 0; i < tags.length; i++) {
                    if(!tags[i].isEmpty()) {
                        aux[contador] = tags[i];
                        contador++;
                    }
                }
                tags = new String[contador];
                for (int i = 0; i < contador; i++) {
                    tags[i] = aux[i];
                }
                
                Integer ano;
                String usuario;
                
                try {
                    ano = Integer.parseInt(txtAno.getText());
                    usuario = UsuarioController.getInstancia().getEmailUsuarioLogado();
                    if(executarAcaoSalvar(nome, autor, album, ano, genero, usuario, tags)){
                        t.setVisible(false);
                    }
                    
                } catch (RuntimeException | IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                
                
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                t.setVisible(false);
            }
        });
    }
    
    
    protected abstract boolean executarAcaoSalvar(String nome, String autor, 
                                 String album, Integer ano, String genero, String usuario, String[] tags);
    
    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public void setTxtAlbum(JTextField txtAlbum) {
        this.txtAlbum = txtAlbum;
    }

    public void setTxtAno(JTextField txtAno) {
        this.txtAno = txtAno;
    }

    public void setTxtGenero(JTextField txtGenero) {
        this.txtGenero = txtGenero;
    }

    public void setTxtTags(JTextField txtTags) {
        this.txtTags = txtTags;
    }

    public void setBtnSalvar(JButton btnSalvar) {
        this.btnSalvar = btnSalvar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }
    
    
    
    
    
    
}
