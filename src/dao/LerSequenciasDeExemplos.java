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
         for(int i=0; i<ExemplosCollection.getQuantidadeExemplos();i++){
         //for(int i=0;i<=1;i++){
             try {
                 File file = new File ("../tccjni/workUnitex"+i+"/list.txt");
                 
                 //FileReader file = new FileReader("../tccjni/workUnitex"+i+"/list.txt");
                 BufferedReader readFile = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file),"UTF-16LE"));
                 
                 String linha;
                 Pattern p = Pattern.compile("\\{(.*?)\\}");
                 
                 while((linha = readFile.readLine())!= null){                 
                 Matcher m = p.matcher(linha);
                 
                 //System.out.println("\n Linha da leitura "+linha+"boolean "+m.find()+" palavra ");
                 Episode newEpidose = new Episode();
                 newEpidose.setSentenceNumber(i);
                 newEpidose.setInitPosition(0);
                 int contPosition=0;
                 while(m.find()){
                    Event newEvent = new Event();
                    newEvent.setSentenceNumber(i); 
                    newEvent.setEventType(m.group(1));
                    newEvent.setPosition(contPosition);
                    GrafosPresenter.addEvent(newEvent);
                    newEpidose.addSequenceEvents(newEvent);
                    //System.out.println(m.group(1));
                    contPosition++;
                 }
                 newEpidose.setEndPosition(contPosition-1);
                 GrafosPresenter.addEpisode(newEpidose);
                 }
                 
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(LerSequenciasDeExemplos.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
         
         
         
     }
}
