package pl.coderslab.zadanie5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main5 {

    public static void main(String[] args) {

        try {
            wyszukiwarkaSlow("https://www.onet.pl/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void wyszukiwarkaSlow(String internetService) throws IOException {

        Connection connect = Jsoup.connect(internetService);
        Document document = connect.get();
        Elements links = document.select("span.title");


        for (Element elem : links) {
            System.out.println(elem.text());
        }

        List<String> lista = new ArrayList<>(); //nowa lista
        Path path = Paths.get("src/pl/coderslab/zadanie5/popular_words.txt");
        for (Element elem : links) {
            lista.add(elem.text());
            Files.write(path, lista);
        }

        //wczytanie pliku do listy
        List<String> calyText = Files.readAllLines(path);
        StringBuilder sb = new StringBuilder();
        for (String item : calyText) {
            sb.append(item + " ");
        }

        String tekst = sb.toString();
        String[] splited = tekst.split("[0-9,\n, \\, \\:, \\., \t]");
        System.out.println(Arrays.toString(splited));

        String[] slowaWykluczone = {"oraz", "ponieważ", "jeśli", "jeżeli", "dlatego", "albo"};

        List<String> allWords = Arrays.asList(splited);
        List<String> wordsToExclude = Arrays.asList(slowaWykluczone);

        List<String> newWords = new ArrayList<>();

        for (String element : allWords) {

            if (!wordsToExclude.contains(element) && element.length() > 3) {
                newWords.add(element);
            }
        }

        System.out.println(Arrays.toString(newWords.toArray()));

        Path path1 = Paths.get("src/pl/coderslab/zadanie5/filtered_" + path.getFileName());
        System.out.println(path1);
        if (Files.exists(path1)) {
            System.out.println("Taki plik już istnieje");
        } else {
            Files.createFile(path1);
            System.out.println("Utworzono plik " + path1);
        }

        Files.write(path1, newWords);
    }
}



