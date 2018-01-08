/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

/**
 *
 * @author seweryn
 */
public class ExportReviewsArgument {
    
    public final ExportReviewsFormat format;
        
    public final String productRemoteId;

    public final String fileName;

    public ExportReviewsArgument(ExportReviewsFormat format,String fileName, String productRemoteId){
        this.format = format;
        this.productRemoteId = productRemoteId;
        this.fileName = fileName;
    }
}
