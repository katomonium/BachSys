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
        ComentarioController CCtrl = ComentarioController.getIntancia();
        
        CCtrl.visualizarComentarios();
        
        UCtrl.iniciarSessao("ff@ff.com", "1235");
        TelaInicial ti = new TelaInicial(null);

        new TelaPrincipal(ti).setVisible(true);

    }
}
