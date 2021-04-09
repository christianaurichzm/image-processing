package br.com.christian.imagefilters.controller.storage;

import br.com.christian.imagefilters.utils.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageStorage {
    private static ImageStorage imageStorage;
    private final String IMAGE_DIRECTORY_PATH = "br/com/christian/imagefilters/images/";
    private BufferedImage img = null;
    private File f = null;
    private Path path;

    public static ImageStorage getInstance() {
        if (imageStorage == null) {
            imageStorage = new ImageStorage();
        }
        return imageStorage;
    }

    public BufferedImage loadImage(String filename) {
        this.path = Paths.get(IMAGE_DIRECTORY_PATH + filename);
        try {
            this.f = new File(this.path.toString());
            this.img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public void saveImage(BufferedImage image) {
        try {
            String fileFormat = FilenameUtils.getFileFormat(this.path.getFileName().toString());
            String filenameWithoutFormat = this.path.getFileName().toString().replace(fileFormat, "");
            this.f = new File(IMAGE_DIRECTORY_PATH + filenameWithoutFormat + "-filtered." + fileFormat);
            this.img = image;
            ImageIO.write(this.img, fileFormat, this.f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
