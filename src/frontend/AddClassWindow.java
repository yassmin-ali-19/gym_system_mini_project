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
public class AddClassWindow extends JFrame implements ActionListener{
    private JLabel classIdLabel = new JLabel("class Id");
    private JLabel classNameLabel = new JLabel("class Name");
    private JLabel TrainerIdLabel = new JLabel("Trainer Id");
    private JLabel DurationLabel = new JLabel("Duration");
    private JLabel maxParticipantsLabel = new JLabel("Max Participants");
    
    private JTextField classIdText = new JTextField();
    private JTextField classNameText = new JTextField();
    private JTextField TrainerIdText = new JTextField();
    private JTextField DurationText = new JTextField();
    private JTextField maxParticipantsText = new JTextField();
    
    private JButton addButton = new JButton("Add");
    TrainerRole trainerRole = new TrainerRole();
    
    public void showFrame(){
        // FRAME
        this.setTitle("Add Class");
        this.setSize(600, 580);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(380, 80);
        this.setLayout(null);
        
        // COMPONENTS
        this.classIdLabel.setBounds(30, 20, 150, 50);
        this.classIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.classIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.classIdLabel.setFont(new Font(this.classIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.classIdLabel.setOpaque(true);
        this.classIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.classIdLabel);

        this.classNameLabel.setBounds(30, 90, 150, 50);
        this.classNameLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.classNameLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.classNameLabel.setFont(new Font(this.classNameLabel.getFont().getName(), Font.PLAIN, 16));
        this.classNameLabel.setOpaque(true);
        this.classNameLabel.setBackground(MyColors.mintGreen);
        this.add(this.classNameLabel);

        this.TrainerIdLabel.setBounds(30, 160, 150, 50);
        this.TrainerIdLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.TrainerIdLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.TrainerIdLabel.setFont(new Font(this.TrainerIdLabel.getFont().getName(), Font.PLAIN, 16));
        this.TrainerIdLabel.setOpaque(true);
        this.TrainerIdLabel.setBackground(MyColors.mintGreen);
        this.add(this.TrainerIdLabel);

        this.DurationLabel.setBounds(30, 230, 150, 50);
        this.DurationLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.DurationLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.DurationLabel.setFont(new Font(this.DurationLabel.getFont().getName(), Font.PLAIN, 16));
        this.DurationLabel.setOpaque(true);
        this.DurationLabel.setBackground(MyColors.mintGreen);
        this.add(this.DurationLabel);

        this.maxParticipantsLabel.setBounds(30, 300, 150, 50);
        this.maxParticipantsLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.maxParticipantsLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.maxParticipantsLabel.setFont(new Font(this.maxParticipantsLabel.getFont().getName(), Font.PLAIN, 16));
        this.maxParticipantsLabel.setOpaque(true);
        this.maxParticipantsLabel.setBackground(MyColors.mintGreen);
        this.add(this.maxParticipantsLabel);

        this.classIdText.setBounds(300, 20, 230, 50);
        this.classIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.classIdText);
        
        this.classNameText.setBounds(300, 90, 230, 50);
        this.classNameText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.classNameText);
        
        this.TrainerIdText.setBounds(300, 160, 230, 50);
        this.TrainerIdText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.TrainerIdText);
        
        this.DurationText.setBounds(300, 230, 230, 50);
        this.DurationText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.DurationText);
        
        this.maxParticipantsText.setBounds(300, 300, 230, 50);
        this.maxParticipantsText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.maxParticipantsText);
                
        this.addButton.setBounds(150, 450, 230, 60);
        this.addButton.setBackground(Color.black);
        this.addButton.setForeground(Color.WHITE);
        this.add(this.addButton);
        this.addButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton){
            String inputClassId = classIdText.getText().toString();
            String inputClassName = classNameText.getText().toString();
            String inputTrainerId = TrainerIdText.getText().toString();
            String inputDuration = DurationText.getText().toString();
            String inputmaxParticipants = maxParticipantsText.getText().toString();
            if(inputClassId.equals("") || inputClassName.equals("") || inputTrainerId.equals("") || inputDuration.equals("") || inputmaxParticipants.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the text fields", "Message", JOptionPane.ERROR_MESSAGE);
            }
            else if(trainerRole.addClass(inputClassId, inputClassName, inputTrainerId, Integer.parseInt(inputDuration), Integer.parseInt(inputmaxParticipants))){
                JOptionPane.showMessageDialog(null, "The Class with Id = " + inputClassId + " already exists", "Message", JOptionPane.ERROR_MESSAGE);
                TrainerRoleWindow trainerRoleMenu = new TrainerRoleWindow();
                trainerRoleMenu.showFrame();
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "The Class with Id = " + inputClassId + " is successfully added", "Message", JOptionPane.INFORMATION_MESSAGE);
                TrainerRoleWindow trainerRoleMenu = new TrainerRoleWindow();
                trainerRoleMenu.showFrame();
                dispose();
            }
        }
    }
}