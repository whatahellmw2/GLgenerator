/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author thiago
 */
public class Generalizer {
    
    ArrayList<Map<String,Integer>> arrayLiterais;
    ArrayList<Map<String,Integer>> arrayLemas;
    ArrayList<Map<String,Integer>> arrayCodigos;
    ArrayList<Map<String,Integer>> arrayFlexoes;
    ArrayList<Map<String,Integer>> solution = new ArrayList<>();
    
   
    //usado como parametro para saber se determinada posição chegou 
    //a generalização maxima
    private int tamanho;
    
    public boolean isSameLength(ArrayList<Episode> episodes){        
        int count=0;
        for(int i=0; i<episodes.size();i++){
            if(i==0){
                count = episodes.get(i).getTamananho();
            }else if(episodes.get(i).getTamananho()!=count){
                return false;
            }            
        }
            
        return true;
    }
    
   public void frequencyByProperties(Map<String, Integer> map, String property){
       if(map.containsKey(property)){
                    int frequency = map.get(property);
                    frequency++;
                    map.put(property, frequency);
                }else{
                    map.put(property, 1);
                }
   }
    
    public void filter(ArrayList<Map<String,Integer>> solution){
         ArrayList<String> chaves= new ArrayList<>();
         for(Map<String,Integer> map: solution){
             int maxValue= Collections.max(map.values());
             map.forEach((chave,valor)->{
                 if(valor<maxValue)
                     chaves.add(chave);
             });
             for(String s: chaves)
                 map.remove(s);
         }
        
    }
    public ArrayList<Map<String,Integer>> gen(ArrayList<Episode> episodes){
        tamanho = episodes.size();
        //iniciando um map por propriedade para cada posição
        for(int j = 0; j < episodes.get(0).getTamananho(); j++){           
           Map<String,Integer> mapLiteral = new HashMap<String,Integer>();
           Map<String,Integer> mapLema = new HashMap<String,Integer>();
           Map<String,Integer> mapCodigos = new HashMap<String,Integer>();
           Map<String,Integer> mapFlexoes = new HashMap<String,Integer>();
           
            for(int i=0; i < episodes.size(); i++){               
                Event event = episodes.get(i).getSequenceEvents().get(j);
                       
                frequencyByProperties(mapLiteral, event.getLiteral());                ;               
                frequencyByProperties(mapFlexoes, event.getInflections());
                
                if (event.getEventType().contains("|")){                    
                    
                    String[] splited=event.getGrammaticalCodes().split("\\|");
                    Set<String> propertiesSameEpisode = new HashSet<>(Arrays.asList(splited));                    
                    for(String s: propertiesSameEpisode){
                       s = s.replaceAll(":.*", "");
                       frequencyByProperties(mapCodigos, s);
                    }
                    
                    splited=event.getLemma().split("\\|");
                    propertiesSameEpisode = new HashSet<>(Arrays.asList(splited));                    
                    for(String s: propertiesSameEpisode){
                       s = s.replaceAll(":.*", "");
                       frequencyByProperties(mapLema, s);
                    }
                        
                }else{
                     frequencyByProperties(mapCodigos, event.getGrammaticalCodes());
                     frequencyByProperties(mapLema, event.getLemma());
                }
                
            }
           
           int literalMaxFrequency = Collections.max(mapLiteral.values());
           int lemaMaxFrequency = Collections.max(mapLema.values());
           int codeMaxFrequency = Collections.max(mapCodigos.values());
           int flectionsMaxFrequency = Collections.max(mapLiteral.values());
           
           if((literalMaxFrequency>lemaMaxFrequency && literalMaxFrequency>codeMaxFrequency)
                   || literalMaxFrequency== tamanho){
               solution.add(mapLiteral);
           }else if(lemaMaxFrequency>codeMaxFrequency || lemaMaxFrequency==tamanho){
               solution.add(mapLema);
           }else {
               solution.add(mapCodigos);
           }
        
        }
        int i = 1;
        for(Map<String,Integer> map: solution){
            
            System.out.println("posicao "+i);
            map.forEach((chave,valor)->{
                System.out.println("chave: "+chave+", valor: "+valor);
            });
            i++;
            System.out.println("\n");
        }
        filter(solution);
        i = 1; 
        System.out.println("filtrado");
        for(Map<String,Integer> map: solution){
            
            System.out.println("posicao "+i);
            map.forEach((chave,valor)->{
                System.out.println("chave: "+chave+", valor: "+valor);
            });
            i++;
            System.out.println("\n");
        }
        return solution;        
    }
}
