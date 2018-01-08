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
class CSVExporterService implements IExporterService{
    
    CSVExporterService(){ }
     
    @Override
    public void exportData( File file, List<ReviewEntity> reviews )throws IOException{ 
        BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        out.write("ID;");
        out.write("AUTHOR;");
        out.write("Score;"); 
        out.write("IsRecomended;"); 
        out.write("Summary;"); 
        out.write("Advantages;"); 
        out.write("Disadvantages;"); 
        out.write("LikesCount;"); 
        out.write("DislikesCount;"); 
        out.write("CreateDate;\n");  
        
        for(ReviewEntity reviewEntity : reviews){
            out.write(String.valueOf(reviewEntity.getRemoteId()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getAuthor()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getScore()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getIsRecomended()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getSummary()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getAdvantages()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getDisadvantages()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getLikesCount()));
            out.write(";");
            out.write(String.valueOf(reviewEntity.getDislikesCount()));
            out.write(";");
            out.write(String.valueOf(formatter.format(reviewEntity.getCreateDate())));
            out.write(";\n");
        } 
        out.close(); 
    }
    
}
