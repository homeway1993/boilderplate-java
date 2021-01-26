package boilerplate.jsoup.wordsgo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordsgoCrawler {

    public static void main(String[] args) throws Exception {
        Document document = Jsoup.connect("http://www.wordsgo.com/2000w/unit10_2/2k_u10u2_wlist.html").get();
        System.out.println(document.title());
    }
}
