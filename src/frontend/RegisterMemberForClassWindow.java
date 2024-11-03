/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import backend.TrainerRole;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

/**
 *
 * @author C O N N E C T
 */
public class RegisterMemberForClassWindow extends JFrame implements ActionListener{
    private JLabel memberIdLabel = new JLabel("Member Id");
    private JLabel classIdLabel = new JLabel("Class Id");
    private JLabel registrationDateLabel = new JLabel("Registration Date");
    
    private JTextField memberIdText = new JTextField();
    private JTextField classIdText = new JTextField();
    
    // Registration Date Field with JSpinner
    SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, DAY_OF_MONTH);
    JSpinner dateSpinner = new JSpinner(dateModel);
    
    private JButton registerButton = new JButton("Register");
    TrainerRole trainerRole = new TrainerRole();
    
    public void showFrame(){
        // FRAME
        this.setTitle("Register Member");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(380, 80);
        this.setLayout(null);
        
        // COMPONENTS
        this.memberIdLabel.setBounds(30, 20, 150, 50);
        this.memberIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.memberIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.memberIdLabel.setFont(new Font(this.memberIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.memberIdLabel.setOpaque(true);
        this.memberIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.memberIdLabel);
        
        this.classIdLabel.setBounds(30, 90, 150, 50);
        this.classIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.classIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.classIdLabel.setFont(new Font(this.classIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.classIdLabel.setOpaque(true);
        this.classIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.classIdLabel);

        this.registrationDateLabel.setBounds(30, 160, 150, 50);
        this.registrationDateLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.registrationDateLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.registrationDateLabel.setFont(new Font(this.registrationDateLabel.getFont().getName(), Font.PLAIN, 16));
        this.registrationDateLabel.setOpaque(true);
        this.registrationDateLabel.setBackground(MyColors.mintGreen);
        this.add(this.registrationDateLabel);

        this.memberIdText.setBounds(230, 20, 230, 50);
        this.memberIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.memberIdText);
        
        this.classIdText.setBounds(230, 90, 230, 50);
        this.classIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.classIdText);
        
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
        add(dateSpinner);
        this.dateSpinner.setBounds(230, 160, 230, 50);

                                
        this.registerButton.setBounds(130, 250, 230, 60);
        this.registerButton.setBackground(Color.black);
        this.registerButton.setForeground(Color.WHITE);
        this.add(this.registerButton);
        this.registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){
            String inputMemberId = memberIdText.getText().toString();
            String inputClassId = classIdText.getText().toString();
            Date inputDate = (Date) dateSpinner.getValue();
            LocalDate localDate = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if(inputMemberId.equals("") || inputClassId.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the text fields", "Message", JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                int flag = trainerRole.registerMemberForClass(inputMemberId, inputClassId, localDate);
                if(flag == 1){
                    JOptionPane.showMessageDialog(null, "Member or Class not found", "Message", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
                else if(flag == 2){
                    JOptionPane.showMessageDialog(null, "The Class has no available seats", "Message", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
                else if(flag == 3){
                    JOptionPane.showMessageDialog(null, "The Member with Id = " + inputMemberId + " has successfully registered to class "+ inputClassId , "Message", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else if(flag == 4){
                    JOptionPane.showMessageDialog(null, "The Member already registered to this class" , "Message", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        }
    }
}