/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.ArrayList;

/**
 *
 * @author hiago
 */
public class ExemplosCollection {
    private static ArrayList<String> listaExemplos;
    public ExemplosCollection(){
        listaExemplos = new ArrayList();
    }
    public void salvarExemplo(String exemplop){
        listaExemplos.add(exemplop);
    }
    
    /*public void exibirExemplos(){
        for(String exemplo: listaExemplos){
            //System.out.println(exemplo);
        }
    }*/

    public static ArrayList<String> getListaExemplos() {
        return listaExemplos;
    }
    
    public static int getQuantidadeExemplos(){
        return listaExemplos.size();
    }
    public void zeraExemplos(){
        this.listaExemplos = new ArrayList<>();
    }
    
}
