package software.ulpgc.imageviewer.view.swing;

import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;
    private BufferedImage bitmap;
    private Shift shift = Shift.Null;
    private final Resizer resizer = new Resizer();
    private final SwingImageDeserializer deserializer = new SwingImageDeserializer();

    public SwingImageDisplay() {
        this.setLayout(new BorderLayout());
    }

    @Override
    public void show(Image image) {
        this.currentImage = image;

        if (image != null) {
            this.bitmap = deserializer.deserialize(image.content());
        } else {
            this.bitmap = null;
        }

        this.repaint();
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        if (bitmap == null) return;

        Rectangle r = resizer.resize(this.getWidth(), this.getHeight(), bitmap.getWidth(), bitmap.getHeight());
        g.drawImage(bitmap, r.x, r.y, r.width, r.height, null);
    }

    @Override
    public String image() {
        return currentImage != null ? currentImage.name() : "";
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }

    public void executeShift(int offset) {
        this.shift.offset(offset);
    }
}