/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import collections.ExemplosCollection;
import generalization.Episode;
import generalization.Event;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import presenter.GrafosPresenter;
/**
 *
 * @author thiago
 */
public class LerSequenciasDeExemplos {
     public static void lerSquencias() throws IOException{
         //for(int i=0; i<ExemplosCollection.getQuantidadeExemplos();i++){
          for(int i=0; i<2;i++){
             try {
                 File file = new File ("../tccjni/workUnitex"+i+"/list.txt");                 
                 
                 BufferedReader readFile = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file),"UTF-8"));
                 
                 String linha;
                 Pattern p = Pattern.compile("\\(\\{(.*?)\\}\\)|\\{(.*?)\\}");//pega cada evento dentro de um episódio
                 
                 while((linha = readFile.readLine())!= null){                 
                 Matcher m = p.matcher(linha);
                 
                 
                 Episode newEpidose = new Episode();                 
                 int contPosition=0;
                 while(m.find()){
                    if((m.group(1)!=null && m.group(1).equals("S"))||(m.group(2)!=null && m.group(2).equals("S"))){
                    }else{
                        Event newEvent = new Event(); 
                        if(m.group(1)!=null)
                        newEvent.setEventType(m.group(1));
                        else
                        newEvent.setEventType(m.group(2));

                        newEvent.setPosition(contPosition);
                        GrafosPresenter.addEvent(newEvent);
                        newEpidose.addSequenceEvents(newEvent);

                        contPosition++;
                    }
                    
                 }
                 newEpidose.setTamananho(contPosition);
                 GrafosPresenter.addEpisode(newEpidose);
                 }
                 
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(LerSequenciasDeExemplos.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
         
     }
}
