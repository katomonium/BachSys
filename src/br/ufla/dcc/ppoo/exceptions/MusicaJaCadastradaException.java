package br.ufla.dcc.ppoo.exceptions;

public class MusicaJaCadastradaException extends Exception {
    public MusicaJaCadastradaException() {
        super("Uma música com este nome já está cadastrada.");
    }
}
