/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.exceptions;

/**
 *
 * @author silventino
 */
public class EmailJaCadastradoException extends Exception{
    public EmailJaCadastradoException(){
        super("O e-mail informado já está cadastrado.");
    }
}
