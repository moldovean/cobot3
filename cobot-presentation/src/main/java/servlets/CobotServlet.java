package servlets;

import bot.Cobot;
import bot.CobotFactory;
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

/**
 * Created by cobot on 11/24/16.
 */
@WebServlet(urlPatterns = "/cobot")
public class CobotServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        HttpSession session = req.getSession(true);

        Cobot cobot = (Cobot) session.getAttribute("cobot");
        if (cobot == null){
            System.out.println("cobot was null!!!");
            CobotFactory.setPathToResources("../webapps/cobot/WEB-INF/classes"); //tomcat
            //Glassfish
            ServletContext context = this.getServletContext();
            CobotFactory.setPathToResources(context.getRealPath("")+"/WEB-INF/classes/"); // Glassfish
            //CobotFactory.setPathToResources("webapps/cobot/WEB-INF/classes");

            cobot = new Cobot();
            session.setAttribute("cobot", cobot);
        }

        PrintWriter writer = resp.getWriter();

        String utterance = req.getParameter("text");

        String answer = cobot.getResponse(utterance);

        JSONObject obj = new JSONObject();
        obj.put("question", utterance);
        obj.put("answer", answer);
        obj.put("previous_question", cobot.getinputHistory(1));
        //System.out.println(obj);

        writer.println(obj.toJSONString());
        writer.close();
        //req.setAttribute();
    }
}
