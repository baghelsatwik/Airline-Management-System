package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton reset, loginButton, cancelButton;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    public Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lb1Username = new JLabel("Username");
        lb1Username.setBounds(20,20,100,20);
        add(lb1Username);
        //username field
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        //password field
        JLabel lb1password = new JLabel("Password");
        lb1password.setBounds(20,60,100,20);
        add(lb1password);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(70,120,100,30);
        reset.setBackground(Color.BLUE);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(200,120,100,30);
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(130,170,100,30);
        cancelButton.setBackground(Color.BLUE);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
        } else if(ae.getSource() == loginButton){
            String username = tfusername.getText();
            String password = tfpassword.getText();
            try{
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet  rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Username pr Password");
                    setVisible(false);
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancelButton){
            
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
