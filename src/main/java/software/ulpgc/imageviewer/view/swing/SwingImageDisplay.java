package software.ulpgc.imageviewer.view.swing;

import software.ulpgc.imageviewer.view.ImageDisplay;
import software.ulpgc.imageviewer.model.Image;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;
    private Shift shift = Shift.Null;

    public SwingImageDisplay() {
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        if (currentImage != null) {
            g.drawString(currentImage.name(), 100, 100);
        }
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }

    @Override
    public String image() {
        return currentImage.name();
    }
    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }
}