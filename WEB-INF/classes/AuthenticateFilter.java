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

public class AuthenticateFilter implements Filter{

    public void init(FilterConfig config)throws ServletException{}

    public void destroy(){}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
    throws IOException,ServletException{
        
        HttpSession session = ((HttpServletRequest) req).getSession();

        String flag = (String) session.getAttribute("token");

        if(flag == null){
            
            HttpServletRequest hreq = (HttpServletRequest)req;

            String servletPath = hreq.getServletPath();
            System.out.println(servletPath);
            hreq.setAttribute("target",servletPath);

            RequestDispatcher disp = hreq.getRequestDispatcher("/orderlogin");
            disp.forward(req,res);
        
        }else{
            chain.doFilter(req,res);
        }
    }
    
}
