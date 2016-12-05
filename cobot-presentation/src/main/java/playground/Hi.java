package playground;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by adri on 12/3/16.
 */
@WebServlet( name ="hi", urlPatterns = "/hi")
public class Hi extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Hi");
        writer.println(request.getContextPath());
        File iaka = new File("");
        writer.println(iaka.getAbsolutePath());
        ServletContext context = this.getServletContext();
        writer.println(context.getRealPath(""));
        writer.close();
    }
}
