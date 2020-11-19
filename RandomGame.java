package ee.bcs.valiiit;

import java.util.Scanner;

public class RandomGame {

    public static void main(String[] args) {

        double randomNumber = Math.random() * 100;
        int randInt = (int) randomNumber;
        int count = 1;

        System.out.println("Guess a number between 1 and 100. You have 10 guesses.\n");

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Guess #" + count + ": ");
        int guess = scanner.nextInt();
        while (count <= 10) {
            if (guess == randInt) {
                System.out.printf("You guessed the number " + randInt + " !");
            } else if (guess>randInt){
                System.out.printf("Your number is too high! Guess again!");
            }
        }


    }

}
