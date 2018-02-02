/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.exceptions;

/**
 *
 * @author dell
 */
public class MusicaJaAvaliadaException extends Exception {

    public MusicaJaAvaliadaException(String musica) {
        super("Voce ja avaliou a musica " + musica + "!");
    }
    
}
