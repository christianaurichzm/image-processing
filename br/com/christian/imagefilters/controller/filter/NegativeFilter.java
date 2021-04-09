package br.com.christian.imagefilters.controller.filter;

public class NegativeFilter implements ImageFilter {
	
	@Override
	public int filterRGB(int x, int y, int rgb) {
        int a = (rgb>>24)&0xff;
        int r = (rgb>>16)&0xff;
        int g = (rgb>>8)&0xff;
        int b = rgb&0xff;

        r = 0xff - r;
        g = 0xff - g;
        b = 0xff - b;

        return (a<<24) | (r<<16) | (g<<8) | b;
	}
}