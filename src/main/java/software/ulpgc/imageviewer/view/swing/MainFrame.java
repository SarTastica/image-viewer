package software.ulpgc.imageviewer.view.swing;

import software.ulpgc.imageviewer.control.Command; // Importa tu nueva interfaz
import software.ulpgc.imageviewer.view.ImageDisplay;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final ImageDisplay imageDisplay;
    private final Map<String, Command> commands = new HashMap<>(); // Mapa para guardar comandos

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

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    private Component createToolBar() {
        JPanel panel = new JPanel();
        JButton prev = new JButton("<");
        JButton next = new JButton(">");

        prev.addActionListener(e -> {
            if (commands.containsKey("prev")) commands.get("prev").execute();
        });
        next.addActionListener(e -> {
            if (commands.containsKey("next")) commands.get("next").execute();
        });

        panel.add(prev);
        panel.add(next);
        return panel;
    }
}