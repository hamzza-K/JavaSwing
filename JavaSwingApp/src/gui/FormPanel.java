package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;



public class FormPanel extends JPanel
{
    /**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	private JLabel nameLabel; //Label text of Name of the customer
    private JLabel occupationLabel; //Occupation of the customer 
    private JTextField nameField;
    private JTextField occupationfield;
    private JButton okbutton;
    private FormListener formListener;
    private JList ageList; //Age List Variable here
    private JComboBox empCombo;
    private JCheckBox pakistani;
    private JTextField nic;
    private JLabel nicLabel;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;


    public FormPanel()
    {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);
        setVisible(false);

        nameLabel = new JLabel("Name: ");
        occupationLabel = new JLabel("Due Amount: ");
        nameField = new JTextField(10); //characters
        occupationfield = new JTextField(10);
        ageList = new JList(); //Age List initialized here
        okbutton = new JButton("OK");
        empCombo = new JComboBox<>();
        pakistani = new JCheckBox();
        nic = new JTextField(12);
        nicLabel = new JLabel("NIC: ");
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();

        //set up mnemonics
        okbutton.setMnemonic(KeyEvent.VK_O);
        

        //set up gender radios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);


        maleRadio.setSelected(true);
        maleRadio.setActionCommand("Male"); //gets you the string on selection
        femaleRadio.setActionCommand("Female");


        //set up NIC
        nicLabel.setEnabled(false);
        nic.setEnabled(false);

        pakistani.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                boolean isTicked = pakistani.isSelected();
                nic.setEnabled(isTicked);
                nicLabel.setEnabled(isTicked);
            }
        });


        //setup up emp list box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel<>();  
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");

        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        // empCombo.setEditable(true);



        setBorder(BorderFactory.createTitledBorder("Add Customer"));

        Border innerBorder = BorderFactory.createTitledBorder("Add Customer");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);

        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


        layoutComponents();

        //okbutton actionlister
        okbutton.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = nameField.getText();
                String occupation = occupationfield.getText();
                AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();
                String nicId = nic.getText();
                boolean paki = pakistani.isSelected();
                String gender = genderGroup.getSelection().getActionCommand(); //returns male female



                FormEvent event = new FormEvent(this, name, occupation, ageCat.getId(), empCat, nicId, paki, gender);

                if(formListener != null)
                {
                    formListener.formEventOccured(event); 
                    
                }
            }
        });


       
        DefaultListModel ageModel =  new DefaultListModel<>(); //Age model component

        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2,"65 or above"));

        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);
}

     
    public void layoutComponents()
    {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///////////////////////////////////////////////////////////
        ////////////////////    First Row   /////////////////////

        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        

        

        gc.gridx = 0;
        
      
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

         ////////////////////    Second Row   /////////////////////
         gc.gridy++;
         gc.weightx = 1;
         gc.weighty = 0.1;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationfield, gc);

         ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age: "), gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(ageList, gc);
         
        ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employe: "), gc);
    
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(empCombo, gc);

        ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

         
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Pakistani: "), gc);
 
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(pakistani, gc);


        ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

         
        gc.gridx = 0;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(nicLabel, gc);
 
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(nic, gc);
    
          ////////////////////    New Row   /////////////////////
          gc.gridy++;

          gc.weightx = 1;
          gc.weighty = 0.05;
  
           
          gc.gridx = 0;
          gc.insets = new Insets(0, 0, 0, 5);
          gc.anchor = GridBagConstraints.LINE_END;
          add(new JLabel("Gender: "), gc);
   
          gc.gridx = 1;
          gc.anchor = GridBagConstraints.FIRST_LINE_START;
          add(maleRadio, gc);    

                ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

         
 
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(femaleRadio, gc);    
         
           
        
        

        ////////////////////    New Row   /////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okbutton, gc);
    }

    

    public void setFormListener(FormListener listener)
    {
        this.formListener = listener;
    }

 
}

class AgeCategory{
    private String text;
    private int id;

    public AgeCategory(int id, String text)
    {
        this.id =id; 
        this.text = text;
    }

    public String toString()
    {
        return text;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


}