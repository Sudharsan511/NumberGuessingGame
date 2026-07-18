import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        char playAgain = 'Y';

        System.out.println("========================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("========================================");

        while (playAgain == 'Y') {

            int maxNumber = 100;
            int attempts = 7;

            System.out.println("\nSelect Difficulty");
            System.out.println("1. Easy (1 - 50)");
            System.out.println("2. Medium (1 - 100)");
            System.out.println("3. Hard (1 - 200)");

            int choice;

            while (true) {
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 3) {
                        break;
                    }

                    System.out.println("Please choose between 1 and 3.");

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Enter a number.");
                    scanner.nextLine();
                }
            }

            switch (choice) {

                case 1:
                    maxNumber = 50;
                    attempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    attempts = 7;
                    break;

                case 3:
                    maxNumber = 200;
                    attempts = 5;
                    break;

            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            boolean guessed = false;

            System.out.println("\nI have selected a number between 1 and " + maxNumber);
            System.out.println("You have " + attempts + " attempts.\n");

            for (int i = 1; i <= attempts; i++) {

                int guess;

                while (true) {

                    try {

                        System.out.print("Attempt " + i + ": ");

                        guess = scanner.nextInt();

                        if (guess < 1 || guess > maxNumber) {
                            System.out.println("Enter a number between 1 and " + maxNumber);
                            continue;
                        }

                        break;

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid input!");

                        scanner.nextLine();

                    }

                }

                if (guess == secretNumber) {

                    guessed = true;

                    int score = (attempts - i + 1) * 10;

                    System.out.println("\nCongratulations!");
                    System.out.println("You guessed the correct number.");

                    System.out.println("Attempts Used : " + i);
                    System.out.println("Score         : " + score);

                    break;

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Too High!");

                }

            }

            if (!guessed) {

                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + secretNumber);

            }

            System.out.print("\nDo you want to play again? (Y/N): ");

            playAgain = scanner.next().toUpperCase().charAt(0);

        }

        System.out.println("\n========================================");
        System.out.println("Thanks for playing!");
        System.out.println("========================================");

        scanner.close();

    }
}