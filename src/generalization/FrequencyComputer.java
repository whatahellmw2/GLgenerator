/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author thiago
 */
public class FrequencyComputer {
  
    public static void computeFrequency(HashSet<Event> eventsSetp, ArrayList<Event> Eventp){
      for(Event e: Eventp){
          if(eventsSetp.contains(e)){
              for(Event e2: eventsSetp ){
                  if(e2.equals(e)){
                      //e2.setFrequency(e2.getFrequency()+1);
                      if(!e2.getSentences().contains(e.getSentenceNumber()))
                        e2.addSentence(e.getSentenceNumber());
                  }
              }
          }
              
      }
      for(Event e: eventsSetp){
          e.setFrequency(e.getSentences().size());
      } 
    }
  
}
