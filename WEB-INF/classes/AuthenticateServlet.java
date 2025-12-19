import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        if(name.equals("god") && pass.equals("isaka")){
            HttpSession session = req.getSession();
            session.setAttribute("token","OK");
        }

        RequestDispatcher disp = req.getRequestDispatcher("/productinput");
        disp.forward(req,res);

    }
    
}
