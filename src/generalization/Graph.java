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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import presenter.DirectorySelectorPresenter;

/**
 *
 * @author thiago
 */
public class Graph {
    
    private String caminho = "/home/thiago/NetBeansProjects/GLgenerator/src/generalization/grfTemplate.grf";
    
    private Path path = (Path)Paths.get("grfTemplate.grf");
    private String graph;

    public String getGraph() {
        return graph;
    }
    public void constructGraph(ArrayList<Map<String,Integer>> solution) throws FileNotFoundException, IOException{       
        int solutionSize=solution.size();

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
       oldContent = oldContent + (solutionSize+2) + System.lineSeparator();//set number of nodes on the graph
       int f=0;
       //começa com 2 estados o inicial 0 e o final 1
       int currentStateNumber=1;       
       //palavraReconhecida posicaoX posicaoY numTransicoesSaída nosAlcançaveis
       
       //initial state
       oldContent = oldContent + "<E>" + " 20" + " 300 " + solution.get(0).size();
       for(String chaves:solution.get(0).keySet()){
           oldContent = oldContent + " " + currentStateNumber;
           currentStateNumber++;
       }
       oldContent = oldContent +" "+ System.lineSeparator();
       
       //final node
        oldContent = oldContent +"\" \" "+ "1000 " + "300 "+"0 "
                               +System.lineSeparator();
       
       for(int i=0; i<solutionSize;i++){
           if(i<solutionSize-1){
                String estadosFilhos="";
                int localStateNumber = currentStateNumber+solution.get(i).size();
                for(String chave:solution.get(i+1).keySet()){
                    estadosFilhos= estadosFilhos + " " + localStateNumber;
                    localStateNumber++;
                }
                for(String chave:solution.get(i).keySet()){
                    oldContent = oldContent + "\"" +chave+ "\"" + " posicaoX " + "posicaoY " + 
                            solution.get(i+1).size() + estadosFilhos + " " + System.lineSeparator();
                    currentStateNumber++;
                }
           }else{
               for(String chave:solution.get(i).keySet()){
                    oldContent = oldContent + "\"" +chave+ "\"" + " posicaoX " + "posicaoY " + 
                            1 + " " + 1 + " " + System.lineSeparator();
                    
                }
           }
           
       }
       System.out.println(oldContent);
    }
    
}
