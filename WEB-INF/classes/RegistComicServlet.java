import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comic.ComicProperty;
import ip.UserProfile;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistComicServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{

            req.setCharacterEncoding("UTF-8");

            String p = req.getParameter("publisher");
            String t = req.getParameter("title");
            String a = req.getParameter("author");

            ComicProperty cp = new ComicProperty();
            cp.setComicPublisher(p);
            cp.setComicTitle(t);
            cp.setComicAuthor(a);

            RegistComicDB.insert(cp);

            List<ComicProperty> comicList = RegistComicDB.selectComicList();

            //HttpServletRequestの実装クラスのインスタンスに
            //ip.UserProfileのインスタンスを登録する
            //この時の登録名profが式言語で使用する識別子になる
            req.setAttribute("comiclist",comicList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("registcomic");

            dispatcher.forward(req,res);
    }
}