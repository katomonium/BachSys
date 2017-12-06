
package br.ufla.dcc.ppoo.exceptions;

import javax.swing.JLabel;

public class CampoVazioException extends Exception{
    public CampoVazioException(String campo){
        super("O campo " + campo + " deve ser preenchido.");
    }
}
