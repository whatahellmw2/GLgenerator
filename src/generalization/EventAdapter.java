/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thiago
 */
public class EventAdapter {
    public void adaptEvent(ArrayList<Event> events){
        for(Event ev: events){
            detachLiteral(ev);            
            detachLemma(ev);
            detachGrammaticalCodes(ev);  
            detachInflection(ev);
                      
        }
    }
    private void detachLiteral(Event ev){
        Pattern p = Pattern.compile("(.*),");    
        Matcher m = p.matcher(ev.getEventType());
        if(m.find())            
        ev.setLiteral(m.group(1));
    }
   
    private void detachLemma(Event ev){
    Pattern p = Pattern.compile(",(.*)\\.");    
        Matcher m = p.matcher(ev.getEventType());
        if(m.find())            
        ev.setLemma(m.group(1));        
    
    }
    
    private void detachGrammaticalCodes(Event ev){
        Pattern p = Pattern.compile("\\.(.*):");        
       
            Matcher m = p.matcher(ev.getEventType());
            
            if(m.find())            
            ev.setGrammaticalCodes(m.group(1));            
           
    }
        
    private void detachInflection(Event ev){
        Pattern p = Pattern.compile(":(.*)\\}"); 
        Matcher m = p.matcher(ev.getEventType());
        if(m.find())            
        ev.setInflections(m.group(1));
    }
    

    

}
