/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author C O N N E C T
 */
public class TrainerRoleWindow extends JFrame implements ActionListener{
    private JButton addMemberB = new JButton("Add Member");
    private JButton viewMembersB = new JButton("View Members");
    private JButton addClassB = new JButton("Add Class");
    private JButton viewClassesB = new JButton("View Classes");
    private JButton registerMemberForClassB = new JButton("Register Member for Class");
    private JButton cancelRegistrationB = new JButton("Cancel Registration");
    private JButton viewRegistrationsB = new JButton("View Registrations");
    private JButton logoutB = new JButton("Logout");
    
    public void showFrame(){
        // FRAME
        this.setTitle("Trainer Role");
        this.setSize(400, 630);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(450, 90);
        this.setLayout(null);
        
        //addMemberB
        this.addMemberB.setBounds(85, 20, 230, 60);
        this.addMemberB.setBackground(Color.black);
        this.addMemberB.setForeground(Color.WHITE);
        this.add(this.addMemberB);
        this.addMemberB.addActionListener(this);
        
        //viewMembersB
        this.viewMembersB.setBounds(85, 90, 230, 60);
        this.viewMembersB.setBackground(Color.black);
        this.viewMembersB.setForeground(Color.WHITE);
        this.add(this.viewMembersB);
        this.viewMembersB.addActionListener(this);
        
        //addClassB
        this.addClassB.setBounds(85, 160, 230, 60);
        this.addClassB.setBackground(Color.black);
        this.addClassB.setForeground(Color.WHITE);
        this.add(this.addClassB);
        this.addClassB.addActionListener(this);
        
        //viewClassesB
        this.viewClassesB.setBounds(85, 230, 230, 60);
        this.viewClassesB.setBackground(Color.black);
        this.viewClassesB.setForeground(Color.WHITE);
        this.add(this.viewClassesB);
        this.viewClassesB.addActionListener(this);
        
        //registerMemberForClassB
        this.registerMemberForClassB.setBounds(85, 300, 230, 60);
        this.registerMemberForClassB.setBackground(Color.black);
        this.registerMemberForClassB.setForeground(Color.WHITE);
        this.add(this.registerMemberForClassB);
        this.registerMemberForClassB.addActionListener(this);
        
        //cancelRegistrationB
        this.cancelRegistrationB.setBounds(85, 370, 230, 60);
        this.cancelRegistrationB.setBackground(Color.black);
        this.cancelRegistrationB.setForeground(Color.WHITE);
        this.add(this.cancelRegistrationB);
        this.cancelRegistrationB.addActionListener(this);
        
        //viewRegistrationsB
        this.viewRegistrationsB.setBounds(85, 440, 230, 60);
        this.viewRegistrationsB.setBackground(Color.black);
        this.viewRegistrationsB.setForeground(Color.WHITE);
        this.add(this.viewRegistrationsB);
        this.viewRegistrationsB.addActionListener(this);
        
        //logoutB
        this.logoutB.setBounds(85, 510, 230, 60);
        this.logoutB.setBackground(Color.black);
        this.logoutB.setForeground(Color.WHITE);
        this.add(this.logoutB);
        this.logoutB.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.addMemberB){
            AddMemberWindow addMemberWindow = new AddMemberWindow();
            addMemberWindow.showFrame();
        }
        if(e.getSource() == this.viewMembersB){
            ViewMembersWindow viewMembersWindow = new ViewMembersWindow();
            viewMembersWindow.showFrame();
        }
        if(e.getSource() == this.addClassB){
            AddClassWindow addClassWindow = new AddClassWindow();
            addClassWindow.showFrame();
        }
        if(e.getSource() == this.viewClassesB){
            ViewClassesWindow viewClassesWindow = new ViewClassesWindow();
            viewClassesWindow.showFrame();
        }
        if(e.getSource() == this.registerMemberForClassB){
            RegisterMemberForClassWindow registerMemberForClassWindow = new RegisterMemberForClassWindow();
            registerMemberForClassWindow.showFrame();
        }
        if(e.getSource() == this.cancelRegistrationB){
            CancelRegistrationWindow cancelRegistrationWindow = new CancelRegistrationWindow();
            cancelRegistrationWindow.showFrame();
        }
    }
}
