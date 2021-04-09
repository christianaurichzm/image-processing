package br.com.christian.imagefilters.controller.filter;

public class GrayscaleFilter implements ImageFilter {

    @Override
    public int filterRGB(int x, int y, int rgb) {
        int a = (rgb >> 24) & 0xff;
        int r = (rgb >> 16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;

        int avg = (r + g + b) / 3;
        return (a << 24) | (avg << 16) | (avg << 8) | avg;
    }
}