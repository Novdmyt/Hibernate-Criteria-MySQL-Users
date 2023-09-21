package org.example.controller;

import org.example.service.UserCreateService;
import org.example.utils.AppStarter;
import org.example.view.UserCreateView;

public class UserCreateController {
    UserCreateService service;
    UserCreateView view;

    public UserCreateController(UserCreateService service, UserCreateView view){
        this.service = service;
        this.view = view;
    }

    public void createUser() {
        view.getOutput(service.userContact(view.getData()));
        AppStarter.startApp();
    }
}
