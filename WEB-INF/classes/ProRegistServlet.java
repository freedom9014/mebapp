import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//サーブレットはHttpServletクラスのサブクラスとして作成する
public class ProRegistServlet extends HttpServlet{ //クラスProRegistServlet。HttpServletのサブクラス

    //HttpServletクラスのdoPost()をオーバーライド。(クライアントのフォームの記述が<form method="post">のため)
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{

            //リクエストするときの文字コードを指定　★訂正：リクエストされたレコードの文字コードを設定
            //setCharacterEncoding()はServletRequestインターフェースから
            //HttpServletRepuestインターフェースが継承したメソッド？
            req.setCharacterEncoding("UTF-8");

            //リクエストするパラメータを取得　★訂正：リクエストされたパラメータを取得
            //getParameter()はServletRequestインターフェースが持ってるメソッド
            //パラメータの値をStringで返す
            String n = req.getParameter("name");
            String a = req.getParameter("address");
            String t = req.getParameter("tel");

            //このリクエストに属性(=Attribute)を保存する
            //29行目はパラメータを格納したnをnameという名前で保存
            req.setAttribute("name",n);
            req.setAttribute("address",a);
            req.setAttribute("tel",t);

            //RequestDispatcherインターフェース(dispatcher=指示、管理する担当者)
            //サーバー上のリソースに送信するオブジェクトを定義する  ★訂正：送信先の指定
            //getRequestDispatcher(String　path)で送信先を取得
            RequestDispatcher dispatcher = req.getRequestDispatcher("proregist");
            
            //サーブレットからのリクエストを転送　★訂正：リクエストされたレコードを転送
            dispatcher.forward(req,res);
    }
}
