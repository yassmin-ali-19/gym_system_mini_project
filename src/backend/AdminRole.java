/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;

/**
 *
 * @author C O N N E C T
 */
public class AdminRole {
    private TrainerDatabase database;
    
//    CONSTRUCTOR
    public AdminRole(){
        database = new TrainerDatabase("Trainers.txt");
    }
    
//    METHODS
    public void addTrainer (String trainerId, String name, String email, String specialty, String phoneNumber){
        database.insertRecord(new Trainer(trainerId, name, email, specialty, phoneNumber));
        database.saveToFile();
    }
    public ArrayList<Trainer> getListOfTrainers() {
        return database.returnAllRecords();
    }
    public void removeTrainer(String key){
        database.deleteRecord(key);
        database.saveToFile();
    } 
    public void logout(){
        database.saveToFile();
    }
}
