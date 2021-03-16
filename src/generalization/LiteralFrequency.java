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
public class LiteralFrequency {
    public static void computeFrequency(ArrayList<Episode> episodesP){
       int cont=0;
       ArrayList<Event> events;
       for(int i=0;i<episodesP.size()-1;i++){
           for(int j=i+1; j<episodesP.size();j++){
               ArrayList<Event> evts=episodesP.get(i).getSequenceEvents();
               ArrayList<Event> evts2=episodesP.get(j).getSequenceEvents();
            for(int k=0;k<evts.size();k++){
               int conti= evts.get(k).getLiteralFrequency();
               int contj= evts2.get(k).getLiteralFrequency();               
               if(evts.get(k).getLiteral().equals(evts2.get(k).getLiteral())){
                   cont++;
                   conti++;
                   contj++;
                   evts.get(k).setLiteralFrequency(conti);
                   evts2.get(k).setLiteralFrequency(contj);
                   if(evts.get(i).getLiteralFrequency()==(episodesP.size()-1)){
                       evts.get(i).setLiteralGen(true);
                   }
                   //System.out.println("##########"+evts.get(k).getLiteral()+"##########"+evts2.get(k).getLiteral());
               }
            }
           }
       }
    }
}
