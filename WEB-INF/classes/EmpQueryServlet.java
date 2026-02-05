import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.EmpQuery;
import jakarta.servlet.RequestDispatcher;

import java.util.List;

public class EmpQueryServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
        List empList = EmpQuery.getEmpList();

        req.setAttribute("empList", empList);
        RequestDispatcher dis = req.getRequestDispatcher("empout.jsp");
        dis.forward(req, res);

    }
}
