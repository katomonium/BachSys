/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.view;

import br.ufla.dcc.ppoo.model.Musica;

/**
 *
 * @author dell
 */
public class TelaDadosMusica extends Tela {

    public TelaDadosMusica(Musica musica, Tela t) {
        super(musica.getNome(), 350, 450, t);
        
        construirTela();
    }

    
    
    @Override
    protected void construirTela() {
        
    }

    @Override
    protected void adicionarAcoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
