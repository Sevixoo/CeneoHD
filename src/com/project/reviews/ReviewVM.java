/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.reviews;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author seweryn
 */
public class ReviewVM {
    
    private final String remoteId;
      
    private final String author;
    
    private final String recomended;
    
    private final String score;
    
    private final String body;
    
    private final String pros;
    
    private final String cons;
    
    private final String votes;
    
    private final String date;
    
    public ReviewVM(String remoteId, String author, Boolean recomended, String score, String body, String pros, String cons, int yes_votes, int not_votes, Date date  ){
        this.remoteId = remoteId;
        this.author = author;
        
        if(recomended ==  null){
            this.recomended = "-";
        }else if(recomended){
            this.recomended = "POLECAM";
        }else{
            this.recomended = "NIE POLECAM";
        }
        
        this.score = score;
        this.body = body;
        this.pros = pros;
        this.cons = cons;
        this.votes = yes_votes + "/" + not_votes;
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        this.date = formatter.format(date);
    }
    
    public String getRmoteId(){
        return getRemoteId();
    }

    public String getRemoteId() {
        return remoteId;
    }

    public String getAuthor() {
        return author;
    }

    public String getRecomended() {
        return recomended;
    }

    public String getScore() {
        return score;
    }

    public String getBody() {
        return body;
    }

    public String getPros() {
        return pros;
    }

    public String getCons() {
        return cons;
    }

    public String getVotes() {
        return votes;
    }

    public String getDate() {
        return date;
    }
    
    
    
}
