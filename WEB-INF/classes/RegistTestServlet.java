import java.io.IOException;

import ip.UserProfile;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistTestServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{

            req.setCharacterEncoding("UTF-8");

            String u = req.getParameter("name");
            String p = req.getParameter("pass");

            //ip.UserProfileクラスのインスタンスを生成し
            //ユーザー名やパスワードをセットする
            UserProfile profile = new UserProfile();
            profile.setUserName(u);
            profile.setPassWord(p);

            //HttpServletRequestの実装クラスのインスタンスに
            //ip.UserProfileのインスタンスを登録する
            //この時の登録名profが式言語で使用する識別子になる
            req.setAttribute("prof",profile);

            RequestDispatcher dispatcher = req.getRequestDispatcher("registresult");

            dispatcher.forward(req,res);
    }
}
