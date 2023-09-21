package org.example.view.userupdate;

import java.util.Scanner;

public class UserUpdateLastNameView {
    public String[] getDataLastName() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "Last Name: ";
        System.out.print(title);
        String lastName = scanner.nextLine().trim();

        return new String[]{id, lastName};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}