package org.example.controller;

import org.example.service.userupdate.UserEmailUpdateService;
import org.example.view.AppViewUpdate;

public class UserUpdateController {
    UserEmailUpdateService service;


    AppViewUpdate viewUpd;

    public UserUpdateController(AppViewUpdate viewUpd ){
        this.viewUpd = viewUpd;

    }
    public void updateMenu(){
        viewUpd.chooseOptionUp();
    }

}