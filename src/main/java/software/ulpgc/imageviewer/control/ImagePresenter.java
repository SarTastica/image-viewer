package software.ulpgc.imageviewer.control;

import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.view.ImageDisplay;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
        this.display.on(offset -> {
            if (offset > 0) image = image.next();
            else image = image.prev();
            display.show(image);
        });
    }

    public void show(Image image) {
        this.image = image;
        this.display.show(image);
    }
}
