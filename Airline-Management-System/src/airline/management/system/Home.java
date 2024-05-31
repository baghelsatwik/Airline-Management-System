package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        JLabel heading = new JLabel("AIR INDIA WELCOME YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 36));
        image.add(heading);

        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        //Details Menu
        JMenu details = new JMenu("Details");
        menubar.add(details);
        JMenuItem bookFlight = new JMenuItem("Book Ticket");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);

        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);

        JMenuItem ticketCanecllation = new JMenuItem("Cancel Ticket");
        ticketCanecllation.addActionListener(this);
        details.add(ticketCanecllation);

        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        switch (text) {
            case "Add Customer Details" ->
                new CustomerDetails();
            case "Flight Details" ->
                new FlightInfo();
            case "Journey Details" ->
                new JourneyDetails();
            case "Book Ticket" ->
                new BookFlight();
            case "Cancel Ticket" ->
                new CancelTicket();
            default -> {
            }
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
