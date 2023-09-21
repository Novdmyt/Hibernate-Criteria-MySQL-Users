package org.example.view;

import org.example.utils.AppStarter;
import org.example.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppViewUpdate {
    Scanner scanner;
    int option;

    public int chooseOptionUp() {
        scanner = new Scanner(System.in);
        showMenuUp();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.startApp();
        }
        return option;
    }
    public  void showMenuUp(){
        System.out.println("""
                ______Update Menu______
                1 - Rename Last name.
                2 - Restore Email.
                0 - Close the App.
             """);
    }
    public void getOutput2(int choice, String output) {
        if (choice == 0) System.out.println(output);
        scanner.close();
        System.exit(0);
    }
}