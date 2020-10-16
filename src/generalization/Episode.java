/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class Episode {
    private ArrayList<Event> sequenceEvents;
    private int sentenceNumber;//de qual sentença esse episódio veio
    private int initPosition;
    private int endPosition;
    private int frequency;

    public void setSentenceNumber(int sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }
    
    public Episode(){
        sequenceEvents = new ArrayList<>();
    }
    public void addSequenceEvents(Event eventp) {
        sequenceEvents.add(eventp);
    }

    public ArrayList<Event> getSequenceEvents() {
        return sequenceEvents;
    }
    
    public void setOriginSentence(int originSentence) {
        this.sentenceNumber = originSentence;
    }

    public void setInitPosition(int initPosition) {
        this.initPosition = initPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }
    public void printEpisode(){
        System.out.println("\n initPosition: "+ initPosition);
        for(Event e: sequenceEvents){
            System.out.print(e.getEventType()+" ");
        }
        System.out.println("\n endPositon: "+ endPosition);
        
    }
    
    
}
