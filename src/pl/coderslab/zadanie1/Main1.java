package pl.coderslab.zadanie1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        guessNumber();

    }

    static void guessNumber() {

        Random random = new Random();

        int losowanie = random.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zgadnij liczbę: ");


        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba.");
                scanner.next();
            }

            int odczyt = scanner.nextInt();
            System.out.println("odczyt: " + odczyt);


            if (odczyt < losowanie) {
                System.out.println("Za mało!");
            } else if (odczyt > losowanie) {
                System.out.println("Za dużo");
            }
            scanner.nextLine();

            if (odczyt == losowanie) {
                System.out.println("Zgadłeś");
                break;
            }
        }
    }
}
