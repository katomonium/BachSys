package br.ufla.dcc.ppoo;

import br.ufla.dcc.ppoo.controller.UsuarioController;
import br.ufla.dcc.ppoo.persistence.UsuarioDAO;
import java.util.Scanner;

public class PongSys {

    public static void main(String[] args) {
        System.out.println("Heyio :3");
        
        UsuarioDAO.getInstancia().visualizaUsuarios();
        
        UsuarioController.getInstancia().cadastrar("KatoMono", "K4t0mono@gmail.com", "senha");
        UsuarioController.getInstancia().cadastrar("Silventino", "silventino.gato@gmail.com", "senha");
        UsuarioDAO.getInstancia().visualizaUsuarios();
    }
}
