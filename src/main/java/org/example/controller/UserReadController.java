package org.example.controller;

import org.example.service.UserReadService;
import org.example.utils.AppStarter;
import org.example.view.UserReadView;

public class UserReadController {
    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view){
        this.service = service;
        this.view = view;
    }
    public void readUser() {
        view.getOutput(service.readUser());
        AppStarter.startApp();
    }
}
