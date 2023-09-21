package org.example.view;

import java.util.Scanner;

public class UserDeleteView {
    public String[] getDeleteData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Enter user ID: ";
        System.out.print(title);
        String id = scanner.nextLine().trim();
        return new String[]{id};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
