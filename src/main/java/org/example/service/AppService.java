package org.example.service;

import org.example.controller.UserCreateController;
import org.example.controller.UserDeleteController;
import org.example.controller.UserReadController;
import org.example.controller.UserUpdateController;
import org.example.controller.userupdate.UserEmailUpdateController;
import org.example.controller.userupdate.UserLastNameController;
import org.example.exaptions.OptionException;
import org.example.repository.UserCreateRepository;
import org.example.repository.UserDeleteRepository;
import org.example.repository.UserReadRepository;
import org.example.repository.userupdate.UserEmailUpdateRepository;
import org.example.repository.userupdate.UserLastNameUpdateRepository;
import org.example.service.userupdate.UserEmailUpdateService;
import org.example.service.userupdate.UserLastNameUpdateService;
import org.example.utils.AppStarter;
import org.example.utils.Constants;
import org.example.view.AppViewUpdate;
import org.example.view.UserCreateView;
import org.example.view.UserDeleteView;
import org.example.view.UserReadView;
import org.example.view.userupdate.UserUpdateEmailView;
import org.example.view.userupdate.UserUpdateLastNameView;

public class AppService {
    public void createUser() {
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service, view);
        controller.createUser();
    }

    public void readUser() {
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service, view);
        controller.readUser();
    }

    public void updateEmail() {
        UserEmailUpdateRepository repository = new UserEmailUpdateRepository();
        UserEmailUpdateService service = new UserEmailUpdateService(repository);
        UserUpdateEmailView view = new UserUpdateEmailView();
        UserEmailUpdateController controller = new UserEmailUpdateController( view,service);
        controller.updateContact();
    }

    public void updateLastName(){
        UserLastNameUpdateRepository repository = new UserLastNameUpdateRepository();
        UserLastNameUpdateService service = new UserLastNameUpdateService(repository);
        UserUpdateLastNameView view = new UserUpdateLastNameView();
        UserLastNameController controller2 = new UserLastNameController( service,view);
        controller2.updateContact();
    }
    public void updateMenu(){
        AppViewUpdate viewUpd = new AppViewUpdate();
        UserUpdateController controller = new UserUpdateController( viewUpd);
        controller.updateMenu();
    }

    public void deleteUser() {
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service, view);
        controller.deleteUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }
    public void getNoSuchOptionUp(int choice) {
        int[] menuChoices = {0, 1, 2};
        if (!contains(menuChoices, choice)) {
            try {
                throw new OptionException(Constants.INCORRECT_VALUE_MSG);
            } catch (OptionException e) {
                System.out.println(e.getMessage());
                AppStarter.startApp();
            }
        }
    }

    // Проверка наличия ввода в массиве выбора
    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
