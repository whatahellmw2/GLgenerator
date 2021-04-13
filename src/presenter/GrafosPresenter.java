

package presenter;
//import fr.umlv.unitex.jni.UnitexJni;
//import DLLJNI.

import collections.ExemplosCollection;
import dao.LerSequenciasDeExemplos;
import generalization.Episode;
import generalization.Event;
import generalization.EventAdapter;
import generalization.Generalizer;
import generalization.Graph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import tccjni.UnitexFunctions;

/**
 *
 * @author hiago
 */
public class GrafosPresenter {
    private ArrayList<String> exemplos;//copia da lista de exemplos
    private static ArrayList<Event>  events= new ArrayList<>();
    private static ArrayList<Episode> episodes = new ArrayList<>(); 
    private Graph graph;
    public void createFSTList(){
        this.exemplos=ExemplosCollection.getListaExemplos();
        String[] arguments;
         arguments = new String[0];
         
         for (int i=0;i< this.exemplos.size();i++) {
             new UnitexFunctions().configUnitex(arguments,this.exemplos.get(i),i);
             
        }
    }
    public void deleteFiles(){
        for (int i=0;i< this.exemplos.size();i++) {
             new UnitexFunctions().deleteFolder("workUnitex"+i);
             
        }
    }
    void imprimirEpidosios(){
          for(Episode ep:episodes){
                System.out.println("\n");
                for(Event ev:ep.getSequenceEvents()){
                    //System.out.print("  "+ev.getEventType() );
                    ev.printEvent();
                }
            }
           System.out.println("\n\n");
    }
    public void constructGraph(){
        this.createFSTList();
        try {
            LerSequenciasDeExemplos.lerSquencias();          
            imprimirEpidosios();
            
            EventAdapter adapter = new EventAdapter();            
            for(Episode ep: episodes){
               adapter.adaptEvent(ep.getSequenceEvents()); 
            }
           imprimirEpidosios();
            Generalizer generalizer = new Generalizer();            
            ArrayList<Map<String,Integer>> solution = generalizer.gen(episodes);
            graph = new Graph();
            graph.constructGraph(solution);
            saveGraph();
        } catch (IOException ex) {
            Logger.getLogger(GrafosPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        //deleteFiles();
    }
    public void saveGraph() throws IOException{
        DirectorySelectorPresenter selector= new DirectorySelectorPresenter();
        File slectedPath = selector.selectFolder();
        if(slectedPath==null){
            selector.dispose();
            selector=null;
            saveGraph();
        }else{
            File newFile = new File(slectedPath.toString()+".grf");
            FileWriter newFileWriter = new FileWriter(newFile);       
            BufferedWriter bWriter = new BufferedWriter(newFileWriter);
            bWriter.write(graph.getGraph());

            bWriter.close();
            newFileWriter.close();
        }
    }

    
//    public void printEpisodes(){
//         System.out.println("imprimindo array de episodios: ");
//            for(Episode e: episodes){
//                e.printEpisode();
//            }
//    }
    public static void addEvent(Event eventp ){
        events.add(eventp);
    }         
    public static void addEpisode(Episode episodep){
        episodes.add(episodep);
    }
}
    