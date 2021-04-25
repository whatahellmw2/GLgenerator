/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.AbrirArquivoTexto;
import java.io.IOException;
import java.nio.file.Files;
import view.SeletorArquivoView;

/**
 *
 * @author hiago
 */
public class SeletorArquivoPresenter {
    private SeletorArquivoView view;

    public SeletorArquivoPresenter(TelaPrincipalPresenter viewp) throws IOException{
        this.view = new SeletorArquivoView();
        this.view.setLocationRelativeTo(null);
        selecionarArquivo(viewp);
        
    }
    public void selecionarArquivo(TelaPrincipalPresenter viewp) throws IOException{
        this.view.getSelecionadorDeArquivo().setFileFilter(this.view.getFiltro());        
        int returnVal = this.view.getSelecionadorDeArquivo().showOpenDialog(view);
        if(returnVal == this.view.getSelecionadorDeArquivo().APPROVE_OPTION) {            
           viewp.escreverTextoNaCaixa(
                   new AbrirArquivoTexto().lerArquivo(this.view
                           .getSelecionadorDeArquivo().getSelectedFile().toPath()));
           
        }
    }
    
}
