/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4.gym.management.system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Yassmin
 */
public class TrainerRole {
    private MemberDatabase memberDatabase;
    private ClassDatabase classDatabase;
    private MemberClassRegistrationDatabase registrationDatabase;
    
    public TrainerRole()
    {
        memberDatabase=new MemberDatabase("Members.txt");
        classDatabase=new ClassDatabase("Classes.txt");
        registrationDatabase=new MemberClassRegistrationDatabase("Registration.txt");
    }
    public void addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status)
    {
        memberDatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
        memberDatabase.saveToFile();
    }
    
    public ArrayList getListOfMembers ()
    {
       return memberDatabase.returnAllRecords();
    }
    
    public void addClass (String classID, String className, String trainerID, int duration, int maxParticipants)
    {
        classDatabase.insertRecord(new Class(classID,className,trainerID,duration,maxParticipants));
        classDatabase.saveToFile();
    }
    public ArrayList getListOfClasses ()
    {
        return classDatabase.returnAllRecords();
    }
    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate){
         Class newclass= classDatabase.getRecord(classID);
         int flag=0;
         if(newclass.getAvailableSeats()>0)flag=1;
         if(flag==1){
         registrationDatabase.insertRecord(new MemberClassRegistration(memberID,classID,registrationDate,"active"));
         newclass.setAvailableSeats(newclass.getAvailableSeats()-1);
         return true;
         }
         else return false;
    }
    public boolean cancelRegistration (String memberID, String classID)
    {
        MemberClassRegistration registration = registrationDatabase.getRecord(memberID+classID);
        LocalDate registrationDate = registration.getRegistrationDate();
        long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), registrationDate.plusDays(3));
        boolean isWithin3Days = Math.abs(daysDifference) <= 3;
        if(isWithin3Days)
        {
            //registrationDatabase.deleteRecord(classID);
            //member=new MemberClassRegistration(memberID,classID,date,"canceled");
            registration.setRegistrationStatus("canceled");
            Class classs = classDatabase.getRecord(classID);
            classs.setAvailableSeats(classs.getAvailableSeats()+1);
            return true;
        }
        return false;
    }
    
    public ArrayList<MemberClassRegistration> getListOfRegistrations () {
        return registrationDatabase.returnAllRecords();
    }

   
}
