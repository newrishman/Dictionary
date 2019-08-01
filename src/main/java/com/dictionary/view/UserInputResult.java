package com.dictionary.view;

import java.util.Scanner;


public class UserInputResult {
    public String[] inputs() {
        Scanner input = new Scanner(System.in);
        String[] userInput = input.nextLine().split("\\s");
        return userInput;
    }
}
