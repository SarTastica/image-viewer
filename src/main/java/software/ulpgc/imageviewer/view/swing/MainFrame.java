package software.ulpgc.imageviewer.view.swing;

import software.ulpgc.imageviewer.view.ImageDisplay;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image Viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        SwingImageDisplay display = new SwingImageDisplay();

        this.imageDisplay = display;
        this.add(display, BorderLayout.CENTER);
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }

    private Component createToolBar() {
        JPanel panel = new JPanel();

        JButton prev = new JButton("<");
        JButton next = new JButton(">");

        prev.addActionListener(e -> imageDisplay.on(ImageDisplay.Shift.Left));
        next.addActionListener(e -> imageDisplay.on(ImageDisplay.Shift.Right));

        panel.add(prev);
        panel.add(next);
        return panel;
    }
}
