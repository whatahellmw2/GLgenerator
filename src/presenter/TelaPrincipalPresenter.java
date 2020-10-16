/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collections.ExemplosCollection;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.TelaPrincipalView;


public class TelaPrincipalPresenter {
    
    private TelaPrincipalView view;
    //private TelaPrincipalPresenter viewp = this;
    private ExemplosCollection collection = new ExemplosCollection();
    
    public static void main(String args[]) {
        System.setProperty("java.library.path", "C:\\Users\\hiago\\Documents\\NetBeansProjects\\tcc2\\src\\DLLJNI\\UnitexJni.dll");
        //System.out.println(System.getProperty("java.library.path"));
        
        new TelaPrincipalPresenter();
        
    }
    
    public TelaPrincipalPresenter(){
        this.view= new TelaPrincipalView();
        //listeners
        //carregar Texto
        this.view.getCarregarTextoOp().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerTexto();                
            }
        });
        //salvar Exemplos
        this.view.getSelecionarExemplosOp().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarExemplo();
            }
        });
        //exibir Exemplos
        this.view.getExibirExemplosOp().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirExemplos();
            }
        });
        this.view.getGerarGramaticaOp().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarGramatica();
            }
        });
        this.view.setVisible(true);
        
    }
  
    public void lerTexto(){
        SeletorArquivoPresenter carregar;
        try {
           carregar = new SeletorArquivoPresenter(this);

       } catch (IOException ex) {
           Logger.getLogger(TelaPrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void escreverTextoNaCaixa(String textop){
        this.view.getCaixaTexto().setText(textop);      
    }
    public void salvarExemplo(){
        collection.salvarExemplo(this.view.getCaixaTexto().getSelectedText());        
    }
    public void exibirExemplos(){
        new ExemplosPresenter(collection);
    }
    public void gerarGramatica(){
        GrafosPresenter gpresenter = new GrafosPresenter();
       gpresenter.testarLib();
    }
}
