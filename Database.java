/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainer;

import java.util.ArrayList;

/**
 *
 * @author C O N N E C T
 * @param <T>
 */
public interface Database<T>{
        
//    METHODS
    public void readFromFile();
    public T createRecordFrom(String line);
    public ArrayList<T> returnAllRecords();
    public boolean contains(String key);
    public T getRecord(String key);
    public void insertRecord(T record);
    public void deleteRecord(String key);
    public void saveToFile();
}
