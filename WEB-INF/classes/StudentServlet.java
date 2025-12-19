import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import human.Student;

public class StudentServlet extends HttpServlet{

    //インスタンス変数で、Studentを入れるArrayList
    ArrayList<Student> studentlist = new ArrayList<Student>();

    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{
        
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        int height = Integer.parseInt(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));
        String studentid = req.getParameter("studentid");

        Student st = new Student();
        st.setName(name);
        st.setHeight(height);
        st.setWeight(weight);
        st.setStudentID(studentid);

        //ArrayListにStudentを追加
        studentlist.add(st);

        
        req.setAttribute("studentlist",studentlist);

        RequestDispatcher dispatcher = req.getRequestDispatcher("registst");

        dispatcher.forward(req,res);

        
        /* 

        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");

        // レスポンスの出力
        //ArrayListをループさせて全研出力できるように書き換え

        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>登録データ</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>登録データ</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>名前</th><th>ID</th><th>身長</th><th>体重</th></tr>");

        for(Student student : studentlist){
            out.println("<tr><td>"+student.getName()+"</td><td>"+student.getStudentID()+"</td><td>"+student.getHeight()+"</td><td>"+student.getWeight()+"</td></tr>");
        }
        
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        */
    }
}


