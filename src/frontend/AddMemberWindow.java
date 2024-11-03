/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import backend.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author C O N N E C T
 */
public class AddMemberWindow extends JFrame implements ActionListener{
    private JLabel idLabel = new JLabel("Id");
    private JLabel nameLabel = new JLabel("Name");
    private JLabel emailLabel = new JLabel("Email");
    private JLabel membershipTypeLabel = new JLabel("Membership Type");
    private JLabel phoneNumberLabel = new JLabel("Phone Number");
    private JLabel statusLabel = new JLabel("Status");
    
    private JTextField idText = new JTextField();
    private JTextField nameText = new JTextField();
    private JTextField emailText = new JTextField();
    private JTextField membershipTypeText = new JTextField();
    private JTextField phoneNumberText = new JTextField();
    private JTextField statusText = new JTextField();
    
    private JButton addButton = new JButton("Add");
    TrainerRole trainerRole = new TrainerRole();
    
    public void showFrame(){
        // FRAME
        this.setTitle("Add Member");
        this.setSize(600, 580);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(380, 80);
        this.setLayout(null);
        
        // COMPONENTS
        this.idLabel.setBounds(30, 20, 150, 50);
        this.idLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.idLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.idLabel.setFont(new Font(this.idLabel.getFont().getName(), Font.PLAIN, 16));
        this.idLabel.setOpaque(true);
        this.idLabel.setBackground(MyColors.mintGreen);
        this.add(this.idLabel);

        this.nameLabel.setBounds(30, 90, 150, 50);
        this.nameLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.nameLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.nameLabel.setFont(new Font(this.nameLabel.getFont().getName(), Font.PLAIN, 16));
        this.nameLabel.setOpaque(true);
        this.nameLabel.setBackground(MyColors.mintGreen);
        this.add(this.nameLabel);

        this.emailLabel.setBounds(30, 160, 150, 50);
        this.emailLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.emailLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.emailLabel.setFont(new Font(this.emailLabel.getFont().getName(), Font.PLAIN, 16));
        this.emailLabel.setOpaque(true);
        this.emailLabel.setBackground(MyColors.mintGreen);
        this.add(this.emailLabel);

        this.membershipTypeLabel.setBounds(30, 230, 150, 50);
        this.membershipTypeLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.membershipTypeLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.membershipTypeLabel.setFont(new Font(this.membershipTypeLabel.getFont().getName(), Font.PLAIN, 16));
        this.membershipTypeLabel.setOpaque(true);
        this.membershipTypeLabel.setBackground(MyColors.mintGreen);
        this.add(this.membershipTypeLabel);

        this.phoneNumberLabel.setBounds(30, 300, 150, 50);
        this.phoneNumberLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.phoneNumberLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.phoneNumberLabel.setFont(new Font(this.phoneNumberLabel.getFont().getName(), Font.PLAIN, 16));
        this.phoneNumberLabel.setOpaque(true);
        this.phoneNumberLabel.setBackground(MyColors.mintGreen);
        this.add(this.phoneNumberLabel);

        this.statusLabel.setBounds(30, 370, 150, 50);
        this.statusLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.statusLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.statusLabel.setFont(new Font(this.statusLabel.getFont().getName(), Font.PLAIN, 16));
        this.statusLabel.setOpaque(true);
        this.statusLabel.setBackground(MyColors.mintGreen);
        this.add(this.statusLabel);

        this.idText.setBounds(300, 20, 230, 50);
        this.idText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.idText);
        
        this.nameText.setBounds(300, 90, 230, 50);
        this.nameText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.nameText);
        
        this.emailText.setBounds(300, 160, 230, 50);
        this.emailText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.emailText);
        
        this.membershipTypeText.setBounds(300, 230, 230, 50);
        this.membershipTypeText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.membershipTypeText);
        
        this.phoneNumberText.setBounds(300, 300, 230, 50);
        this.phoneNumberText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.phoneNumberText);
        
        this.statusText.setBounds(300, 370, 230, 50);
        this.statusText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.statusText);
        
        this.addButton.setBounds(150, 450, 230, 60);
        this.addButton.setBackground(Color.black);
        this.addButton.setForeground(Color.WHITE);
        this.add(this.addButton);
        this.addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String inputId = idText.getText().toString();
            String inputName = nameText.getText().toString();
            String inputEmail = emailText.getText().toString();
            String inputMembershipType = membershipTypeText.getText().toString();
            String inpuPhoneNumber = phoneNumberText.getText().toString();
            String inputStatus = statusText.getText().toString();
            if(inputId.equals("") || inputName.equals("") || inputEmail.equals("") || inputMembershipType.equals("") || inpuPhoneNumber.equals("") || inputStatus.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the text fields", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else if(trainerRole.addMember(inputId, inputName, inputMembershipType, inputEmail, inpuPhoneNumber, inputStatus)){
                JOptionPane.showMessageDialog(null, "The Member with Id = " + inputId + " already exists", "Message", JOptionPane.ERROR_MESSAGE);
                TrainerRoleWindow trainerRoleMenu = new TrainerRoleWindow();
                trainerRoleMenu.showFrame();
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "The Member with Id = " + inputId + " is successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
                TrainerRoleWindow trainerRoleMenu = new TrainerRoleWindow();
                trainerRoleMenu.showFrame();
                dispose();
            }
        }
    }
}
