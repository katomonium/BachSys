
package br.ufla.dcc.ppoo.seguranca;

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
        System.out.println("Logou carai");
    }
    
    public Boolean estaLogado() {
        if(usuario == null) {
            return false;
        }
        return true;
    }
    
    public String getNomeUsuario() {
        if(usuario == null) {
            // TODO: Excecao "Não há usuario logado"
            return "";
        }
        return usuario.getNome();
    }
    
    public String getEmailUsuario() {
        if(usuario == null) {
            // TODO: Excecao "Não há usuario logado"
            return "";
        }
        return usuario.getEmail();
    }
    
    
}
