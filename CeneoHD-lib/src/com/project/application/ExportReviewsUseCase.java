/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.service.IExporterService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author seweryn
 */
public class ExportReviewsUseCase implements UseCase<ExportReviewsUseCase.Argument, File>{
    
    public static enum Format{
        TXT, CSV
    }
    
    public static class Argument{

        private final Format format;
        
        private final String productRemoteId;
        
        private final String fileName;
        
        public Argument(Format format, String fileName){
            this(format,fileName,null);
        }
        public Argument(Format format,String fileName, String productRemoteId){
            this.format = format;
            this.productRemoteId = productRemoteId;
            this.fileName = fileName;
        }
    }
    
    private final IProductRepository productRepository;
    
    private final Map<Format,IExporterService> exporterServices;
    
    public ExportReviewsUseCase(IProductRepository productRepository, IExporterService csvExport, IExporterService txtExport){
        this.productRepository = productRepository;
        this.exporterServices = new HashMap<>();
        this.exporterServices.put(Format.CSV,csvExport);
        this.exporterServices.put(Format.TXT,txtExport);
    }
    
    @Override
    public File execute(Argument request) throws Throwable{
        //TODO... export do pliku. wybrany format Argument.Format 
        //exporterServices.get(request.format).exportData(file, reviews);
        return null;
    }
    
}
