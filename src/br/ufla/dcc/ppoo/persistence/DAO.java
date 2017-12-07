
package br.ufla.dcc.ppoo.persistence;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public abstract class DAO {
    private final String nomeArquivo;

    public DAO(String nomeArquivo) throws IOException {
        this.nomeArquivo = nomeArquivo;
        gerarArquivoSeNaoExiste();
    }
    
    protected String getNomeArquivo(){
        return nomeArquivo;
    }
    
    
    public void gerarArquivoSeNaoExiste() throws IOException {
        File arq = new File(nomeArquivo);
        if(!arq.exists()) {
            if(arq.createNewFile()) {
                arq.canRead();
                arq.canWrite();
                arq.canExecute();
                
            }
            
        }
  
    }
}
