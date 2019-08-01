package allDictionary;

import java.util.Scanner;

class UserInput {
    protected String input() {
        Scanner input = new Scanner(System.in);
        String word = input.nextLine();
        return word;
    }
}

