package pl.coderslab.zadanie2;

import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        try {
            lottoSimulator();
        } catch (InputMismatchException e) {
            System.out.println("Wrong value");
            e.printStackTrace();
        }
    }

    static void lottoSimulator() throws InputMismatchException {

        Integer[] arr = new Integer[49];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Collections.shuffle(Arrays.asList(arr));

        Integer[] wylosowaneLiczby = Arrays.copyOfRange(arr, 0, 6);
        System.out.println("Wylosowane liczby: " + Arrays.toString(wylosowaneLiczby));

        Scanner scanner = new Scanner(System.in);

        int number = 0;
        int[] userNumbers = new int[6];
        System.out.println("Wytypuj 6 liczb z zakresu 1-49");

        for (int i = 0; i < userNumbers.length; i++) {
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("To nie liczba!");
                    scanner.next();
                }
                number = scanner.nextInt();
                System.out.println("Podaj liczbę od 1 do 49");
            } while (number < 1 || number > 49 || number == userNumbers[i]);
            userNumbers[i] = number;
        }

        System.out.println("Wytypowane liczby: " + Arrays.toString(userNumbers));


        int duplicateCount = 0;
        for (
                int i = 0;
                i < wylosowaneLiczby.length; i++) {
            for (int j = 0; j < userNumbers.length; j++) {

                if (arr[i] == userNumbers[j]) {
                    System.out.println("arr[" + i + "]" + " = " + arr[i]);
                    System.out.println("userNumbers[" + j + "]" + " = " + userNumbers[j]);
                    duplicateCount++;
                    System.out.println(duplicateCount);
                }
            }
        }
        System.out.println("Ilość trafień: " + duplicateCount);

        switch (duplicateCount) {
            case 3:
                System.out.println("Trafiłeś trójkę");
                break;
            case 4:
                System.out.println("Trafiłeś czwórkę");
                break;
            case 5:
                System.out.println("Trafiłeś piątkę");
                break;
            case 6:
                System.out.println("Trafiłeś szóstkę!!!");
                break;

            default:
                System.out.println("Brak wygranej");
                break;
        }
        scanner.close();
    }
}
