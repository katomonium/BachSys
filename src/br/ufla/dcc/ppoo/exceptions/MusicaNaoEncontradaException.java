
package br.ufla.dcc.ppoo.exceptions;

public class MusicaNaoEncontradaException extends Exception{

    public MusicaNaoEncontradaException() {
        super("A musica procurada nao foi encontrada entre as musicas cadastradas");
    }
    
}
