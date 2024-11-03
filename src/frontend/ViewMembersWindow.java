package frontend;

import static constants.FileNames.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViewMembersWindow extends JFrame {

    public void showFrame(){
        // FRAME        
        setTitle("View Members");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setSize(600, 400);
        setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(true);

        DefaultTableModel model = loadDataFromCsv(MEMBER_FILENAME);
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
    }

    private static DefaultTableModel loadDataFromCsv(String filePath) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Id", "Name", "Email", "Membership Type", "Phone Number", "status"});
        
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