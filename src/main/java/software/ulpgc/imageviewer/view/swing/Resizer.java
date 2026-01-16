package software.ulpgc.imageviewer.view.swing;

import java.awt.*;

public class Resizer {
    public Resizer() {
    }

    public Rectangle resize(int availableWidth, int availableHeight, int imageWidth, int imageHeight) {
        double widthRatio = (double) availableWidth / imageWidth;
        double heightRatio = (double) availableHeight / imageHeight;
        double scale = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (imageWidth * scale);
        int newHeight = (int) (imageHeight * scale);

        int x = (availableWidth - newWidth) / 2;
        int y = (availableHeight - newHeight) / 2;

        return new Rectangle(x, y, newWidth, newHeight);
    }
}
