/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab.pkg4.gym.management.system;

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
public class ClassDatabase implements Database<Class>{
    private ArrayList<Class> records;
    private String filename;
    
//    CONSTRUCTOR
    public ClassDatabase(String filename){
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
                Class cl = new Class(lineArray[0],lineArray[1],lineArray[2],Integer.parseInt(lineArray[3]),Integer.parseInt(lineArray[4]));
                this.records.add(cl);
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
    public Class createRecordFrom(String line){
        String[] lineArray = line.split(",");
        Class cl = new Class(lineArray[0],lineArray[1],lineArray[2],Integer.parseInt(lineArray[3]),Integer.parseInt(lineArray[4]));
        return cl;
    }
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<Class> returnAllRecords(){
        return this.records;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public boolean contains(String key){
        for(Class record:this.records){
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
    public Class getRecord(String key){
        for(Class record:this.records){
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
    public void insertRecord(Class record){
        for(Class r:this.records){
            if(r.getSearchKey().equals(record.getSearchKey())){
                System.out.println("Class already in system!!!");
                return;
            }
        }
        this.records.add(record);
    }

    /**
     *
     * @param key
     */
    @Override
    public void deleteRecord(String key){
        int i=0;
        for(Class record:this.records){
            if(key.equals(record.getSearchKey())){
                this.records.remove(i);
                saveToFile();
                return;
            }
            i++;
        }
        System.out.println("Class to be deleted not found");
    }

    /**
     *
     */
    @Override
    public void saveToFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            boolean firstRecord = true;
            for(Class record:records){
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
