package ttc;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class SessionEndServlet  extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{

        HttpSession session = req.getSession();

        //セッションを終了する
        session.invalidate();

        RequestDispatcher dispatcher = req.getRequestDispatcher("sessionshow");

        dispatcher.forward(req,res);
    }
    
}
