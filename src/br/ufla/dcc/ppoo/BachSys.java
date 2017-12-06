package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.ComentarioController;
import br.ufla.dcc.ppoo.controller.MusicaController;
import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.view.TelaEditarMusica;
import br.ufla.dcc.ppoo.exceptions.CampoVazioException;
import br.ufla.dcc.ppoo.exceptions.ConfirmacaoDeSenhaException;
import br.ufla.dcc.ppoo.exceptions.EmailInvalidoException;
import br.ufla.dcc.ppoo.exceptions.EmailJaCadastradoException;
import br.ufla.dcc.ppoo.exceptions.LoginInvalidoException;
import br.ufla.dcc.ppoo.exceptions.MusicaJaCadastradaException;
import br.ufla.dcc.ppoo.exceptions.SenhaCurtaException;
import br.ufla.dcc.ppoo.model.Musica;
import br.ufla.dcc.ppoo.view.TelaInicial;
import br.ufla.dcc.ppoo.view.TelaPrincipal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BachSys {

    public static void main(String[] args) throws LoginInvalidoException, EmailJaCadastradoException, ConfirmacaoDeSenhaException, SenhaCurtaException, CampoVazioException, EmailInvalidoException, IOException, ClassNotFoundException {
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
        
//        MusicaController MCtrl = MusicaController.getInstancia();
//        for (int i = 0; i < 50; i++) {
//            MCtrl.addMusica(
//                    "Time1" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
//                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
//                    null
//            );
//
//            MCtrl.addMusica(
//                    "Time2" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
//                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
//                    null
//            );
//
//            MCtrl.addMusica(
//                    "silva" + i, "Epic Mountain", "Kurzgesast 1", 2014, "",
//                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
//                    new String[] {"fff", "ggg"}
//            );
//        }
        ComentarioController CCtrl = ComentarioController.getIntancia();
        
        CCtrl.visualizarComentarios();
        
        UCtrl.iniciarSessao("ff@ff.com", "1235");
        TelaInicial ti = new TelaInicial(null);
//        Musica m = new Musica("Uauu", "Epic Mountain", "Kurzgesast 1", 2014, "",
//                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
//                    null);
//        Musica m2 = new Musica("YEAH", "Epic Mountain", "Kurzgesast 1", 2014, "",
//                    UsuarioController.getInstancia().getUsuario("ff@ff.com").getEmail(),
//                    null);
//        
//        Map<String[], Musica> lista = new HashMap<>();
//        String[] key = new String[] {"silsilsil", m.getNome()};
//        lista.put(key,m);
//        
//        String[] key2 = new String[] {"silsilsil", m2.getNome()};
//        lista.put(key2, m2);
//        
//        ObjectOutputStream oos = new ObjectOutputStream(new 
//        FileOutputStream("musica.bin"));
//          
//        oos.writeObject(lista);
//        
//        oos.close();
//        
//        ObjectInputStream ois = new ObjectInputStream(new 
//        FileInputStream("musica.bin"));
//          
//        Map<String[], Musica> teste = (Map<String[], Musica>) ois.readObject();
//        
//        ois.close();
//        
//        System.out.println(teste);

        new TelaPrincipal(ti).setVisible(true);

    }
}
