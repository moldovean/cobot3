package bot;

import org.alicebot.ab.Bot;

import java.io.File;

/**
 * Created by cobot on 11/24/16.
 */
public class CobotFactory {
    private static CobotFactory cf = null;
    private static Bot bot=null;
    private static String pathToResources;

    private CobotFactory(){
    }

    public static Bot getBot(){
        //File resourcesDirectory = new File("/home/adri/Documents/code/java/hack");
        //tomcat
        pathToResources = "/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources";
        //File resourcesDirectory = new File("../webapps/cobot/WEB-INF/classes"); // works with Tomcat
        File resourcesDirectory = new File(pathToResources);
        //File resourcesDirectory = new File("cobot-integration/src/main/resources");
        String path = resourcesDirectory.getAbsolutePath();
        System.out.println(path);
        if (bot == null){
            //TO DO make path 4m rel2abs
            bot = new Bot("cobot",path);
        }
        return bot;
    }
    public static void modifyResources(String path){
        pathToResources = path;
    }
}
