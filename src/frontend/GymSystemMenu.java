/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author C O N N E C T
 */
public class GymSystemMenu extends JFrame implements ActionListener{
    private JButton adminRoleButton = new JButton("Admin Role");
    private JButton trainerRoleButton = new JButton("Trainer Role");

    public void showFrame(){
        // FRAME
        this.setTitle("Gym System");
        this.setSize(400, 350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(500, 200);
        this.setLayout(null);

        // COMPONENTS
        this.adminRoleButton.setBounds(42, 60, 300, 60);
        this.adminRoleButton.setBackground(Color.black);
        this.adminRoleButton.setForeground(Color.WHITE);
        this.add(this.adminRoleButton);
        this.adminRoleButton.addActionListener(this);

        this.trainerRoleButton.setBounds(42, 170, 300, 60);
        this.trainerRoleButton.setBackground(Color.BLACK);
        this.trainerRoleButton.setForeground(Color.WHITE);
        this.add(this.trainerRoleButton);
        this.trainerRoleButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.adminRoleButton){
//            ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
        }
        if(e.getSource() == this.trainerRoleButton){
            TrainerLoginWindow trainerLoginMenu = new TrainerLoginWindow();
            trainerLoginMenu.showFrame();
            dispose();
        }
    }
}
