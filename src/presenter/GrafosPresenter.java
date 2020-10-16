

package presenter;
//import fr.umlv.unitex.jni.UnitexJni;
//import DLLJNI.

import collections.ExemplosCollection;
import dao.LerSequenciasDeExemplos;
import generalization.Episode;
import generalization.Event;
import generalization.EventAdapter;
import generalization.FrequencyComputer;
import generalization.Graph;
import generalization.LowFrequencyRemover;
import generalization.RedundancyRemover;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tccjni.UnitexFunctions;
import tccjni.UnitexJniDemo;

/**
 *
 * @author hiago
 */
public class GrafosPresenter {
    private ArrayList<String> exemplos;//copia da lista de exemplos
    private static ArrayList<Event>  events= new ArrayList<>();
    private static ArrayList<Episode> episodes = new ArrayList<>();
    private RedundancyRemover remover;
   
    public void testarLib(){
        this.exemplos=ExemplosCollection.getListaExemplos();
        String[] arguments;
         arguments = new String[0];
         for (int i=0;i< this.exemplos.size();i++) {
             UnitexFunctions.teste(arguments,this.exemplos.get(i),i);
        }
        try {
            LerSequenciasDeExemplos.lerSquencias();            
            new EventAdapter().removeInflection(events);
            new EventAdapter().removeGrammaticalCodes(events);
            new EventAdapter().removeLemma(events);
            remover = new RedundancyRemover(events);//cria um set de eventos considerando tipo e posição 
            remover.printSet();
            FrequencyComputer.computeFrequency(remover.getSet(), events);//calcula o numero de ocorrencias
            //remover.printSet();
            //LowFrequencyRemover.setThreshhold(exemplos.size());
            LowFrequencyRemover.setThreshhold(2);
            LowFrequencyRemover.removeLowFrequency(remover.getSet(), episodes, events);
            new Graph(events.size(), episodes);
        } catch (IOException ex) {
            Logger.getLogger(GrafosPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void printEvents(){
         System.out.println("imprimindo array de eventos: ");
            for(Event e: events){
                e.printEvent();
            }
    }
    
    public void printEpisodes(){
         System.out.println("imprimindo array de episodios: ");
            for(Episode e: episodes){
                e.printEpisode();
            }
    }
    public static void addEvent(Event eventp ){
        events.add(eventp);
    }         
    public static void addEpisode(Episode episodep){
        episodes.add(episodep);
    }
}
    