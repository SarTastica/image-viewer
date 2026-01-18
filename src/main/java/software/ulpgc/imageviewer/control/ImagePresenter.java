package software.ulpgc.imageviewer.control;

import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.view.ImageDisplay;

public class ImagePresenter {
    private final ImageDisplay display;
    private Image currentImage;

    public ImagePresenter(ImageDisplay display) {
        this.display = display;
    }

    public void show(Image image) {
        this.currentImage = image;
        this.display.show(image);
    }

    public void next() {
        if (currentImage != null) {
            show(currentImage.next());
        }
    }

    public void prev() {
        if (currentImage != null) {
            show(currentImage.prev());
        }
    }
}
