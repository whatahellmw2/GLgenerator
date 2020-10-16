/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author thiago
 */
public class LowFrequencyRemover {
    private static int threshold;
    
    public static void setThreshhold(int numSamples){
        threshold = (numSamples+2)/2;
        System.out.println("limiar: "+threshold);
    }
    public static void removeLowFrequency(HashSet<Event> eventSet, ArrayList<Episode> episodes, ArrayList<Event> events ){
        Iterator i = eventSet.iterator();
        while(i.hasNext()){
            
            Event newEvent = new Event();
            newEvent=(Event)i.next();
            if(newEvent.getFrequency() <threshold){//remove events from set wiht frequency under treshold
                i.remove();
            }
        }
        /*for(Event e: eventSet){
            if(e.getFrequency()<threshold){
                eventSet.remove(e);
            }
            
        }*/
        Iterator k = episodes.iterator();
        
        while(k.hasNext()){
            Episode newEpisode;
            newEpisode = (Episode)k.next();
            for(Event ev: newEpisode.getSequenceEvents()){
                
                if(!eventSet.contains(ev)){
                   for(Event ev2: newEpisode.getSequenceEvents()){//remove episodes that contains low frequency events
                       events.remove(ev2);
                   }
                    k.remove();
                    break;
                }
            }            
        }
        
            
        System.out.println("imprimindo resto eventos");
        for(Event e: events){
           
            e.printEvent();
        }
        
    }
}
