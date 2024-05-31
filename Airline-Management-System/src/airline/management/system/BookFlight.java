package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {

    JTextField tfadharNumber;
    JLabel lbname, lbnationality, lbaddress, lbphoneNumber, lbgender, lbfName, lbfCode;
    JButton bookFlight, fetchFlight, fetchUser;
    Choice chsource, chdestination;
    JDateChooser dcdate;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(400, 20, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);

        //Adhar Number
        JLabel adharNumber = new JLabel("Adhar Number");
        adharNumber.setBounds(30, 100, 130, 30);
        adharNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        adharNumber.setForeground(Color.BLUE);
        add(adharNumber);
        //textfield for adharNumber
        tfadharNumber = new JTextField();
        tfadharNumber.setBounds(200, 100, 200, 30);
        add(tfadharNumber);
        //Fetch User Button
        fetchUser = new JButton("Fetch User");
        fetchUser.setBounds(420, 100, 100, 30);
        fetchUser.setForeground(Color.WHITE);
        fetchUser.setBackground(Color.BLACK);
        fetchUser.addActionListener(this);
        add(fetchUser);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(30, 150, 130, 30);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLUE);
        add(name);
        //textfield for name
        lbname = new JLabel();
        lbname.setBounds(200, 150, 200, 30);
        add(lbname);

        //Nationality
        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(30, 200, 130, 30);
        nationality.setFont(new Font("Dialog", Font.PLAIN, 18));
        nationality.setForeground(Color.BLUE);
        add(nationality);
        //textfield for nationality
        lbnationality = new JLabel();
        lbnationality.setBounds(200, 200, 200, 30);
        add(lbnationality);

        //Address
        JLabel address = new JLabel("Address");
        address.setBounds(30, 250, 130, 30);
        address.setFont(new Font("Dialog", Font.PLAIN, 18));
        address.setForeground(Color.BLUE);
        add(address);
        //textfield for Address
        lbaddress = new JLabel();
        lbaddress.setBounds(200, 250, 300, 30);
        add(lbaddress);

        //Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 300, 130, 30);
        gender.setFont(new Font("Dialog", Font.PLAIN, 18));
        gender.setForeground(Color.BLUE);
        add(gender);
        //textfield for gender
        lbgender = new JLabel("Gender");
        lbgender.setBounds(200, 300, 200, 30);
        add(lbgender);

        //Phone Number
        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(30, 350, 130, 30);
        phoneNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        phoneNumber.setForeground(Color.BLUE);
        add(phoneNumber);
        //textfield for phone Number
        lbphoneNumber = new JLabel();
        lbphoneNumber.setBounds(200, 350, 200, 30);
        add(lbphoneNumber);

        //source
        JLabel source = new JLabel("Source");
        source.setBounds(30, 400, 130, 30);
        source.setFont(new Font("Dialog", Font.PLAIN, 18));
        source.setForeground(Color.BLUE);
        add(source);

        chsource = new Choice();
        chsource.setBounds(200, 400, 200, 40);
        add(chsource);

        //Destination
        JLabel destination = new JLabel("Destination");
        destination.setBounds(30, 450, 130, 30);
        destination.setFont(new Font("Dialog", Font.PLAIN, 18));
        destination.setForeground(Color.BLUE);
        add(destination);

        chdestination = new Choice();
        chdestination.setBounds(200, 450, 200, 40);
        add(chdestination);

        fetchFlight = new JButton("Fetch Flight");
        fetchFlight.setBackground(Color.BLACK);
        fetchFlight.setForeground(Color.WHITE);
        fetchFlight.setBounds(420, 450, 100, 30);
        fetchFlight.addActionListener(this);
        add(fetchFlight);

        try {
            Conn c = new Conn();

            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                chsource.add(rs.getString("f_source"));
                chdestination.add(rs.getString("f_destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Flight Name
        JLabel fName = new JLabel("Flight Name");
        fName.setBounds(30, 500, 130, 30);
        fName.setFont(new Font("Dialog", Font.PLAIN, 18));
        fName.setForeground(Color.BLUE);
        add(fName);
        //textfield for Address
        lbfName = new JLabel();
        lbfName.setBounds(200, 500, 200, 30);
        add(lbfName);

        //Flight code
        JLabel fCode = new JLabel("Flight Code");
        fCode.setBounds(30, 550, 130, 30);
        fCode.setFont(new Font("Dialog", Font.PLAIN, 18));
        fCode.setForeground(Color.BLUE);
        add(fCode);
        //textfield for Address
        lbfCode = new JLabel();
        lbfCode.setBounds(200, 550, 200, 30);
        add(lbfCode);

        //Flight code
        JLabel date = new JLabel("Date of Tarvel");
        date.setBounds(30, 600, 130, 30);
        date.setFont(new Font("Dialog", Font.PLAIN, 18));
        date.setForeground(Color.BLUE);
        add(date);
        //textfield for Address
        dcdate = new JDateChooser();
        dcdate.setBounds(200, 600, 200, 30);
        add(dcdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel empImage = new JLabel(i3);
        empImage.setBounds(550, 80, 500, 410);
        add(empImage);

        bookFlight = new JButton("Book Flight");
        bookFlight.setBackground(Color.BLUE);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.setFont(new Font("Dialog", Font.BOLD, 24));
        bookFlight.setBounds(700, 500, 200, 40);
        bookFlight.addActionListener(this);
        add(bookFlight);

        setSize(1100, 700);
        setLocation(150, 30);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //Fetch User Button Action
        if (ae.getSource() == fetchUser) {
            String adhar = tfadharNumber.getText();
            try {
                Conn c = new Conn();

                String query = "select * from passenger where adhar = '" + adhar + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    lbname.setText(rs.getString("name"));
                    lbnationality.setText(rs.getString("nationality"));
                    lbaddress.setText(rs.getString("address"));
                    lbgender.setText(rs.getString("gender"));
                    lbphoneNumber.setText(rs.getString("phone"));

                } else {
                    JOptionPane.showMessageDialog(null, "Please enter Correct Adhar Number");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Fetch Flight Button Action
        } else if (ae.getSource() == fetchFlight) {
            String f_source = chsource.getSelectedItem();
            String f_destination = chdestination.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from flight where f_source = '" + f_source + "' and f_destination = '" + f_destination + "'";

                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    lbfName.setText(rs.getString("f_name"));
                    lbfCode.setText(rs.getString("f_code"));

                } else {
                    JOptionPane.showMessageDialog(null, "No Flight Found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            String adhar = tfadharNumber.getText();
            String name = lbname.getText();
            String nationality = lbnationality.getText();
            String phone = lbphoneNumber.getText();
            String f_name = lbfName.getText();
            String f_code = lbfCode.getText();
            String f_source = chsource.getSelectedItem();
            String f_destination = chdestination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try{
                Conn c = new Conn();
                
                String query = "insert into reservation value('"
                        + "PNR-" + random.nextInt(1000000) + "','"
                        + "TIC-" + random.nextInt(10000) + "','"
                        + adhar + "','"
                        + name + "','"
                        + nationality + "','"
                        + phone + "','"
                        + f_name + "','"
                        + f_code + "','"
                        + f_source + "','"
                        + f_destination + "','"
                        + ddate + "')";
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BookFlight();
    }
}
