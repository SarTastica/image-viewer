package software.ulpgc.imageviewer.view.swing;

import software.ulpgc.imageviewer.view.ImageDisplay;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final ImageDisplay imageDisplay;
    private final SwingImageDisplay swingDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.swingDisplay = new SwingImageDisplay();
        this.imageDisplay = swingDisplay;

        this.add(swingDisplay, BorderLayout.CENTER);
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }

    private Component createToolBar() {
        JPanel panel = new JPanel();

        JButton prev = new JButton("<");
        JButton next = new JButton(">");

        prev.addActionListener(e -> swingDisplay.executeShift(-1));
        next.addActionListener(e -> swingDisplay.executeShift(1));

        panel.add(prev);
        panel.add(next);
        return panel;
    }
}