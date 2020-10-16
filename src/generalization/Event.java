/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalization;

import java.util.ArrayList;
import java.util.Objects;



/**
 *
 * @author thiago
 */
public class Event {    
    private String eventType;
    private int position;
    private int eventSequence;
    private int sentenceNumber;
    private int frequency;
    private String inflections;
    private String grammaticalCodes;
    private String literal;
    private String lemma;

    public void setInflections(String inflections) {
        this.inflections = inflections;
    }

    public void setGrammaticsCodes(String grammaticsCodes) {
        this.grammaticalCodes = grammaticsCodes;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getInflections() {
        return inflections;
    }

    public String getGrammaticsCodes() {
        return grammaticalCodes;
    }

    public String getLiteral() {
        return literal;
    }

    public String getLemma() {
        return lemma;
    }
    
    private ArrayList<Integer> sentences= new ArrayList<>();
    
    public void addSentence(int sentenceNumberp){
        sentences.add(sentenceNumberp);
    }

    public ArrayList<Integer> getSentences() {
        return sentences;
    }
    public int getFrequency() {
        return frequency;
    }

    public int getSentenceNumber() {
        return sentenceNumber;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setSentenceNumber(int sentenceNumber) {
        this.sentenceNumber = sentenceNumber;
    }
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public void printEvent(){
        System.out.println("grammatics codes:"+ this.grammaticalCodes);
        System.out.println("event type: "+ this.eventType);
        System.out.println("position: "+ this.position);
        System.out.println("Frequency: "+ this.frequency);
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        Event e = (Event) obj;        
        return this.grammaticalCodes.equals(e.getGrammaticsCodes()) && this.position == e.getPosition();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.eventType);
        return hash;
    }
}
