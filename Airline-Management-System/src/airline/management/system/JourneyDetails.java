package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    
    JTable table;
    JTextField tfpnr;
    
    public JourneyDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel lbPnr = new JLabel("PNR");
        lbPnr.setBounds(30, 30, 70, 40);
        lbPnr.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbPnr.setForeground(Color.BLUE);
        add(lbPnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(120, 30, 200, 40);
        add(tfpnr);
        
        JButton show = new JButton("Show Details");
        show.setBounds(350, 30, 150, 40);
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLUE);
        show.setFont(new Font("Tahoma", Font.PLAIN, 20));
        show.addActionListener(this);
        add(show);
        
         table = new JTable();
         
         JScrollPane jsp = new JScrollPane(table);
         jsp.setBounds(0, 100, 800, 150);
         jsp.setBackground(Color.WHITE);
         add(jsp);
        
        
        setSize(800,500);
        setLocation(300,150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String pnr = tfpnr.getText();
        try {
            Conn c = new Conn();
            
            String query = "select * from reservation where PNR = '" + pnr + "'";
            ResultSet rs = c.s.executeQuery(query);
            
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(null, "Invalid PNR");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));     
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new JourneyDetails();
    }
}
