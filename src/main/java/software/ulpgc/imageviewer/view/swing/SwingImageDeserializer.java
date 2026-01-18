package software.ulpgc.imageviewer.view.swing;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SwingImageDeserializer {
    private final Map<String, BufferedImage> cache = new HashMap<>();

    public BufferedImage deserialize(byte[] bytes) {
        String key = String.valueOf(java.util.Arrays.hashCode(bytes));

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));

            if (image != null) {
                cache.put(key, image);
            }
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}