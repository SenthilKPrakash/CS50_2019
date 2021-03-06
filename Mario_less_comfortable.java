import java.util.Scanner;

public class Mario_less_comfortable {
    public static void main(String[] args) {
        //Mario Pyramids

        int height = getHeight();

        //Make Pyramid
        printPyramid(height, "#");
    }

    public static int getHeight() {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Enter a valid number between 1 & 8: ");
        int height = inputs.nextInt();

        while (height<1 || height>8) {
            height =  getHeight();
        }
        inputs.close();
        return height;
    }

    public static void printPyramid(int height, String hash) {

        for (int i = 1; i < height; i++) {
            System.out.print(" ");
        }

        if (height > 0) {
            System.out.println(hash);
            hash += "#";
            printPyramid(height-1, hash);
        }

    }
}
