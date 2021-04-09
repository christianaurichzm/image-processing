package br.com.christian.imagefilters.view;

import java.util.Scanner;

import br.com.christian.imagefilters.controller.filter.GrayscaleFilter;
import br.com.christian.imagefilters.controller.filter.ImageFilter;
import br.com.christian.imagefilters.controller.filter.ImageFilterController;
import br.com.christian.imagefilters.controller.filter.NegativeFilter;

public class FilterMenuView {
    private Scanner sc;
    private ImageFilter imageFilter;

    public FilterMenuView() {
        sc = new Scanner(System.in);
    }

    public void menuScreen() {
        int option = 0;
        String filename = null;
        System.out.println("What is the name of the file you want to apply a filter to?");
        filename = sc.nextLine();
        System.out.println("Which filter do you want to apply?");
        System.out.println("1 - Negative");
        System.out.println("2 - Greyscale");
        option = sc.nextInt();
        switch (option) {
            case 1:
                this.imageFilter = new NegativeFilter();
                ImageFilterController.getInstance().applyFilter(imageFilter, filename);
                break;
            case 2:
                this.imageFilter = new GrayscaleFilter();
                ImageFilterController.getInstance().applyFilter(imageFilter, filename);
                break;
        }
    }

}
