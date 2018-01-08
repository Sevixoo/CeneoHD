/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.application;

import com.project.base.UseCase;
import com.project.data.IProductRepository;
import com.project.entity.ReviewEntity;
import com.project.service.IExporterService;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author seweryn
 */
class ExportReviewsUseCase implements UseCase<ExportReviewsArgument, File>{
     
    private final String PATH_TO_EXPORT = "./exports";
    
    private final IProductRepository productRepository;
    
    private final Map<ExportReviewsFormat,IExporterService> exporterServices;
    
    ExportReviewsUseCase(IProductRepository productRepository, IExporterService csvExport, IExporterService txtExport){
        this.productRepository = productRepository;
        this.exporterServices = new HashMap<>();
        this.exporterServices.put(ExportReviewsFormat.CSV,csvExport);
        this.exporterServices.put(ExportReviewsFormat.TXT,txtExport);
    }
    
    @Override
    public File execute(ExportReviewsArgument request) throws Throwable{ 
        File file = new File(PATH_TO_EXPORT);
        if(!file.exists()){
            file.mkdir();
        }
        if(request.format == ExportReviewsFormat.CSV){
            file = new File(PATH_TO_EXPORT + "/" + request.fileName + ".csv" );
        }else if(request.format == ExportReviewsFormat.TXT){
            file = new File(PATH_TO_EXPORT + "/" + request.fileName  );
            if(!file.exists()){
                file.mkdir();
            }
        }
        
        List<ReviewEntity> reviews = productRepository.loadReviews(request.productRemoteId); 
        exporterServices.get(request.format).exportData(file, reviews); 
        return file;
    }
    
}
