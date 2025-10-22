import java.util.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Project{
    public static void main(String[]args){
        
        //Create a new Jframe(GUI Window)
        JFrame frame = new JFrame("Teacher Information");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Teacher's Name:");
        nameLabel.setBounds(50, 20, 120, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 20, 150, 25);

        // Create a label and input field for the teacher's subject
        JLabel subjectLabel = new JLabel("Teacher's Subject:");
        subjectLabel.setBounds(50, 60, 120, 25);
        JTextField subjectField = new JTextField();
        subjectField.setBounds(180, 60, 150, 25);

        // Create a button to display the information
        JButton displayButton = new JButton("Display Info");
        displayButton.setBounds(120, 100, 150, 25);

        // Create a label to display the result
        JLabel resultLabel = new JLabel("Info will appear here.");
        resultLabel.setBounds(50, 140, 300, 25);

        // Add action listener to the button
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name and subject from the text fields
                String name = nameField.getText();
                String subject = subjectField.getText();

                // Display the message in the result label
                if (!name.isEmpty() && !subject.isEmpty()) {
                    resultLabel.setText("Teacher: " + name + ", Subject: " + subject);
                } else {
                    resultLabel.setText("Please fill in both fields.");
                }
            }
        });

        // Add all components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(displayButton);
        frame.add(resultLabel);

        // Set the frame to be visible
        frame.setVisible(true);
    

    }

}