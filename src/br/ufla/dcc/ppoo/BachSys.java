package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.ComentarioController;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.LoginInvalidoException;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;

public class BachSys {

    public static void main(String[] args) throws LoginInvalidoException {
        UsuarioController UCtrl = UsuarioController.getInstancia();

        UCtrl.cadastrar("k4t0mono", "k4t0mono@gmail.com", "KohZahv8");
        UCtrl.cadastrar("aa", "ff@ff.com", "1235");
        
        MusicaController MCtrl = MusicaController.getInstancia();
        for (int i = 0; i < 50; i++) {
            MCtrl.addMusica(
                    "Time1" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
                    null
            );

            MCtrl.addMusica(
                    "Time2" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
                    null
            );

            MCtrl.addMusica(
                    "silva" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
                    new String[] {"fff", "ggg"}
            );
        }
        ComentarioController CCtrl = ComentarioController.getIntancia();
        
        CCtrl.visualizarComentarios();
        
        UCtrl.iniciarSessao("k4t0mono@gmail.com", "KohZahv8");
        TelaInicial ti = new TelaInicial(null);
        new TelaPrincipal(ti).setVisible(true);
    }
}
