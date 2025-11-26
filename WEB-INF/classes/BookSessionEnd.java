import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class BookSessionEnd extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{

        HttpSession session = req.getSession();

        session.invalidate();

        RequestDispatcher dispatcher = req.getRequestDispatcher("bookshow");

        dispatcher.forward(req,res); 
    }
}
