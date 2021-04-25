/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collections.ExemplosCollection;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import view.ExemplosView;

/**
 *
 * @author hiago
 */
public class ExemplosPresenter {
    private ExemplosView view;
    
    public ExemplosPresenter(ExemplosCollection collectionp){    
        this.view = new ExemplosView();
        exibirExemplos(collectionp);
        //listeners
        //sair
        this.view.getBtnSair().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        this.view.getBtnEditarExemplos().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarExemplos(collectionp);
            }
        });
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    public void exibirExemplos(ExemplosCollection collectionp){
        
        DefaultTableModel model = (DefaultTableModel) this.view.getTabelaExemplos().getModel();
        model.setNumRows(0);
        for(String exemplo: collectionp.getListaExemplos()){
           model.addRow(new Object[]{
               exemplo,false
           });
        }
    }
    public void sair(){
        this.view.dispose();
    }
    public void editarExemplos(ExemplosCollection collectionp){
        for(int linha=0; linha<this.view.getTabelaExemplos().getRowCount();linha++){
            if((boolean)this.view.getTabelaExemplos().getValueAt(linha,1)){
                //System.out.println(this.view.getTabelaExemplos().getValueAt(linha, 0));
                collectionp.getListaExemplos().set(linha,(String)this.view.getTabelaExemplos().getValueAt(linha, 0));
                this.view.getTabelaExemplos().setValueAt(false, linha, 1);
//}
             //System.out.println(this.view.getTabelaExemplos().getValueAt(linha, 0)+" "+this.view.getTabelaExemplos().getValueAt(linha, 1)
               //       );
            }
        }
    }
}