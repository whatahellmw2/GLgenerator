/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JEditorPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTextPane;

/**
 *
 * @author hiago
 */
public class TelaPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalView
     */
    public TelaPrincipalView() {
        initComponents();
        
        caixaTexto.setEditable(true);
        //caixaTexto.setContentType("txt/html");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        caixaTexto = new javax.swing.JTextPane();
        fontSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTexto = new javax.swing.JMenu();
        carregarTextoOp = new javax.swing.JMenuItem();
        exemplosMenu = new javax.swing.JMenu();
        selecionarExemplosOp = new javax.swing.JMenuItem();
        exibirExemplosOp = new javax.swing.JMenuItem();
        limparExemplosOption = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        gerarGramaticaOp = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GGL-Unitex");

        jScrollPane1.setViewportView(caixaTexto);

        fontSpinner.setValue(14);

        jLabel1.setText("Fonte");

        menuTexto.setText("Texto");

        carregarTextoOp.setText("Carregar Texto");
        menuTexto.add(carregarTextoOp);

        jMenuBar1.add(menuTexto);

        exemplosMenu.setText("Exemplos");

        selecionarExemplosOp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selecionarExemplosOp.setText("Selecionar Texto Marcado Como Exemplo");
        exemplosMenu.add(selecionarExemplosOp);

        exibirExemplosOp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exibirExemplosOp.setText("Exibir Exemplos");
        exemplosMenu.add(exibirExemplosOp);

        limparExemplosOption.setText("LimparExemplos");
        exemplosMenu.add(limparExemplosOption);

        jMenuBar1.add(exemplosMenu);

        jMenu1.setText("Gramática");

        gerarGramaticaOp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        gerarGramaticaOp.setText("Gerar Gramática");
        jMenu1.add(gerarGramaticaOp);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(463, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane caixaTexto;
    private javax.swing.JMenuItem carregarTextoOp;
    private javax.swing.JMenu exemplosMenu;
    private javax.swing.JMenuItem exibirExemplosOp;
    private javax.swing.JSpinner fontSpinner;
    private javax.swing.JMenuItem gerarGramaticaOp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem limparExemplosOption;
    private javax.swing.JMenu menuTexto;
    private javax.swing.JMenuItem selecionarExemplosOp;
    // End of variables declaration//GEN-END:variables
    
    public JTextPane getCaixaTexto() {
        return caixaTexto;
    }

    public JMenuItem getCarregarTextoOp() {
        return carregarTextoOp;
    }

    public JMenu getExemplosMenu() {
        return exemplosMenu;
    }

    public JMenuItem getExibirExemplosOp() {
        return exibirExemplosOp;
    }

    public JMenuItem getGerarGramaticaOp() {
        return gerarGramaticaOp;
    }
    
    public JMenu getMenuTexto() {
        return menuTexto;
    }

    public JMenuItem getLimparExemplosOption() {
        return limparExemplosOption;
    }

    public JSpinner getFontSpinner() {
        return fontSpinner;
    }
    
    public JMenuItem getSelecionarExemplosOp() {
        return selecionarExemplosOp;
    }
    
}
