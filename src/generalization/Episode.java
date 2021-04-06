/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class Episode {
    private ArrayList<Event> sequenceEvents;
    private int tamananho;
            
      public Episode(){
        this.sequenceEvents= new ArrayList<>();
        }
      
    public void addSequenceEvents(Event eventp) {
        sequenceEvents.add(eventp);
    }

    public ArrayList<Event> getSequenceEvents() {
        return sequenceEvents;
    } 

    public int getTamananho() {
        return tamananho;
    }

    public void setTamananho(int tamananho) {
        this.tamananho = tamananho;
    }
    
}
