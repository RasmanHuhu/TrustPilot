package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import model.Person;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.logging.Logger;


//utils.Scraper fungerer lidt ala Utils klassen i Jokes projektet
public class Scraper {

    static String url = "https://dk.trustpilot.com/review/www.apple.com";
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();


    // Metode til at fetchdata (lav om)
    // Kopieret fra site: styles_consumerDetailsWrapper__p2wdr
    public static Person fetchData(String url) throws IOException, InterruptedException {
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                        "(KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36")
                .get();
        Thread.sleep(1000); // 1 second
        Elements consumerProfile = doc.

    }




    // Metode til at parse et objekt om til json

    // Metode til at parse json om til et objekt

    // pagination til at scrape multiple pages
}
