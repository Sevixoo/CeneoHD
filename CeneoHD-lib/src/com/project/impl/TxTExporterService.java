/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.impl;

import com.project.entity.ReviewEntity;
import com.project.service.IExporterService;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author seweryn
 */
class TxTExporterService implements IExporterService{
    
    public TxTExporterService(){ }
     
    @Override
    public void exportData( File file, List<ReviewEntity> reviews )throws IOException{
        //TODO...
    }
    
}