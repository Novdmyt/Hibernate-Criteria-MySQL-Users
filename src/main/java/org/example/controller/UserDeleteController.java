package org.example.controller;

import org.example.service.UserDeleteService;
import org.example.utils.AppStarter;
import org.example.view.UserDeleteView;

public class UserDeleteController {
    UserDeleteService service;
    UserDeleteView view;
    public UserDeleteController(UserDeleteService service, UserDeleteView view){
        this.service = service;
        this.view = view;
    }
    public void deleteUser() {
        view.getOutput(service.deleteUser(view.getDeleteData()));
        AppStarter.startApp();
    }
}
