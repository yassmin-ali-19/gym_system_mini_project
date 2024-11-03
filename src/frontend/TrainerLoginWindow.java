/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import constants.LoginCredentials;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author C O N N E C T
 */
public class TrainerLoginWindow extends JFrame implements ActionListener{
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JTextField usernameText = new JTextField();
    private JPasswordField passwordText = new JPasswordField();
    private JButton loginButton = new JButton("Login");
    
    public void showFrame(){
        // FRAME
        this.setTitle("Trainer Login");
        this.setSize(600, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(350, 150);
        this.setLayout(null);
        
        // COMPONENTS
        this.usernameLabel.setBounds(50, 80, 230, 80);
        this.usernameLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.usernameLabel.setVerticalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.usernameLabel.setBorder(border);
        this.usernameLabel.setFont(new Font(this.usernameLabel.getFont().getName(), Font.PLAIN, 16));
        this.usernameLabel.setOpaque(true);
        this.usernameLabel.setBackground(MyColors.mintGreen);
        this.add(this.usernameLabel);

        this.passwordLabel.setBounds(50, 200, 230, 80);
        this.passwordLabel.setHorizontalAlignment(SwingConstants.CENTER); 
        this.passwordLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.passwordLabel.setBorder(border);
        this.passwordLabel.setFont(new Font(this.usernameLabel.getFont().getName(), Font.PLAIN, 16));
        this.passwordLabel.setOpaque(true);
        this.passwordLabel.setBackground(MyColors.mintGreen);
        this.add(this.passwordLabel);
        
        this.usernameText.setBounds(300, 80, 230, 80);
        this.usernameText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.usernameText);

        this.passwordText.setBounds(300, 200, 230, 80);
        this.passwordText.setFont(new Font("Arial", Font.PLAIN, 16));
        this.add(this.passwordText);
        
        this.loginButton.setBounds(150, 350, 230, 60);
        this.loginButton.setBackground(Color.black);
        this.loginButton.setForeground(Color.WHITE);
        this.add(this.loginButton);
        this.loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.loginButton){
            String inputUsername = usernameText.getText().toString();
            String inputPassword = new String(passwordText.getPassword());
            if(inputUsername.equals(LoginCredentials.TRAINER_USERNAME) && inputPassword.equals(LoginCredentials.TRAINER_PASSWORD)){
                TrainerRoleWindow trainerRoleMenu = new TrainerRoleWindow();
                trainerRoleMenu.showFrame();
                dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Wrong username or password", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
