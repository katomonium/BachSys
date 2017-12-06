package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.ComentarioController;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.ConfirmacaoDeSenhaException;
import br.ufla.dcc.ppoo.exceptions.EmailInvalidoException;
import br.ufla.dcc.ppoo.exceptions.EmailJaCadastradoException;
import br.ufla.dcc.ppoo.exceptions.LoginInvalidoException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.SenhaCurtaException;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BachSys {

    public static void main(String[] args) throws LoginInvalidoException, EmailJaCadastradoException, ConfirmacaoDeSenhaException, SenhaCurtaException, CampoVazioException, EmailInvalidoException, MusicaJaCadastradaException {
        UsuarioController UCtrl = UsuarioController.getInstancia();

        try{
            UCtrl.cadastrar("k4t0mono", "k4t0mono@gmail.com", "KohZahv8", "KohZahv8");
        }
        catch(Exception e1){
            System.out.println("hoho");
        }

        try{
            UCtrl.cadastrar("aa", "ff@ff.com", "1235", "1235");
        }
        catch(Exception e1){
            System.out.println("hoho");
        }
        
        
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
        ti.setVisible(false);
        new TelaPrincipal(ti).setVisible(true);

//        Map<String, String> map = new HashMap<>();
//        map.put("oi", "heyio");
//        System.out.println(map.get("oi"));
//        
//        Map<String[], String> map2 = new HashMap<>();
//        
//        String[] k = {"2", "s"};
//        map2.put(k, "beta");
//        System.out.println(map2.get(k));
//        
//        map2.put(new String[] {"1", "a"}, "alfa");
//        System.out.println(map2.get(new String[] {"1", "a"}));
//        
//        Map<List<String>, String> map3 = new HashMap<>();
//        map3.put(Arrays.asList("1", "2"), "gamma");
//        System.out.println(map3.get(Arrays.asList("1", "2")));
    }
}
