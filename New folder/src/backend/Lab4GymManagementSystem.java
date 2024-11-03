/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backend;

import java.time.LocalDate;

/**
 *
 * @author C O N N E C T
 */
public class Lab4GymManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdminRole admin1=new AdminRole();
    
        admin1.addTrainer("T1001", "John", "john@gmail.com","yoga","0123456789");
        admin1.addTrainer("n1001", "John", "john@gmail.com","yoga","0123456789");
             
        TrainerRole trainerrole1=new TrainerRole();
        
        trainerrole1.addMember("M222", "tamer", "Monthly", "tamer@gmail.com", "121515156", "active");
        trainerrole1.addMember("M122", "yassmin", "Monthly", "tamer@gmail.com", "121515156", "active");
        trainerrole1.getListOfMembers();
        for(Member i:trainerrole1.getListOfMembers())
        {
            System.out.println(i.lineRepresentation());
        }
             
        trainerrole1.addClass("C101", "karate", "T1001", 60, 30);
        trainerrole1.addClass("C201", "Yuga", "T1001", 60, 30);
        boolean out=trainerrole1.registerMemberForClass("M122", "C201", LocalDate.now());
        System.out.println(out);
        System.out.println(trainerrole1.cancelRegistration("M222", "C201"));
    }
    
}
