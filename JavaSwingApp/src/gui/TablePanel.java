

package gui;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Customer;


public class TablePanel extends JPanel {
	
    private JTable table;
    private CustomerTableModel tableModel;
    private JPopupMenu popup;
    private CustomerTableListener customerTableListener;

    public TablePanel() {
    	
    	
        tableModel = new CustomerTableModel();        
        popup = new JPopupMenu();
        table = new JTable(tableModel);

        JMenuItem removeItem = new JMenuItem("Delete Row");
        popup.add(removeItem);
        
        table.addMouseListener((MouseListener) new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3)
				{
					popup.show(table, e.getX(), e.getY());
				}
			}
        	
        });

        removeItem.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				
				if(customerTableListener != null)
				{
					customerTableListener.rowDeleted(row);
					tableModel.fireTableRowsDeleted(row, row);
				}
				
				
			}
        	
        });
        
        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

//
    public void setData(List<Customer> db) {
        this.tableModel.setData(db);
    }
//
    public void refresh() {
        tableModel.fireTableDataChanged();
    }
    
    public void setCustomerTableListener(CustomerTableListener listener)
    {
    	this.customerTableListener = listener;
    }
}