package frontend;

import static constants.FileNames.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author C O N N E C T
 */
public class ViewClassesWindow extends JFrame{

    public void showFrame(){
        // FRAME        
        setTitle("View Classes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(600, 400);
        setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(true);

        DefaultTableModel model = loadDataFromCsv(CLASS_FILENAME);
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
    }

    private static DefaultTableModel loadDataFromCsv(String filePath) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Class Id", "Class Name", "Trainer Id", "Duration", "Max Participants"});
        
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
}