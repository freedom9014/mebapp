import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
    public void init(FilterConfig config) throws ServletException{}

    public void destroy(){}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException,ServletException{

        String name = req.getParameter("name");
        String pass = req.getParameter("pass");

        if(name != null && pass != null){

            if(name.equals("god") && pass.equals("isaka")){

                HttpSession session = ((HttpServletRequest)req).getSession();

                session.setAttribute("token","OK");
            }
        }

        chain.doFilter(req,res);
    }
}
