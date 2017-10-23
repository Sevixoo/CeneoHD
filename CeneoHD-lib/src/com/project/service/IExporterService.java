/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.service;

import com.project.entity.ReviewEntity;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author seweryn
 */
public interface IExporterService {
    
    void exportData( File file, List<ReviewEntity> reviews )throws IOException;
    
}
