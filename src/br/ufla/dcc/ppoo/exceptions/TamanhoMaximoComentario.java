/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.exceptions;

/**
 *
 * @author aluno
 */
public class TamanhoMaximoComentario extends Exception {

    public TamanhoMaximoComentario(int tamanho) {
        super("O tamanho máximo do comentário é " + tamanho + " caracteres.");
    }
    
}
