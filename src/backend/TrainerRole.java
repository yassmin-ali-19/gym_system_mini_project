/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import static constants.FileNames.*;
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
        memberDatabase=new MemberDatabase(MEMBER_FILENAME);
        classDatabase=new ClassDatabase(CLASS_FILENAME);
        registrationDatabase=new MemberClassRegistrationDatabase(REGISTRATION_FILENAME);
    }
    public boolean addMember(String memberID, String name, String membershipType, String email, String phoneNumber, String status)
    {
        boolean found = memberDatabase.insertRecord(new Member(memberID,name,membershipType,email,phoneNumber,status));
        memberDatabase.saveToFile();
        return found;
    }
    
    public ArrayList<Member> getListOfMembers ()
    {
       return memberDatabase.returnAllRecords();
    }
    
    public boolean addClass (String classID, String className, String trainerID, int duration, int maxParticipants)
    {
        boolean found = classDatabase.insertRecord(new Class(classID,className,trainerID,duration,maxParticipants));
        classDatabase.saveToFile();
        return found;
    }
    public ArrayList<Class> getListOfClasses ()
    {
        return classDatabase.returnAllRecords();
    }
    public boolean registerMemberForClass (String memberID, String classID, LocalDate registrationDate){
        if(classDatabase.contains(classID) && memberDatabase.contains(memberID)){
            Class newclass = classDatabase.getRecord(classID);
             int flag=0;
             if(newclass.getAvailableSeats()>0)flag=1;
             if(flag==1){
             registrationDatabase.insertRecord(new MemberClassRegistration(memberID,classID,registrationDate,"active"));
             newclass.setAvailableSeats(newclass.getAvailableSeats()-1);
             registrationDatabase.saveToFile();
             return true;
             }
             return false;
        }
        return false;
    }
    public boolean cancelRegistration (String memberID, String classID)
    {
        if(registrationDatabase.contains(memberID+classID)){
            MemberClassRegistration registration = registrationDatabase.getRecord(memberID+classID);
            LocalDate registrationDate = registration.getRegistrationDate();
            long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), registrationDate.plusDays(3));
            boolean isWithin3Days = Math.abs(daysDifference) <= 3;
            if(isWithin3Days)
            {
                registration.setRegistrationStatus("canceled");
                Class classs = classDatabase.getRecord(classID);
                classs.setAvailableSeats(classs.getAvailableSeats()+1);
                registrationDatabase.saveToFile();
                return true;
            }
            return false;
        }
        return false;
    }
    
    public ArrayList<MemberClassRegistration> getListOfRegistrations () {
        return registrationDatabase.returnAllRecords();
    }
    public void logout ()
    {
        memberDatabase.saveToFile();
        classDatabase.saveToFile();
        registrationDatabase.saveToFile();
    }
            

   
}
