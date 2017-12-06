
package br.ufla.dcc.ppoo.seguranca;

import br.ufla.dcc.ppoo.exceptions.NaoHaUsuarioLogadoException;
import br.ufla.dcc.ppoo.model.Usuario;

public class Sessao {
    // instância única da classe (Padrão de Projeto Singleton)
    private static Sessao instancia = new Sessao();
    private Usuario usuario;

    private Sessao() {}
    
    public static Sessao getInstancia(){
        return instancia;
    }
    
    public void alterarSessao(Usuario u) {
        if((u == null) || (usuario != null)) {
            System.out.println("Não logou");
            return;
        }
        this.usuario = u;
    }
    
    public void finalizar() throws NaoHaUsuarioLogadoException {
        if(usuario == null) {
            throw new NaoHaUsuarioLogadoException();
        }
        this.usuario = null;
        System.out.println("Deslogou carai");
    }
    
    public Boolean estaLogado() {
        return usuario != null;
    }
    
    public String getNomeUsuario() throws NaoHaUsuarioLogadoException {
        if(usuario == null) {
            throw new NaoHaUsuarioLogadoException();
        }
        return usuario.getNome();
    }
    
    public String getEmailUsuario() throws NaoHaUsuarioLogadoException {
        if(usuario == null) {
            throw new NaoHaUsuarioLogadoException();
        }
        return usuario.getEmail();
    }
    
    
}
