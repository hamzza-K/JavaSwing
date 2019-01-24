package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Toolbar extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    private JButton helloButton;
    private JButton goodbyeButton;
    private TextPanel textPanel;
    private StringListener textListener;

    public Toolbar()
    {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("GoodBye");


        helloButton.addActionListener(this);
        goodbyeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.CENTER));

//        add(helloButton);
//        add(goodbyeButton);

        setBorder(BorderFactory.createEtchedBorder());
    }


    public void setStringListener(StringListener listener)
    {
        this.textListener = listener; 
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();

        if(clicked == helloButton)
        {
            if(textListener!=null)
            {
            textListener.textEmitted("hello\n");        }
        }

        else if(clicked == goodbyeButton)
        {
            if(textListener!=null)
            {
            textListener.textEmitted("GoodBye\n"); }
        }
    }
}

interface StringListener
{
    public void textEmitted(String text);
}