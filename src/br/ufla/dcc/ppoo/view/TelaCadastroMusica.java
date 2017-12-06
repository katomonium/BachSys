
package br.ufla.dcc.ppoo.view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaCadastroMusica extends Tela{
    
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

    public TelaCadastroMusica(Tela t) {
        super("Cadastrar música", 350, 200, t);
        construirTela();
        adicionarAcoes();
    }

    @Override
    protected void construirTela() {

        lbNome = new JLabel("Nome:");
        lbAlbum = new JLabel("Album:");
        lbAno = new JLabel("Ano:");
        lbAutor = new JLabel("Autor:");
        lbGenero = new JLabel("Gênero:");
        lbTags = new JLabel("Tags:");
        
        txtNome = new JTextField(10);
        txtAlbum = new JTextField(10);
        txtAno = new JTextField(10);
        txtAutor = new JTextField(10);
        txtGenero = new JTextField(10);
        txtTags = new JTextField(10);
        
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
                
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                t.setVisible(false);
            }
        });
    }
    
}
