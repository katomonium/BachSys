
package br.ufla.dcc.ppoo.exceptions;

public class EmailInvalidoException extends Exception{
    public EmailInvalidoException(){
        super("Digite um e-mail válido.");
    }
}
