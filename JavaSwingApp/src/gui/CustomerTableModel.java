package gui;

import java.util.List;

import model.Customer;

import javax.swing.table.AbstractTableModel;

	

public class CustomerTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    private List<Customer> db; 

    private String[] colNames = { "ID", "Name", "Due Amount", "Age", "Employement", "Pakistani",
            "NIC" };

    public CustomerTableModel() {

    }

    @Override
    public String getColumnName(int column)
    {
        return colNames[column];
    }
    
    

    public void setData(List<Customer> db) {
        this.db = db;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Customer customer = db.get(row);

        switch (column) {
        case 0:
            return customer.getId();
        case 1:
            return customer.getName();
        case 2:
            return customer.getOccupation();
        case 3:
            return customer.getAgeCategory();
        case 4:
            return customer.getEmpCat();
        case 5:
            return customer.isPakistani();
        case 6:
            return customer.getNicId();
        }
        return null;
    }
}