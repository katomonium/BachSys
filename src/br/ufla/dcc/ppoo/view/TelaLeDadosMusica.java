
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        super(titulo, 350, 200, t);
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
                ArrayList<String> tags = new ArrayList<String>();
                String[] aux = txtTags.getText().split(" ");
                for(int i = 0; i < aux.length; i++) {
                    if(!aux[i].equals("")) {
                        tags.add(aux[i]);
                    }
                }
                
                if(nome.equals("")) {
                    System.out.println("NOME");
                    return;
                }
                
                if(album.equals("")) {
                    System.out.println("ALBUM");
                    return;
                }
                
                if(autor.equals("")) {
                    System.out.println("AUTOR");
                    return;
                }
                
                if(genero.equals("")) {
                    System.out.println("GENERO");
                    return;

                }
                
                if(tags.size() < 2) {
                    System.out.println("TAGS");
                    return;
                }
                
                Integer ano = -1;
                
                try {
                    ano = Integer.parseInt(txtAno.getText());
                } catch (RuntimeException rtm) {
                    System.out.println("ANO");
                }
                
                String usuario = UsuarioController.getInstancia().getEmailUsuarioLogado();
                MusicaController.getInstancia().addMusica(nome, autor, album, 
                                            ano, genero, usuario, aux);
                
                t.setVisible(false);
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                t.setVisible(false);
            }
        });
    }
    
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
    
    
    
    
    
}
