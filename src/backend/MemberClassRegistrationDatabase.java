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
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author C O N N E C T
 */
public class MemberClassRegistrationDatabase implements Database<MemberClassRegistration>{
    private ArrayList<MemberClassRegistration> records;
    private String filename;
    
//    CONSTRUCTOR
    public MemberClassRegistrationDatabase(String filename){
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
                MemberClassRegistration reg = new MemberClassRegistration(lineArray[0],lineArray[1],LocalDate.parse(lineArray[2]),lineArray[3]);
                this.records.add(reg);
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
    public MemberClassRegistration createRecordFrom(String line){
        String[] lineArray = line.split(",");
        MemberClassRegistration reg = new MemberClassRegistration(lineArray[0],lineArray[1],LocalDate.parse(lineArray[2]),lineArray[3]);
        return reg;
    }
    
    /**
     *
     * @return
     */
    @Override
    public ArrayList<MemberClassRegistration> returnAllRecords(){
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
        for(MemberClassRegistration record:this.records){
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
    public MemberClassRegistration getRecord(String key){
        this.readFromFile();
        for(MemberClassRegistration record:this.records){
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
    public boolean insertRecord(MemberClassRegistration record){
        this.readFromFile();
        for(MemberClassRegistration r:this.records){
            if(r.getSearchKey().equals(record.getSearchKey())){
                System.out.println("Member already registered in this class!!!");
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
        for(MemberClassRegistration record:this.records){
            if(key.equals(record.getSearchKey())){
                this.records.remove(i);
                saveToFile();
                return;
            }
            i++;
        }
        System.out.println("Registration to be deleted not found");
    }

    /**
     *
     */
    @Override
    public void saveToFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            boolean firstRecord = true;
            for(MemberClassRegistration record:records){
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