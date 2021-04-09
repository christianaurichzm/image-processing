package br.com.christian.imagefilters.utils;

public class FilenameUtils {

    public static String getFileFormat(String filename) {
        String format = null;
        int index = filename.lastIndexOf('.');
        if (index > 0) {
            format = filename.substring(index + 1);
        }
        return format;
    }
}
