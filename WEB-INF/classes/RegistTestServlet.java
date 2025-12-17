import java.io.IOException;
import java.util.ArrayList;

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

            
            //profileの中身をDBに書き込む

            RegistDB.insert(profile);

            //書き込みメソッドの引数にprofileを渡して中身を書き込んでもらう

            //読み取りメソッドに中身を詰めこんだArrayListを返してもらう
            ArrayList<UserProfile> userlist = RegistDB.selectTest();  
           

            //HttpServletRequestの実装クラスのインスタンスに
            //ip.UserProfileのインスタンスを登録する
            //この時の登録名profが式言語で使用する識別子になる
            
            //このsetATtributeはDBから返された中身をArrayListに詰め替え、
            //そのArrayListをセット
            req.setAttribute("userlist",userlist);

            RequestDispatcher dispatcher = req.getRequestDispatcher("registresult");

            dispatcher.forward(req,res);
    }
}
