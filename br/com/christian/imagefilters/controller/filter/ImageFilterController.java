package br.com.christian.imagefilters.controller.filter;

import br.com.christian.imagefilters.controller.storage.ImageStorage;

import java.awt.image.BufferedImage;

public class ImageFilterController {
    private static ImageFilterController imageFilterController;
    private final ImageStorage imageStorage = ImageStorage.getInstance();

    public static ImageFilterController getInstance() {
        if (imageFilterController == null) {
            imageFilterController = new ImageFilterController();
        }
        return imageFilterController;
    }

    public void applyFilter(ImageFilter imageFilter, String filename) {
        BufferedImage image = imageStorage.loadImage(filename);
        int width = image.getWidth();
        int height = image.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);
                image.setRGB(x, y, imageFilter.filterRGB(x, y, p));
            }
        }
        this.imageStorage.saveImage(image);
    }
}
