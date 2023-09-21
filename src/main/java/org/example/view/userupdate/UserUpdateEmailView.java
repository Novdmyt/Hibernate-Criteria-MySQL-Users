package org.example.view.userupdate;

import java.util.Scanner;

public class UserUpdateEmailView {
    public String[] getData() {

        Scanner scanner = new Scanner(System.in);

        String title = "Enter user ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();

        title = "User email: ";
        System.out.print(title);
        String user = scanner.nextLine().trim();

        return new String[]{id, user};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}