package pl.coderslab.zadanie4;

import java.util.Arrays;
import java.util.Random;

public class Main4 {

    public static void main(String[] args) {

        int wynik = kostkaDoGry("3D10-5");
        System.out.println("Wynik: " + wynik);

    }

    static int kostkaDoGry(String kodKostki) {

        int result = 0;
        int iloscRzutow = 0;
        int rodzajKostki = 0;
        int moderator = 0;

        String[] daneWejsciowe = new String[3];
        daneWejsciowe = kodKostki.split("\\D");


        boolean czyJedenRzut = true;

        for (int i = 0; i < daneWejsciowe.length; i++) {
            if (kodKostki.startsWith("D")) {
                daneWejsciowe[0] = "1";
                iloscRzutow = Integer.parseInt(daneWejsciowe[0]);
                rodzajKostki = Integer.parseInt(daneWejsciowe[1]);
                if (daneWejsciowe.length == 2) {
                    moderator = 0;
                } else {
                    moderator = Integer.parseInt(daneWejsciowe[2]);
                }
                System.out.println(daneWejsciowe[i]);
            } else {
                iloscRzutow = Integer.parseInt(daneWejsciowe[0]);
                rodzajKostki = Integer.parseInt(daneWejsciowe[1]);
                if (daneWejsciowe.length == 2) {
                    moderator = 0;
                } else {
                    moderator = Integer.parseInt(daneWejsciowe[2]);
                }
            }
        }


        char[] znakiKodu = kodKostki.toCharArray();
        System.out.println(Arrays.toString(znakiKodu));
        for (int i = 0; i < znakiKodu.length; i++) {
            if (znakiKodu[i] == ('-')) {
                moderator *= -1;
            }
        }


        System.out.println("Wybrana kostka: D" + rodzajKostki);
        System.out.println("Ilość rzutów kostką: " + iloscRzutow);
        System.out.println("Wartość dodatkowa: " + moderator);


        Random random = new Random();
        int[] rzuty = new int[iloscRzutow];

        int suma = 0;
        for (int i = 0; i < rzuty.length; i++) {
            rzuty[i] = random.nextInt(rodzajKostki);
            rzuty[i] = rzuty[i] + 1;
            suma += rzuty[i];
        }
        System.out.println("Rzucono: " + Arrays.toString(rzuty));
        System.out.println("Suma: " + suma);

        result = suma + moderator;

        return result;
    }
}


