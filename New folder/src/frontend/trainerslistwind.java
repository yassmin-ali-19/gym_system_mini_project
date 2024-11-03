/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;
import backend.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Yassmin
 */
public class trainerslistwind {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CSV Data Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            // Load data from CSV file
            String filePath = "data.csv"; // Change this to your file path
            DefaultTableModel model = loadDataFromCsv(filePath);

            // Create JTable
            JTable table = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }

    private static DefaultTableModel loadDataFromCsv(String filePath) {
        DefaultTableModel model = new DefaultTableModel();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                
                // If it's the first line, set the column names
                if (isHeader) {
                    model.setColumnIdentifiers(values);
                    isHeader = false;
                } else {
                    model.addRow(values);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return model;
    }
    
}
