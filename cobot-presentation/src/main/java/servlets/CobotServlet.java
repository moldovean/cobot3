package servlets;

//import bot.Cobot; //don't use this one!
import cobot.Cobot;

import org.json.simple.JSONObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *  I think the you need to choose Tomcat or GlassFish ?
 */


/**
 * Created by cobot on 11/24/16.
 */
@WebServlet(urlPatterns = "/cobot")
public class CobotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; cahrset=UTF-8");

        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        HttpSession session = req.getSession(true);

        Cobot cobot = (Cobot) session.getAttribute("cobot");
        if (cobot == null){
            System.out.println("cobot was null!!!");
            //CobotFactory.setPathToResources("../webapps/cobot/WEB-INF/classes"); //tomcat
            //CobotFactory.setPathToResources("/home/adri/Documents/code/java/hack/cobot3/cobot-integration/src/main/resources");

            //works
            //CobotFactory.setPathToResources("tomcat","");
            //testing path

            //Glassfish
            ServletContext context = this.getServletContext();
            System.out.println(context.getRealPath(""));

            //CobotFactory.setPathToResources(context.getRealPath("")+"/WEB-INF/classes/"); // Glassfish
            //CobotFactory.setPathToResources("glassfish", "");

            cobot = new Cobot();
            session.setAttribute("cobot", cobot);
        }

        PrintWriter writer = resp.getWriter();

        String utterance = req.getParameter("text");

        String answer = cobot.getResponse(utterance);

        JSONObject obj = new JSONObject();
        obj.put("question", utterance);
        obj.put("answer", answer);
        obj.put("previous_question", cobot.getInputHistory(1));
        //obj.put("path", this.getServletContext().getRealPath(""));
        //System.out.println(obj);

        writer.println(obj.toJSONString());
        writer.close();
        //req.setAttribute();
    }
}
