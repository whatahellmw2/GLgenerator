/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collections.ExemplosCollection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import view.TelaPrincipalView;
import javax.swing.text.StyledDocument;

public class TelaPrincipalPresenter {
    
    private TelaPrincipalView view;
    //private TelaPrincipalPresenter viewp = this;
    private ExemplosCollection collection = new ExemplosCollection();
    
    public static void main(String args[]) {
        System.setProperty("java.library.path", "/home/thiago/NetBeansProjects/GLgenerator/src/tccjni/");
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
        
        Document doc = this.view.getCaixaTexto().getDocument();

        StyleContext sc = new StyleContext();
        Style style = sc.addStyle("yourStyle", null);

        Font font = new Font("Arial", Font.BOLD, 18);

        StyleConstants.setForeground(style, Color.RED);
        StyleConstants.setFontFamily(style, font.getFamily());
        StyleConstants.setBold(style, true);
        String selected = this.view.getCaixaTexto().getSelectedText();
        int start = this.view.getCaixaTexto().getSelectionStart();
        int end = this.view.getCaixaTexto().getSelectionEnd();
        String startSubString= this.view.getCaixaTexto().getText().substring(0, start);
        String endSubString= this.view.getCaixaTexto().getText().substring(end,this.view.getCaixaTexto().getText().length() );
        //System.out.println("substring inicial: "+startSubString);
        //System.out.println("substring final: "+endSubString);
        try {
                Style s1 = this.view.getCaixaTexto().getStyle(startSubString);
                Style s2 = this.view.getCaixaTexto().getStyle(endSubString);
                //System.out.println("start: "+start+"end: "+end);
                doc.remove(startSubString.length(), selected.length());
                //doc.insertString(0, startSubString, s1);
                //doc.insertString(startSubString.length(),selected, style);
                
                //doc.insertString(startSubString.length()+selected.length(), endSubString, s2);
                doc.insertString(start,selected, style);
            } catch (BadLocationException ex) {
                Logger.getLogger(TelaPrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public void exibirExemplos(){
        new ExemplosPresenter(collection);
    }
    public void gerarGramatica(){
        GrafosPresenter gpresenter = new GrafosPresenter();
       gpresenter.constructGraph();
    }
}
