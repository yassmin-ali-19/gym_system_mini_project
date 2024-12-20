/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author C O N N E C T
 */
public class TrainerDatabase implements Database<Trainer>{
    private ArrayList<Trainer> records;
    private String filename;
    
//    CONSTRUCTOR
    public TrainerDatabase(String filename){
        this.filename = filename;
        records = new ArrayList<>();
    }
    
//    METHODS

    /**
     *
     */
    @Override
    public void readFromFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            String[] lineArray;
            while((line = reader.readLine()) != null){
                lineArray = line.split(",");
                Trainer trainer = new Trainer(lineArray[0],lineArray[1],lineArray[2],lineArray[3],lineArray[4]);
                this.records.add(trainer);
            }
                
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    /**
     *
     * @param line
     * @return 
     */
    @Override
    public Trainer createRecordFrom(String line){
        String[] lineArray = line.split(",");
        Trainer trainer = new Trainer(lineArray[0],lineArray[1],lineArray[2],lineArray[3],lineArray[4]);
        return trainer;
    }
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<Trainer> returnAllRecords(){
        this.readFromFile();
        return this.records;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(String key){
        this.readFromFile();
        for(Trainer record:this.records){
            if(key.equals(record.getSearchKey()))
                return true;
        }
        return false;
    }
    
    /**
     *
     * @param key
     * @return
     */
    @Override
    public Trainer getRecord(String key){
        this.readFromFile();
        for(Trainer record:this.records){
            if(key.equals(record.getSearchKey()))
                return record;
        }
        return null;
    }

    /**
     *
     * @param record
     */
    @Override
    public boolean insertRecord(Trainer record){
        this.readFromFile();
        for(Trainer r:this.records){
            if(r.getSearchKey().equals(record.getSearchKey())){
                System.out.println("Trainer already in system!!!");
                return true;
            }
        }
        this.records.add(record);
        return false;
    }

    /**
     *
     * @param key
     */
    @Override
    public void deleteRecord(String key){
        this.readFromFile();
        int i=0;
        for(Trainer record:this.records){
            if(key.equals(record.getSearchKey())){
                this.records.remove(i);
                saveToFile();
                return;
            }
            i++;
        }
        System.out.println("Trainer to be deleted not found");
    }

    /**
     *
     */
    @Override
    public void saveToFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            boolean firstRecord = true;
            for(Trainer record:records){
                if(firstRecord)
                    writer.write(record.lineRepresentation());
                else
                    writer.write("\n" + record.lineRepresentation());
                firstRecord = false;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
