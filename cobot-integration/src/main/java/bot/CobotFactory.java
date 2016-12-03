package bot;

import org.alicebot.ab.Bot;

import java.io.File;

/**
 * Created by cobot on 11/24/16.
 */
public class CobotFactory {
    private static CobotFactory cf = null;
    private static Bot bot=null;

    private CobotFactory(){
    }

    public static Bot getBot(){
        //File resourcesDirectory = new File("/home/adri/Documents/code/java/hack");
        //tomcat
        File resourcesDirectory = new File("../webapps/cobot/WEB-INF/classes");
        //File resourcesDirectory = new File("cobot-integration/src/main/resources");
        String path = resourcesDirectory.getAbsolutePath();
        System.out.println(path);
        if (bot == null){
            //TO DO make path 4m rel2abs
            bot = new Bot("cobot",path);
        }
        return bot;
    }
}
