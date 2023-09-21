package org.example.controller;

import org.example.service.AppService;
import org.example.utils.AppStarter;
import org.example.utils.Constants;
import org.example.view.AppViewUpdate;

public class AppControllerUpdate {
    AppViewUpdate view;
    AppService service;

    public AppControllerUpdate(AppViewUpdate view, AppService service) {
        this.view = view;
        this.service = service;
    }

    public void runApp() {
        filterChoice(view.chooseOptionUp());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.updateLastName();
            case 2 -> service.updateEmail();
            case 3 -> AppStarter.startApp();
            case 0 ->view.getOutPut(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOptionUp(choice);
        }

    }
}
