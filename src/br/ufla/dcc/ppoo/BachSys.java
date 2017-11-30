package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;
import java.util.List;

public class BachSys {

    public static void main(String[] args) {
//        UsuarioController.getInstancia().cadastrar("thuza", "a@a.a", "1234");
//        TelaInicial telaIni = new TelaInicial(null);
////        telaIni.setVisible(true);        
//
//        UsuarioController.getInstancia().iniciarSessao("a@a.a", "1234");
//        new TelaPrincipal(telaIni).setVisible(true);
        
        UsuarioController UCtrl = UsuarioController.getInstancia();

        UCtrl.cadastrar("k4t0mono", "k4t0mono@gmail.com", "KohZahv8");
        UCtrl.cadastrar("aa", "ff@ff.com", "1235");
        
        MusicaController MCtrl = MusicaController.getINSTANCIA();
        
        MCtrl.addMusica(
                "Time", "Epic Mountain", "Kurzgesast 1", 2014, "",
                UsuarioController.getInstancia().getUsuario("k4t0mono@gmail.com"),
                null
        );
        
        MCtrl.addMusica(
                "Time2", "Epic Mountain", "Kurzgesast 1", 2014, "",
                UsuarioController.getInstancia().getUsuario("k4t0mono@gmail.com"),
                null
        );
        
        MCtrl.addMusica(
                "Time3", "Epic Mountain", "Kurzgesast 1", 2014, "",
                UsuarioController.getInstancia().getUsuario("ff@ff.com"),
                null
        );
        
        System.out.println(MCtrl.getQtdMusicas());
        System.out.println(MCtrl.getQtdMusicas("k4t0mono@gmail.com"));
        System.out.println(MCtrl.getQtdMusicas("ff@ff.com"));
        
        List<Musica> musicas = MCtrl.getMusicas("k4t0mono@gmail.com");
        musicas.forEach((musica) -> {
            System.out.println(musica);
        });
        
        List<Musica> musicas2 = MCtrl.getMusicas("ff@ff.com");
        musicas2.forEach((musica) -> {
            System.out.println(musica);
        });
    }
}
