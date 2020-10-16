/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author thiago
 */
public class RedundancyRemover {
    private ArrayList<Event> eventsCpy;
    private HashSet<Event> eventsSet;
    public RedundancyRemover(ArrayList<Event> eventsp){
        //eventsCpy= new ArrayList<>(eventsp);
        eventsSet= new HashSet<>(eventsp);
    }
    public void removeRedundancy(ArrayList<Event> eventsp){
        
    }
    public void printSet(){
        int cont=0;
        System.out.println("imprimindo o set: ");
        
        for(Event e: eventsSet){
            cont++;
            e.printEvent();
            System.out.println("hashcode: "+e.hashCode());
        }
        
        System.out.println("Fim do print set");
        System.out.println("contador "+cont);
    }

    public HashSet<Event> getSet() {
        return eventsSet;
    }
 
}
