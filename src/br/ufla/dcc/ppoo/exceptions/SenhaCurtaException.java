
package br.ufla.dcc.ppoo.exceptions;

public class SenhaCurtaException extends Exception{
    public SenhaCurtaException(){
        super("A senha deve conter no mínimo 4 digitos.");
    }
}
