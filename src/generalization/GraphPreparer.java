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
public class GraphPreparer {
    public static void prepareGraph(ArrayList<Episode> episodesP){        
        
        HashSet<Event> initialEvents = new HashSet<Event>();
        
        for(Episode ep:episodesP){
            initialEvents.add(ep.getSequenceEvents().get(0));
        }
        
        
        recursivePrepare( initialEvents, 0, episodesP.get(0).getSequenceEvents().size(), episodesP );
        
//        for(Event e:initialEvents){            
//            for(int i=0;i<episodesP.size();i

//                if(e.equals(episodesP.get(i).getSequenceEvents().get(0))){
//                    e.getChildren().add(episodesP.get(i).getSequenceEvents().get(0));
//                }
//            }
//        }
       
        System.out.println("preparing graph");
        
    }
    private static Event recursivePrepare(HashSet<Event> events, int cont, int size,ArrayList<Episode> episodesP){
          for(Event e:events){
                System.out.println("###########recursive prepare cont"+cont);
                e.printEvent();
            }
          
        if(cont<size-1){         
            for(Event e: events){                
                for(Episode ep: episodesP){                    
                    for(int i=0; i<size;i++){
                        if(e.equals(ep.getSequenceEvents().get(i))){
                           HashSet<Event> hashAux= new HashSet<Event>( ep.getSequenceEvents().subList(i+1,size));
                           cont++;
                            e.getChildren().add(recursivePrepare(hashAux, cont, size, episodesP));                            
                        }
                    }
                    cont=0;
                }   
                if(cont!=0)
                    return e;
                
                
            }
            
        }else {
            
             return null;
        }
        return null;
    }
    public void printRecursive(){
        
        
    }
}
