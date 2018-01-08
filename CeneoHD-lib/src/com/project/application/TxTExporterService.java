/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.entity.ReviewEntity;
import com.project.service.IExporterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author seweryn
 */
class TxTExporterService implements IExporterService{
    
    TxTExporterService(){ }
     
    @Override
    public void exportData( File file, List<ReviewEntity> reviews )throws IOException{
          
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        for(ReviewEntity reviewEntity : reviews){
            
            File outFile = new File(file.getAbsolutePath() + "/" + reviewEntity.getRemoteId() + ".txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(outFile)); 
             
            out.write("ID:");
            out.write(String.valueOf(reviewEntity.getRemoteId())); 
            out.write("\nAUTHOR:");
            out.write(String.valueOf(reviewEntity.getAuthor())); 
            out.write("\nScore:"); 
            out.write(String.valueOf(reviewEntity.getScore())); 
            out.write("\nIsRecomended:"); 
            out.write(String.valueOf(reviewEntity.getIsRecomended())); 
            out.write("\nSummary:"); 
            out.write(String.valueOf(reviewEntity.getSummary())); 
            out.write("\nAdvantages:"); 
            out.write(String.valueOf(reviewEntity.getAdvantages())); 
            out.write("\nDisadvantages:");
            out.write(String.valueOf(reviewEntity.getDisadvantages())); 
            out.write("\nLikesCount:"); 
            out.write(String.valueOf(reviewEntity.getLikesCount())); 
            out.write("\nDislikesCount:"); 
            out.write(String.valueOf(reviewEntity.getDislikesCount())); 
            out.write("\nCreateDate:");  
            out.write(String.valueOf(formatter.format(reviewEntity.getCreateDate()))); 
            
            out.close(); 
        } 
        
    }
    
}
