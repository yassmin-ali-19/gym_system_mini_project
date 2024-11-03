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
public class CancelRegistrationWindow extends JFrame implements ActionListener{
    private JLabel memberIdLabel = new JLabel("Member Id");
    private JLabel classIdLabel = new JLabel("Class Id");
    private JTextField memberIdText = new JTextField();
    private JTextField classIdText = new JTextField();
    private JButton cancelButton = new JButton("Cancel Registration");
    TrainerRole trainerRole = new TrainerRole();

    public void showFrame(){
        // FRAME
        this.setTitle("Cancel Registration");
        this.setSize(500, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(380, 80);
        this.setLayout(null);
        
        this.memberIdLabel.setBounds(50, 60, 150, 50);
        this.memberIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.memberIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.memberIdLabel.setFont(new Font(this.memberIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.memberIdLabel.setOpaque(true);
        this.memberIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.memberIdLabel);
        
        this.classIdLabel.setBounds(50, 180, 150, 50);
        this.classIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.classIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.classIdLabel.setFont(new Font(this.classIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.classIdLabel.setOpaque(true);
        this.classIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.classIdLabel);

        this.memberIdText.setBounds(230, 60, 180, 50);
        this.memberIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.memberIdText);
        
        this.classIdText.setBounds(230, 180, 180, 50);
        this.classIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.classIdText);
        
        this.cancelButton.setBounds(130, 280, 230, 60);
        this.cancelButton.setBackground(Color.black);
        this.cancelButton.setForeground(Color.WHITE);
        this.add(this.cancelButton);
        this.cancelButton.addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancelButton){
            String inputMemberId = memberIdText.getText().toString();
            String inputClassId = classIdText.getText().toString();
            
            if(inputMemberId.equals("") || inputClassId.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the text fields", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int flag = trainerRole.cancelRegistration(inputMemberId, inputClassId);
                if(flag == 1){
                    JOptionPane.showMessageDialog(null, "Registration not found", "Message", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
                else if(flag == 2){
                    JOptionPane.showMessageDialog(null, "Registration not within 3 days, Can't cancel", "Message", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
                else if(flag == 3){
                    
                }
            }

        }
    }
    
}
