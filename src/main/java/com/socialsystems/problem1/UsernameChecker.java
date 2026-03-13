package com.socialsystems.problem1;

import java.util.Scanner;

public class UsernameChecker {
    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        UsernameChecker checker = new UsernameChecker();
        System.out.println("Valid? " + checker.isValidUsername(username));
    }
}