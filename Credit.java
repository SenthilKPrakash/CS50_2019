package PrakashLabs;

import java.util.Scanner;

public class Credit {
    private long cardNo;
    private boolean isValid = false;
    private String cardType;

    public void getCardNo() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Please enter your Credit card number: ");
        this.cardNo = inputs.nextLong();
    }

    public void cardValidation() {
        int sum = sumOfAlternateNo();
        sum = sumOfOtherAlternates(sum);

        if (sum % 10 == 0) {
            checkCardType();
        }
        else {
            this.isValid = false;
            this.cardType = "INVALID";
        }
    }

    public String getCardType() {
        return this.cardType;
    }

    public int sumOfAlternateNo() {
        long copy = cardNo/10;
        int last;
        int sum = 0;

        //Sum of all alternate numbers from last but one
        while (copy > 0) {
            last = (int)(copy % 10);
            last *= 2;
            if (last > 9) {
                int temp = last % 10;
                last /= 10;
                last += temp;
            }
            sum += last;

            copy /= 100;
        }
        return sum;
    }

    public int sumOfOtherAlternates(int sum) {
        long copy = cardNo;
        int last;

        //Add other alternative numbers to the sum
        while (copy > 0) {
            last = (int)(copy % 10);
            sum += last;
            copy /= 100;
        }
        return sum;
    }

    public void checkCardType() {
        long cardNo = this.cardNo;
        String cardVal = String.valueOf(cardNo);
        int cardLength = cardVal.length();

        Boolean isAmex = (cardLength == 15 && (cardVal.startsWith("34") || cardVal.startsWith("37")));
        Boolean isMaster = (cardLength == 16 &&
                (cardVal.startsWith("51") || cardVal.startsWith("52")
                        || cardVal.startsWith("53") || cardVal.startsWith("54")
                        || cardVal.startsWith("55")));
        Boolean isVisa = ((cardLength == 13 || cardLength == 16) && cardVal.startsWith("4"));

        if (isAmex) {
            this.isValid = true;
            this.cardType = "AMEX";
        } else if (isMaster) {
            this.isValid = true;
            this.cardType = "MASTERCARD";
        } else if (isVisa) {
            this.isValid = true;
            this.cardType = "VISA";
        } else {
            this.isValid = false;
            this.cardType = "INVALID";
        }
    }

}
