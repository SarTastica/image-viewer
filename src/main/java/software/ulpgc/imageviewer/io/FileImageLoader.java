package software.ulpgc.imageviewer.io;

import software.ulpgc.imageviewer.model.Image;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Set;

public class FileImageLoader implements ImageLoader {
    private final File[] files;

    public FileImageLoader(File folder) {
        this.files = folder.listFiles(isImage());
    }

    private static FilenameFilter isImage() {
        return (dir, name) -> Set.of("jpg", "png", "jpeg").stream()
                .anyMatch(extension -> name.toLowerCase().endsWith(extension));
    }

    @Override
    public Image load() {
        if (files == null || files.length == 0){
            return null;
        }
        return imageAt(0);
    }

    private Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return files[i].getName();
            }

            @Override
            public byte[] content() {
                try {
                    return Files.readAllBytes(files[i].toPath());
                } catch (IOException e) {
                    return new byte[0];
                }
            }

            @Override
            public Image next() {
                return imageAt((i + 1) % files.length);
            }

            @Override
            public Image prev() {
                return imageAt((i - 1 + files.length) % files.length);
            }
        };
    }
}
