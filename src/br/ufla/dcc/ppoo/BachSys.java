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
import br.ufla.dcc.ppoo.model.Usuario;
import br.ufla.dcc.ppoo.seguranca.Sessao;
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

        TelaInicial ti = new TelaInicial(null);
        Usuario u = new Usuario("teste", "t@t.c", "teste");
        Sessao.getInstancia().alterarSessao(u);
        TelaPrincipal t = new TelaPrincipal(ti);
        t.setVisible(true);

        

    }
}
