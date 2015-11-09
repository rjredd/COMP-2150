package programmingassignment2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloAndGoodbye extends JFrame
{
    private JButton helloButton, goodbyeButton, exitButton;
    private String message;

    public HelloAndGoodbye()
    {
        helloButton = new JButton("Hello");
        goodbyeButton = new JButton("Goodbye");
        exitButton = new JButton("Exit");
        message = "";// initializes message to the empty string, so that if no
                     // button
                     // is pressed, nothing appears on the screen

        setTitle("Hello and Goodbye");
        setBounds(0, 0, 300, 300);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(helloButton);
        buttonPanel.add(goodbyeButton);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        helloButton.addActionListener(new ButtonListener());
        goodbyeButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());
        
        setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Font f = new Font("Arial", Font.BOLD, 16);
        g.setFont(f);
        g.drawString(message, 100, 100);
    }

    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == helloButton)
            {
                message = "Hello";
                repaint();
            } else if (e.getSource() == goodbyeButton)
            {
                message = "Goodbye";
                repaint();
            } else
                System.exit(0);
        }
    }
}
