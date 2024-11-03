package frontend;
import constants.*;
import backend.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class trainerslistwind extends JFrame {

    public trainerslistwind() {
        setTitle("View Trainers");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(600, 400);
        setLayout(new BorderLayout());

        String filePath = FileNames.TRAINER_FILENAME; 
        DefaultTableModel model = loadDataFromCsv(filePath);
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
        setVisible(true); 
    }

    private static DefaultTableModel loadDataFromCsv(String filePath) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Id", "Name", "Email", "Speciality", "PhoneNumber"});
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                model.addRow(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return model;
    }

    public static void main(String[] args) {
          
                new trainerslistwind().setVisible(true);
            
     
    }
}