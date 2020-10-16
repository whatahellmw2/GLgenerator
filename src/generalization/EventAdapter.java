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
    public void removeInflection(ArrayList<Event> events){
        Pattern p = Pattern.compile(":.*");
        
        for(Event e: events){
            Matcher m = p.matcher(e.getEventType());
            
            if(m.find())            
            e.setInflections(m.group());
            
            
            String teste = m.replaceFirst("");
            e.setEventType(teste);
            //System.out.println("teste string: "+ teste);
            //System.out.println("inflections: "+ e.getInflections());
        }
    }
    public void removeGrammaticalCodes(ArrayList<Event> events){
        Pattern p = Pattern.compile("\\.(.*)");
        
        for(Event e: events){
            Matcher m = p.matcher(e.getEventType());
            
            if(m.find())            
            e.setGrammaticsCodes(m.group(1));
            
            String teste = m.replaceFirst("");
            e.setEventType(teste);
            //System.out.println("teste string: "+ teste);
            //System.out.println("Grammatical Codes: "+ e.getGrammaticsCodes());
        }
    }
    public void removeLemma(ArrayList<Event> events){
        Pattern p = Pattern.compile(",.*");
        
        for(Event e: events){
            Matcher m = p.matcher(e.getEventType());
            
            if(m.find())            
            e.setLemma(m.group().replace(",", "+"));
            
            String teste = m.replaceFirst("");
            e.setEventType(teste);
            e.setLiteral(teste);
            e.setEventType(e.getLiteral()+e.getLemma()+"+<"+e.getGrammaticsCodes()+">");
            //System.out.println(e.getEventType());
            //System.out.println("teste string: "+ teste);
            //System.out.println("Lemma: "+ e.getLemma());
        }
    }
}
