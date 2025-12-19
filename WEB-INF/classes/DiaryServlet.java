import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import diary.DiaryItem;
import ex.LogicException;

public class DiaryServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
    throws IOException,ServletException{
        try{
            req.setCharacterEncoding("UTF-8");

            String date = req.getParameter("date");
            String content = req.getParameter("content");

            //ファイルなりに書き込みたい

            String line = date +" "+ content ;

            DiaryItem ditem = new DiaryItem();
            //ditem.setDate(date);
            ditem.createItem(line);
        

            
            //HttpServletRequestの実装クラスのインスタンスに
            //ip.UserProfileのインスタンスを登録する
            //この時の登録名profが式言語で使用する識別子になる
            req.setAttribute("diaryitem",line);

                RequestDispatcher dispatcher = req.getRequestDispatcher("resultdiary");

                dispatcher.forward(req,res);
        }catch(LogicException e){
            throw new ServletException(e.getMessage(),e);

        }
    }
}

