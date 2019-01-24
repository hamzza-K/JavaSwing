package gui;

import java.awt.Dimension;




import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import controller.Controller;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import gui.TablePanel;





public class MainFrame extends JFrame
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//--------------------------
//    private JTextArea textArea;
    private JButton button;
//    private TextPanel textPanel;
    private Toolbar toolbar;
    private FormPanel formPanel; 
    private JFileChooser fileChooser;
     private TablePanel tablePanel;
    private Controller controller;
    //--------------------------



    //------------------
    public MainFrame()
    {
   
        super("Incendiary ");

        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
        
//        button = new JButton("Cick me");
//        textPanel = new TextPanel();
        toolbar = new Toolbar();
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
         tablePanel = new TablePanel();
         controller = new Controller();
         
         tablePanel.setData(controller.getCustomer());
         
         tablePanel.setCustomerTableListener(new CustomerTableListener()
        		 {
        	 		public void rowDeleted(int row)
        	 		{
        	 			controller.removeCustomer(row);
        	 		}
        		 });
         

        fileChooser.addChoosableFileFilter(new CustomerFileFilter());
        
        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
//        add(button, BorderLayout.SOUTH);

//        
//        toolbar.setStringListener(new StringListener()
//        {
//            public void textEmitted(String text)
//            {
//                textPanel.appendText(text);
//            }
//        });

        formPanel.setFormListener(new FormListener()
        {
            public void formEventOccured(FormEvent e)
            {
                // String name = e.getName();
                // String occupation = e.getOccupation();
                // int ageCat = e.getAgeCategory();
                // String empCat = e.getEmployementCategory();

                // textPanel.appendText(name + ": " + occupation + " : " + ageCat + " - " + empCat + "\n");

                controller.addCustomer(e);
                 tablePanel.refresh();
            }
        });


//        button.addActionListener(new ActionListener(){
//        
//            @Override
//            public void actionPerformed(ActionEvent arg0) {
//                textPanel.appendText("oh shit\n");
//            }
//        });
        
        setMinimumSize(new Dimension(600, 500));
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    //-----------------------------
    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");


        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exiItem = new JMenuItem("Exit");

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exiItem);

        
        JCheckBoxMenuItem showFormiItem = new JCheckBoxMenuItem("Customer Form");
        showFormiItem.setSelected(false);

        
        showMenu.add(showFormiItem);
        windowMenu.add(showMenu);

        showFormiItem.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)arg0.getSource();

                formPanel.setVisible(menuItem.isSelected());
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exiItem.setMnemonic(KeyEvent.VK_X);

        exiItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        
        importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));


        importDataItem.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) 
                {
                	try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
						
					} catch (ClassNotFoundException | IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this, "Could Not Load Data from File", "Error", JOptionPane.ERROR_MESSAGE);;
					}
                   
                }
            }
        });
        
        exportDataItem.addActionListener(new ActionListener()
        		{

        	   @Override
               public void actionPerformed(ActionEvent arg0) {
                   if(fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) 
                   {
                   	try {
   						controller.saveToFile(fileChooser.getSelectedFile());
   					} catch (IOException e) {
   						JOptionPane.showMessageDialog(MainFrame.this, "Could Not Save Data to File", "Error", JOptionPane.ERROR_MESSAGE);;
   					}
                      
                   }
               }
        		});

        exiItem.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure?", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if(action ==  JOptionPane.OK_OPTION)
                {
                System.exit(0);
                }
            }
        });

        return menuBar;
    }
}


