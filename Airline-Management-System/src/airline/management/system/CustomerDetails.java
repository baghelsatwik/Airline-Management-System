package airline.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerDetails extends JFrame implements ActionListener{
    
    JTextField tfname, tfnationality, tfadharNumber, tfaddress, tfphoneNumber;
    JRadioButton rbmale, rbfemale;
    public CustomerDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(170,30, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        //name
        JLabel name = new JLabel("Name");
        name.setBounds(30, 120, 130, 30);
        name.setFont(new Font("Dialog", Font.PLAIN, 18));
        name.setForeground(Color.BLUE);
        add(name);
        //textfield for name
        tfname = new JTextField();
        tfname.setBounds(200, 120, 200, 30);
        add(tfname);
        
        //Nationality
        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(30, 170, 130, 30);
        nationality.setFont(new Font("Dialog", Font.PLAIN, 18));
        nationality.setForeground(Color.BLUE);
        add(nationality);
        //textfield for nationality
        tfnationality = new JTextField();
        tfnationality.setBounds(200, 170, 200, 30);
        add(tfnationality);
        
        //Adhar Number
        JLabel adharNumber = new JLabel("Adhar Number");
        adharNumber.setBounds(30, 220, 130, 30);
        adharNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        adharNumber.setForeground(Color.BLUE);
        add(adharNumber);
        //textfield for adharNumber
        tfadharNumber = new JTextField();
        tfadharNumber.setBounds(200, 220, 200, 30);
        add(tfadharNumber);
        
        //Address
        JLabel address = new JLabel("Address");
        address.setBounds(30, 270, 130, 30);
        address.setFont(new Font("Dialog", Font.PLAIN, 18));
        address.setForeground(Color.BLUE);
        add(address);
        //textfield for name
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 270, 200, 30);
        add(tfaddress);
        
        //Gender
        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 320, 130, 30);
        gender.setFont(new Font("Dialog", Font.PLAIN, 18));
        gender.setForeground(Color.BLUE);
        add(gender);
        //Option for Gender
        ButtonGroup genderGroup = new ButtonGroup();
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 320, 70, 30);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 320, 70, 30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        genderGroup.add(rbmale);
        genderGroup.add(rbfemale);
        
        
        //Phone Number
        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(30, 370, 130, 30);
        phoneNumber.setFont(new Font("Dialog", Font.PLAIN, 18));
        phoneNumber.setForeground(Color.BLUE);
        add(phoneNumber);
        //textfield for name
        tfphoneNumber = new JTextField();
        tfphoneNumber.setBounds(200, 370, 200, 30);
        add(tfphoneNumber);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icons/emp.png"));
        JLabel empImage = new JLabel(i1);
        empImage.setBounds(420,100, 280,400);
        add(empImage);
        
        JButton save = new JButton("Save");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,450,150, 30);
        save.addActionListener(this);
        add(save);
        
        setSize(700,650);
        setLocation(300, 30);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String adhar = tfadharNumber.getText();
        String address = tfaddress.getText();
        String phone = tfphoneNumber.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else {
            gender = "Female";
        }
        try{
            Conn c = new Conn();
            
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+adhar+"','"+address+"','"+gender+"','"+phone+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            
            setVisible(false);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new CustomerDetails();
    }
}
