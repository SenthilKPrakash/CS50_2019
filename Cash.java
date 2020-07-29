import java.util.Scanner;

public class Cash {
    public static void main(String[] args) {
        //Cash - change owed
        int changeOwed = (int)getChange();
        printCentDetails(changeOwed);

    }

    public static float getChange() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Change Owed: ");
        float changeOwed = inputs.nextFloat();

        while (changeOwed<0) {
            changeOwed = getChange();
        }

        return (Math.round(changeOwed * 100));
    }

    public static void printCentDetails(int change) {
        int[] cents = { 1, 5, 10, 25 };
        int noOfCoins = 0;
        int i = 3;

        System.out.println("Cents: ");

        while (change > 0 && i >= 0) {
            if (change >= cents[i]) {
                change = change - cents[i];
                noOfCoins++;
                System.out.println("  " + cents[i] + " cents.");
            }
            else i--;
        }

        System.out.println("No of coins: " + noOfCoins);
    }

}
