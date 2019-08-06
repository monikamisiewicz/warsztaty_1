package pl.coderslab.zadanie3;

import java.util.Scanner;

public class Main3 {


    public static void main(String[] args) {

        guessNumber2();

    }

    static void guessNumber2() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w maksymalnie 10 próbach");

        int min = 0;
        int max = 1000;

        for(int i=0; i<10; i++) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję: " + guess);

            System.out.println("Podaj odpowiedź: 'za dużo', 'za mało', 'zgadłeś'");
            String answer = scanner.nextLine();
            System.out.println(answer);

            if ("zgadłeś".equalsIgnoreCase(answer)) {
                System.out.println("Wygrałem!");
                break;
            }

            if ("za dużo".equalsIgnoreCase(answer)) {
                max = guess;
                continue;
            }

            if ("za mało".equalsIgnoreCase(answer)) {
                min = guess;
                continue;
            } else {
                System.out.println("Nie oszukuj!");
            }

            System.out.println("Koniec gry");

        }
    }
}


