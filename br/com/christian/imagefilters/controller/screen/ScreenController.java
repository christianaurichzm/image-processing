package br.com.christian.imagefilters.controller.screen;

import br.com.christian.imagefilters.view.FilterMenuView;

public class ScreenController {
    private static ScreenController screenController;

    public static ScreenController getInstance() {
        if (screenController == null) {
            screenController = new ScreenController();
        }
        return screenController;
    }

    public void openFilterMenuScreen() {
        FilterMenuView filterMenuView = new FilterMenuView();
        filterMenuView.menuScreen();
    }
}
