package PrakashLabs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Credit

        Credit newCard = new Credit();

        newCard.getCardNo();
        newCard.cardValidation();
        String cardType = newCard.getCardType();

        System.out.println("Your Card is: " + cardType);
    }
}