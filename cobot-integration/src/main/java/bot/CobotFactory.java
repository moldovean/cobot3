package bot;

import org.alicebot.ab.Bot;
import util.ResourcesPath;

import java.io.File;

/**
 * Created by cobot on 11/24/16.
 */
public class CobotFactory {
    private static CobotFactory cf = null;
    private static Bot bot=null;
    private static String pathToResources;
    //private static String pathToResources = "/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources";

    static {
        pathToResources = ResourcesPath.getResourcePath(); //should give a relative path
    }

    private CobotFactory(){
    }

    public static Bot getBot(){
        // Comment is need here ?
        //File resourcesDirectory = new File("/home/adri/Documents/code/java/hack");
        //File resourcesDirectory = new File("cobot-integration/src/main/resources");
        //pathToResources = "/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources";
        //File resourcesDirectory = new File("../webapps/cobot/WEB-INF/classes"); // works with Tomcat
        File resourcesDirectory = new File(pathToResources);

        String path = resourcesDirectory.getAbsolutePath();
        System.out.println(path);
        if (bot == null){
            //TO DO make path 4m rel2abs
            bot = new Bot("cobot",path);
        }
        return bot;
    }
/*    public static void setPathToResources(String path){
        pathToResources = path;
    }*/
    //To Do OS
    public static void setPathToResources(String server){
        pathToResources = ResourcesPath.getResourcePath(server);
    }
}
