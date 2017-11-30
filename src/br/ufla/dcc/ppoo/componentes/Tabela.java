/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.ppoo.componentes;

import br.ufla.dcc.ppoo.model.Musica;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author aluno
 */
public class Tabela extends JTable{
    
    public Tabela(List<Musica> musicas, String[] colunas){
        super(formatarMusicas(musicas), colunas);
        getTableHeader().setReorderingAllowed(false);
    }
    
    private static Object[][] formatarMusicas(List<Musica> musicas){ 
        
        
        
        Object objetos[][] = new Object[musicas.size()][5];
        
        for(int i = 0; i < musicas.size(); i++){
            objetos[i][0] = musicas.get(i).getNome();
            objetos[i][1] = musicas.get(i).getAutor();
            objetos[i][2] = musicas.get(i).getAlbum();
            objetos[i][3] = musicas.get(i).getGenero();
            objetos[i][4] = musicas.get(i).getAno();
        }
        return objetos;
    } 
    
    @Override
    public boolean isCellEditable(int row, int column){  
          return false;  
    }
    
    
    
}
