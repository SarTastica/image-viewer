package software.ulpgc.imageviewer;

import software.ulpgc.imageviewer.control.ImagePresenter;
import software.ulpgc.imageviewer.control.NextCommand;
import software.ulpgc.imageviewer.control.PreviousCommand;
import software.ulpgc.imageviewer.io.FileImageLoader;
import software.ulpgc.imageviewer.io.ImageLoader;
//import software.ulpgc.imageviewer.io.MockImageLoader; //descomentar si creo el MockImageLoader
import software.ulpgc.imageviewer.model.Image;
import software.ulpgc.imageviewer.view.swing.MainFrame;
import com.formdev.flatlaf.FlatLightLaf;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();

        String rootPath = args.length > 0 ? args[0] : "fotos";
        File folder = new File(rootPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Error: No encuentro la carpeta '" + rootPath + "'.");
            System.err.println("Asegúrate de crearla en la raíz del proyecto y poner imágenes dentro.");
            return;
        }

        ImageLoader loader = new FileImageLoader(folder);
        //ImageLoader loader = new MockImageLoader();
        Image image = loader.load();

        if (image == null) {
            System.err.println("Error: No se han encontrado imágenes válidas (.jpg, .png) en la carpeta '" + rootPath + "'.");
            return;
        }

        MainFrame mainFrame = new MainFrame();
        ImagePresenter presenter = new ImagePresenter(mainFrame.imageDisplay());

        mainFrame.add("prev", new PreviousCommand(presenter));
        mainFrame.add("next", new NextCommand(presenter));

        presenter.show(image);
        mainFrame.setVisible(true);
    }
}