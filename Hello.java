
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        //Hello, Name!
        Scanner inputs = new Scanner(System.in);

        System.out.println("Please enter your name: ");

        String name = inputs.nextLine();
        System.out.println("Hello, " + name + "!");

    }
}
