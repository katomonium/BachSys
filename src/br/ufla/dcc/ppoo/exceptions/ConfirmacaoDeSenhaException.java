
package br.ufla.dcc.ppoo.exceptions;

public class ConfirmacaoDeSenhaException extends Exception {
    public ConfirmacaoDeSenhaException(){
        super("Senha e confirmação de senha devem ser iguais");
    }
}
