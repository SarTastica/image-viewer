package software.ulpgc.imageviewer.io;

import software.ulpgc.imageviewer.model.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

public class MockImageLoader implements ImageLoader {
    private final String[] colorNames = {"Imagen de Prueba ROJA", "Imagen de Prueba VERDE", "Imagen de Prueba AZUL"};
    private final Color[] colors = {new Color(200, 50, 50), new Color(50, 200, 50), new Color(50, 50, 200)};

    @Override
    public Image load() {
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return colorNames[i];
            }

            @Override
            public byte[] content() {
                return generateImageBytes(colors[i], name());
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % colors.length);
            }

            @Override
            public Image prev() {
                return imageAt((i - 1 + colors.length) % colors.length);
            }
        };
    }

    private byte[] generateImageBytes(Color bgColor, String text) {
        try {
            BufferedImage img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = img.createGraphics();

            g.setColor(bgColor);
            g.fillRect(0, 0, 800, 600);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString(text, 150, 300);
            g.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", baos);
            return baos.toByteArray();
        } catch (Exception e) {
            return new byte[0];
        }
    }
}