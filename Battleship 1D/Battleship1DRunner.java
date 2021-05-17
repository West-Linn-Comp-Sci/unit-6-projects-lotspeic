import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship1DRunner {

    private Scanner scanner;
    private int guesses;
    private Battleship1D game;

    public static void main(String args[]) {
        Battleship1DRunner runner = new Battleship1DRunner();
        runner.run();
    }

    public Battleship1DRunner() {
        scanner = new Scanner(System.in);
        guesses = 0;
        game = new Battleship1D();
    }

    public void run() {
        while(true) {
            int input = getUserInput();
            if(game.shootTile(input)) System.out.println("Hit!");
            else System.out.println("Miss...");
            guesses++;
            if(game.isShipSunk()) {
                System.out.println("You sunk the battleship!");
                break;
            }
        }
        System.out.println(String.format("\nGuesses: %s.\nRating: %s\n\nThanks for playing!", guesses, getUserRating()));
    }

    private int getUserInput() {
        while(true) {
            System.out.print("Please enter a tile # between 1 and 7: ");
            try {
                int val = scanner.nextInt();
                if(val > 0 && val < 8) {
                    if(game.canShootTile(val - 1)) return val - 1;
                    System.out.println("You've already shot that tile!");
                }
                System.out.println("Invalid input! Only integers within the range [1, 7] are accepted.");
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input! Only integers are accepted.");
            }
        }
    }

    private String getUserRating() {
        switch(guesses) {
            case 3: return "Amazing!";
            case 4: return "Good!";
            case 5: return "OK.";
            case 6: return "Suboptimal.";
            case 7: return "Better luck next time...";
        }
        return "Error.";
    }

}