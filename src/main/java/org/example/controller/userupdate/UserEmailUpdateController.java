package org.example.controller.userupdate;

import org.example.service.userupdate.UserEmailUpdateService;
import org.example.utils.AppStarter;
import org.example.view.userupdate.UserUpdateEmailView;

public class UserEmailUpdateController {
    UserEmailUpdateService service;

    UserUpdateEmailView view;


    public UserEmailUpdateController(UserUpdateEmailView view, UserEmailUpdateService service ){
        this.view = view;
        this.service = service;
    }
    public void updateContact() {

        view.getOutput(service.updateContact(view.getData()));
        AppStarter.startApp();
    }
}
