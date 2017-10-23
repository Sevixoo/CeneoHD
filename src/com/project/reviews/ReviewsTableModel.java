/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.reviews;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author seweryn
 */
public class ReviewsTableModel extends AbstractTableModel {

    private final List<ReviewVM> dataList;
     
    String[] columnNames = {"Review text","Remote id"};
    
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class};
    
    public ReviewsTableModel(){
        this.dataList = new ArrayList<>();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public int getRowCount() {
        return dataList.size();
    }
    
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int row, int col) {
        ReviewVM reviewVM = dataList.get(row);
        switch(col){
            
            case 0: return reviewVM.getName();
            
            case 1: return reviewVM.getRmoteId();
            
        };
        return null;
    }
    
    @Override
    public Class getColumnClass(int c) {
        return COLUMN_TYPES[c];
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    public void setData(List<ReviewVM> data) {
        dataList.clear();
        dataList.addAll(data);
        fireTableStructureChanged();
    }
    
}
