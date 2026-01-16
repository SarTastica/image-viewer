package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.control.ImagePresenter;
import software.ulpgc.imageviewer.io.FileImageLoader;
import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.view.swing.MainFrame;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String rootPath = "C:\\Users\\madan\\OneDrive\\Escritorio\\image-viewer";

        File folder = new File(rootPath);

        if (!folder.exists()) {
            System.err.println("Error: La carpeta no existe en la ruta indicada: " + rootPath);
            return;
        }

        FileImageLoader loader = new FileImageLoader(folder);
        Image image = loader.load();

        if (image == null) {
            System.err.println("Error: No se han encontrado imágenes .jpg o .png en la carpeta.");
            return;
        }

        MainFrame mainFrame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(mainFrame.imageDisplay());

        presenter.show(image);

        mainFrame.setVisible(true);
    }
}
