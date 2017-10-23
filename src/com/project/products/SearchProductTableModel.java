/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.products;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author seweryn
 */
public class SearchProductTableModel extends AbstractTableModel {

    public static interface OnItemActionClickListener{
        
        void onActionClick(ProductVM product);
        
    }
    
    private final List<ProductVM> dataList;
     
    String[] columnNames = {"Product name","Remote id", "Action"};
    
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[] {String.class, String.class, JButton.class};

    private final OnItemActionClickListener onItemActionClickListener;
    
    public SearchProductTableModel(OnItemActionClickListener onItemActionClickListener){
        this.dataList = new ArrayList<>();
        this.onItemActionClickListener = onItemActionClickListener;
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
        ProductVM productVM = dataList.get(row);
        switch(col){
            
            case 0: return productVM.getName();
            
            case 1: return productVM.getRmoteId();
              
            case 2: 
                final JButton button = new JButton("select");
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        onItemActionClickListener.onActionClick(productVM);
                    }
                });
                return button;
            
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
    
    public void setData(List<ProductVM> data) {
        dataList.clear();
        dataList.addAll(data);
        fireTableStructureChanged();
    }
    
}
