package org.example.controller.userupdate;

import org.example.service.userupdate.UserLastNameUpdateService;
import org.example.utils.AppStarter;
import org.example.view.userupdate.UserUpdateLastNameView;

public class UserLastNameController {
    UserLastNameUpdateService service;

    UserUpdateLastNameView view;


    public UserLastNameController(UserLastNameUpdateService service, UserUpdateLastNameView view ){
        this.service =service;
        this.view = view;
    }

    public void updateContact() {
        view.getOutput(service.updateContact(view.getDataLastName()));
        AppStarter.startApp();
    }
}
