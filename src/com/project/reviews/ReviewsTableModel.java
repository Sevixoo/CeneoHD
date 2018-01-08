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
     
    String[] columnNames = { 
        "Remote id", "Author", "Recomended" , "Score", 
        "Body" , "Pros" , "Cons" , "Yes/No" , "Date"
    };
    
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {
        String.class, String.class,String.class, String.class,
        String.class, String.class,String.class, String.class, String.class
    };
    
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
            
            case 0: return reviewVM.getRemoteId();
            
            case 1: return reviewVM.getAuthor();
            
            case 2: return reviewVM.getRecomended();
            
            case 3: return reviewVM.getScore();
            
            case 4: return reviewVM.getBody();
            
            case 5: return reviewVM.getPros();
            
            case 6: return reviewVM.getCons();
            
            case 7: return reviewVM.getVotes();
            
            case 8: return reviewVM.getDate();
            
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
