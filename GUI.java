/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatudpclient1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pc15
 */
public class GUI extends JFrame implements ActionListener
{
    
    JPanel panel;
    JTextField textField;
    JTextArea textArea;
    JButton button;
    JScrollPane scroll;
    String username;
    
    int porta;
    InetAddress indirizzoIP;
    DatagramSocket socket;
    
    
    public GUI(String username, int porta, InetAddress indirizzoIP, DatagramSocket socket)
    {
        this.porta = porta;
        this.indirizzoIP = indirizzoIP;
        this.socket = socket;
        this.username = username;
        this.setBounds(500, 200, 200, 500);
        setTitle("Interfaccia");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        textField = new JTextField();
        textField.setEditable(true);
        textArea = new JTextArea();
        textArea.setEditable(true);
        button = new JButton("Invia");
        scroll = new JScrollPane(textArea);
        
        
        this.add(panel);
        panel.add(textField);
        panel.add(scroll);
        panel.add(button);
        
        this.pack();
        setVisible(true);
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
       if(ae.getActionCommand().equals("Invia"))
       {
           String message = username + " | " + this.textField.getText();
           new SendUserInputToServer(socket, indirizzoIP, porta, message);
       }
    }
    
    public void addMessage(String messaggio)
    {
        this.textArea.append(messaggio);
    }
    
}
