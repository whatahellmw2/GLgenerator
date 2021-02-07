/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import dao.AbrirArquivoTexto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import presenter.DirectorySelectorPresenter;

/**
 *
 * @author thiago
 */
public class Graph {
    private String caminho = "/home/thiago/NetBeansProjects/tccjni/src/generalization/grfTemplate.grf";
    private Path path = (Path)Paths.get("grfTemplate.grf");
    private String graph;

    public String getGraph() {
        return graph;
    }
    public Graph(int numNodes, ArrayList<Episode> episodes) throws IOException{
       // AbrirArquivoTexto.lerArquivo(path);
       //System.out.println("imprindo arquivo gtf: "+ AbrirArquivoTexto.lerArquivo(path));
       File fileToBeModified = new File(caminho);
       String oldContent = "";
       BufferedReader reader = new BufferedReader(new FileReader(caminho));
       String line = reader.readLine();
       
       while(line != null){
           //System.out.println(line);
           oldContent = oldContent + line + System.lineSeparator();
           line=reader.readLine();
       }
       reader.close();
       oldContent = oldContent + (numNodes+2) + System.lineSeparator();//set number of nodes on the graph
       int f=0;
       int cont=0;
       String nodes="";
       for(Episode ep:episodes){
           int i=0;
           for(Event ev: ep.getSequenceEvents()){
               if(i==0){
               //oldContent = oldContent +"\"<E>\" "+ (110*i+20) +" " +(35*j+30) +" "+"1 " 
               //         +"2 "+System.lineSeparator();
               nodes=nodes+(f+2)+" ";    
               cont++;    
               }
               f++;
               i++;
           }       
       }
       //inicialnode
       oldContent = oldContent +"\"<E>\" "+"20 " +"300 "+cont+" " 
                        +nodes+System.lineSeparator();
       //inicial node
       oldContent = oldContent +"\" \" "+ "900 " + "300 "+"0 "
                               +System.lineSeparator();
       int k=0;
       int j=0;
       for(Episode ep: episodes){
           int i=0;
           
           for(Event ev: ep.getSequenceEvents()){
              
               if(i<ep.getSequenceEvents().size()-1){
                   
                   //if(k==0){
                        //oldContent = oldContent +"\""+ ev.getEventType()+"\" "+ (110*i+20) +" " +(35*j+30) +" "+"1 " 
                        //+"2 "+System.lineSeparator();
                   
                        //oldContent = oldContent +"\" \" "+ "900 " + "300 "+"0 "
                          //     +System.lineSeparator();
                       //k++;
                       //System.out.println("k "+k);
                   //}else{
                        oldContent = oldContent +"\""+ ev.getEventType()+"\" "+ (110*i+120) +" " +(35*j+30) +" "+"1 " 
                        +(k+3)+" "+System.lineSeparator();
                        System.out.println("i "+i);
                   //}
                   
                }else{//the final event on the epidode points to the final episode of the graph
                   oldContent = oldContent +"\""+ ev.getEventType()+"\" "+ (110*i+120) +" " +(35*j+30) +" "+"1 "+"1 " 
                        +System.lineSeparator();
               }
               i++;
               k++;
           }
           j++;
       }
       System.out.println(oldContent);
       graph=oldContent; 
       
        
    }
    
}
