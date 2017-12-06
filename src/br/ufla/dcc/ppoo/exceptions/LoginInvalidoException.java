
package br.ufla.dcc.ppoo.exceptions;

public class LoginInvalidoException extends Exception {
    public LoginInvalidoException(){
        super("Usuário ou senha inválidos.");
    }
}
