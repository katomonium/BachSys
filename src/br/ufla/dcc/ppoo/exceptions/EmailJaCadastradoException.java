package br.ufla.dcc.ppoo.exceptions;

public class EmailJaCadastradoException extends Exception{
    public EmailJaCadastradoException(){
        super("O e-mail informado já está cadastrado.");
    }
}
