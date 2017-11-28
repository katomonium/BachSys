package br.ufla.dcc.ppoo.view;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;


=======
import javax.swing.JPanel;


>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
public class TelaPrincipal extends Tela {
    
    private JPanel painelDadosUsuario;
    private JPanel painelAcoes;
    private JPanel painelListaMusica;
    
<<<<<<< HEAD
    public TelaPrincipal(Tela t) {
        super("BachSys", 800, 600, t);
        construirTela();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        

        
    }
    
    @Override
    protected void construirTela() {
        painelAcoes = new JPanel();
        painelAcoes.setPreferredSize(new Dimension(100,100));
        painelAcoes.setBackground(Color.yellow);
        adicionarComponente(painelAcoes, GridBagConstraints.WEST, GridBagConstraints.NONE, 1, 0, 1, 1);
        painelDadosUsuario = new JPanel();
        painelDadosUsuario.setPreferredSize(new Dimension(100, 200));
        painelDadosUsuario.setBackground(Color.blue);
        adicionarComponente(painelDadosUsuario, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, 0, 1, 1);
        painelListaMusica = new JPanel();
        painelListaMusica.setPreferredSize(new Dimension(400,100));
        adicionarComponente(painelListaMusica, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0, 1, 1, 2);
        painelListaMusica.setBackground(Color.red);
        
        JButton b = new JButton("TESTE");
        painelAcoes.add(b);
        JButton b2 = new JButton("TESTE");
        painelListaMusica.add(b2);
        JButton b3 = new JButton("TESTE");
        painelDadosUsuario.add(b3);
=======
    public TelaPrincipal() {
        super("BachSys", 800, 600);
        construirTela();
        
        painelAcoes = new JPanel();
        painelDadosUsuario = new JPanel();
        painelListaMusica = new JPanel();
    }
    
    @Override
    protected void construirTela() {
        
    }

    @Override
    protected void adicionarAcoes() {
        
>>>>>>> 1e7be4f04d1b7a67df079e8e6bfcc12a6fcb7c19
    }
    
}
