package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.view.TelaPrincipal;

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
        
        MusicaController MCtrl = MusicaController.getInstancia();
        for(int i = 0; i < 39; i++) {

            MCtrl.addMusica(
                    "Time1" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("k4t0mono@gmail.com"),
                    null
            );

            MCtrl.addMusica(
                    "Time2" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("k4t0mono@gmail.com"),
                    null
            );

            MCtrl.addMusica(
                    "Time3" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("ff@ff.com"),
                    null
            );
        }
        
        UCtrl.iniciarSessao("ff@ff.com", "1235");
        new TelaPrincipal(null).setVisible(true);
    }
}
