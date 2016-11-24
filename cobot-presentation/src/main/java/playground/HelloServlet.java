package playground;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import static playground.ServicePlay.getMessage;
import static playground.ServicePlay.provideList;

/**
 * Created by cobot on 11/20/16.
 */

@WebServlet(urlPatterns = "/serv/")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //Writer w = resp.getWriter();
        //PrintWriter writer = resp.getWriter();
        //writer.println("Hello World !!!");
        //writer.close();
        String myVarIaka = getMessage();
        //myVar = "Adrian";
        req.setAttribute("myVar",myVarIaka);
        req.setAttribute("myList",provideList());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);

    }
}
