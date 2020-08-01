package Caesar;

import java.util.Scanner;

public class Validate {
    private int keyValue;

    Scanner input = new Scanner(System.in);

    public int validateKey(String keyText) {
        boolean checkNumeric = isNumeric(keyText);

        while (!checkNumeric) {
            System.out.println("Please enter a valid key (Natural number): ");
            keyText = input.nextLine();
            keyValue = validateKey(keyText);
        }
        this.keyValue = Integer.parseInt(keyText);
        return keyValue;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            int n = Integer.parseInt(strNum);
            if (n < 1) {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }
}
