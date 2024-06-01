package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CancelTicket extends JFrame implements ActionListener {

    JTextField tfpnrNumber;
    JLabel lbname, lbcancellationNo, lbf_code, lbphoneNumber, lbdate, lbfName, lbfCode;
    JButton bcancel, fetchUser;

    public CancelTicket() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random = new Random();

        JLabel heading = new JLabel("Cancel Ticket");
        heading.setBounds(250, 20, 250, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 100, 250, 250);
        add(image);

        //Adhar Number
        JLabel pnrNumber = new JLabel("PNR Number");
        pnrNumber.setBounds(30, 100, 200, 30);
        pnrNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        pnrNumber.setForeground(Color.BLUE);
        add(pnrNumber);
        //textfield for adharNumber
        tfpnrNumber = new JTextField();
        tfpnrNumber.setBounds(200, 100, 200, 30);
        add(tfpnrNumber);

        //Fetch User Button
        fetchUser = new JButton("Fetch User");
        fetchUser.setBounds(420, 100, 100, 30);
        fetchUser.setForeground(Color.WHITE);
        fetchUser.setBackground(Color.BLACK);
        fetchUser.addActionListener(this);
        add(fetchUser);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(30, 150, 200, 30);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLUE);
        add(name);
        //textfield for name
        lbname = new JLabel();
        lbname.setBounds(200, 150, 200, 30);
        lbname.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbname);

        //Nationality
        JLabel cancellationNo = new JLabel("Cancellation No.");
        cancellationNo.setBounds(30, 200, 200, 30);
        cancellationNo.setFont(new Font("Dialog", Font.PLAIN, 18));
        cancellationNo.setForeground(Color.BLUE);
        add(cancellationNo);
        //textfield for nationality
        lbcancellationNo = new JLabel("" + random.nextInt(1000000));
        lbcancellationNo.setBounds(200, 200, 200, 30);
        lbcancellationNo.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbcancellationNo);

        //Address
        JLabel f_code = new JLabel("Flight Code");
        f_code.setBounds(30, 250, 130, 30);
        f_code.setFont(new Font("Dialog", Font.PLAIN, 18));
        f_code.setForeground(Color.BLUE);
        add(f_code);
        //textfield for Address
        lbf_code = new JLabel();
        lbf_code.setBounds(200, 250, 300, 30);
        lbf_code.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbf_code);

        //Phone Number
        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(30, 350, 200, 30);
        phoneNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        phoneNumber.setForeground(Color.BLUE);
        add(phoneNumber);
        //textfield for phone Number
        lbphoneNumber = new JLabel();
        lbphoneNumber.setBounds(200, 350, 200, 30);
        lbphoneNumber.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbphoneNumber);

        //date
        JLabel ddate = new JLabel("Date");
        ddate.setBounds(30, 300, 130, 30);
        ddate.setFont(new Font("Dialog", Font.PLAIN, 18));
        ddate.setForeground(Color.BLUE);
        add(ddate);
        //textfield for date
        lbdate = new JLabel();
        lbdate.setBounds(200, 300, 200, 30);
        lbdate.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbdate);

        bcancel = new JButton("Cancel");
        bcancel.setBackground(Color.BLACK);
        bcancel.setForeground(Color.WHITE);
        bcancel.setBounds(350, 450, 200, 40);
        bcancel.setFont(new Font("Tahomia", Font.BOLD, 18));
        bcancel.addActionListener(this);
        add(bcancel);

        setSize(900, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnrNumber.getText();
        if (ae.getSource() == fetchUser) {
            try {
                Conn c = new Conn();
                String query = "select * from reservation where pnr = '" + pnr + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    lbname.setText(rs.getString("name"));
                    lbf_code.setText(rs.getString("flightCode"));
                    lbdate.setText(rs.getString("ddate"));
                    lbphoneNumber.setText(rs.getString("phone"));
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bcancel) {
            String name = lbname.getText();
            String cancellationno = lbcancellationNo.getText();
            String flightcode = lbf_code.getText();
            String date = lbdate.getText();
            String phone = lbphoneNumber.getText();
            try {
                Conn c = new Conn();

                String query = "insert into cancelReservation values('" 
                        + pnr + "','"
                        + name + "','"
                        + cancellationno + "','"
                        + flightcode + "','"
                        + date + "','"
                        + phone + "')";
                
                c.s.executeUpdate(query);
//                c.s.executeQuery("delete from reservation where pnr = '" + pnr + "'");
                
                JOptionPane.showMessageDialog(null, "Cancel Ticket\n\t" + pnr);
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CancelTicket();
    }
}
