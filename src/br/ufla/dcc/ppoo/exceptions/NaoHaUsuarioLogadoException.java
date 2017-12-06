package br.ufla.dcc.ppoo.exceptions;

public class NaoHaUsuarioLogadoException extends Exception {
    
    public NaoHaUsuarioLogadoException() {
        super("Não há usuário logado");
    }
    
}
