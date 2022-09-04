import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CS1400HW1 {
    public static void main(String[] args) {
        int max = 100, min = 1, guess, command, lie = 0;
        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        guess = rand.nextInt(100); // Generates a random number
        System.out.println("Please think of a number between 1 and 100.");
        System.out.println("Is the number " + guess + "?");
        System.out.println("If more than the guessed number please type in 1 and press enter.");
        System.out.println("If less than the guessed number please type in -1 and press enter");
        System.out.println("If my guess was correct please type in 0 and press enter"); // comment
        command = keyboard.nextInt();
        while (command != 0) {
            if (command == 1) {
                min = guess + 1; // updates boundary (+1) to make sure boundary cannot be guessed
            }
            if (command == -1) {
                max = guess - 1; // updates boundary (-1) to make sure boundary cannot be guessed
            }
            if ((max - min) < 1) // to detect lies or mistakes
            {
                command = 0;
                lie = 1;
                System.out.println("You have made a mistake, or YOU'RE LYING↓↓↓");
            }
            guess = ThreadLocalRandom.current().nextInt(min, max + 1); // new random number generated through updated
                                                                       // "guess"
            System.out.print("Is the number " + guess + "?\n");
            command = keyboard.nextInt();
        }
        if (lie == 0) {
            System.out.println("Haha that was easy.");
        }
    }
}
