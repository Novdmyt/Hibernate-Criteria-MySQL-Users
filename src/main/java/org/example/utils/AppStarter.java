package org.example.utils;

import org.example.view.AppView;

public class AppStarter {
    public static void startApp(){
        AppService service = new AppService();
        AppViewUpd viewUp = new AppViewUpd();
        AppView view = new AppView();
        AppControllerUpdate appControllerUpdate = new AppControllerUpdate(viewUp, service);
        AppController controller = new AppController(view, service);
        controller.runApp();
        appControllerUpdate.runApp();


    }
}
