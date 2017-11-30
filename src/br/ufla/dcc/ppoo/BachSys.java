package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.ComentarioController;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.persistence.ComentarioDAO;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;
import java.util.List;

public class BachSys {

    public static void main(String[] args) {
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
        
        ComentarioController CCtrl = ComentarioController.getINSTANCIA();
        
        CCtrl.visualizarComentarios();
        
        CCtrl.addComentario("a@a.a", "Time", "Lorem ipsum");
        CCtrl.visualizarComentarios();
    }
}
