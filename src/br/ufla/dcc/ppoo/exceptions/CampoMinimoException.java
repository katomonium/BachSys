package br.ufla.dcc.ppoo.exceptions;

public class CampoMinimoException extends Exception {

    public CampoMinimoException(String campo, Integer qtdMinimo) {
        super("O campo " + campo + " deve conter no minimo " + qtdMinimo.toString() + " itens");
    }
    
}
