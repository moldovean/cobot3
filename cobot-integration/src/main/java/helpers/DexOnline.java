package helpers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.IOException;
import java.util.List;

import static util.EncodeURIComponent.encodeURIComponent;

/**
 * Created by adri on 12/9/16.
 */
public class DexOnline {

    public static String getDexDefinition(String word){
        Element definition=null;
        StringBuilder result = new StringBuilder();
        try {
            definition = Jsoup.connect("https://dexonline.ro/definitie/" + encodeURIComponent(word))
                    .get()
                    .select(".defWrapper > .def")
                    .first();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Element element : definition.select("abbr")) {
            element.replaceWith(new TextNode(element.attr("title"), ""));
        }
        for (Element element : definition.select("i")) {
            element.remove();
        }
        for (Element element : definition.select("sup, sub")) {
            element.remove();
        }

        result.append(definition.text()) ;
        String formatedResult = result.toString().replaceAll("(\\d+\\.)", "\n$1").trim();
        return formatedResult;
    }

    public static String getDexDefinitions(List<String> words) {
        Element definition;
        StringBuilder response = new StringBuilder();

        for (String word : words) {
            try {
                definition = Jsoup.connect("https://dexonline.ro/definitie/" + encodeURIComponent(word))
                        .get()
                        .select(".defWrapper > .def")
                        .first();

                for (Element element : definition.select("abbr")) {
                    element.replaceWith(new TextNode(element.attr("title"), ""));
                }

                for (Element element : definition.select("sup, sub")) {
                    element.remove();
                }

                response.append(definition.text().replaceAll(" (\\d+.) ", "\n$1 ") + "\n\n");
            } catch (IOException e) {
                response.append("Nu am reușit să găsesc definiția" + "\n\n");
            }
        }

        return response.toString().trim();
    }
}
