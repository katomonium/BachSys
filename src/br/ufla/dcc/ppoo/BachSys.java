package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;

public class BachSys {

    public static void main(String[] args) {
//        System.out.println("Heyio :3");
//        
//        UsuarioDAO.getInstancia().visualizaUsuarios();
//        UsuarioController.getInstancia().cadastrar("KatoMono", "k4t0mono@gmail.com", "senha");
//        UsuarioController.getInstancia().cadastrar("k4t0mono", "k4t0mono@gmail.com", "senha");
//        UsuarioController.getInstancia().cadastrar("Silventino", "silventino.gato@gmail.com", "senha");
//        UsuarioController.getInstancia().cadastrar("Alberto", "alberto.gato@gmail.com", "senha");
//        UsuarioDAO.getInstancia().visualizaUsuarios();
        
//        Usuario u1 = new Usuario("KatoMono", "k4t0mono@gmail.com", "senha");
//
//        MusicaDAO.getINSTANCIA().visualizarMusicas();
//        MusicaDAO.getINSTANCIA().addMusica(new Musica("çol", "a", "b", 1998, "pumk-funk", u1, null));
//        MusicaDAO.getINSTANCIA().visualizarMusicas();

        UsuarioController.getInstancia().cadastrar("thuza", "a@a.a", "1234");
        TelaInicial telaIni = new TelaInicial(null);
//        telaIni.setVisible(true);        

        
        UsuarioController.getInstancia().iniciarSessao("a@a.a", "1234");
        new TelaPrincipal(telaIni).setVisible(true);
        
    }
}
