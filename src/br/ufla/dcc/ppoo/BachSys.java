package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.persistence.MusicaDAO;
import br.ufla.dcc.ppoo.persistence.UsuarioDAO;

public class BachSys {

    public static void main(String[] args) {
        System.out.println("Heyio :3");
        
        UsuarioDAO.getInstancia().visualizaUsuarios();
        UsuarioController.getInstancia().cadastrar("KatoMono", "k4t0mono@gmail.com", "senha");
        UsuarioController.getInstancia().cadastrar("k4t0mono", "k4t0mono@gmail.com", "senha");
        UsuarioController.getInstancia().cadastrar("Silventino", "silventino.gato@gmail.com", "senha");
        UsuarioDAO.getInstancia().visualizaUsuarios();
    }
}
