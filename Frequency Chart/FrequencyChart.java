import java.util.InputMismatchException;
import java.util.Scanner;

public class FrequencyChart {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome!\nYou may enter as many integers within the range [1, 100] as you wish.\nOnce you are finished, enter 0 to view your results.\n");
        int[] frequencies = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        while(true) {
            int input = promptForInt();
            if(input == 0) break;
            frequencies[getFrequencyIndex(input)]++;
        }
        System.out.println("\nFrequencies\n<--------->\n");
        for(int i = 0; i < 10; i++) {
            int lowerBound = (10 * i) + 1;
            int upperBound = 10 * (i + 1);
            String extraSpaces = "";
            if(i != 9) extraSpaces = " ";
            String frequency = new String(new char[frequencies[i]]).replace("\0", "*");
            System.out.printf("%s%s - %s %s| %s\n", i == 0 ? " " : "", lowerBound, upperBound, extraSpaces, frequency);
        }
    }

    private static int promptForInt() {
        while(true) {
            System.out.print("Input: ");
            try {
                int val = scanner.nextInt();
                if(val >= 0 && val <= 100) return val;
                System.out.println("Invalid input! Only integers within the range [1, 100] and 0 are accepted.");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input! Only integers are accepted.");
            }
        }
    }

    private static int getFrequencyIndex(int input) {
        int index = 0;
        while(input > 10) {
            index++;
            input -= 10;
        }
        return index;
    }
}
