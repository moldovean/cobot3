package playground;

import bot.Cobot;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

import java.io.File;

/**
 * Created by cobot on 11/24/16.
 */
public class Play {
    public static void main(String[] args) {
        // https://github.com/josephmisiti/awesome-machine-learning#java-general-purpose

        File resourcesDirectory = new File("src/main/resources");
        System.out.println(resourcesDirectory.getAbsolutePath());


        Cobot cobot = new Cobot();
        System.out.println(cobot.getResponse("salut"));
    }
}
