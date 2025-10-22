import java.util.List;
import javax.swing.*;

import Network.Metro.MetroNetwork;

import java.awt.*;
import java.util.*;

public class RouteFinder {
    public static void main(String[]args){
        // Create the metro network
        MetroNetwork.createNetwork();

        // Create GUI components
        JFrame frame = new JFrame("Metro Path Finder");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Input panel for source and destination
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel srcLabel = new JLabel("Source: ");
        JTextField srcField = new JTextField(15);
        JLabel destLabel = new JLabel("Destination: ");
        JTextField destField = new JTextField(15);
        JButton findPathButton = new JButton("Find Path");

        inputPanel.add(srcLabel);
        inputPanel.add(srcField);
        inputPanel.add(destLabel);
        inputPanel.add(destField);
        inputPanel.add(findPathButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Text area to show the result
        JTextArea resultArea = new JTextArea(10, 40);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Use a monospaced font for better readability
        resultArea.setLineWrap(true); // Allows text to wrap
        resultArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(resultArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button action listener to calculate and display the shortest path
        findPathButton.addActionListener(e -> {
            String src = srcField.getText();
            String dest = destField.getText();

            // Run Dijkstra's algorithm to find the shortest path
            Map<String, String> previous = new HashMap<>(); // To store previous stations for path reconstruction
            Map<String, Integer> distances = MetroNetwork.dijkstra(src, previous);

            // Get the shortest path from source to destination
            List<String> path = MetroNetwork.getPath(previous, dest);

            // Output the results in the text area
            if (path.isEmpty()) {
                resultArea.setText("No path found between " + src + " and " + dest);
            } else {
                StringBuilder pathResult = new StringBuilder();
                pathResult.append("Shortest path from ").append(src).append(" to ").append(dest).append(":\n");
                
                // Display each station on a new line
                for (String station : path) {
                    pathResult.append(station).append("\n");
                }
                pathResult.append("\nShortest distance: ").append(distances.get(dest));
                resultArea.setText(pathResult.toString());
            }
        });

        // Display the frame
        frame.setVisible(true);
    

    }
    
}
