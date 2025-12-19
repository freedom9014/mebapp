package ttc;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletContext;

public class SessionStartServlet extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{

        HttpSession session = req.getSession();

        ServletContext context = getServletContext();
        String s = context.getInitParameter("name"); //指定された初期化パラメータについて、その値が格納されたStringを返す

        session.setAttribute("name","ashi");
        session.setAttribute("pass","tera");
        session.setAttribute("param",s);

        RequestDispatcher dispatcher = req.getRequestDispatcher("sessionshow");

        dispatcher.forward(req,res);
    }
}
