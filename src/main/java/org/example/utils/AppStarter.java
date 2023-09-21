package org.example.utils;

import org.example.controller.AppController;
import org.example.controller.AppControllerUpdate;
import org.example.service.AppService;
import org.example.view.AppView;
import org.example.view.AppViewUpdate;

public class AppStarter {
    public static void startApp(){
        AppService service = new AppService();
        AppViewUpdate viewUp = new AppViewUpdate();
        AppView view = new AppView();
        AppControllerUpdate appControllerUpdate = new AppControllerUpdate(viewUp, service);
        AppController controller = new AppController(view, service);
        controller.runApp();
        appControllerUpdate.runApp();


    }
}
