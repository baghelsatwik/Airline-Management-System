package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel lbname, lbnationality, lbsource, lbdestination, lbfname, lbfcode, lbdate;
    JButton show;

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 20, 450, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.RED);
        add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 70, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 30));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        //Adhar Number
        JLabel pnr = new JLabel("PNR Details");
        pnr.setBounds(30, 150, 130, 30);
        pnr.setFont(new Font("Dialog", Font.PLAIN, 18));
        pnr.setForeground(Color.BLUE);
        add(pnr);
        //textfield for adharNumber
        tfpnr = new JTextField();
        tfpnr.setBounds(200, 150, 200, 30);
        add(tfpnr);
        //fetch Boarding pass
        show = new JButton("Enter");
        show.setBounds(420, 150, 100, 30);
        show.setFont(new Font("Dialog", Font.PLAIN, 18));
        show.setForeground(Color.WHITE);
        show.setBackground(Color.BLACK);
        show.addActionListener(this);
        add(show);

        //name
        JLabel name = new JLabel("Name");
        name.setBounds(30, 200, 130, 30);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLUE);
        add(name);
        //textfield for name
        lbname = new JLabel();
        lbname.setBounds(200, 200, 200, 30);
        lbname.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbname);

        //Nationality
        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(30, 250, 130, 30);
        nationality.setFont(new Font("Dialog", Font.PLAIN, 18));
        nationality.setForeground(Color.BLUE);
        add(nationality);
        //textfield for nationality
        lbnationality = new JLabel();
        lbnationality.setBounds(200, 250, 200, 30);
        lbnationality.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbnationality);

        //Address
        JLabel source = new JLabel("Source");
        source.setBounds(30, 300, 130, 30);
        source.setFont(new Font("Dialog", Font.PLAIN, 18));
        source.setForeground(Color.BLUE);
        add(source);
        //textfield for Address
        lbsource = new JLabel();
        lbsource.setBounds(200, 300, 200, 30);
        lbsource.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbsource);

        //Gender
        JLabel destination = new JLabel("Destination");
        destination.setBounds(400, 300, 130, 30);
        destination.setFont(new Font("Dialog", Font.PLAIN, 18));
        destination.setForeground(Color.BLUE);
        add(destination);
        //textfield for gender
        lbdestination = new JLabel();
        lbdestination.setBounds(550, 300, 200, 30);
        lbdestination.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbdestination);

        //Phone Number
        JLabel fname = new JLabel("Flight Name");
        fname.setBounds(30, 350, 130, 30);
        fname.setFont(new Font("Dialog", Font.PLAIN, 18));
        fname.setForeground(Color.BLUE);
        add(fname);
        //label for flight name
        lbfname = new JLabel();
        lbfname.setBounds(200, 350, 200, 30);
        lbfname.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbfname);

        //source
        JLabel fcode = new JLabel("Flight Code");
        fcode.setBounds(400, 350, 130, 30);
        fcode.setFont(new Font("Dialog", Font.PLAIN, 18));
        fcode.setForeground(Color.BLUE);
        add(fcode);
        //label for f;ight code
        lbfcode = new JLabel();
        lbfcode.setBounds(550, 350, 200, 30);
        lbfcode.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbfcode);

        //Destination
        JLabel date = new JLabel("Date");
        date.setBounds(30, 400, 130, 30);
        date.setFont(new Font("Dialog", Font.PLAIN, 18));
        date.setForeground(Color.BLUE);
        add(date);

        lbdate = new JLabel();
        lbdate.setBounds(200, 400, 200, 30);
        lbdate.setFont(new Font("Tahomia", Font.PLAIN, 18));
        add(lbdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600, 70, 250, 250);
        add(image);

        setSize(1000, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        //Fetch User Button Action
        if (ae.getSource() == show) {
            String pnr = tfpnr.getText();
            try {
                Conn c = new Conn();

                String query = "select * from reservation where pnr = '" + pnr + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    lbname.setText(rs.getString("name"));
                    lbnationality.setText(rs.getString("nationality"));
                    lbsource.setText(rs.getString("flightSource"));
                    lbdestination.setText(rs.getString("flightDestination"));
                    lbfname.setText(rs.getString("flightName"));
                    lbfcode.setText(rs.getString("flightCode"));
                    lbdate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid " + pnr);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
