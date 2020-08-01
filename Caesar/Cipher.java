package Caesar;

import java.util.Scanner;

public class Cipher {
    private int key;
    private char textArray[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private String plainText;
    private String cipherText;

    Scanner input = new Scanner(System.in);
    Validate validate = new Validate();

    public void getKey() {
        System.out.println("Please enter a valid key (Natural number): ");
        String keyText = input.nextLine();
        this.key = validate.validateKey(keyText);
    }

    public void getPlainText() {
        System.out.println("please enter the text that needs enciphering: ");
        this.plainText = input.nextLine();
    }

    public void encipher() {
        char text[] = this.plainText.toCharArray();
        char returnText[] = new char[text.length];
        int returnArrayIndex;

        for (int i=0; i<text.length; i++) {
            if ((text[i]>='a' && text[i]<='z') || (text[i]>='A' && text[i]<='Z')) {
                returnText[i] = getIndex(text[i]);
            } else {
                returnText[i] = text[i];
            }
        }
        cipherText = new String(returnText);
    }

    public void printCipherText() {
        System.out.println("The Cipher-text of the plain-text input is: " + this.cipherText);
    }

    public char getIndex(char alp) {
        if (alp>='a' && alp<='z') {
            alp = Character.toUpperCase(alp);
            alp = cipherFormula(alp);
            alp = Character.toLowerCase(alp);
        } else {
            alp = cipherFormula(alp);
        }
        return alp;
    }

    public char cipherFormula(char alp) {
        boolean isValid = false;
            for (int i = 0; i < 26; i++) {
                if ((alp == textArray[i]) && !isValid) {
                    int index = (i + this.key) % 26;
                    alp = textArray[index];
                    isValid = true;
                }
                else if (isValid) {
                    break;
                }
            }
        return alp;
    }

}
